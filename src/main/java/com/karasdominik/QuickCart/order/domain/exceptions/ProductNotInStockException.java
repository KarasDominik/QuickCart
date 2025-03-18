package com.karasdominik.QuickCart.order.domain.exceptions;

import com.karasdominik.QuickCart.common.exceptions.ConflictedRequestException;

import java.io.Serial;

public class ProductNotInStockException extends ConflictedRequestException {

    @Serial
    private static final long serialVersionUID = 5283055603018312879L;

    public ProductNotInStockException(String message) {
        super(message);
    }
}
