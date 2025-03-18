package com.karasdominik.QuickCart.order.domain.valueobjects;

import com.karasdominik.QuickCart.common.fields.FieldInfo;

import java.io.Serializable;

import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notLessThan;
import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notMoreThan;
import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notNull;

public record OrderQuantity(int value) implements Serializable {

    private static final FieldInfo PRODUCT_QUANTITY = new FieldInfo("productQuantity");

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 20;

    public static OrderQuantity of(Integer value) {
        notNull(value, PRODUCT_QUANTITY);
        return new OrderQuantity(value);
    }

    public OrderQuantity {
        notLessThan(value, MIN_VALUE, PRODUCT_QUANTITY);
        notMoreThan(value, MAX_VALUE, PRODUCT_QUANTITY);
    }
}
