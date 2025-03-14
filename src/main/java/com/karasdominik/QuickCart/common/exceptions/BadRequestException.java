package com.karasdominik.QuickCart.common.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class BadRequestException extends RuntimeException {

    private String message;
}
