package com.karasdominik.QuickCart.payment.application.services;

import com.karasdominik.QuickCart.common.dto.ProductId;
import com.karasdominik.QuickCart.payment.application.ports.outbound.PaymentRepository;
import com.karasdominik.QuickCart.payment.application.ports.outbound.StripeProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@Component
@RequiredArgsConstructor
@Transactional
public class PaymentAssertions {

    private final StripeProductRepository products;
    private final PaymentRepository payments;

    public void assertProductCreated(ProductId id, String stripeId) {
        assertThat(products.getBy(id))
                .isPresent()
                .hasValueSatisfying(product -> assertThat(product.stripeId()).isEqualTo(stripeId));
    }

    public void assertPaymentCreated(UUID orderId) {
        assertThat(payments.findBy(orderId))
                .isNotNull()
                .satisfies(payment -> assertThat(payment.checkoutUrl()).isNotEmpty());
    }
}
