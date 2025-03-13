package com.karasdominik.QuickCart.product.infrastructure.adapters.inbound.rest;

import com.karasdominik.QuickCart.product.domain.dto.ProductDto;

import java.util.List;

record GetProductsResponse(List<Product> products) {

    static GetProductsResponse of(List<ProductDto> dtos) {
        return new GetProductsResponse(dtos.stream()
                .map(Product::of)
                .toList());
    }

    record Product() {

        static Product of(ProductDto dto) {
            return new Product();
        }
    }
}
