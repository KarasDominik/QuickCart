package com.karasdominik.QuickCart.payment.infrastructure.adapters.inbound.event;

import com.karasdominik.QuickCart.order.domain.events.OrderCreatedEvent;
import com.karasdominik.QuickCart.payment.application.services.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderCreatedEventListener {

    private final PaymentService paymentService;

    @ApplicationModuleListener
    public void handle(OrderCreatedEvent event) {
        log.info("Received order created event for order {}", event.orderId());
        paymentService.create();
    }
}
