package com.karasdominik.QuickCart.inventory.infrastructure.configuration.converters;

import com.karasdominik.QuickCart.inventory.domain.valueobjects.ProductQuantity;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ProductQuantityConverter implements AttributeConverter<ProductQuantity, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ProductQuantity quantity) {
        return quantity.value();
    }

    @Override
    public ProductQuantity convertToEntityAttribute(Integer integer) {
        return ProductQuantity.of(integer);
    }
}
