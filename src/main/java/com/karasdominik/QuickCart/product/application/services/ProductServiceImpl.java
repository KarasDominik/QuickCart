package com.karasdominik.QuickCart.product.application.services;

import com.karasdominik.QuickCart.common.dto.ProductId;
import com.karasdominik.QuickCart.product.application.ports.inbound.ProductService;
import com.karasdominik.QuickCart.product.application.ports.outbound.ProductEventPublisher;
import com.karasdominik.QuickCart.product.application.ports.outbound.ProductRepository;
import com.karasdominik.QuickCart.product.domain.dto.CreateProductCommand;
import com.karasdominik.QuickCart.product.domain.dto.ProductDto;
import com.karasdominik.QuickCart.product.domain.entities.Product;
import com.karasdominik.QuickCart.product.domain.events.ProductCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository products;
    private final ProductEventPublisher publisher;

    @Override
    public List<ProductDto> getAll() {
        return products.getAll().stream()
                .map(Product::asDto)
                .toList();
    }

    @Override
    public ProductId create(CreateProductCommand command) {
        log.info("Creating new product with name: {}", command.name());
        var id = products.save(Product.create(command));
        log.info("Created new product with name {} and id {}", command.name(), id);
        publisher.publish(ProductCreatedEvent.builder()
                .productId(id)
                .price(command.price().value())
                .name(command.name().value())
                .build());
        return id;
    }
}
