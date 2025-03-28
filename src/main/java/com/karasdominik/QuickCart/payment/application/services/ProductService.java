package com.karasdominik.QuickCart.payment.application.services;

import com.karasdominik.QuickCart.payment.application.ports.inbound.ProductCreator;
import com.karasdominik.QuickCart.payment.application.ports.outbound.StripeClient;
import com.karasdominik.QuickCart.payment.application.ports.outbound.StripeProductRepository;
import com.karasdominik.QuickCart.payment.domain.dto.CreateProductCommand;
import com.karasdominik.QuickCart.payment.domain.entities.StripeProduct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
class ProductService implements ProductCreator {

    private final StripeClient stripe;
    private final StripeProductRepository products;

    @Override
    public void create(CreateProductCommand command) {
        log.info("Creating new product {}", command.name());
        var productStripeId = stripe.createProduct(command);
        products.save(StripeProduct.create(command.productId(), productStripeId));
        log.info("Product {} created successfully", command.name());
    }
}
