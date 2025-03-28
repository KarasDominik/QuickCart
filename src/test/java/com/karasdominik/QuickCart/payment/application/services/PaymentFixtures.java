package com.karasdominik.QuickCart.payment.application.services;

import com.karasdominik.QuickCart.payment.application.ports.outbound.PaymentRepository;
import com.karasdominik.QuickCart.payment.application.ports.outbound.StripeProductRepository;
import com.karasdominik.QuickCart.payment.domain.entities.Payment;
import com.karasdominik.QuickCart.payment.domain.entities.PaymentsForTests;
import com.karasdominik.QuickCart.payment.domain.entities.PaymentsForTests.PaymentTestData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class PaymentFixtures {

    private final PaymentRepository payments;
    private final StripeProductRepository products;

    public void setUp() {
        setUp(PaymentsForTests.First_Payment.DATA);
    }

    private void setUp(PaymentTestData testData) {
        payments.save(Payment.builder()
                .id(testData.id())
                .orderId(testData.orderId())
                .checkoutUrl(testData.checkoutUrl())
                .build());
    }

    public void tearDown() {
        payments.deleteAll();
    }
}
