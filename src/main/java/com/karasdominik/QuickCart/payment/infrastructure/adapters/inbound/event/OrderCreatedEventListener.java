package com.karasdominik.QuickCart.payment.infrastructure.adapters.inbound.event;

import com.karasdominik.QuickCart.order.domain.events.OrderCreatedEvent;
import com.karasdominik.QuickCart.payment.application.ports.inbound.PaymentCreator;
import com.karasdominik.QuickCart.payment.domain.dto.CreatePaymentCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderCreatedEventListener {

    private final PaymentCreator paymentCreator;

    @ApplicationModuleListener
    public void handle(OrderCreatedEvent event) {
        log.info("Received order created event for order {}", event.orderId());
        paymentCreator.create(CreatePaymentCommand.builder()
                .orderId(event.orderId())
                .products(event.orderedProducts())
                .build());
    }
}
