package com.aeo.checkout.fraud.model;

public interface APIResponse {
	
	boolean isSuccess();
	
	boolean isTimeout();
	
	Error getError();
	
	enum Error {
		TIMEOUT,
		INVALID_CARD_NUMBER,
		OTHER,
		INTERNAL_ERROR;
	}

}
