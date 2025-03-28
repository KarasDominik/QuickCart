package com.karasdominik.QuickCart.payment.application.ports.outbound;

import com.karasdominik.QuickCart.common.dto.ProductId;
import com.karasdominik.QuickCart.payment.domain.entities.StripeProduct;

import java.util.Optional;

public interface StripeProductRepository {

    void save(StripeProduct product);

    StripeProduct findOrThrow(ProductId key);

    Optional<StripeProduct> getBy(ProductId id);

    long count();
}
