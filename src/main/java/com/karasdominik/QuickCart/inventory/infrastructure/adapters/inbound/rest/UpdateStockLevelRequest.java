package com.karasdominik.QuickCart.inventory.infrastructure.adapters.inbound.rest;

import com.karasdominik.QuickCart.inventory.domain.valueobjects.ProductQuantity;

record UpdateStockLevelRequest(ProductQuantity quantity) {}
