package com.karasdominik.QuickCart.common.config.serialization;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.util.List;

@Configuration
public class JacksonConfiguration {

    @Bean
    public ObjectMapper objectMapper(List<? extends StdSerializer<?>> serializers,
                                     List<? extends StdDeserializer<?>> deserializers) {
        var builder = new Jackson2ObjectMapperBuilder();
        builder.serializers(serializers.toArray(JsonSerializer[]::new));
        builder.deserializers(deserializers.toArray(StdDeserializer[]::new));
        return builder.build();
    }
}
