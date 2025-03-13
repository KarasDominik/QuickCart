package com.karasdominik.QuickCart.product.domain.entities;

import com.karasdominik.QuickCart.product.domain.dto.ProductDto;

public class Product {

    public ProductDto asDto() {
        return new ProductDto();
    }
}
