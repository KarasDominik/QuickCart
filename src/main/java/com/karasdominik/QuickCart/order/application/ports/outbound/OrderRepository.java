package com.karasdominik.QuickCart.order.application.ports.outbound;

import com.karasdominik.QuickCart.order.domain.dto.OrderId;
import com.karasdominik.QuickCart.order.domain.entities.Order;

public interface OrderRepository {

    Order save(Order order);

    Order findOrThrow(OrderId id);
}
