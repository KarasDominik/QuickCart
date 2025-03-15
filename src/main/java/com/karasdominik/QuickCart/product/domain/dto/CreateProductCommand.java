package com.karasdominik.QuickCart.product.domain.dto;

import com.karasdominik.QuickCart.common.fields.FieldInfo;
import com.karasdominik.QuickCart.product.domain.valueobjects.Price;
import com.karasdominik.QuickCart.product.domain.valueobjects.ProductDescription;
import com.karasdominik.QuickCart.product.domain.valueobjects.ProductName;
import lombok.Builder;

import static com.karasdominik.QuickCart.common.fields.FieldAssertions.notNull;

@Builder
public record CreateProductCommand(ProductName name, ProductDescription description, Price price) {

    private static final FieldInfo NAME = new FieldInfo("name");
    private static final FieldInfo DESCRIPTION = new FieldInfo("description");
    private static final FieldInfo PRICE = new FieldInfo("price");

    public CreateProductCommand {
        notNull(name, NAME);
        notNull(description, DESCRIPTION);
        notNull(price, PRICE);
    }
}
