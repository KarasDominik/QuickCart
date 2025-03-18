package com.karasdominik.QuickCart.order.application.ports.outbound;

import com.karasdominik.QuickCart.order.domain.events.OrderEvent;

public interface OrderEventPublisher {

    void publish(OrderEvent event);
}
