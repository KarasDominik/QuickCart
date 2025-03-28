package com.karasdominik.QuickCart.product.application.ports.outbound;

import com.karasdominik.QuickCart.product.domain.events.ProductEvent;

public interface ProductEventPublisher {

    void publish(ProductEvent event);
}
