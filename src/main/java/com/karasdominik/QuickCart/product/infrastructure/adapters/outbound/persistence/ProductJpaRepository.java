package com.karasdominik.QuickCart.product.infrastructure.adapters.outbound.persistence;

import com.karasdominik.QuickCart.product.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface ProductJpaRepository extends JpaRepository<Product, UUID> {}
