package com.karasdominik.QuickCart.inventory.application.ports.inbound;

import com.karasdominik.QuickCart.inventory.domain.dto.UpdateStockLevelCommand;

public interface InventoryService {

    void update(UpdateStockLevelCommand command);
}
