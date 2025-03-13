package com.karasdominik.QuickCart.product.infrastructure.adapters.inbound.rest;

import com.karasdominik.QuickCart.product.application.ports.inbound.ProductProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
class ProductController {

    private final ProductProvider service;

    @GetMapping
    GetProductsResponse getAll() {
        return GetProductsResponse.of(service.getAll());
    }
}
