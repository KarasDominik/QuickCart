package com.karasdominik.QuickCart.payment.application.ports.inbound;

import com.karasdominik.QuickCart.payment.domain.dto.CreateProductCommand;

public interface ProductCreator {

    void create(CreateProductCommand command);
}
