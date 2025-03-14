package com.karasdominik.QuickCart.product.infrastructure.adapters.inbound.rest;

import com.karasdominik.QuickCart.product.domain.dto.CreateProductCommand;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
class ProductRequestMapper {

    static CreateProductCommand asCommand(CreateProductRequest request) {
        return CreateProductCommand.builder()
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .build();
    }
}
