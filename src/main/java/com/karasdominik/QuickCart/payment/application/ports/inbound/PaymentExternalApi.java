package com.karasdominik.QuickCart.payment.application.ports.inbound;

import java.util.UUID;

public interface PaymentExternalApi {

    String getPaymentUrl(UUID orderId);
}
