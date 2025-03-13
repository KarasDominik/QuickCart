package com.karasdominik.QuickCart.product.application.ports.inbound;

import com.karasdominik.QuickCart.product.domain.dto.ProductDto;

import java.util.List;

public interface ProductProvider {

    List<ProductDto> getAll();
}
