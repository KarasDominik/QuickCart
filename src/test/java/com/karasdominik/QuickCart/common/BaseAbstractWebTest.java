package com.karasdominik.QuickCart.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@ComponentScan("com.karasdominik.QuickCart.common.config.serialization")
public abstract class BaseAbstractWebTest {

    @Autowired
    protected MockMvc mockMvc;
}
