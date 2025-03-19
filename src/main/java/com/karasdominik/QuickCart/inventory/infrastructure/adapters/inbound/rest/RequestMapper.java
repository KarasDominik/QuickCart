package com.karasdominik.QuickCart.inventory.infrastructure.adapters.inbound.rest;

import com.karasdominik.QuickCart.common.dto.ProductId;
import com.karasdominik.QuickCart.inventory.domain.dto.UpdateStockLevelCommand;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
class RequestMapper {

    static UpdateStockLevelCommand asCommand(ProductId productId, UpdateStockLevelRequest request) {
        return UpdateStockLevelCommand.builder()
                .productId(productId)
                .quantity(request.quantity())
                .build();
    }
}
