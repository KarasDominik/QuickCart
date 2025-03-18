package com.karasdominik.QuickCart.common.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serial;

@AllArgsConstructor
@Getter
public abstract class ConflictedRequestException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -5168530081223934141L;

    private String message;
}
