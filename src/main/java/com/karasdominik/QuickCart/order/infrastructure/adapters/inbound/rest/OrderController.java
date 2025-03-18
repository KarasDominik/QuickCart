package com.karasdominik.QuickCart.order.infrastructure.adapters.inbound.rest;

import com.karasdominik.QuickCart.order.application.ports.inbound.OrderCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static com.karasdominik.QuickCart.order.infrastructure.adapters.inbound.rest.RequestMapper.asCommand;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
class OrderController {

    private final OrderCreator orders;

    @PostMapping
    @ResponseStatus(CREATED)
    CreateOrderResponse create(@RequestBody CreateOrderRequest request) {
        return CreateOrderResponse.of(orders.create(asCommand(request)));
    }
}
