package com.aeo.checkout.fraud.model;

import java.util.Date;

import lombok.Data;

@Data
public class FraudTokenResponse implements APIResponse {

	private boolean success;
	private boolean timeout;
	private String tokenId;
	private Date tokenExpirationDate;
	private String failureReason;
	private Error error;
	
}
