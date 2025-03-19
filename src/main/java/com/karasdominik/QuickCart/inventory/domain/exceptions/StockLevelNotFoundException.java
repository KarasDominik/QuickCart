package com.karasdominik.QuickCart.inventory.domain.exceptions;

import com.karasdominik.QuickCart.common.exceptions.NotFoundException;

import java.io.Serial;

public class StockLevelNotFoundException extends NotFoundException {

    @Serial
    private static final long serialVersionUID = 2424073401432362342L;

    public StockLevelNotFoundException(String message) {
        super(message);
    }
}
