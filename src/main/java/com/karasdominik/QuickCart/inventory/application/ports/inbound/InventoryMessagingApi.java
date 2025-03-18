package com.karasdominik.QuickCart.inventory.application.ports.inbound;

import com.karasdominik.QuickCart.inventory.domain.dto.ReduceStockLevelsCommand;

public interface InventoryMessagingApi {

    void update(ReduceStockLevelsCommand command);
}
