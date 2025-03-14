package com.karasdominik.QuickCart.inventory.domain.valueobjects;

import com.karasdominik.QuickCart.common.fields.FieldInfo;

import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notLessThan;

public record ProductQuantity(int value) {

    private static final FieldInfo PRODUCT_QUANTITY = new FieldInfo("productQuantity");

        public static ProductQuantity of(int value) {
            return new ProductQuantity(value);
        }

        public ProductQuantity {
            notLessThan(value, 0, PRODUCT_QUANTITY);
        }
}
