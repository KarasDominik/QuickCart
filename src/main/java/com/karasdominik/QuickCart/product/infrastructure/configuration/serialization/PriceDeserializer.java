package com.karasdominik.QuickCart.product.infrastructure.configuration.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.karasdominik.QuickCart.product.domain.valueobjects.Price;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PriceDeserializer extends StdDeserializer<Price> {

    protected PriceDeserializer() {
        super(Price.class);
    }

    @Override
    public Price deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
        return Price.of(jsonParser.getDecimalValue());
    }
}
