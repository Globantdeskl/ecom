package com.aeo.checkout.fraud.model;

import lombok.Data;

@Data
public class FraudTokenRequest {
	
	private String orderId;
	private String cardNumber;
	private String cardExpDate;
	
}
