package com.aeo.checkout.fraud.model;

import java.util.Date;

import lombok.Data;
@Data
public class FraudCheckResponse {
	
	private String responseCode;
	private String responseCodeDesc;
	private String statusCode;
	private String statusCodeDetail;
	private String recordId;
	private boolean requestTimeout;
	private boolean success;
	private String failureReason;
	private Error error;
	private String tokenId;
	private Date tokenExpirationDate;
	
	public boolean hasRequestTimeout() {
		return this.isRequestTimeout();
	}
	
	public enum Error {
		
		TIMEOUT,
		INVALID_CARD_NUMBER,
		OTHER,
		INTERNAL_ERROR;
		
	}
		
	@Override
	public String toString() {
		return "FraudCheckResponse [\n\t"
				+ "success=" + isSuccess() + "\n\t" 
				+ "requestTimeout=" + isRequestTimeout() + "\n\t"
				+ "tokenId=" + getTokenId() + "\n\t"
				+ "tokenExpirationDate=" + getTokenExpirationDate() + "\n\t"
				+ "failureReason=" + getFailureReason() + "\n\t"
				+ "error=" + getError() + "\n\t"
				+ "RESP_REC_ID=" + getRecordId() + "\n\t"
				+ "RESP_STATUS_CODE=" + getStatusCode() + "\n\t"
				+ "RESP_STATUS_DETAIL=" + getStatusCodeDetail() + "\n\t"
				+ "RESP_RSP_CODE=" + getResponseCode() + "\n\t"
				+ "RESP_RSP_CODE_DESC=" + getResponseCodeDesc() + "\n"
				+ "]";
	}

}
