package com.karasdominik.QuickCart.order.domain.events;

import com.karasdominik.QuickCart.common.dto.ProductId;

import java.util.Map;
import java.util.UUID;

public record OrderCreatedEvent(UUID orderId, String email, Map<ProductId, Integer> orderedProducts) implements OrderEvent {}
