package com.karasdominik.QuickCart.inventory.domain.entities;

import com.karasdominik.QuickCart.common.dto.ProductId;
import com.karasdominik.QuickCart.inventory.domain.dto.StockLevelId;
import com.karasdominik.QuickCart.inventory.domain.dto.UpdateStockLevelCommand;
import com.karasdominik.QuickCart.inventory.domain.valueobjects.ProductQuantity;
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
@Builder
@EqualsAndHashCode
@Getter
public class StockLevel {

    public static StockLevel create(UpdateStockLevelCommand command) {
        return StockLevel.builder()
                .id(StockLevelId.create())
                .productId(command.productId())
                .quantity(command.quantity())
                .build();
    }

    @EmbeddedId
    @AttributeOverride(name = "value", column = @Column(name = "id"))
    private StockLevelId id;

    private ProductId productId;

    private ProductQuantity quantity;

    public void update(ProductQuantity stockQuantity) {
        this.quantity = stockQuantity;
    }
}
