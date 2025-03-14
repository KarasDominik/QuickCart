package com.karasdominik.QuickCart.product.infrastructure.adapters.outbound.persistence;

import com.karasdominik.QuickCart.product.application.ports.outbound.ProductRepository;
import com.karasdominik.QuickCart.product.domain.dto.ProductId;
import com.karasdominik.QuickCart.product.domain.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductJpaRepository products;

    @Override
    public List<Product> getAll() {
        return products.findAll();
    }

    @Override
    public ProductId save(Product product) {
        return ProductId.of(products.save(product).id());
    }
}
