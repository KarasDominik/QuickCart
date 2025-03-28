package com.karasdominik.QuickCart.product.infrastructure.adapters.inbound.rest;

import com.karasdominik.QuickCart.common.BaseAbstractModuleTest;
import com.karasdominik.QuickCart.common.dto.ProductId;
import com.karasdominik.QuickCart.product.infrastructure.adapters.outbound.persistence.ProductAssertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.modulith.test.ApplicationModuleTest;

import java.io.IOException;
import java.util.Map;

import static com.karasdominik.QuickCart.common.TestUtils.fetchJsonFrom;
import static com.karasdominik.QuickCart.common.TestUtils.parsed;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ApplicationModuleTest(webEnvironment = RANDOM_PORT)
@ComponentScan("com.karasdominik.QuickCart.product.infrastructure.adapters.outbound.persistence")
public class ProductControllerModuleTest extends BaseAbstractModuleTest {

    private static final String PATH = "/api/v1/products";

    @Autowired
    private ProductAssertions assertions;

    @Nested
    class CreateTests {

        private static final class Requests {
            private static final String DIR = "src/test/resources/requests/product/";
            private static final String VALID = DIR + "/valid.json";
        }

        @Test
        void shouldCreateProduct() throws IOException {
            var request = fetchJsonFrom(Requests.VALID);

            var rawId =
                    given()
                            .contentType(JSON)
                            .body(request)
                        .when()
                            .post(PATH)
                        .then()
                            .statusCode(SC_CREATED)
                            .extract().response()
                            .jsonPath().getString("id");

            Map<String, Object> expected = parsed(request);

            assertions.assertProductCreated(ProductId.of(rawId), expected);
        }
    }
}
