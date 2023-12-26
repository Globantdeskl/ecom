package com.aeo.checkout.tax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableHystrix
@SpringBootApplication
public class CheckoutTaxCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckoutTaxCalculatorApplication.class, args);
	}

}
