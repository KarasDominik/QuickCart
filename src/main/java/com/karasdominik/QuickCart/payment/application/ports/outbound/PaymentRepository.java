package com.karasdominik.QuickCart.payment.application.ports.outbound;

import com.karasdominik.QuickCart.payment.domain.entities.Payment;

import java.util.UUID;

public interface PaymentRepository {

    void save(Payment payment);

    Payment findBy(UUID orderId);

    void deleteAll();

    long count();
}
