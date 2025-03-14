package com.karasdominik.QuickCart.product.infrastructure.adapters.inbound.rest;

import com.karasdominik.QuickCart.product.application.ports.inbound.ProductProvider;
import com.karasdominik.QuickCart.product.domain.dto.ProductId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static com.karasdominik.QuickCart.product.infrastructure.adapters.inbound.rest.ProductRequestMapper.asCommand;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
class ProductController {

    private final ProductProvider service;

    @GetMapping
    GetProductsResponse getAll() {
        return GetProductsResponse.of(service.getAll());
    }

    @PostMapping
    @ResponseStatus(CREATED)
    ProductId create(@RequestBody CreateProductRequest request) {
        return service.create(asCommand(request));
    }
}
