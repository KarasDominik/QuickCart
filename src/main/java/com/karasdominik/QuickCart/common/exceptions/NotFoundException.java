package com.karasdominik.QuickCart.common.exceptions;

import lombok.Getter;

import java.io.Serial;

@Getter
public abstract class NotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -8559588923392427203L;

    private final String message;

    public NotFoundException(String message) {
        this.message = message;
    }
}
