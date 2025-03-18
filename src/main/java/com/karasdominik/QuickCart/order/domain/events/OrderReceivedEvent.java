package com.karasdominik.QuickCart.order.domain.events;

import com.karasdominik.QuickCart.common.dto.ProductId;

import java.util.Map;

public record OrderReceivedEvent(Map<ProductId, Integer> orderedProducts) implements OrderEvent {}
