package com.karasdominik.QuickCart.order.infrastructure.adapters.outbound.event;

import com.karasdominik.QuickCart.order.application.ports.outbound.OrderEventPublisher;
import com.karasdominik.QuickCart.order.domain.events.OrderEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderEventPublisherImpl implements OrderEventPublisher {

    private final ApplicationEventPublisher publisher;

    @Override
    public void publish(OrderEvent event) {
        log.info("Publishing event: {}", event.getClass().getSimpleName());
        publisher.publishEvent(event);
    }
}
