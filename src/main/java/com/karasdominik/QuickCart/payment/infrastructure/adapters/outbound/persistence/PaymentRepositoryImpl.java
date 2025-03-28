package com.karasdominik.QuickCart.payment.infrastructure.adapters.outbound.persistence;

import com.karasdominik.QuickCart.payment.application.ports.outbound.PaymentRepository;
import com.karasdominik.QuickCart.payment.domain.entities.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentRepositoryImpl implements PaymentRepository {

    private final PaymentJpaRepository payments;

    @Override
    public void save(Payment payment) {
        payments.save(payment);
    }

    @Override
    public Payment findBy(UUID orderId) {
        return payments.findByOrderId(orderId)
                .orElseThrow();
    }
}
