package com.karasdominik.QuickCart.inventory.application.services;

import com.karasdominik.QuickCart.inventory.application.ports.inbound.InventoryService;
import com.karasdominik.QuickCart.inventory.application.ports.outbound.InventoryRepository;
import com.karasdominik.QuickCart.inventory.domain.dto.UpdateStockLevelCommand;
import com.karasdominik.QuickCart.inventory.domain.entities.StockLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventory;

    @Override
    @Transactional
    public void update(UpdateStockLevelCommand command) {
        log.info("Updating stock level for product {}", command.productId());
        inventory.getBy(command.productId())
                .ifPresentOrElse(stockLevel -> stockLevel.update(command.quantity()),
                        () -> inventory.save(StockLevel.create(command)));
    }


}
