package com.karasdominik.QuickCart.payment.infrastructure.adapters.inbound.rest;

import com.karasdominik.QuickCart.payment.application.ports.inbound.PaymentExternalApi;
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

    private final PaymentExternalApi externalApi;

    @GetMapping("/checkout-url/{orderId}")
    public GetPaymentUrlResponse getPaymentUrl(@PathVariable UUID orderId) {
        return new GetPaymentUrlResponse(externalApi.getPaymentUrl(orderId));
    }
}
