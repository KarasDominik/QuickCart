package com.karasdominik.QuickCart.order.infrastructure.adapters.outbound.persistence;

import com.karasdominik.QuickCart.order.domain.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderJpaRepository extends JpaRepository<Order, UUID> {}
