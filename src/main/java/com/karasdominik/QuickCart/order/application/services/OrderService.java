package com.karasdominik.QuickCart.order.application.services;

import com.karasdominik.QuickCart.order.application.ports.inbound.OrderCreator;
import com.karasdominik.QuickCart.order.application.ports.outbound.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService implements OrderCreator {

    private final OrderRepository orders;

    @Override
    public void create() {
        orders.save();
    }
}
