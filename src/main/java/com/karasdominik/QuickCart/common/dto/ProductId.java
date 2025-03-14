package com.karasdominik.QuickCart.common.dto;

import com.karasdominik.QuickCart.common.fields.FieldInfo;

import java.io.Serializable;
import java.util.UUID;

import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notBlank;
import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notNull;
import static java.util.UUID.fromString;
import static java.util.UUID.randomUUID;

public record ProductId(UUID value) implements Serializable {

    private static final FieldInfo PRODUCT_ID = new FieldInfo("productId");

    public static ProductId of(UUID value) {
        notNull(value, PRODUCT_ID);
        return new ProductId(value);
    }

    public static ProductId of(String value) {
        notBlank(value, PRODUCT_ID);
        return new ProductId(fromString(value));
    }

    public static ProductId create() {
        return ProductId.of(randomUUID());
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
