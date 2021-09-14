package com.ecomindo.onboarding.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
public class ShirtsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShirtsApplication.class, args);
	}

}
