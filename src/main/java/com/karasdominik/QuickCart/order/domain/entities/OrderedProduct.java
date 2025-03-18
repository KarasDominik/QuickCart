package com.karasdominik.QuickCart.order.domain.entities;

import com.karasdominik.QuickCart.common.dto.ProductId;
import com.karasdominik.QuickCart.order.domain.dto.OrderedProductId;
import com.karasdominik.QuickCart.order.domain.valueobjects.OrderQuantity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ordered_product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Getter
public class OrderedProduct {

    @EmbeddedId
    @AttributeOverride(name = "value", column = @jakarta.persistence.Column(name = "id"))
    private OrderedProductId id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private ProductId productId;

    private OrderQuantity quantity;
}
