package com.karasdominik.QuickCart.payment.infrastructure.adapters.outbound.stripe;

import com.karasdominik.QuickCart.common.dto.ProductId;
import com.karasdominik.QuickCart.payment.application.ports.outbound.StripeClient;
import com.karasdominik.QuickCart.payment.application.ports.outbound.StripeProductRepository;
import com.karasdominik.QuickCart.payment.domain.dto.CreatePaymentCommand;
import com.karasdominik.QuickCart.payment.domain.dto.CreateProductCommand;
import com.karasdominik.QuickCart.payment.domain.exceptions.StripeException;
import com.stripe.Stripe;
import com.stripe.model.Product;
import com.stripe.model.checkout.Session;
import com.stripe.param.ProductCreateParams;
import com.stripe.param.checkout.SessionCreateParams;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.stripe.param.checkout.SessionCreateParams.Mode.PAYMENT;

@Service
@RequiredArgsConstructor
@Slf4j
class StripeClientImpl implements StripeClient {

    @Value("${quickcart.stripe.api-key}")
    private String apiKey;

    private final StripeProductRepository products;

    @Override
    public String createProduct(CreateProductCommand command) {
        try {
            Stripe.apiKey = apiKey;
            log.info("Creating new product {} on Stripe", command.name());
            var params = ProductCreateParams.builder()
                    .setName(command.name())
                    .setDefaultPriceData(
                            ProductCreateParams.DefaultPriceData.builder()
                                    .setCurrency("pln")
                                    .setUnitAmount(command.price().value().longValue() * 100)
                                    .build())
                    .build();

            var product = Product.create(params);
            log.info("Product {} created successfully with id {}", command.name(), product.getId());
            return product.getId();
        } catch (Exception e) {
            log.error("Error creating Stripe product {}", command.name());
            throw new StripeException("Error creating Stripe product", e);
        }
    }

    @Override
    public String createCheckoutSession(CreatePaymentCommand command) {
        Stripe.apiKey = apiKey;
        try {
            var params = SessionCreateParams.builder()
                    .setSuccessUrl("https://example.com/success")
                    .setMode(PAYMENT);
            command.products().entrySet().forEach(orderedProduct -> addProductToSession(params, orderedProduct));

            var session = Session.create(params.build());
            return session.getUrl();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private void addProductToSession(SessionCreateParams.Builder params, Map.Entry<ProductId, Integer> orderedProduct) {
        try {
            var stripeProduct = products.findOrThrow(orderedProduct.getKey());
            params.addLineItem(
                    SessionCreateParams.LineItem.builder()
                            .setPrice(Product.retrieve(stripeProduct.stripeId()).getDefaultPrice())
                            .setQuantity(orderedProduct.getValue().longValue())
                            .build());
        } catch (com.stripe.exception.StripeException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
