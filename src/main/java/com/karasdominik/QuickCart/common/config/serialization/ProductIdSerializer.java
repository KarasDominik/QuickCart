package com.karasdominik.QuickCart.common.config.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.karasdominik.QuickCart.common.dto.ProductId;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serial;

@Component
public class ProductIdSerializer extends StdSerializer<ProductId> {

    @Serial
    private static final long serialVersionUID = -9152929590699197931L;

    public ProductIdSerializer() {
        super(ProductId.class);
    }

    @Override
    public void serialize(ProductId value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(value.value().toString());
    }
}
