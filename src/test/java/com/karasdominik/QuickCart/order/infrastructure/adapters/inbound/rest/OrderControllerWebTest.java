package com.karasdominik.QuickCart.order.infrastructure.adapters.inbound.rest;

import com.karasdominik.QuickCart.common.BaseAbstractWebTest;
import com.karasdominik.QuickCart.order.application.ports.inbound.OrderCreator;
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

@WebMvcTest(OrderController.class)
@ComponentScan("com.karasdominik.QuickCart.order.infrastructure.configuration.serialization")
class OrderControllerWebTest extends BaseAbstractWebTest {

    private static final String PATH = "/api/v1/orders";

    @MockitoBean
    private OrderCreator creator;

    @Nested
    class CreateTests {

        private static final class Requests {
            private static final String DIR = "src/test/resources/requests/order/";

            private static final String INVALID_EMPTY = DIR + "invalid_empty.json";
            private static final String INVALID_PRODUCT_ID_NULL = DIR + "invalid_product_id_null.json";
            private static final String INVALID_QUANTITY_NULL = DIR + "invalid_quantity_null.json";
            private static final String INVALID_QUANTITY_ZERO = DIR + "invalid_quantity_zero.json";
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
                    Arguments.of(Requests.INVALID_EMPTY, "Field 'orderedProducts' cannot be empty"),
                    Arguments.of(Requests.INVALID_PRODUCT_ID_NULL, "Field 'productId' is required"),
                    Arguments.of(Requests.INVALID_QUANTITY_NULL, "Field 'quantity' is required"),
                    Arguments.of(Requests.INVALID_QUANTITY_ZERO, "Field 'productQuantity' cannot be less than than 1")
            );
        }
    }
}
