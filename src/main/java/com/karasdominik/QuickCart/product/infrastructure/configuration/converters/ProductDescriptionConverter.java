package com.karasdominik.QuickCart.product.infrastructure.configuration.converters;

import com.karasdominik.QuickCart.product.domain.valueobjects.ProductDescription;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ProductDescriptionConverter implements AttributeConverter<ProductDescription, String> {

    @Override
    public String convertToDatabaseColumn(ProductDescription description) {
        return description.value();
    }

    @Override
    public ProductDescription convertToEntityAttribute(String value) {
        return ProductDescription.of(value);
    }
}
