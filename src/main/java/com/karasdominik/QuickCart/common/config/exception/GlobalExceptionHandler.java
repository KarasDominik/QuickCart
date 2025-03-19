package com.karasdominik.QuickCart.common.config.exception;

import com.karasdominik.QuickCart.common.exceptions.BadRequestException;
import com.karasdominik.QuickCart.common.exceptions.ConflictedRequestException;
import com.karasdominik.QuickCart.common.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ErrorResponse handle(BadRequestException e) {
        return new ErrorResponse(e.message());
    }

    @ResponseStatus(CONFLICT)
    @ExceptionHandler(ConflictedRequestException.class)
    public ErrorResponse handle(ConflictedRequestException e) {
        return new ErrorResponse(e.message());
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorResponse handle(NotFoundException e) {
        return new ErrorResponse(e.message());
    }
}
