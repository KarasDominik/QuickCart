package com.karasdominik.QuickCart.product.domain.valueobjects;

import com.karasdominik.QuickCart.common.fields.FieldInfo;

import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notBlank;
import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notLongerThan;
import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notShorterThan;

public record ProductDescription(String value) {

    public static ProductDescription of(String value) {
        return new ProductDescription(value);
    }

    private static final int MAX_LENGTH = 1000;
    private static final int MIN_LENGTH = 10;

    private static final FieldInfo DESCRIPTION = new FieldInfo("description");

    public ProductDescription {
        notBlank(value, DESCRIPTION);
        notShorterThan(value, MIN_LENGTH, DESCRIPTION);
        notLongerThan(value, MAX_LENGTH, DESCRIPTION);
    }

    public String toString() {
        return value;
    }
}
