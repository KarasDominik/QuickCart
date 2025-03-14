package com.karasdominik.QuickCart.inventory.application.services;

import com.karasdominik.QuickCart.common.dto.ProductId;
import com.karasdominik.QuickCart.inventory.application.ports.outbound.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Component
@RequiredArgsConstructor
public class InventoryAssertions {

    private final InventoryRepository inventory;

    public void assertStockLevelUpdated(ProductId productId, int quantity) {
        assertThat(inventory.getBy(productId))
                .isPresent()
                .hasValueSatisfying(stockLevel -> assertThat(stockLevel.quantity().value()).isEqualTo(quantity));
    }
}
