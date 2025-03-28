package com.karasdominik.QuickCart.payment.infrastructure.adapters.inbound.event;

import com.karasdominik.QuickCart.common.BaseAbstractModuleTest;
import com.karasdominik.QuickCart.common.dto.ProductId;
import com.karasdominik.QuickCart.order.domain.events.OrderCreatedEvent;
import com.karasdominik.QuickCart.payment.application.ports.outbound.PaymentRepository;
import com.karasdominik.QuickCart.payment.application.services.PaymentAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;

import java.time.Duration;
import java.util.Map;
import java.util.UUID;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ApplicationModuleTest(webEnvironment = RANDOM_PORT)
@ComponentScan({
        "com.karasdominik.QuickCart.payment.application.services",
        "com.karasdominik.QuickCart.payment.infrastructure.configuration.stripe"})
class OrderEventListenerModuleTest extends BaseAbstractModuleTest {

    @Autowired
    private PaymentRepository payments;
    @Autowired
    private PaymentAssertions assertions;

    @Test
    void shouldCreatePaymentWithCheckoutUrlWhenOrderIsCreated(Scenario scenario) {
        var orderId = UUID.randomUUID();
        var email = "test@gmail.com";
        var orderedProducts = Map.of(
                ProductId.create(), 2
        );
        scenario.publish(new OrderCreatedEvent(orderId, email, orderedProducts))
                .andWaitAtMost(Duration.ofSeconds(3))
                .forStateChange(() -> payments.count());

        assertions.assertPaymentCreated(orderId);
    }
}
