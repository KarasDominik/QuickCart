package com.karasdominik.QuickCart.product.domain.dto;

import com.karasdominik.QuickCart.common.fields.FieldInfo;
import com.karasdominik.QuickCart.product.domain.valueobjects.Price;
import lombok.Builder;

import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notBlank;
import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notNull;

@Builder
public record CreateProductCommand(String name, String description, Price price) {

    private static final FieldInfo NAME = new FieldInfo("name");
    private static final FieldInfo DESCRIPTION = new FieldInfo("description");
    private static final FieldInfo PRICE = new FieldInfo("price");

    public CreateProductCommand {
        notBlank(name, NAME);
        notBlank(description, DESCRIPTION);
        notNull(price, PRICE);
    }
}
