package com.karasdominik.QuickCart.inventory.infrastructure.adapters.inbound.rest;

import com.karasdominik.QuickCart.common.BaseAbstractModuleTest;
import com.karasdominik.QuickCart.common.dto.ProductId;
import com.karasdominik.QuickCart.inventory.application.services.InventoryAssertions;
import com.karasdominik.QuickCart.inventory.application.services.InventoryFixtures;
import com.karasdominik.QuickCart.inventory.domain.StockLevelsForTests.IPHONE_15_STOCK_LEVEL;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.modulith.test.ApplicationModuleTest;

import java.io.IOException;

import static com.karasdominik.QuickCart.common.TestUtils.fetchJsonFrom;
import static com.karasdominik.QuickCart.common.TestUtils.parsed;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.apache.http.HttpStatus.SC_OK;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ApplicationModuleTest(webEnvironment = RANDOM_PORT)
@ComponentScan("com.karasdominik.QuickCart.inventory.application.services")
class InventoryControllerModuleTest extends BaseAbstractModuleTest {

    private static final String PATH = "/api/v1/inventory";

    @Autowired
    private InventoryAssertions assertions;
    @Autowired
    private InventoryFixtures fixtures;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        fixtures.setUp();
    }

    @AfterEach
    protected void tearDown() {
        fixtures.tearDown();
    }

    @Nested
    class UpdateTests {

        private static final class Requests {
            private static final String DIR = "src/test/resources/requests/inventory/";
            private static final String VALID = DIR + "/valid.json";
        }

        @Test
        void shouldUpdateStockLevelOfExistingProduct() throws IOException {
            var productId = IPHONE_15_STOCK_LEVEL.PRODUCT_ID;
            var request = fetchJsonFrom(Requests.VALID);

            given()
                    .contentType(JSON)
                    .body(request)
                .when()
                    .put(PATH + "/product/" + productId)
                .then()
                    .statusCode(SC_OK);

            var expected = Integer.parseInt(parsed(request)
                    .get("quantity").toString());
            assertions.assertStockLevelUpdated(productId, expected);
        }

        @Test
        void shouldUpdateStockLevelOfNewProduct() throws IOException {
            var productId = ProductId.create();
            var request = fetchJsonFrom(Requests.VALID);

            given()
                    .contentType(JSON)
                    .body(request)
                    .when()
                    .put(PATH + "/product/" + productId)
                    .then()
                    .statusCode(SC_OK);

            var expected = Integer.parseInt(parsed(request)
                    .get("quantity").toString());
            assertions.assertStockLevelUpdated(productId, expected);
        }
    }
}
