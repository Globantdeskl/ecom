package com.aeo.checkout.fraud.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import com.aeo.checkout.fraud.model.FraudResponse;
import com.aeo.checkout.fraud.model.FraudTokenResponse;
import com.aeo.checkout.fraud.model.aci.LPTransactionProperty;
import com.liveprocessor.LPClient.LPTransaction;


public class ResponseTransformerTest {
	
	private ResponseTransformer responseTransformer;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
		responseTransformer = new ResponseTransformer();
	}
	
	@Test
	void createFraudResponse() {
		LPTransaction good = quotationResponse();
		
		LPTransaction inactiveToken = quotationResponse();
		inactiveToken.setField(LPTransactionProperty.TOKEN_STAT_CD.name(), "INACTIVE");
		
		LPTransaction timeout = quotationResponse();
		timeout.setField(LPTransactionProperty.STAT_CD.name(), "ENETLP");
		
		LPTransaction badCC = quotationResponse();
		badCC.setField(LPTransactionProperty.STAT_CD.name(), "EIVCCN");
		
		LPTransaction badData = quotationResponse();
		badData.setField(LPTransactionProperty.STAT_CD.name(), "EIVPMD");
		
		assertTrue(responseTransformer.createFraudResponse(good).isSuccess());
		assertTrue(responseTransformer.createFraudResponse(inactiveToken).isSuccess());
		assertTrue(responseTransformer.createFraudResponse(quotationResponseNoToken()).isSuccess());
		
		assertEquals(FraudResponse.Error.INTERNAL_ERROR, responseTransformer.createFraudResponse(null).getError());
		assertEquals(FraudResponse.Error.TIMEOUT, responseTransformer.createFraudResponse(timeout).getError());
		assertEquals(FraudResponse.Error.INVALID_CARD_NUMBER, responseTransformer.createFraudResponse(badCC).getError());
		assertEquals(FraudResponse.Error.OTHER, responseTransformer.createFraudResponse(badData).getError());
	}
	
	@Test
	void createFraudTokenResponse() {
		LPTransaction good = tokenResponse();
		
		LPTransaction timeout = quotationResponse();
		timeout.setField(LPTransactionProperty.STAT_CD.name(), "ENETLP");
		
		LPTransaction badCC = quotationResponse();
		badCC.setField(LPTransactionProperty.STAT_CD.name(), "EIVCCN");
		
		LPTransaction badData = quotationResponse();
		badData.setField(LPTransactionProperty.STAT_CD.name(), "EIVACT");
		
		LPTransaction inactiveToken = tokenResponse();
		inactiveToken.setField(LPTransactionProperty.TOKEN_STAT_CD.name(), "INACTIVE");
		
		LPTransaction expireDateNotADate = noExpireDateResponse();
		expireDateNotADate.setField("TOKEN_EXP_DT", "abcd");
		
		assertTrue(responseTransformer.createFraudTokenResponse(good).isSuccess());
		assertTrue(responseTransformer.createFraudTokenResponse(noExpireDateResponse()).isSuccess());
		assertTrue(responseTransformer.createFraudTokenResponse(expireDateNotADate).isSuccess());
		
		assertEquals(FraudTokenResponse.Error.INTERNAL_ERROR, responseTransformer.createFraudTokenResponse(null).getError());
		assertEquals(FraudTokenResponse.Error.TIMEOUT, responseTransformer.createFraudTokenResponse(timeout).getError());
		assertEquals(FraudTokenResponse.Error.INVALID_CARD_NUMBER, responseTransformer.createFraudTokenResponse(badCC).getError());
		assertEquals(FraudTokenResponse.Error.OTHER, responseTransformer.createFraudTokenResponse(badData).getError());
		assertEquals("TOKEN_NOT_ACTIVE", responseTransformer.createFraudTokenResponse(inactiveToken).getFailureReason());
		// once token is set LPTransaction does not allow unset
		assertEquals("TOKEN_ID_MISSING", responseTransformer.createFraudTokenResponse(noTokenResponse()).getFailureReason());
	}
	
	private LPTransaction noExpireDateResponse() {
		LPTransaction tokenResponse = new LPTransaction();
		tokenResponse.setField("TOKEN_ID", "db8257d4a8d015c53ba4e3a4c21d41fa5bb2a60c4856a9d68694c7487d15a6f5");
		tokenResponse.setField("TOKEN_EXP_DT", null);
		tokenResponse.setField("STAT_CD", "SUCCESS");
		tokenResponse.setField("TOKEN_STAT_CD", "ACTIVE");
		return tokenResponse;
	}
	
	private LPTransaction noTokenResponse() {
		LPTransaction tokenResponse = new LPTransaction();
		tokenResponse.setField("TOKEN_ID", "");
		tokenResponse.setField("TOKEN_EXP_DT", null);
		tokenResponse.setField("STAT_CD", "SUCCESS");
		tokenResponse.setField("TOKEN_STAT_CD", "ACTIVE");
		return tokenResponse;
	}
	
	private LPTransaction tokenResponse() {
		LPTransaction tokenResponse = new LPTransaction();
		tokenResponse.setField("TOKEN_ID", "db8257d4a8d015c53ba4e3a4c21d41fa5bb2a60c4856a9d68694c7487d15a6f5");
		tokenResponse.setField("TOKEN_EXP_DT", "2119-08-05T00:00:00.000+0000");
		tokenResponse.setField("STAT_CD", "SUCCESS");
		tokenResponse.setField("TOKEN_STAT_CD", "ACTIVE");
		return tokenResponse;
	}

	private LPTransaction quotationResponse() {
		LPTransaction quotationResponse = new LPTransaction();
		quotationResponse.setField("ORD_ID", "0000848329");
		quotationResponse.setField("TOKEN_STAT_CD", "ACTIVE");
		quotationResponse.setField("FRAUD_STAT_CD", "ACCEPT");
		quotationResponse.setField("TOKEN_ID", "9cd9fb5a9c345f7b766791920aa88b7a3a3fa203ef8cdcf4bbea47dabbd86e78");
		quotationResponse.setField("STAT_CD", "PENDING");
		quotationResponse.setField("TOKEN_EXP_DT", "2119-08-05T00:00:00.000+0000");
		quotationResponse.setField("REQ_ID", "110023745435");
		quotationResponse.setField("FRAUD_USE_CD", "C");
		quotationResponse.setField("PROC_CD", "EBT");
		quotationResponse.setField("FRAUD_RSP_CD", "0150");
		quotationResponse.setField("FRAUD_REC_ID", "000450030001XEN20200309124600418");
		return quotationResponse;
	}
	
	private LPTransaction quotationResponseNoToken() {
		LPTransaction quotationResponse = new LPTransaction();
		quotationResponse.setField("ORD_ID", "0000848329");
		quotationResponse.setField("TOKEN_STAT_CD", "ACTIVE");
		quotationResponse.setField("FRAUD_STAT_CD", "ACCEPT");
		quotationResponse.setField("TOKEN_ID", "");
		quotationResponse.setField("STAT_CD", "PENDING");
		quotationResponse.setField("TOKEN_EXP_DT", "2119-08-05T00:00:00.000+0000");
		quotationResponse.setField("REQ_ID", "110023745435");
		quotationResponse.setField("FRAUD_USE_CD", "C");
		quotationResponse.setField("PROC_CD", "EBT");
		quotationResponse.setField("FRAUD_RSP_CD", "0150");
		quotationResponse.setField("FRAUD_REC_ID", "000450030001XEN20200309124600418");
		return quotationResponse;
	}
	
}
