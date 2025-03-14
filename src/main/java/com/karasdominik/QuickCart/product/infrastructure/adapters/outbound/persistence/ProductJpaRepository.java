package com.karasdominik.QuickCart.product.infrastructure.adapters.outbound.persistence;

import com.karasdominik.QuickCart.common.dto.ProductId;
import com.karasdominik.QuickCart.product.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

interface ProductJpaRepository extends JpaRepository<Product, ProductId> {}
