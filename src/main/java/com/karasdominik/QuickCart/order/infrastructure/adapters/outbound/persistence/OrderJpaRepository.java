package com.karasdominik.QuickCart.order.infrastructure.adapters.outbound.persistence;

import com.karasdominik.QuickCart.order.domain.dto.OrderId;
import com.karasdominik.QuickCart.order.domain.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

interface OrderJpaRepository extends JpaRepository<Order, OrderId> {

    default Order findOrThrow(OrderId id) {
        return findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order with id " + id + " not found"));
    }
}
