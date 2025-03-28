package com.karasdominik.QuickCart.payment.domain.valueobjects;

import com.karasdominik.QuickCart.common.fields.FieldInfo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import static com.karasdominik.QuickCart.common.fields.FieldAssertions.greaterThan;
import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notNull;

public record Price(BigDecimal value) {

    public static Price of(BigDecimal value) {
        return new Price(value);
    }

    public static Price of(String value) {
        return new Price(new BigDecimal(value));
    }

    private static final FieldInfo PRICE = new FieldInfo("price");

    public Price {
        notNull(value, PRICE);
        greaterThan(value, BigDecimal.ZERO, PRICE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return value.setScale(2, RoundingMode.HALF_UP).equals(price.value.setScale(2, RoundingMode.HALF_UP));
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
