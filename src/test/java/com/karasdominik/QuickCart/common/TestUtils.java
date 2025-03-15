package com.karasdominik.QuickCart.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class TestUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static String fetchJsonFrom(String path) throws IOException {
        return Files.readString(Paths.get(path));
    }

    public static Map<String, Object> parsed(String json) throws JsonProcessingException {
        return mapper.readValue(json, new TypeReference<>() {});
    }
}
