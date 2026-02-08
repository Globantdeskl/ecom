package com.aeo.framework.model.response;

import lombok.Data;

import java.util.Date;

@Data
public class FraudResponse {
	
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
