package com.karasdominik.QuickCart.inventory.domain.valueobjects;

import com.karasdominik.QuickCart.common.fields.FieldInfo;

import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notLessThan;
import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notMoreThan;

public record ProductQuantity(int value) {

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 1000;

    private static final FieldInfo PRODUCT_QUANTITY = new FieldInfo("productQuantity");

        public static ProductQuantity of(int value) {
            return new ProductQuantity(value);
        }

        public ProductQuantity {
            notLessThan(value, MIN_VALUE, PRODUCT_QUANTITY);
            notMoreThan(value, MAX_VALUE, PRODUCT_QUANTITY);
        }

    public ProductQuantity subtract(ProductQuantity quantity) {
        return new ProductQuantity(value - quantity.value);
    }

    public boolean isGreaterOrEqualTo(ProductQuantity quantity) {
        return value >= quantity.value;
    }
}
