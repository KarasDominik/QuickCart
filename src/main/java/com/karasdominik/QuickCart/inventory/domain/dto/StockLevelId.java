package com.karasdominik.QuickCart.inventory.domain.dto;

import com.karasdominik.QuickCart.common.fields.FieldInfo;

import java.io.Serializable;
import java.util.UUID;

import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notBlank;
import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notNull;
import static java.util.UUID.fromString;
import static java.util.UUID.randomUUID;

public record StockLevelId(UUID value) implements Serializable {

    private static final FieldInfo STOCK_LEVEL_ID = new FieldInfo("stockLevelId");

    public static StockLevelId of(UUID value) {
        notNull(value, STOCK_LEVEL_ID);
        return new StockLevelId(value);
    }

    public static StockLevelId of(String value) {
        notBlank(value, STOCK_LEVEL_ID);
        return new StockLevelId(fromString(value));
    }

    public static StockLevelId create() {
        return StockLevelId.of(randomUUID());
    }
}
