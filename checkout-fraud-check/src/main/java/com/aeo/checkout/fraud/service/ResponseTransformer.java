package com.aeo.checkout.fraud.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.aeo.checkout.fraud.config.FraudConfig.ACIResponseCode;
import com.aeo.checkout.fraud.model.FraudResponse;
import com.aeo.checkout.fraud.model.FraudTokenResponse;
import com.aeo.checkout.fraud.model.aci.ACIConstants;
import com.aeo.checkout.fraud.model.aci.LPTransactionProperty;
import com.aeo.checkout.fraud.service.tools.TransformerUtils;
import com.liveprocessor.LPClient.LPTransaction;
import com.newrelic.api.agent.Trace;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ResponseTransformer {
	
	private SimpleDateFormat tokenExpireFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@Trace
	public FraudResponse createFraudResponse(LPTransaction quotationResponse) {
		logLPTransactionResponse(quotationResponse);
		
		FraudResponse error = determineFraudResponseInError(quotationResponse);
		if(error != null) {
			return error;
		}
		
		String statusCode = quotationResponse.getField(LPTransactionProperty.STAT_CD.name());
		String tokenId = quotationResponse.getField(LPTransactionProperty.TOKEN_ID.name());
		String tokenStatusCode = quotationResponse.getField(LPTransactionProperty.TOKEN_STAT_CD.name());
		if(!ACIConstants.TOKEN_STATUS_CODE_ACTIVE.equals(tokenStatusCode)) {
			// got a token status code, but it was not ACTIVE
			// we'll proceed with processing the rest of the response
			log.error("RedACIClientProvider :: fraudCheck :: Token status code was not ACTIVE, tokenId={}, tokenStatusCode={}",
					tokenId, tokenStatusCode);
		}
		
		if (TransformerUtils.isBlank(tokenId)) {
			// token ID is empty
			// warn and continue processing
			log.warn("RedACIClientProvider :: fraudCheck :: Response status code was {} but tokenId was missing, tokenId={}, tokenStatusCode={}",
					statusCode, tokenId, tokenStatusCode);
		}
		
		FraudResponse response = new FraudResponse();
		response.setSuccess(true);
		response.setTimeout(false);
		response.setTokenId(tokenId);
		response.setTokenExpirationDate(
				extractTokenExpireDate(quotationResponse.getField(LPTransactionProperty.TOKEN_EXP_DT.name())));
		//StatusCode = stat_cd:: PENDING or SUSPEND, PENDING=success
		response.setStatusCode(statusCode);
		//StatusCodeDetail = fraud_stat_cd :: the actual response: ACCEPT, DENY, CHALLANGE, NOSCORE, ERROR, ENETP, ETMOUT
		response.setStatusCodeDetail(quotationResponse.getField(LPTransactionProperty.FRAUD_STAT_CD.name()));
		//RecordId fraud_req_id :: record id for transaction assigned by RedACI
		response.setRecordId(quotationResponse.getField(LPTransactionProperty.FRAUD_REC_ID.name()));
		//ResponseCode fraud_rsp_cd :: code 0100 means success, any other code mean there was some validation error
		response.setResponseCode(quotationResponse.getField(LPTransactionProperty.FRAUD_RSP_CD.name()));
		//ResponseCodeDesc fraud_rsp_desc :: deatils about the response code, ie specific errors
		response.setResponseCodeDesc(quotationResponse.getField(LPTransactionProperty.FRAUD_RSP_DESC.name()));
		
		return response;
	}
	
	private Date extractTokenExpireDate(String tokenExpDt) {
		if (TransformerUtils.isNotBlank(tokenExpDt)) {
			try {
				return tokenExpireFormat.parse(tokenExpDt);
			} catch (ParseException e) {
                log.error("Could not parse token expiration date: {}", tokenExpDt, e);
			}
		}
		return null;
	}
	
	private FraudResponse determineFraudResponseInError(LPTransaction quotationResponse) {
		FraudResponse error = null;
		if(quotationResponse == null) {
			error = new FraudResponse();
			error.setSuccess(false);
			error.setTimeout(false);
			error.setError(FraudResponse.Error.INTERNAL_ERROR);
		} else {
			String statusCode = quotationResponse.getField(LPTransactionProperty.STAT_CD.name());
			if (!ACIResponseCode.FRAUD_CHECKED.statusCodes().contains(statusCode)) {
				error = new FraudResponse();
				error.setSuccess(false);
				error.setTimeout(false);
				error.setFailureReason(statusCode);
				FraudResponse.Error errorCode = null;
				if(ACIResponseCode.ERROR_CONNECTION.statusCodes().contains(statusCode)) {
					errorCode = FraudResponse.Error.TIMEOUT;
					error.setTimeout(true);
				} else if(ACIResponseCode.ERROR_CARD_NUMBER.statusCodes().contains(statusCode)) {
					errorCode = FraudResponse.Error.INVALID_CARD_NUMBER;
				}
				if (errorCode == null) {
					errorCode = FraudResponse.Error.OTHER;
				}
				error.setError(errorCode);
			}
		}
		return error;
	}
	
	@Trace
	public FraudTokenResponse createFraudTokenResponse(LPTransaction tokenResponse) {
		logLPTransactionResponse(tokenResponse);
		
		FraudTokenResponse error = determineTokenResponseInError(tokenResponse);
		if(error != null) {
			return error;
		}
		
		FraudTokenResponse response = new FraudTokenResponse();
		response.setSuccess(true);
		response.setTimeout(false);
		response.setTokenId(tokenResponse.getField(LPTransactionProperty.TOKEN_ID.name()));
		response.setTokenExpirationDate(
				extractTokenExpireDate(tokenResponse.getField(LPTransactionProperty.TOKEN_EXP_DT.name())));
		return response;
	}
	
	private FraudTokenResponse determineTokenResponseInError(LPTransaction tokenResponse) {
		FraudTokenResponse error = null;
		if(tokenResponse == null) {
			error = new FraudTokenResponse();
			error.setSuccess(false);
			error.setTimeout(false);
			error.setError(FraudTokenResponse.Error.INTERNAL_ERROR);
		} else {
			String statusCode = tokenResponse.getField(LPTransactionProperty.STAT_CD.name());
			if (!ACIConstants.STATUS_CODE_SUCCESS.equals(statusCode)) {
				error = new FraudTokenResponse();
				error.setSuccess(false);
				error.setTimeout(false);
				error.setFailureReason(statusCode);
				FraudTokenResponse.Error errorCode = null;
				if(ACIResponseCode.ERROR_CONNECTION.statusCodes().contains(statusCode)) {
					errorCode = FraudTokenResponse.Error.TIMEOUT;
					error.setTimeout(true);
				} else if(ACIResponseCode.ERROR_CARD_NUMBER.statusCodes().contains(statusCode)) {
					errorCode = FraudTokenResponse.Error.INVALID_CARD_NUMBER;
				}
				if (errorCode == null) {
					errorCode = FraudTokenResponse.Error.OTHER;
				}
				error.setError(errorCode);
			} else {
				String tokenId = tokenResponse.getField(LPTransactionProperty.TOKEN_ID.name());
				String tokenStatusCode = tokenResponse.getField(LPTransactionProperty.TOKEN_STAT_CD.name());
				if (!ACIConstants.TOKEN_STATUS_CODE_ACTIVE.equals(tokenStatusCode)) {
					error = new FraudTokenResponse();
					error.setSuccess(false);
					error.setFailureReason("TOKEN_NOT_ACTIVE");
					error.setError(FraudTokenResponse.Error.OTHER);
				} else if (TransformerUtils.isBlank(tokenId)) {
					error = new FraudTokenResponse();
					error.setSuccess(false);
					error.setFailureReason("TOKEN_ID_MISSING");
					error.setError(FraudTokenResponse.Error.OTHER);
				}
			}
		}
		return error;
	}
	
	private void logLPTransactionResponse(LPTransaction transaction) {
		StringBuilder sb = new StringBuilder();
		if(transaction != null) {
			for (LPTransactionProperty property : LPTransactionProperty.responseProperties) {
				// ACCT_NUM will be masked by LPClient, so no need to mask on response debug output
				String value = transaction.getField(property.name());
				if (TransformerUtils.isNotBlank(value)) {
					if(sb.toString().isEmpty()) {
						sb.append(property.toString()).append(": ").append(value);
					} else {
						sb.append(", ").append(property.toString()).append(": ").append(value);
					}
				}
			}
		}
		log.info("RedACI Response: " + sb.toString());
	}

}
