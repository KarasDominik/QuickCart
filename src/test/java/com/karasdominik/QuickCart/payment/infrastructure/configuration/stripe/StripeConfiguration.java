package com.karasdominik.QuickCart.payment.infrastructure.configuration.stripe;

import com.karasdominik.QuickCart.payment.application.ports.outbound.StripeClient;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@TestConfiguration
@Profile("test")
public class StripeConfiguration {

    @Bean
    @Primary
    public StripeClient stripeClient() {
        return new StripeFakeClient();
    }
}
