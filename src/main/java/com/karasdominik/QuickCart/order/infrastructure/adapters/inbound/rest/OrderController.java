package com.karasdominik.QuickCart.order.infrastructure.adapters.inbound.rest;

import com.karasdominik.QuickCart.order.application.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.karasdominik.QuickCart.order.infrastructure.adapters.inbound.rest.RequestMapper.asCommand;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
class OrderController {

    private final OrderService orders;

    @PostMapping
    CreateOrderResponse create(CreateOrderRequest request) {
        return CreateOrderResponse.of(orders.create(asCommand(request)));
    }
}
