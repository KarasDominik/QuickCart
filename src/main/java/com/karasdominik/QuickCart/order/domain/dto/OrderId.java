package com.karasdominik.QuickCart.order.domain.dto;

import com.karasdominik.QuickCart.common.fields.FieldInfo;

import java.io.Serializable;
import java.util.UUID;

import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notBlank;
import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notNull;
import static java.util.UUID.fromString;
import static java.util.UUID.randomUUID;

public record OrderId(UUID value) implements Serializable {

    private static final FieldInfo ORDER_ID = new FieldInfo("orderId");

    public static OrderId of(UUID value) {
        notNull(value, ORDER_ID);
        return new OrderId(value);
    }

    public static OrderId of(String value) {
        notBlank(value, ORDER_ID);
        return new OrderId(fromString(value));
    }

    public static OrderId create() {
        return OrderId.of(randomUUID());
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
