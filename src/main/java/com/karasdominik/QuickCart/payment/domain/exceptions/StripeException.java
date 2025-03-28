package com.karasdominik.QuickCart.payment.domain.exceptions;

import java.io.Serial;

public class StripeException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -6850201045178662230L;

    public StripeException(String message, Throwable cause) {
        super(message, cause);
    }
}
