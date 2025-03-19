package com.karasdominik.QuickCart.order.domain.valueobjects;

import com.karasdominik.QuickCart.common.fields.FieldInfo;

import static com.karasdominik.QuickCart.common.fields.FieldAssertions.isValid;
import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notBlank;
import static org.apache.commons.validator.GenericValidator.isEmail;

public record Email(String value) {

    public static Email of(String value) {
        return new Email(value);
    }

    private static final FieldInfo EMAIL = new FieldInfo("email");

    public Email {
        notBlank(value, EMAIL);
        isValid(isEmail(value), EMAIL);
    }
}
