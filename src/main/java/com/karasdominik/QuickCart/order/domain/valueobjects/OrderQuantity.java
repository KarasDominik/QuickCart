package com.karasdominik.QuickCart.order.domain.valueobjects;

import com.karasdominik.QuickCart.common.fields.FieldInfo;

import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notLessThan;
import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notMoreThan;

public record OrderQuantity(int value) {

    private static final FieldInfo PRODUCT_QUANTITY = new FieldInfo("productQuantity");

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 20;

    public static OrderQuantity of(int value) {
        return new OrderQuantity(value);
    }

    public OrderQuantity {
        notLessThan(value, MIN_VALUE, PRODUCT_QUANTITY);
        notMoreThan(value, MAX_VALUE, PRODUCT_QUANTITY);
    }
}
