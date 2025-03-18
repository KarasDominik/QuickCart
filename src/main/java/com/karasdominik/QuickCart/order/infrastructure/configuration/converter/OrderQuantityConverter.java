package com.karasdominik.QuickCart.order.infrastructure.configuration.converter;

import com.karasdominik.QuickCart.order.domain.valueobjects.OrderQuantity;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class OrderQuantityConverter implements AttributeConverter<OrderQuantity, Integer> {

    @Override
    public Integer convertToDatabaseColumn(OrderQuantity quantity) {
        return quantity.value();
    }

    @Override
    public OrderQuantity convertToEntityAttribute(Integer value) {
        return OrderQuantity.of(value);
    }
}
