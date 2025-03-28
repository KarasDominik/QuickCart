package com.karasdominik.QuickCart.product.domain.events;

import com.karasdominik.QuickCart.common.dto.ProductId;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductCreatedEvent(ProductId productId, BigDecimal price, String name) implements ProductEvent {}
