package com.karasdominik.QuickCart.product.infrastructure.configuration.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.karasdominik.QuickCart.product.domain.valueobjects.ProductName;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serial;

@Component
public class ProductNameDeserializer extends StdDeserializer<ProductName> {

    @Serial
    private static final long serialVersionUID = -3839717467616446084L;

    protected ProductNameDeserializer() {
        super(ProductName.class);
    }

    @Override
    public ProductName deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return ProductName.of(jsonParser.getValueAsString());
    }
}
