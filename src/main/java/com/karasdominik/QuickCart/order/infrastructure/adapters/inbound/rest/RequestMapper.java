package com.karasdominik.QuickCart.order.infrastructure.adapters.inbound.rest;

import com.karasdominik.QuickCart.order.domain.dto.CreateOrderCommand;
import com.karasdominik.QuickCart.order.infrastructure.adapters.inbound.rest.CreateOrderRequest.OrderedProduct;
import lombok.NoArgsConstructor;

import static java.util.stream.Collectors.toMap;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
class RequestMapper {

    static CreateOrderCommand asCommand(CreateOrderRequest request) {
        return new CreateOrderCommand(request.orderedProducts().stream()
                .collect(toMap(OrderedProduct::productId, OrderedProduct::quantity)));
    }
}
