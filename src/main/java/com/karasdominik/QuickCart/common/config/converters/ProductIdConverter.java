package com.karasdominik.QuickCart.common.config.converters;

import com.karasdominik.QuickCart.common.dto.ProductId;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.UUID;

@Converter(autoApply = true)
public class ProductIdConverter implements AttributeConverter<ProductId, UUID> {

    @Override
    public UUID convertToDatabaseColumn(ProductId productId) {
        return productId.value();
    }

    @Override
    public ProductId convertToEntityAttribute(UUID value) {
        return ProductId.of(value);
    }
}
