package com.karasdominik.QuickCart.payment.application.ports.outbound;

import com.karasdominik.QuickCart.payment.domain.dto.CreatePaymentCommand;
import com.karasdominik.QuickCart.payment.domain.dto.CreateProductCommand;

public interface StripeClient {

    String createProduct(CreateProductCommand command);

    String createCheckoutSession(CreatePaymentCommand command);
}
