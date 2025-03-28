package com.karasdominik.QuickCart.payment.domain.exceptions;

public class StripeException extends RuntimeException {

    public StripeException(String message) {
        super(message);
    }

    public StripeException(String message, Throwable cause) {
        super(message, cause);
    }
}
