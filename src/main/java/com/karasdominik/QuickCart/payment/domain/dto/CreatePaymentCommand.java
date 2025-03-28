package com.karasdominik.QuickCart.payment.domain.dto;

import com.karasdominik.QuickCart.common.dto.ProductId;
import lombok.Builder;

import java.util.Map;
import java.util.UUID;

@Builder
public record CreatePaymentCommand(UUID orderId, Map<ProductId, Integer> products) {}
