package com.karasdominik.QuickCart.payment.infrastructure.adapters.outbound.persistence;

import com.karasdominik.QuickCart.payment.domain.dto.PaymentId;
import com.karasdominik.QuickCart.payment.domain.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

interface PaymentJpaRepository extends JpaRepository<Payment, PaymentId> {

    Optional<Payment> findByOrderId(UUID orderId);
}
