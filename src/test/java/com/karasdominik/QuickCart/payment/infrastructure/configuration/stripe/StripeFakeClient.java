package com.karasdominik.QuickCart.payment.infrastructure.configuration.stripe;

import com.karasdominik.QuickCart.payment.application.ports.outbound.StripeClient;
import com.karasdominik.QuickCart.payment.domain.dto.CreateProductCommand;

public class StripeFakeClient implements StripeClient {

    public static final String FAKE_PRODUCT_ID = "prod_NWjs8kKbJWmuuc";

    @Override
    public String createProduct(CreateProductCommand command) {
        return FAKE_PRODUCT_ID;
    }
}
