package com.payments.gateways;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.payments.gateways"})
public class GatewaysApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewaysApplication.class, args);
	}

}
