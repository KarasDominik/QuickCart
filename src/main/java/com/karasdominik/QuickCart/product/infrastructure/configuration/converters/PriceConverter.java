package com.karasdominik.QuickCart.product.infrastructure.configuration.converters;

import com.karasdominik.QuickCart.product.domain.valueobjects.Price;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.math.BigDecimal;

@Converter(autoApply = true)
public class PriceConverter implements AttributeConverter<Price, BigDecimal> {

    @Override
    public BigDecimal convertToDatabaseColumn(Price price) {
        return price.value();
    }

    @Override
    public Price convertToEntityAttribute(BigDecimal value) {
        return Price.of(value);
    }
}
