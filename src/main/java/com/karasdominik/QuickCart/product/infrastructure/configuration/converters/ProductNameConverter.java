package com.karasdominik.QuickCart.product.infrastructure.configuration.converters;

import com.karasdominik.QuickCart.product.domain.valueobjects.ProductName;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ProductNameConverter implements AttributeConverter<ProductName, String> {

    @Override
    public String convertToDatabaseColumn(ProductName productName) {
        return productName.value();
    }

    @Override
    public ProductName convertToEntityAttribute(String value) {
        return ProductName.of(value);
    }
}
