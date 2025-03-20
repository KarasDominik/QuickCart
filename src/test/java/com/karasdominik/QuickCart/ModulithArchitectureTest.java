package com.karasdominik.QuickCart;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

public class ModulithArchitectureTest {

    @Test
    void verifyModularStructure() {
        var modules = ApplicationModules.of(QuickCartApplication.class);

        new Documenter(modules)
                .writeModulesAsPlantUml()
                .writeIndividualModulesAsPlantUml();

        modules.verify();
    }
}
