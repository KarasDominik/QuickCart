package com.karasdominik.QuickCart.payment.domain.dto;

import com.karasdominik.QuickCart.common.fields.FieldInfo;

import java.io.Serializable;
import java.util.UUID;

import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notBlank;
import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notNull;
import static java.util.UUID.fromString;
import static java.util.UUID.randomUUID;

public record StripeProductId(UUID value) implements Serializable {

    private static final FieldInfo STRIPE_PRODUCT_ID = new FieldInfo("stripeProductId");

    public static StripeProductId of(UUID value) {
        notNull(value, STRIPE_PRODUCT_ID);
        return new StripeProductId(value);
    }

    public static StripeProductId of(String value) {
        notBlank(value, STRIPE_PRODUCT_ID);
        return new StripeProductId(fromString(value));
    }

    public static StripeProductId create() {
        return StripeProductId.of(randomUUID());
    }
}
