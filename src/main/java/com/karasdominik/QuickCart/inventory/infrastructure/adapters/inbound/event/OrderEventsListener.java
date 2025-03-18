package com.karasdominik.QuickCart.inventory.infrastructure.adapters.inbound.event;

import com.karasdominik.QuickCart.inventory.application.ports.inbound.InventoryMessagingApi;
import com.karasdominik.QuickCart.inventory.domain.dto.ReduceStockLevelsCommand;
import com.karasdominik.QuickCart.inventory.domain.valueobjects.ProductQuantity;
import com.karasdominik.QuickCart.order.domain.events.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Map.Entry;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderEventsListener {

    private final InventoryMessagingApi messagingApi;

    @EventListener
    public void handle(OrderCreatedEvent event) {
        log.info("Received order created event");
        messagingApi.update(ReduceStockLevelsCommand.builder()
                .toBeReduced(event.orderedProducts().entrySet().stream()
                        .collect(Collectors.toMap(Entry::getKey, e -> ProductQuantity.of(e.getValue()))))
                .build());
    }
}
