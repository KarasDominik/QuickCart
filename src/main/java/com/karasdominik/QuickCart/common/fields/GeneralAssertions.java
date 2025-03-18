package com.karasdominik.QuickCart.common.fields;

import lombok.NoArgsConstructor;

import java.util.function.Supplier;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class GeneralAssertions {

    public static void isTrue(boolean condition, Supplier<? extends RuntimeException> exception) {
        if (!condition) {
            throw exception.get();
        }
    }
}
