package com.karasdominik.QuickCart.order.application.services;

import com.karasdominik.QuickCart.order.application.ports.inbound.OrderCreator;
import com.karasdominik.QuickCart.order.application.ports.outbound.OrderRepository;
import com.karasdominik.QuickCart.order.domain.dto.CreateOrderCommand;
import com.karasdominik.QuickCart.order.domain.dto.OrderId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService implements OrderCreator {

    private final OrderRepository orders;

    @Override
    @Transactional
    public OrderId create(CreateOrderCommand command) {
        log.info("Starting to create new order");
        assertOrderCanBeCreated(command);
        // create order
        // update inventory sync
        // send notification async
        return OrderId.create();
    }

    private void assertOrderCanBeCreated(CreateOrderCommand command) {
        // TODO check inventory
    }
}
