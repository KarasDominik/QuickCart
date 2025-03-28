package com.karasdominik.QuickCart.payment.domain.entities;

import com.karasdominik.QuickCart.payment.domain.dto.PaymentId;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "payment")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
public class Payment {

    @EmbeddedId
    @AttributeOverride(name = "value", column = @Column(name = "id"))
    private PaymentId id;

    private UUID orderId;

    private String checkoutUrl;
}
