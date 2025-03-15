package com.karasdominik.QuickCart.order.infrastructure.configuration.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.karasdominik.QuickCart.order.domain.valueobjects.OrderQuantity;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serial;

@Component
public class OrderQuantityDeserializer extends StdDeserializer<OrderQuantity> {

    @Serial
    private static final long serialVersionUID = -3079032985724543768L;

    protected OrderQuantityDeserializer() {
        super(OrderQuantity.class);
    }

    @Override
    public OrderQuantity deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return OrderQuantity.of(jsonParser.getIntValue());
    }
}
