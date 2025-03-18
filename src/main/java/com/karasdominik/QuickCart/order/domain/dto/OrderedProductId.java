package com.karasdominik.QuickCart.order.domain.dto;

import com.karasdominik.QuickCart.common.fields.FieldInfo;

import java.io.Serializable;
import java.util.UUID;

import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notBlank;
import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notNull;
import static java.util.UUID.fromString;
import static java.util.UUID.randomUUID;

public record OrderedProductId(UUID value) implements Serializable {

    private static final FieldInfo ORDERED_PRODUCT_ID = new FieldInfo("orderedProductId");

    public static OrderedProductId of(UUID value) {
        notNull(value, ORDERED_PRODUCT_ID);
        return new OrderedProductId(value);
    }

    public static OrderedProductId of(String value) {
        notBlank(value, ORDERED_PRODUCT_ID);
        return new OrderedProductId(fromString(value));
    }

    public static OrderedProductId create() {
        return OrderedProductId.of(randomUUID());
    }
}
