package com.karasdominik.QuickCart.payment.application.services;

import com.karasdominik.QuickCart.payment.application.ports.inbound.PaymentCreator;
import com.karasdominik.QuickCart.payment.application.ports.inbound.PaymentExternalApi;
import com.stripe.Stripe;
import com.stripe.model.Product;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService implements PaymentCreator, PaymentExternalApi {

    @Override
    public void create() {
        // create payment
    }

    @Override
    public String getPaymentUrl(UUID orderId) {
        Stripe.apiKey = "sk_test_51R4UxCP2acvI4IuRPfQLnaDzJyF89qzbRRdrnzCw2qvW6jigRxcVXDwkTd7eqaxmJbOPZO5smLpJ1Gn4UqBCFJx0005hAYauaD";
        try {
            SessionCreateParams params =
                    SessionCreateParams.builder()
                            .setSuccessUrl("https://example.com/success")
                            .addLineItem(
                                    SessionCreateParams.LineItem.builder()
                                            .setPrice(Product.retrieve("prod_RyRsunu6kfzkvg").getDefaultPrice())
                                            .setQuantity(2L)
                                            .build()
                            )
                            .setMode(SessionCreateParams.Mode.PAYMENT)
                            .build();
        Session session = Session.create(params);
        return session.getUrl();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
