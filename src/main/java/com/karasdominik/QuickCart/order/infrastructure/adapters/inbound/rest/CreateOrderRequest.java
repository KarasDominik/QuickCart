package com.karasdominik.QuickCart.order.infrastructure.adapters.inbound.rest;

import com.karasdominik.QuickCart.common.dto.ProductId;
import com.karasdominik.QuickCart.common.fields.FieldInfo;
import com.karasdominik.QuickCart.order.domain.valueobjects.OrderQuantity;

import java.util.List;

import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notEmpty;
import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notNull;

record CreateOrderRequest(List<OrderedProduct> orderedProducts) {

    private static final FieldInfo ORDERED_PRODUCTS = new FieldInfo("orderedProducts");

    CreateOrderRequest {
        notNull(orderedProducts, ORDERED_PRODUCTS);
        notEmpty(orderedProducts, ORDERED_PRODUCTS);
    }

    record OrderedProduct(ProductId productId, OrderQuantity quantity) {

        private static final FieldInfo PRODUCT_ID = new FieldInfo("productId");
        private static final FieldInfo QUANTITY = new FieldInfo("quantity");

        OrderedProduct {
            notNull(productId, PRODUCT_ID);
            notNull(quantity, QUANTITY);
        }
    }
}
