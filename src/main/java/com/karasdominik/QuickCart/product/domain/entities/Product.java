package com.karasdominik.QuickCart.product.domain.entities;

import com.karasdominik.QuickCart.product.domain.dto.CreateProductCommand;
import com.karasdominik.QuickCart.product.domain.dto.ProductDto;
import com.karasdominik.QuickCart.product.domain.dto.ProductId;
import com.karasdominik.QuickCart.product.domain.valueobjects.Price;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

    @Id
    private ProductId id;
    private String name;
    private String description;
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
