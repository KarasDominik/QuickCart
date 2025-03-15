package com.karasdominik.QuickCart.inventory.infrastructure.adapters.inbound.rest;

import com.karasdominik.QuickCart.common.BaseAbstractWebTest;
import com.karasdominik.QuickCart.inventory.application.ports.inbound.InventoryService;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.stream.Stream;

import static com.karasdominik.QuickCart.common.TestUtils.fetchJsonFrom;
import static java.util.UUID.randomUUID;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(InventoryController.class)
@ComponentScan("com.karasdominik.QuickCart.inventory.infrastructure.configuration.serialization")
class InventoryControllerWebTest extends BaseAbstractWebTest {

    private static final String PATH = "/api/v1/inventory";

    @MockitoBean
    private InventoryService service;

    @Nested
    class UpdateTests {

        private static final class Requests {
            private static final String DIR = "src/test/resources/requests/inventory/";
            private static final String INVALID_QUANTITY_NEGATIVE = DIR + "/invalid_quantity_negative.json";
            private static final String INVALID_QUANTITY_TOO_LARGE = DIR + "/invalid_quantity_too_large.json";
        }

        @ParameterizedTest
        @MethodSource("invalidRequests")
        void shouldReturnHttp400WhenRequestIsInvalid(String path, String errorMessage) throws Exception {
            var requestBody = fetchJsonFrom(path);

            mockMvc.perform(put(PATH + "/product/" + randomUUID())
                    .contentType(APPLICATION_JSON)
                    .content(requestBody))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.message").value(errorMessage));
        }

        private static Stream<Arguments> invalidRequests() {
            return Stream.of(
                    Arguments.of(Requests.INVALID_QUANTITY_NEGATIVE, "Field 'productQuantity' cannot be less than than 0"),
                    Arguments.of(Requests.INVALID_QUANTITY_TOO_LARGE, "Field 'productQuantity' cannot be more than than 1000")
            );
        }

    }
}
