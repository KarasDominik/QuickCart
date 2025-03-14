package com.karasdominik.QuickCart.inventory.infrastructure.adapters.inbound.rest;

import com.karasdominik.QuickCart.inventory.application.ports.inbound.InventoryService;
import com.karasdominik.QuickCart.common.dto.ProductId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.karasdominik.QuickCart.inventory.infrastructure.adapters.inbound.rest.RequestMapper.asCommand;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/inventory")
class InventoryController {

    private final InventoryService service;

    @PutMapping("/product/{productId}")
    void update(@PathVariable String productId, @RequestBody UpdateStockLevelRequest request) {
        service.update(asCommand(ProductId.of(productId), request));
    }
}
