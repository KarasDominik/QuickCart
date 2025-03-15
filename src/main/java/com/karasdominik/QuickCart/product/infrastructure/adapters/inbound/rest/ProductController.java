package com.karasdominik.QuickCart.product.infrastructure.adapters.inbound.rest;

import com.karasdominik.QuickCart.product.application.ports.inbound.ProductService;
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

    private final ProductService service;

    @GetMapping
    GetProductsResponse getAll() {
        return GetProductsResponse.of(service.getAll());
    }

    @PostMapping
    @ResponseStatus(CREATED)
    CreateProductResponse create(@RequestBody CreateProductRequest request) {
        return CreateProductResponse.of(service.create(asCommand(request)));
    }
}
