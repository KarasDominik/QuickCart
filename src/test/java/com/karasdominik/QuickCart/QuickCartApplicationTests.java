package com.karasdominik.QuickCart;

import com.karasdominik.QuickCart.common.BaseAbstractModuleTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class QuickCartApplicationTests extends BaseAbstractModuleTest {

	@Test
	void contextLoads() {}

}
