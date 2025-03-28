package com.karasdominik.QuickCart.payment.infrastructure.adapters.outbound.stripe;

import com.karasdominik.QuickCart.payment.application.ports.outbound.StripeClient;
import com.karasdominik.QuickCart.payment.domain.dto.CreateProductCommand;
import com.karasdominik.QuickCart.payment.domain.exceptions.StripeException;
import com.stripe.Stripe;
import com.stripe.model.Product;
import com.stripe.param.ProductCreateParams;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
class StripeClientImpl implements StripeClient {

    @Value("${quickcart.stripe.api-key}")
    private String apiKey;

    @Override
    public String createProduct(CreateProductCommand command) {
        try {
            Stripe.apiKey = apiKey;
            log.info("Creating new product {} on Stripe", command.name());
            var params = ProductCreateParams.builder()
                    .setName(command.name())
                    .setDefaultPriceData(
                            ProductCreateParams.DefaultPriceData.builder()
                                    .setCurrency("pln")
                                    .setUnitAmount(command.price().value().longValue() * 100)
                                    .build())
                    .build();

            var product = Product.create(params);
            log.info("Product {} created successfully with id {}", command.name(), product.getId());
            return product.getId();
        } catch (Exception e) {
            log.error("Error creating Stripe product {}", command.name());
            throw new StripeException("Error creating Stripe product", e);
        }
    }
}
