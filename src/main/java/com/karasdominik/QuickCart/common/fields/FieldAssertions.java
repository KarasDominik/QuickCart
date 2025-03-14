package com.karasdominik.QuickCart.common.fields;

import com.karasdominik.QuickCart.common.exceptions.InvalidFieldException;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import static io.micrometer.common.util.StringUtils.isBlank;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class FieldAssertions {

    public static void notNull(Object value, FieldInfo field) {
        if (value == null) {
            throw new InvalidFieldException(String.format("Field '%s' is required", field.name()));
        }
    }

    public static void notBlank(String value, FieldInfo field) {
        if (isBlank(value)) {
            throw new InvalidFieldException(String.format("Field '%s' is required", field.name()));
        }
    }

    public static void greaterThan(BigDecimal value, BigDecimal threshold, FieldInfo field) {
        if (value.compareTo(threshold) <= 0) {
            throw new InvalidFieldException(String.format("Field '%s' has to be greater than %s", field.name(), threshold));
        }
    }
}
