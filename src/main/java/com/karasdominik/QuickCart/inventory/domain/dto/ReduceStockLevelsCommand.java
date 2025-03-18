package com.karasdominik.QuickCart.inventory.domain.dto;

import com.karasdominik.QuickCart.common.dto.ProductId;
import com.karasdominik.QuickCart.inventory.domain.valueobjects.ProductQuantity;
import lombok.Builder;

import java.util.Map;

@Builder
public record ReduceStockLevelsCommand(Map<ProductId, ProductQuantity> toBeReduced) {}
