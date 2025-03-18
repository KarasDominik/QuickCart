package com.karasdominik.QuickCart.order.application.services;

import com.karasdominik.QuickCart.common.dto.ProductId;
import com.karasdominik.QuickCart.order.application.ports.outbound.OrderRepository;
import com.karasdominik.QuickCart.order.domain.dto.OrderId;
import com.karasdominik.QuickCart.order.domain.entities.OrderedProduct;
import com.karasdominik.QuickCart.order.domain.valueobjects.OrderQuantity;
import lombok.RequiredArgsConstructor;
import org.assertj.core.groups.Tuple;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static com.karasdominik.QuickCart.order.domain.dto.OrderStatus.WAITING_FOR_PAYMENT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;

@Component
@RequiredArgsConstructor
@Transactional
public class OrderAssertions {

    private final OrderRepository orders;

    public void assertOrderCreated(OrderId id, Map<String, Object> expected) {
        var order = orders.findOrThrow(id);
        assertThat(order.status()).isEqualTo(WAITING_FOR_PAYMENT);

        List<Map<String, Object>> expectedProducts = (List<Map<String, Object>>) expected.get("orderedProducts");

        assertThat(order.orderedProducts())
                .extracting(OrderedProduct::productId, OrderedProduct::quantity)
                .containsExactlyInAnyOrder(expectedProducts.stream()
                        .map(e -> tuple(
                                ProductId.of(e.get("productId").toString()),
                                OrderQuantity.of(Integer.parseInt(e.get("quantity").toString()))))
                        .toArray(Tuple[]::new));
    }
}
