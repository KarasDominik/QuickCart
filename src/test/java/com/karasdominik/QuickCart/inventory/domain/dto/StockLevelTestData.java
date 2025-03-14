package com.karasdominik.QuickCart.inventory.domain.dto;

import com.karasdominik.QuickCart.common.dto.ProductId;
import com.karasdominik.QuickCart.inventory.domain.valueobjects.ProductQuantity;
import lombok.Builder;

@Builder
public record StockLevelTestData(StockLevelId id, ProductId productId, ProductQuantity quantity) {}
