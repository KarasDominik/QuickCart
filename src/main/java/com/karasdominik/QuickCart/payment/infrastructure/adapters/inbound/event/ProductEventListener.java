package com.karasdominik.QuickCart.payment.infrastructure.adapters.inbound.event;

import com.karasdominik.QuickCart.payment.application.ports.inbound.ProductCreator;
import com.karasdominik.QuickCart.payment.domain.dto.CreateProductCommand;
import com.karasdominik.QuickCart.payment.domain.valueobjects.Price;
import com.karasdominik.QuickCart.product.domain.events.ProductCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
class ProductEventListener {

    private final ProductCreator productCreator;

    @ApplicationModuleListener
    void handle(ProductCreatedEvent event) {
        log.info("Received product {} created event", event.productId());
        productCreator.create(CreateProductCommand.builder()
                .productId(event.productId())
                .price(Price.of(event.price()))
                .name(event.name())
                .build());
    }
}
