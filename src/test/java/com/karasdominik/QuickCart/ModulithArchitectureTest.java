package com.karasdominik.QuickCart;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

public class ModulithArchitectureTest {

    @Test
    void verifyModularStructure() {
        var modules = ApplicationModules.of(QuickCartApplication.class);

        modules.verify();
    }
}
