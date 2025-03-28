package com.karasdominik.QuickCart.payment.domain.dto;

import com.karasdominik.QuickCart.common.dto.ProductId;
import com.karasdominik.QuickCart.common.fields.FieldInfo;
import com.karasdominik.QuickCart.payment.domain.valueobjects.Price;
import lombok.Builder;

import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notBlank;
import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notNull;

@Builder
public record CreateProductCommand(ProductId productId, Price price, String name) {

    private static final FieldInfo PRODUCT_ID = new FieldInfo("productId");
    private static final FieldInfo PRICE = new FieldInfo("price");
    private static final FieldInfo NAME = new FieldInfo("name");

    public CreateProductCommand {
        notNull(productId, PRODUCT_ID);
        notNull(price, PRICE);
        notBlank(name, NAME);
    }
}
