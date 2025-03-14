package com.karasdominik.QuickCart.product.infrastructure.adapters.inbound.rest;

import com.karasdominik.QuickCart.product.domain.valueobjects.Price;

record CreateProductRequest(String name, String description, Price price) {}
