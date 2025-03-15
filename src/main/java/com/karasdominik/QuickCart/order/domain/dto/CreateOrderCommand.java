package com.karasdominik.QuickCart.order.domain.dto;

import com.karasdominik.QuickCart.common.dto.ProductId;
import com.karasdominik.QuickCart.common.fields.FieldInfo;
import com.karasdominik.QuickCart.order.domain.valueobjects.OrderQuantity;

import java.util.Map;

import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notNull;

public record CreateOrderCommand(Map<ProductId, OrderQuantity> orderedProducts) {

    private static final FieldInfo ORDERED_PRODUCTS = new FieldInfo("orderedProducts");

    public CreateOrderCommand {
        notNull(orderedProducts, ORDERED_PRODUCTS);
    }
}
