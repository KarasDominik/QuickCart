package com.karasdominik.QuickCart.product.infrastructure.adapters.inbound.rest;

import com.karasdominik.QuickCart.common.BaseAbstractWebTest;
import com.karasdominik.QuickCart.product.application.ports.inbound.ProductService;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.stream.Stream;

import static com.karasdominik.QuickCart.common.TestUtils.fetchJsonFrom;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
@ComponentScan("com.karasdominik.QuickCart.product.infrastructure.configuration.serialization")
class ProductControllerWebTest extends BaseAbstractWebTest {

    private static final String PATH = "/api/v1/products";

    @MockitoBean
    private ProductService service;

    @Nested
    class CreateTests {

        private static final class Requests {
            private static final String DIR = "src/test/resources/requests/product/";

            private static final String INVALID_DESCRIPTION_BLANK = DIR + "invalid_description_blank.json";
            private static final String INVALID_NAME_BLANK = DIR + "invalid_name_blank.json";
            private static final String INVALID_PRICE_NEGATIVE = DIR + "invalid_price_negative.json";
            private static final String INVALID_DESCRIPTION_NULL = DIR + "invalid_description_null.json";
            private static final String INVALID_NAME_NULL = DIR + "invalid_name_null.json";
            private static final String INVALID_PRICE_NULL = DIR + "invalid_price_null.json";
            private static final String INVALID_NAME_TOO_SHORT = DIR + "invalid_name_too_short.json";
            private static final String INVALID_NAME_TOO_LONG = DIR + "invalid_name_too_long.json";
            private static final String INVALID_DESCRIPTION_TOO_SHORT = DIR + "invalid_description_too_short.json";
            private static final String INVALID_DESCRIPTION_TOO_LONG = DIR + "invalid_description_too_long.json";
        }

        @ParameterizedTest
        @MethodSource("invalidRequests")
        void shouldReturnHttp400WhenRequestIsInvalid(String path, String errorMessage) throws Exception {
            var requestBody = fetchJsonFrom(path);

            mockMvc.perform(post(PATH)
                    .contentType(APPLICATION_JSON)
                    .content(requestBody))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.message").value(errorMessage));
        }

        private static Stream<Arguments> invalidRequests() {
            return Stream.of(
                    Arguments.of(Requests.INVALID_DESCRIPTION_BLANK, "Field 'description' is required"),
                    Arguments.of(Requests.INVALID_NAME_BLANK, "Field 'name' is required"),
                    Arguments.of(Requests.INVALID_PRICE_NEGATIVE, "Field 'price' has to be greater than 0"),
                    Arguments.of(Requests.INVALID_DESCRIPTION_NULL, "Field 'description' is required"),
                    Arguments.of(Requests.INVALID_NAME_NULL, "Field 'name' is required"),
                    Arguments.of(Requests.INVALID_PRICE_NULL, "Field 'price' is required"),
                    Arguments.of(Requests.INVALID_NAME_TOO_SHORT, "Field 'name' must contain at least 3 characters"),
                    Arguments.of(Requests.INVALID_NAME_TOO_LONG, "Field 'name' must contain at most 255 characters"),
                    Arguments.of(Requests.INVALID_DESCRIPTION_TOO_SHORT, "Field 'description' must contain at least 10 characters"),
                    Arguments.of(Requests.INVALID_DESCRIPTION_TOO_LONG, "Field 'description' must contain at most 1000 characters")
            );
        }
    }
}
