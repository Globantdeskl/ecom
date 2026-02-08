package com.aeo.checkout.fraud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableHystrix
@SpringBootApplication
public class CheckoutFraudCheckApplication {

	public static void main(String[] args) {
		System.setProperty("jdk.tls.client.enableSessionTicketExtension", Boolean.FALSE.toString());
		SpringApplication.run(CheckoutFraudCheckApplication.class, args);
	}

}
