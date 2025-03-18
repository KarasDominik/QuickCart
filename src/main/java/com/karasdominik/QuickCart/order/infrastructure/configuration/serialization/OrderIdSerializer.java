package com.karasdominik.QuickCart.order.infrastructure.configuration.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.karasdominik.QuickCart.order.domain.dto.OrderId;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serial;

@Component
public class OrderIdSerializer extends StdSerializer<OrderId> {

    @Serial
    private static final long serialVersionUID = 7266565514441639315L;

    protected OrderIdSerializer() {
        super(OrderId.class);
    }

    @Override
    public void serialize(OrderId orderId, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(orderId.toString());
    }
}
