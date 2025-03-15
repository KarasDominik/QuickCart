package com.karasdominik.QuickCart.product.domain.valueobjects;

import com.karasdominik.QuickCart.common.fields.FieldInfo;

import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notBlank;
import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notLongerThan;
import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notShorterThan;

public record ProductName(String value) {

    public static ProductName of(String value) {
        return new ProductName(value);
    }

    private static final int MAX_LENGTH = 255;
    private static final int MIN_LENGTH = 3;

    private static final FieldInfo NAME = new FieldInfo("name");

    public ProductName {
        notBlank(value, NAME);
        notShorterThan(value, MIN_LENGTH, NAME);
        notLongerThan(value, MAX_LENGTH, NAME);
    }
}
