package com.karasdominik.QuickCart.product.domain.dto;

import java.io.Serializable;
import java.util.UUID;

import static java.util.UUID.fromString;
import static java.util.UUID.randomUUID;

public record ProductId(UUID value) implements Serializable {

    public static ProductId of(UUID value) {
        return new ProductId(value);
    }

    public static ProductId of(String value) {
        return new ProductId(fromString(value));
    }

    public static ProductId create() {
        return ProductId.of(randomUUID());
    }
}
