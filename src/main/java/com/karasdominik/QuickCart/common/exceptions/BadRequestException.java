package com.karasdominik.QuickCart.common.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serial;

@AllArgsConstructor
@Getter
public abstract class BadRequestException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -2108559121563167770L;

    private String message;
}
