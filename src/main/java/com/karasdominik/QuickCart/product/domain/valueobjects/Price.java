package com.karasdominik.QuickCart.product.domain.valueobjects;

import com.karasdominik.QuickCart.common.fields.FieldInfo;

import java.math.BigDecimal;

import static com.karasdominik.QuickCart.common.fields.FieldAssertions.greaterThan;
import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notNull;

public record Price(BigDecimal value) {

    public static Price of(BigDecimal value) {
        return new Price(value);
    }

    private static final FieldInfo PRICE = new FieldInfo("price");

    public Price {
        notNull(value, PRICE);
        greaterThan(value, BigDecimal.ZERO, PRICE);
    }
}
