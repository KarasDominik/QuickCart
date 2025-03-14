package com.karasdominik.QuickCart.inventory.application.services;

import com.karasdominik.QuickCart.inventory.application.ports.outbound.InventoryRepository;
import com.karasdominik.QuickCart.inventory.domain.StockLevelsForTests.IPHONE_14_STOCK_LEVEL;
import com.karasdominik.QuickCart.inventory.domain.StockLevelsForTests.IPHONE_15_STOCK_LEVEL;
import com.karasdominik.QuickCart.inventory.domain.dto.StockLevelTestData;
import com.karasdominik.QuickCart.inventory.domain.entities.StockLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InventoryFixtures {

    private final InventoryRepository inventory;

    public void setUp() {
        setUp(IPHONE_15_STOCK_LEVEL.DATA);
        setUp(IPHONE_14_STOCK_LEVEL.DATA);
    }

    public void tearDown() {
        inventory.deleteAll();
    }

    private void setUp(StockLevelTestData stockLevel) {
        inventory.save(StockLevel.builder()
                .id(stockLevel.id())
                .productId(stockLevel.productId())
                .quantity(stockLevel.quantity())
                .build());
    }
}
