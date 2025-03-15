package com.karasdominik.QuickCart.product.infrastructure.adapters.inbound.rest;

import com.karasdominik.QuickCart.product.domain.valueobjects.Price;
import com.karasdominik.QuickCart.product.domain.valueobjects.ProductDescription;
import com.karasdominik.QuickCart.product.domain.valueobjects.ProductName;

record CreateProductRequest(ProductName name, ProductDescription description, Price price) {}
