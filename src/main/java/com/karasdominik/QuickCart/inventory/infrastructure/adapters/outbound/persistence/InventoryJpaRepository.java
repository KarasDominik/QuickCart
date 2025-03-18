package com.karasdominik.QuickCart.inventory.infrastructure.adapters.outbound.persistence;

import com.karasdominik.QuickCart.common.dto.ProductId;
import com.karasdominik.QuickCart.inventory.domain.dto.StockLevelId;
import com.karasdominik.QuickCart.inventory.domain.entities.StockLevel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface InventoryJpaRepository extends JpaRepository<StockLevel, StockLevelId> {

    Optional<StockLevel> findByProductId(ProductId productId);

    default StockLevel findOrThrowBy(ProductId productId) {
        return findByProductId(productId)
                .orElseThrow(() -> new RuntimeException("Stock level not found"));
    }
}
