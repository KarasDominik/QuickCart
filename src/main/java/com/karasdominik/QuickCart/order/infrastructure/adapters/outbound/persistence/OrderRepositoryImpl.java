package com.karasdominik.QuickCart.order.infrastructure.adapters.outbound.persistence;

import com.karasdominik.QuickCart.order.application.ports.outbound.OrderRepository;
import com.karasdominik.QuickCart.order.domain.dto.OrderId;
import com.karasdominik.QuickCart.order.domain.entities.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderJpaRepository orders;

    @Override
    public Order save(Order order) {
        return orders.save(order);
    }

    @Override
    public Order findOrThrow(OrderId id) {
        return orders.findOrThrow(id);
    }
}
