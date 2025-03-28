package com.karasdominik.QuickCart.payment.domain.entities;

import com.karasdominik.QuickCart.order.domain.dto.OrderedProductId;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
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
@Table(name = "payment_ordered_product")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
public class PaymentOrderedProduct {

    @EmbeddedId
    @AttributeOverride(name = "value", column = @Column(name = "id"))
    private OrderedProductId id;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private StripeProduct product;

    private int quantity;
}
