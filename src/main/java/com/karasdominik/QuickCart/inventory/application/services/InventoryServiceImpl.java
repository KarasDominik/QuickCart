package com.karasdominik.QuickCart.inventory.application.services;

import com.karasdominik.QuickCart.inventory.application.ports.inbound.InventoryMessagingApi;
import com.karasdominik.QuickCart.inventory.application.ports.inbound.InventoryService;
import com.karasdominik.QuickCart.inventory.application.ports.outbound.InventoryRepository;
import com.karasdominik.QuickCart.inventory.domain.dto.ReduceStockLevelsCommand;
import com.karasdominik.QuickCart.inventory.domain.dto.UpdateStockLevelCommand;
import com.karasdominik.QuickCart.inventory.domain.entities.StockLevel;
import com.karasdominik.QuickCart.inventory.domain.exceptions.InventoryUpdateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.karasdominik.QuickCart.common.fields.GeneralAssertions.isTrue;

@Service
@RequiredArgsConstructor
@Slf4j
class InventoryServiceImpl implements InventoryService, InventoryMessagingApi {

    private final InventoryRepository inventory;

    @Override
    @Transactional
    public void update(UpdateStockLevelCommand command) {
        log.info("Updating stock level for product {}", command.productId());
        inventory.getBy(command.productId())
                .ifPresentOrElse(stockLevel -> stockLevel.update(command.quantity()),
                        () -> inventory.save(StockLevel.create(command)));
    }

    @Override
    @Transactional
    public void update(ReduceStockLevelsCommand command) {
        log.info("Reducing stock levels after order received");
        command.toBeReduced().forEach((productId, quantity) -> {
            var stockLevel = inventory.findOrThrowBy(productId);
            isTrue(stockLevel.hasEnough(quantity), () -> new InventoryUpdateException("Not enough stock for product " + productId));
            stockLevel.reduce(quantity);
        });
    }
}
