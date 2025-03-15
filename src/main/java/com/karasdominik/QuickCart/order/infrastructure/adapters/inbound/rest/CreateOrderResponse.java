package com.karasdominik.QuickCart.order.infrastructure.adapters.inbound.rest;

import com.karasdominik.QuickCart.order.domain.dto.OrderId;

record CreateOrderResponse(OrderId id) {

    static CreateOrderResponse of(OrderId id) {
        return new CreateOrderResponse(id);
    }
}
