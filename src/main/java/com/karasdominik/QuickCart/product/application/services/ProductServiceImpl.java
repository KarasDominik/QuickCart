package com.karasdominik.QuickCart.product.application.services;

import com.karasdominik.QuickCart.product.application.ports.inbound.ProductProvider;
import com.karasdominik.QuickCart.product.application.ports.outbound.ProductRepository;
import com.karasdominik.QuickCart.product.domain.dto.ProductDto;
import com.karasdominik.QuickCart.product.domain.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductProvider {

    private final ProductRepository products;

    @Override
    public List<ProductDto> getAll() {
        return products.getAll().stream()
                .map(Product::asDto)
                .toList();
    }
}
