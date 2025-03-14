package com.karasdominik.QuickCart.product.application.ports.inbound;

import com.karasdominik.QuickCart.product.domain.dto.CreateProductCommand;
import com.karasdominik.QuickCart.product.domain.dto.ProductDto;
import com.karasdominik.QuickCart.common.dto.ProductId;

import java.util.List;

public interface ProductProvider {

    List<ProductDto> getAll();

    ProductId create(CreateProductCommand command);
}
