package com.karasdominik.QuickCart.payment.application.services;

import com.karasdominik.QuickCart.order.domain.dto.OrderedProductId;
import com.karasdominik.QuickCart.payment.application.ports.inbound.PaymentCreator;
import com.karasdominik.QuickCart.payment.application.ports.inbound.PaymentExternalApi;
import com.karasdominik.QuickCart.payment.application.ports.outbound.PaymentRepository;
import com.karasdominik.QuickCart.payment.application.ports.outbound.StripeProductRepository;
import com.karasdominik.QuickCart.payment.domain.dto.CreatePaymentCommand;
import com.karasdominik.QuickCart.payment.domain.dto.PaymentId;
import com.karasdominik.QuickCart.payment.domain.entities.Payment;
import com.karasdominik.QuickCart.payment.domain.entities.PaymentOrderedProduct;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Product;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.stripe.param.checkout.SessionCreateParams.Mode.PAYMENT;
import static java.util.stream.Collectors.toSet;

@Service
@RequiredArgsConstructor
@Slf4j
class PaymentService implements PaymentCreator, PaymentExternalApi {

    @Value("${quickcart.stripe.api-key}")
    private String apiKey;

    private final PaymentRepository payments;
    private final StripeProductRepository products;

    @Override
    public void create(CreatePaymentCommand command) {
        log.info("Creating payment for order {}", command.orderId());
        var paymentId = PaymentId.create();
        var payment = Payment.builder()
                .id(paymentId)
                .orderId(command.orderId())
                .build();
        payment.addProducts(command.products().entrySet().stream()
                .map(entry -> PaymentOrderedProduct.builder()
                        .id(OrderedProductId.create())
                        .payment(payment)
                        .product(products.findOrThrow(entry.getKey()))
                        .quantity(entry.getValue())
                        .build())
                        .collect(toSet()));
        payments.save(payment);
        log.info("Payment created with id {}", payment.id());
    }

    @Override
    public String getPaymentUrl(UUID orderId) {
        Stripe.apiKey = apiKey;
        try {
            var payment = payments.findBy(orderId);
            var params = SessionCreateParams.builder()
                    .setSuccessUrl("https://example.com/success")
                    .setMode(PAYMENT);
            payment.orderedProducts().forEach(orderedProduct -> addProductToSession(params, orderedProduct));

        var session = Session.create(params.build());
        return session.getUrl();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private void addProductToSession(SessionCreateParams.Builder params, PaymentOrderedProduct orderedProduct) {
        try {
            var product = orderedProduct.product();
            var stripeProduct = products.findOrThrow(product.id());
            params.addLineItem(
                    SessionCreateParams.LineItem.builder()
                            .setPrice(Product.retrieve(stripeProduct.stripeId()).getDefaultPrice())
                            .setQuantity((long) orderedProduct.quantity())
                            .build());
        } catch (StripeException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
