package com.karasdominik.QuickCart.notification.infrastructure.adapters.inbound;

import com.karasdominik.QuickCart.common.BaseAbstractModuleTest;
import com.karasdominik.QuickCart.notification.application.services.MailAssertions;
import com.karasdominik.QuickCart.notification.application.services.MailFixtures;
import com.karasdominik.QuickCart.order.domain.dto.OrderId;
import com.karasdominik.QuickCart.order.domain.events.OrderCreatedEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;

import java.time.Duration;
import java.util.Map;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ApplicationModuleTest(webEnvironment = RANDOM_PORT)
@ComponentScan("com.karasdominik.QuickCart.notification.application.services")
public class OrderEventListenerModuleTest extends BaseAbstractModuleTest {

    private static final GenericContainer<?> MAILHOG = new GenericContainer<>("mailhog/mailhog")
                .withExposedPorts(1025, 8025);

    static {
        MAILHOG.start();
    }

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.mail.host", () -> "localhost");
        registry.add("spring.mail.port", () -> MAILHOG.getMappedPort(1025));
        registry.add("spring.mail.http.port", () -> MAILHOG.getMappedPort(8025));
    }

    @Value("${quickcart.mail.from}")
    private String sender;

    @Autowired
    private MailAssertions assertions;
    @Autowired
    private MailFixtures mails;

    @Test
    void shouldSendEmailWhenOrderIsCreated(Scenario scenario) {
        var orderId = OrderId.create().value();
        var email = "test12@gmail.com";
        scenario.publish(new OrderCreatedEvent(orderId, email, Map.of()))
                .andWaitAtMost(Duration.ofSeconds(3))
                .forStateChange(() -> mails.count());

        assertions.assertEmailSent(sender, email, "Your order with id " + orderId + " has been created");
    }
}
