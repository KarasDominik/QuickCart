package com.karasdominik.QuickCart.payment.infrastructure.adapters.inbound.rest;

import com.karasdominik.QuickCart.payment.application.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/payment")
class PaymentController {

    private final PaymentService service;

    @GetMapping("/url/{orderId}")
    public GetPaymentUrlResponse getPaymentUrl(@PathVariable UUID orderId) {
        return new GetPaymentUrlResponse(service.getPaymentUrl(orderId));
    }
}
