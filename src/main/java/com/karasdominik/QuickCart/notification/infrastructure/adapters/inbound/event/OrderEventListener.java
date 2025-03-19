package com.karasdominik.QuickCart.notification.infrastructure.adapters.inbound.event;

import com.karasdominik.QuickCart.notification.application.ports.inbound.EmailMessagingApi;
import com.karasdominik.QuickCart.notification.domain.dto.OrderId;
import com.karasdominik.QuickCart.notification.domain.dto.SendEmailCommand;
import com.karasdominik.QuickCart.notification.domain.valueobjects.Email;
import com.karasdominik.QuickCart.order.domain.events.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
class OrderEventListener {

    private final EmailMessagingApi messagingApi;

    @ApplicationModuleListener
    void handle(OrderCreatedEvent event) {
        log.info("Received order created event for order {}", event.orderId());
        messagingApi.send(SendEmailCommand.builder()
                .email(Email.of(event.email()))
                .orderId(OrderId.of(event.orderId()))
                .build());
    }
}
