package com.karasdominik.QuickCart.product.domain.entities;

import com.karasdominik.QuickCart.product.domain.dto.CreateProductCommand;
import com.karasdominik.QuickCart.product.domain.dto.ProductDto;
import com.karasdominik.QuickCart.common.dto.ProductId;
import com.karasdominik.QuickCart.product.domain.valueobjects.Price;
import com.karasdominik.QuickCart.product.domain.valueobjects.ProductDescription;
import com.karasdominik.QuickCart.product.domain.valueobjects.ProductName;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Getter
public class Product {

    @EmbeddedId
    @AttributeOverride(name = "value", column = @Column(name = "id"))
    private ProductId id;
    private ProductName name;
    private ProductDescription description;
    private Price price;

    public static Product create(CreateProductCommand command) {
        return Product.builder()
                .id(ProductId.create())
                .name(command.name())
                .description(command.description())
                .price(command.price())
                .build();
    }

    public ProductDto asDto() {
        return new ProductDto();
    }
}
