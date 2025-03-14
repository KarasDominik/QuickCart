package com.karasdominik.QuickCart.product.infrastructure.inbound.rest;

import com.karasdominik.QuickCart.common.BaseAbstractITTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.test.ApplicationModuleTest;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ApplicationModuleTest(webEnvironment = RANDOM_PORT)
public class ProductControllerITTest extends BaseAbstractITTest {

    private static final String PATH = "/api/v1/products";

    @Nested
    class CreateTests {

        @Test
        void shouldCreateProduct() {
            var request = """
                    {
                        "name": "iPhone 15",
                        "description": "Description 1",
                        "price": 100.00
                    }
                    """;

            given()
                    .contentType(JSON)
                    .body(request)
                .when()
                    .post(PATH)
                .then()
                    .statusCode(SC_CREATED);
        }
    }
}
