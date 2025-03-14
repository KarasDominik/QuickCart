package com.karasdominik.QuickCart.common.exceptions;

public class InvalidFieldException extends BadRequestException {

    public InvalidFieldException(String message) {
        super(message);
    }
}
