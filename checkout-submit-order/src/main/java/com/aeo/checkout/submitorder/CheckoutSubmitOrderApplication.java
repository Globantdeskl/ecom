package com.aeo.checkout.submitorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.retry.annotation.EnableRetry;

@EnableHystrix
@EnableRetry
@SpringBootApplication
public class CheckoutSubmitOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckoutSubmitOrderApplication.class, args);
	}

}
