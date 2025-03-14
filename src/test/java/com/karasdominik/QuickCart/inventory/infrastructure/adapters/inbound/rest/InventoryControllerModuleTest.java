package com.karasdominik.QuickCart.inventory.infrastructure.adapters.inbound.rest;

import com.karasdominik.QuickCart.common.BaseAbstractModuleTest;
import com.karasdominik.QuickCart.common.dto.ProductId;
import com.karasdominik.QuickCart.inventory.application.services.InventoryAssertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.modulith.test.ApplicationModuleTest;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static java.util.UUID.randomUUID;
import static org.apache.http.HttpStatus.SC_OK;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ApplicationModuleTest(webEnvironment = RANDOM_PORT)
@ComponentScan("com.karasdominik.QuickCart.inventory.application.services")
class InventoryControllerModuleTest extends BaseAbstractModuleTest {

    private static final String PATH = "/api/v1/inventory";

    @Autowired
    private InventoryAssertions assertions;

    @Nested
    class UpdateTests {

        @Test
        void shouldUpdateStockLevel() {
            var productId = ProductId.of(randomUUID());
            var request = """
                    {
                        "quantity": 10
                    }
                    """;

            given()
                    .contentType(JSON)
                    .body(request)
                .when()
                    .put(PATH + "/product/" + productId)
                .then()
                    .statusCode(SC_OK);

            assertions.assertStockLevelUpdated(productId, 10);
        }
    }
}
