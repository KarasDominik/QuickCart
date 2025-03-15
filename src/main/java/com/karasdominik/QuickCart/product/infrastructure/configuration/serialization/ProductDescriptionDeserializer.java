package com.karasdominik.QuickCart.product.infrastructure.configuration.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.karasdominik.QuickCart.product.domain.valueobjects.ProductDescription;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serial;

@Component
public class ProductDescriptionDeserializer extends StdDeserializer<ProductDescription> {

    @Serial
    private static final long serialVersionUID = -8050993178650846195L;

    protected ProductDescriptionDeserializer() {
        super(ProductDescription.class);
    }

    @Override
    public ProductDescription deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return ProductDescription.of(jsonParser.getValueAsString());
    }
}
