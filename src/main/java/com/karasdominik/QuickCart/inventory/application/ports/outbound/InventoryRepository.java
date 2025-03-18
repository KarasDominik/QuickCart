package com.karasdominik.QuickCart.inventory.application.ports.outbound;

import com.karasdominik.QuickCart.common.dto.ProductId;
import com.karasdominik.QuickCart.inventory.domain.entities.StockLevel;

import java.util.Optional;

public interface InventoryRepository {

    Optional<StockLevel> getBy(ProductId productId);

    StockLevel findOrThrowBy(ProductId productId);

    void save(StockLevel stockLevel);

    void deleteAll();
}
