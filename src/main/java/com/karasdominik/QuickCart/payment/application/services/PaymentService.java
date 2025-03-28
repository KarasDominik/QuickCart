package com.karasdominik.QuickCart.payment.application.services;

import com.karasdominik.QuickCart.payment.application.ports.inbound.PaymentCreator;
import com.karasdominik.QuickCart.payment.application.ports.inbound.PaymentExternalApi;
import com.karasdominik.QuickCart.payment.application.ports.outbound.PaymentRepository;
import com.karasdominik.QuickCart.payment.application.ports.outbound.StripeClient;
import com.karasdominik.QuickCart.payment.application.ports.outbound.StripeProductRepository;
import com.karasdominik.QuickCart.payment.domain.dto.CreatePaymentCommand;
import com.karasdominik.QuickCart.payment.domain.dto.PaymentId;
import com.karasdominik.QuickCart.payment.domain.entities.Payment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
class PaymentService implements PaymentCreator, PaymentExternalApi {

    @Value("${quickcart.stripe.api-key}")
    private String apiKey;

    private final PaymentRepository payments;
    private final StripeProductRepository products;
    private final StripeClient stripeClient;

    @Override
    public void create(CreatePaymentCommand command) {
        log.info("Creating payment for order {}", command.orderId());
        var paymentId = PaymentId.create();
        var payment = Payment.builder()
                .id(paymentId)
                .orderId(command.orderId())
                .checkoutUrl(stripeClient.createCheckoutSession(command))
                .build();
        payments.save(payment);
        log.info("Payment created with id {}", payment.id());
    }

    @Override
    public String getPaymentUrl(UUID orderId) {
        return payments.findBy(orderId).checkoutUrl();
    }
}
