package com.prices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.prices")
@EntityScan("com.prices.*")
public class BackendTestPricesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendTestPricesApplication.class, args);
	}

}
