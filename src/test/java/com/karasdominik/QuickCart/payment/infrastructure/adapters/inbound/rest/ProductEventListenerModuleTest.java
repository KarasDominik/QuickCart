package com.karasdominik.QuickCart.payment.infrastructure.adapters.inbound.rest;

import com.karasdominik.QuickCart.common.BaseAbstractModuleTest;
import com.karasdominik.QuickCart.common.dto.ProductId;
import com.karasdominik.QuickCart.payment.application.ports.outbound.StripeProductRepository;
import com.karasdominik.QuickCart.payment.application.services.PaymentAssertions;
import com.karasdominik.QuickCart.product.domain.events.ProductCreatedEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;

import java.time.Duration;

import static java.math.BigDecimal.TEN;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ApplicationModuleTest(webEnvironment = RANDOM_PORT)
@ComponentScan("com.karasdominik.QuickCart.payment.application.services")
@ComponentScan("com.karasdominik.QuickCart.payment.infrastructure.configuration.stripe")
class ProductEventListenerModuleTest extends BaseAbstractModuleTest {

    @Autowired
    private StripeProductRepository products;
    @Autowired
    private PaymentAssertions assertions;

    @Test
    void shouldCreateStripeProductWhenEventIsPublished(Scenario scenario) {
        var productId = ProductId.create();
        scenario.publish(new ProductCreatedEvent(productId, TEN, "Test product"))
                .andWaitAtMost(Duration.ofSeconds(3))
                .forStateChange(() -> products.count());

        assertions.assertProductCreated(productId, "prod_NWjs8kKbJWmuuc");
    }
}
