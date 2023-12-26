package com.aeo.checkout.sdd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class CheckoutSameDayDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckoutSameDayDeliveryApplication.class, args);
	}

}
