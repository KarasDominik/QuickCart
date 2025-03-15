package com.karasdominik.QuickCart.order.application.ports.inbound;

import com.karasdominik.QuickCart.order.domain.dto.CreateOrderCommand;
import com.karasdominik.QuickCart.order.domain.dto.OrderId;

public interface OrderCreator {

    OrderId create(CreateOrderCommand command);
}
