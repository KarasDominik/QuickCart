package com.karasdominik.QuickCart.payment.application.ports.inbound;

import com.karasdominik.QuickCart.payment.domain.dto.CreatePaymentCommand;

public interface PaymentCreator {

    void create(CreatePaymentCommand command);
}
