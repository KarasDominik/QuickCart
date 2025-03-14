package com.karasdominik.QuickCart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.modulith.Modulithic;

@Modulithic(sharedModules = "common")
@SpringBootApplication
public class QuickCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuickCartApplication.class, args);
	}

}
