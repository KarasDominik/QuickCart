package com.karasdominik.QuickCart.payment.domain.entities;

import com.karasdominik.QuickCart.common.dto.ProductId;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "stripe_product")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode
@Getter
public class StripeProduct {

    public static StripeProduct create(ProductId productId, String stripeId) {
        return StripeProduct.builder()
                .id(productId)
                .stripeId(stripeId)
                .build();
    }

    @EmbeddedId
    @AttributeOverride(name = "value", column = @jakarta.persistence.Column(name = "id"))
    private ProductId id;
    private String stripeId;
}
