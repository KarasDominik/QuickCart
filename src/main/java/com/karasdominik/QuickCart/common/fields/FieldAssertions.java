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

    public static void notLessThan(int value, int minValue, FieldInfo field) {
        if (value < minValue) {
            throw new InvalidFieldException(String.format("Field '%s' cannot be less than than %s", field.name(), minValue));
        }
    }

    public static void notShorterThan(String value, int minLength, FieldInfo field) {
        if (value.length() < minLength) {
            throw new InvalidFieldException(String.format("Field '%s' must contain at least %s characters", field.name(), minLength));
        }
    }

    public static void notLongerThan(String value, int maxLength, FieldInfo field) {
        if (value.length() > maxLength) {
            throw new InvalidFieldException(String.format("Field '%s' must contain at most %s characters", field.name(), maxLength));
        }
    }

    public static void greaterThan(BigDecimal value, BigDecimal threshold, FieldInfo field) {
        if (value.compareTo(threshold) <= 0) {
            throw new InvalidFieldException(String.format("Field '%s' has to be greater than %s", field.name(), threshold));
        }
    }
}
