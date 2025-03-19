package com.karasdominik.QuickCart.order.domain.events;

import java.util.UUID;

public record OrderCreatedEvent(UUID orderId, String email) implements OrderEvent {}
