package com.karasdominik.QuickCart.product.infrastructure.configuration.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.karasdominik.QuickCart.product.domain.dto.ProductId;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ProductIdSerializer extends StdSerializer<ProductId> {

    public ProductIdSerializer() {
        super(ProductId.class);
    }

    @Override
    public void serialize(ProductId value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(value.value().toString());
    }
}
