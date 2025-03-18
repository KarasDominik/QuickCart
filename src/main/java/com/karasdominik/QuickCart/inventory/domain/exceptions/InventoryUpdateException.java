package com.karasdominik.QuickCart.inventory.domain.exceptions;

import com.karasdominik.QuickCart.common.exceptions.ConflictedRequestException;

import java.io.Serial;

public class InventoryUpdateException extends ConflictedRequestException {

    @Serial
    private static final long serialVersionUID = 4304653881452340446L;

    public InventoryUpdateException(String message) {
        super(message);
    }
}
