package com.karasdominik.QuickCart.product.infrastructure.adapters.outbound.event;

import com.karasdominik.QuickCart.product.application.ports.outbound.ProductEventPublisher;
import com.karasdominik.QuickCart.product.domain.events.ProductEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
class ProductEventPublisherImpl implements ProductEventPublisher {

    private final ApplicationEventPublisher publisher;

    @Override
    public void publish(ProductEvent event) {
        log.info("Publishing {}", event.getClass().getSimpleName());
        publisher.publishEvent(event);
    }
}
