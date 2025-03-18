package com.karasdominik.QuickCart.common.config.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.karasdominik.QuickCart.common.dto.ProductId;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serial;

@Component
public class ProductIdDeserializer extends StdDeserializer<ProductId> {

    @Serial
    private static final long serialVersionUID = -9152929590699197931L;

    public ProductIdDeserializer() {
        super(ProductId.class);
    }

    @Override
    public ProductId deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return ProductId.of(jsonParser.getValueAsString());
    }
}
