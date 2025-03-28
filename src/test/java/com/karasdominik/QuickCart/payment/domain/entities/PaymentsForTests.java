package com.karasdominik.QuickCart.payment.domain.entities;

import com.karasdominik.QuickCart.payment.domain.dto.PaymentId;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class PaymentsForTests {

    public static final class First_Payment {
        public static final PaymentId ID = PaymentId.of("93cda2a6-1d56-4c08-ba0c-045e5b9f1f99");
        public static final UUID ORDER_ID = UUID.fromString("93cda2a6-1d56-4c08-ba0c-045e5b9f1f00");
        public static final String CHECKOUT_URL = "https://checkout.stripe.com/c/pay/cs_test_a1AtVOnrQjFcossDIrY2UJ9bOMFSNLXp8vnb4FMF67UZs8sNKNG395d64n#fidkdWxOYHwnPyd1blpxYHZxWjA0VzFQfUZVN2Rmc0wxTHBXRENzUHRGVGFKQGFfUHJiVUN2TD1IN3xkSE5xR3MydzxvQFR%2FZkBhS3VWUzN3b3d%2FbnE3ZFZKd1VfXUBIUjE3Z25yalRIR09zNTVTdG1cMHBkRicpJ2N3amhWYHdzYHcnP3F3cGApJ2lkfGpwcVF8dWAnPyd2bGtiaWBabHFgaCcpJ2BrZGdpYFVpZGZgbWppYWB3dic%2FcXdwYHgl";
        public static final PaymentTestData DATA = new PaymentTestData(ID, ORDER_ID, CHECKOUT_URL);
    }

    public record PaymentTestData(PaymentId id, UUID orderId, String checkoutUrl) {}
}
