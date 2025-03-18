package com.karasdominik.QuickCart.order.infrastructure.adapters.inbound.rest;

import com.karasdominik.QuickCart.common.BaseAbstractModuleTest;
import com.karasdominik.QuickCart.common.dto.ProductId;
import com.karasdominik.QuickCart.inventory.domain.exceptions.InventoryUpdateException;
import com.karasdominik.QuickCart.inventory.infrastructure.adapters.inbound.event.OrderEventsListener;
import com.karasdominik.QuickCart.order.application.services.OrderAssertions;
import com.karasdominik.QuickCart.order.domain.dto.OrderId;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.io.IOException;

import static com.karasdominik.QuickCart.common.TestUtils.fetchJsonFrom;
import static com.karasdominik.QuickCart.common.TestUtils.parsed;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CONFLICT;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ApplicationModuleTest(webEnvironment = RANDOM_PORT)
@ComponentScan("com.karasdominik.QuickCart.order.application.services")
class OrderControllerModuleTest extends BaseAbstractModuleTest {

    private static final String PATH = "/api/v1/orders";

    @Autowired
    private OrderAssertions assertions;

    @MockitoBean
    private OrderEventsListener listener;

    @Nested
    class CreateTests {

        private static final class Requests {
            private static final String DIR = "src/test/resources/requests/order";
            private static final String VALID = DIR + "/valid.json";
        }

        @Test
        void shouldCreateOrder() throws IOException {
            var request = fetchJsonFrom(Requests.VALID);

            var rawId =
                    given()
                            .contentType("application/json")
                            .body(request)
                        .when()
                            .post(PATH)
                        .then()
                            .statusCode(SC_CREATED)
                            .extract().response()
                            .jsonPath().getString("id");

            assertions.assertOrderCreated(OrderId.of(rawId), parsed(request));
        }

        @Test
        void shouldNotCreateOrderWhenInventoryUpdateFailed() throws IOException {
            var request = fetchJsonFrom(Requests.VALID);
            doThrow(new InventoryUpdateException("Not enough stock for product " + ProductId.create())).when(listener).handle(any());

            given()
                    .contentType("application/json")
                    .body(request)
                .when()
                    .post(PATH)
                .then()
                    .statusCode(SC_CONFLICT);
        }
    }
}
