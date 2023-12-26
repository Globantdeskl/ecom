package com.aeo.checkout.fraud.model;

import java.util.Date;

import lombok.Data;

@Data
public class FraudResponse implements APIResponse {
	
	private boolean success;
	private boolean timeout;
	private String responseCode;
	private String responseCodeDesc;
	private String statusCode;
	private String statusCodeDetail;
	private String recordId;
	private String tokenId;
	private Date tokenExpirationDate;
	private String failureReason;
	private Error error;

}
