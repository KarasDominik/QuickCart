package com.karasdominik.QuickCart.common;

import lombok.NoArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class TestUtils {

    public static String fetchJsonFrom(String path) throws IOException {
        return Files.readString(Paths.get(path));
    }
}
