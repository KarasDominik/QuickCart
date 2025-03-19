package com.karasdominik.QuickCart.order.infrastructure.configuration.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.karasdominik.QuickCart.order.domain.valueobjects.Email;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serial;

@Component
public class EmailDeserializer extends StdDeserializer<Email> {

    @Serial
    private static final long serialVersionUID = -6159203732192963582L;

    protected EmailDeserializer() {
        super(Email.class);
    }

    @Override
    public Email deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return Email.of(jsonParser.getText());
    }
}
