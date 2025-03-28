package com.karasdominik.QuickCart.payment.infrastructure.adapters.inbound.rest;

import com.karasdominik.QuickCart.common.BaseAbstractModuleTest;
import com.karasdominik.QuickCart.payment.application.services.PaymentFixtures;
import com.karasdominik.QuickCart.payment.domain.entities.PaymentsForTests.First_Payment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.modulith.test.ApplicationModuleTest;

import static com.karasdominik.QuickCart.payment.domain.entities.PaymentsForTests.First_Payment.ORDER_ID;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ApplicationModuleTest(webEnvironment = RANDOM_PORT)
@ComponentScan({
        "com.karasdominik.QuickCart.payment.application.services",
        "com.karasdominik.QuickCart.payment.infrastructure.configuration.stripe"
})
class PaymentControllerModuleTest extends BaseAbstractModuleTest {

    private static final String PATH = "/api/v1/payment";

    @Autowired
    private PaymentFixtures payments;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        payments.setUp();
    }

    @AfterEach
    protected void tearDown() {
        payments.tearDown();
    }

    @Nested
    class GetPaymentUrl {

            private static final String CHECKOUT_PATH = PATH + "/checkout-url/{orderId}";

            @Test
            void shouldReturnCheckoutSessionUrl() {
                given()
                    .when()
                        .get(CHECKOUT_PATH, ORDER_ID)
                    .then()
                        .statusCode(200)
                        .body("checkoutUrl", is(First_Payment.CHECKOUT_URL));
            }
    }
}
