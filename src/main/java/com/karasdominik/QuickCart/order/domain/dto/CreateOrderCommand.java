package com.karasdominik.QuickCart.order.domain.dto;

import com.karasdominik.QuickCart.common.dto.ProductId;
import com.karasdominik.QuickCart.common.fields.FieldInfo;
import com.karasdominik.QuickCart.order.domain.valueobjects.Email;
import com.karasdominik.QuickCart.order.domain.valueobjects.OrderQuantity;
import lombok.Builder;

import java.util.Map;

import static com.karasdominik.QuickCart.common.fields.FieldAssertions.isValid;
import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notEmpty;
import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notNull;

@Builder
public record CreateOrderCommand(Email email, Map<ProductId, OrderQuantity> orderedProducts) {

    private static final FieldInfo ORDERED_PRODUCTS = new FieldInfo("orderedProducts");

    public CreateOrderCommand {
        notEmpty(orderedProducts, ORDERED_PRODUCTS);
        notNull(orderedProducts, ORDERED_PRODUCTS);
        isValid(productsNotNull(orderedProducts), ORDERED_PRODUCTS);
    }

    private boolean productsNotNull(Map<ProductId, OrderQuantity> orderedProducts) {
        return orderedProducts.keySet().stream()
                .noneMatch(key -> key == null || orderedProducts.get(key) == null);
    }
}
