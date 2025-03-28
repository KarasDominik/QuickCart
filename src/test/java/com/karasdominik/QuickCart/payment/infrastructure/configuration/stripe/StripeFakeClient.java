package com.karasdominik.QuickCart.payment.infrastructure.configuration.stripe;

import com.karasdominik.QuickCart.payment.application.ports.outbound.StripeClient;
import com.karasdominik.QuickCart.payment.domain.dto.CreatePaymentCommand;
import com.karasdominik.QuickCart.payment.domain.dto.CreateProductCommand;

public class StripeFakeClient implements StripeClient {

    public static final String FAKE_PRODUCT_ID = "prod_NWjs8kKbJWmuuc";

    @Override
    public String createProduct(CreateProductCommand command) {
        return FAKE_PRODUCT_ID;
    }

    @Override
    public String createCheckoutSession(CreatePaymentCommand command) {
        return "https://checkout.stripe.com/c/pay/cs_test_a1AtVOnrQjFcossDIrY2UJ9bOMFSNLXp8vnb4FMF67UZs8sNKNG395d64n#fidkdWxOYHwnPyd1blpxYHZxWjA0VzFQfUZVN2Rmc0wxTHBXRENzUHRGVGFKQGFfUHJiVUN2TD1IN3xkSE5xR3MydzxvQFR%2FZkBhS3VWUzN3b3d%2FbnE3ZFZKd1VfXUBIUjE3Z25yalRIR09zNTVTdG1cMHBkRicpJ2N3amhWYHdzYHcnP3F3cGApJ2lkfGpwcVF8dWAnPyd2bGtiaWBabHFgaCcpJ2BrZGdpYFVpZGZgbWppYWB3dic%2FcXdwYHgl";
    }
}
