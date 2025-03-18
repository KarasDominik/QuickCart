package com.karasdominik.QuickCart.order.application.services;

import com.karasdominik.QuickCart.order.application.ports.inbound.OrderCreator;
import com.karasdominik.QuickCart.order.application.ports.outbound.OrderEventPublisher;
import com.karasdominik.QuickCart.order.application.ports.outbound.OrderRepository;
import com.karasdominik.QuickCart.order.domain.dto.CreateOrderCommand;
import com.karasdominik.QuickCart.order.domain.dto.OrderId;
import com.karasdominik.QuickCart.order.domain.entities.Order;
import com.karasdominik.QuickCart.order.domain.entities.OrderedProduct;
import com.karasdominik.QuickCart.order.domain.events.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

import static java.util.stream.Collectors.toMap;

@Service
@RequiredArgsConstructor
@Slf4j
class OrderService implements OrderCreator {

    private final OrderRepository orders;
    private final OrderEventPublisher publisher;

    @Override
    @Transactional
    public OrderId create(CreateOrderCommand command) {
        log.info("Starting to create new order");
        var order = orders.save(Order.create(command, Instant::now));
        publisher.publish(new OrderCreatedEvent(order.orderedProducts().stream()
                .collect(toMap(OrderedProduct::productId, e -> e.quantity().value()))));
        log.info("Order {} created", order.id());
        return order.id();
    }
}
