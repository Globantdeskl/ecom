package com.aeo.checkout.fraud.model;

import lombok.Data;

@Data
public class AuthorizationDetails {

	private boolean transactionSuccess;
	private Double amount;
	private String cvvResponse;
	private String errorMessage;
	private String avsCode;

}
