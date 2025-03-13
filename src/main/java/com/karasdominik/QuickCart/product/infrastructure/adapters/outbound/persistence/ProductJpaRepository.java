package com.karasdominik.QuickCart.product.infrastructure.adapters.outbound.persistence;

import com.karasdominik.QuickCart.product.application.ports.outbound.ProductRepository;
import com.karasdominik.QuickCart.product.domain.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductJpaRepository implements ProductRepository {

    @Override
    public List<Product> getAll() {
        return List.of();
    }
}
