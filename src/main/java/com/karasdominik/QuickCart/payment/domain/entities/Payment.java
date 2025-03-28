package com.karasdominik.QuickCart.payment.domain.entities;

import com.karasdominik.QuickCart.payment.domain.dto.PaymentId;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Table(name = "payment")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@EqualsAndHashCode(exclude = "orderedProducts")
public class Payment {

    @EmbeddedId
    @AttributeOverride(name = "value", column = @Column(name = "id"))
    private PaymentId id;

    private UUID orderId;

    @OneToMany(mappedBy = "payment", cascade = ALL, orphanRemoval = true)
    @Builder.Default
    private Set<PaymentOrderedProduct> orderedProducts = new HashSet<>();

    public void addProducts(Set<PaymentOrderedProduct> products) {
        orderedProducts.addAll(products);
    }
}
