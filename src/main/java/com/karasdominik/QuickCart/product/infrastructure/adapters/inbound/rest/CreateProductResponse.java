package com.karasdominik.QuickCart.product.infrastructure.adapters.inbound.rest;

import com.karasdominik.QuickCart.common.dto.ProductId;

record CreateProductResponse(ProductId id) {

    static CreateProductResponse of(ProductId id) {
        return new CreateProductResponse(id);
    }
}
