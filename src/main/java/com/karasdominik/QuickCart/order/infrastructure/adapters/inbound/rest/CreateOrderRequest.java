package com.karasdominik.QuickCart.order.infrastructure.adapters.inbound.rest;

import com.karasdominik.QuickCart.common.dto.ProductId;
import com.karasdominik.QuickCart.order.domain.valueobjects.OrderQuantity;

import java.util.Map;

record CreateOrderRequest(Map<ProductId, OrderQuantity> orderedProducts) {}
