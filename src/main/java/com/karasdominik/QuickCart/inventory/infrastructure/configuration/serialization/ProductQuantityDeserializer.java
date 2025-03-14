package com.karasdominik.QuickCart.inventory.infrastructure.configuration.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.karasdominik.QuickCart.inventory.domain.valueobjects.ProductQuantity;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serial;

@Component
public class ProductQuantityDeserializer extends StdDeserializer<ProductQuantity> {

    @Serial
    private static final long serialVersionUID = 2030234232321627847L;

    protected ProductQuantityDeserializer() {
        super(ProductQuantity.class);
    }

    @Override
    public ProductQuantity deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return ProductQuantity.of(jsonParser.getIntValue());
    }
}
