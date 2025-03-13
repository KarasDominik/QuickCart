package com.karasdominik.QuickCart;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

public class ModulithArchitectureTest {

    @Test
    void verifyModularStructure() {
        ApplicationModules.of(QuickCartApplication.class).verify();
    }
}
