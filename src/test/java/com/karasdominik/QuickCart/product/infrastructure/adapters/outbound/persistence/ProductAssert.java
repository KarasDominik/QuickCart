package com.karasdominik.QuickCart.product.infrastructure.adapters.outbound.persistence;

import com.karasdominik.QuickCart.product.domain.entities.Product;
import com.karasdominik.QuickCart.product.domain.valueobjects.Price;
import org.assertj.core.api.AbstractAssert;

class ProductAssert extends AbstractAssert<ProductAssert, Product> {

    ProductAssert(Product actual) {
        super(actual, ProductAssert.class);
    }

    static ProductAssert assertThat(Product product) {
        return new ProductAssert(product);
    }

    ProductAssert hasName(String expected) {
        isNotNull();
        if (!actual.name().equals(expected)) {
            failWithMessage("Expected product to have name %s but was %s", expected, actual.name());
        }
        return this;
    }

    ProductAssert hasDescription(String expected) {
        isNotNull();
        if (!actual.description().equals(expected)) {
            failWithMessage("Expected product to have description %s but was %s", expected, actual.description());
        }
        return this;
    }

    ProductAssert hasPrice(Price expected) {
        isNotNull();
        if (!actual.price().equals(expected)) {
            failWithMessage("Expected product to have price %s but was %s", expected, actual.price());
        }
        return this;
    }
}