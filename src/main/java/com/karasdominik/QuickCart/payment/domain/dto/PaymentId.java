package com.karasdominik.QuickCart.payment.domain.dto;

import com.karasdominik.QuickCart.common.fields.FieldInfo;

import java.io.Serializable;
import java.util.UUID;

import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notBlank;
import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notNull;
import static java.util.UUID.fromString;
import static java.util.UUID.randomUUID;

public record PaymentId(UUID value) implements Serializable {

    private static final FieldInfo PAYMENT_ID = new FieldInfo("paymentId");

    public static PaymentId of(UUID value) {
        notNull(value, PAYMENT_ID);
        return new PaymentId(value);
    }

    public static PaymentId of(String value) {
        notBlank(value, PAYMENT_ID);
        return new PaymentId(fromString(value));
    }

    public static PaymentId create() {
        return PaymentId.of(randomUUID());
    }
}
