package com.karasdominik.QuickCart.product.application.ports.outbound;

import com.karasdominik.QuickCart.product.domain.dto.ProductId;
import com.karasdominik.QuickCart.product.domain.entities.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> getAll();

    ProductId save(Product product);
}
