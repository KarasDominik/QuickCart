package com.karasdominik.QuickCart.inventory.domain.dto;

import com.karasdominik.QuickCart.common.dto.ProductId;
import com.karasdominik.QuickCart.common.fields.FieldInfo;
import com.karasdominik.QuickCart.inventory.domain.valueobjects.ProductQuantity;
import lombok.Builder;

import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notNull;

@Builder
public record UpdateStockLevelCommand(ProductId productId, ProductQuantity quantity) {

    private static final FieldInfo PRODUCT_ID = new FieldInfo("productId");
    private static final FieldInfo QUANTITY = new FieldInfo("quantity");

    public UpdateStockLevelCommand {
        notNull(productId, PRODUCT_ID);
        notNull(quantity, QUANTITY);
    }
}
