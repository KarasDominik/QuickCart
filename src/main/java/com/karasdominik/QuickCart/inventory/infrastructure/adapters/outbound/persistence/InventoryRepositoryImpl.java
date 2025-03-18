package com.karasdominik.QuickCart.inventory.infrastructure.adapters.outbound.persistence;

import com.karasdominik.QuickCart.common.dto.ProductId;
import com.karasdominik.QuickCart.inventory.application.ports.outbound.InventoryRepository;
import com.karasdominik.QuickCart.inventory.domain.entities.StockLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
class InventoryRepositoryImpl implements InventoryRepository {

    private final InventoryJpaRepository inventory;

    @Override
    public Optional<StockLevel> getBy(ProductId productId) {
        return inventory.findByProductId(productId);
    }

    @Override
    public StockLevel findOrThrowBy(ProductId productId) {
        return inventory.findOrThrowBy(productId);
    }

    @Override
    public void save(StockLevel stockLevel) {
        inventory.save(stockLevel);
    }

    @Override
    public void deleteAll() {
        inventory.deleteAll();
    }
}
