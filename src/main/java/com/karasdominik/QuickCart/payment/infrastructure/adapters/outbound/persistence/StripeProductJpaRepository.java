package com.karasdominik.QuickCart.payment.infrastructure.adapters.outbound.persistence;

import com.karasdominik.QuickCart.common.dto.ProductId;
import com.karasdominik.QuickCart.payment.domain.entities.StripeProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StripeProductJpaRepository extends JpaRepository<StripeProduct, ProductId> {}
