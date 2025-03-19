package com.karasdominik.QuickCart.order.domain.events;

import com.karasdominik.QuickCart.common.dto.ProductId;
import com.karasdominik.QuickCart.order.domain.valueobjects.Email;

import java.util.Map;

public record OrderReceivedEvent(Email email, Map<ProductId, Integer> orderedProducts) implements OrderEvent {}
