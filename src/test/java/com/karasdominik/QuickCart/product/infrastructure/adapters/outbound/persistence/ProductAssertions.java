package com.karasdominik.QuickCart.product.infrastructure.adapters.outbound.persistence;

import com.karasdominik.QuickCart.product.domain.dto.ProductId;
import com.karasdominik.QuickCart.product.domain.valueobjects.Price;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.karasdominik.QuickCart.product.infrastructure.adapters.outbound.persistence.ProductAssert.assertThat;

@Component
@RequiredArgsConstructor
public class ProductAssertions {

    private final ProductJpaRepository products;

    public void assertProductCreated(ProductId id, Map<String, Object> expected) {
        var product = products.findById(id).orElseThrow();
        assertThat(product)
                .hasName(expected.get("name").toString())
                .hasDescription(expected.get("description").toString())
                .hasPrice(Price.of(expected.get("price").toString()));
    }
}
