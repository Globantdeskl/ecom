package com.aeo.checkout.fraud.model;

import lombok.Data;

@Data
public class CreditDebitTender {

    private String maskedAccountNumber;
    private String creditCardExpDate;
    private AuthorizationDetails authorizationDtls;
	private String cardToken;
	private String cardVerificationNumber;
	private String fraudToken;
	
}
