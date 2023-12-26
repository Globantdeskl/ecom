package com.aeo.checkout.fraud.rest;

import static net.logstash.logback.argument.StructuredArguments.v;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aeo.checkout.fraud.message.FraudClient;
import com.aeo.checkout.fraud.model.APIResponse;
import com.aeo.checkout.fraud.model.CreditDebitTender;
import com.aeo.checkout.fraud.model.FraudRequest;
import com.aeo.checkout.fraud.model.FraudResponse;
import com.aeo.checkout.fraud.model.FraudTokenRequest;
import com.aeo.checkout.fraud.model.FraudTokenResponse;
import com.aeo.checkout.fraud.model.PaymentMethod;
import com.aeo.checkout.fraud.model.aci.ACIException;
import com.aeo.checkout.fraud.service.RequestTransformer;
import com.aeo.checkout.fraud.service.ResponseTransformer;
import com.aeo.checkout.fraud.service.tools.TransformerUtils;
import com.aeo.logging.CommonKeys;
import com.liveprocessor.LPClient.LPTransaction;
import com.newrelic.api.agent.Trace;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class FraudServiceRestController {
	
	private FraudClient fraudClient;
	private RequestTransformer requestTransformer;
	private ResponseTransformer responseTransformer;
	private boolean enabled;
	
	public FraudServiceRestController(FraudClient fraudClient,
									  RequestTransformer requestTransformer,
									  ResponseTransformer responseTransformer,
									  @Value("${fraud.enabled}") boolean enabled) {
		this.fraudClient = fraudClient;
		this.requestTransformer = requestTransformer;
		this.responseTransformer = responseTransformer;
		this.enabled = enabled;
	}
	
	@Trace(dispatcher = true, metricName = "/fraud/check#POST")
	@PostMapping("/fraud/check")
	public ResponseEntity<FraudResponse> checkFraud(@RequestBody FraudRequest fraudRequest) throws InterruptedException {
		if(!enabled){
			return makeDisabledResponse(fraudRequest.getOrderId());
		}
		log.info("Fraud Check called {}", v(CommonKeys.ORDER_ID.key(), fraudRequest.getOrderId()));
		handleFraudToken(fraudRequest);
		LPTransaction fraudResponse = null;
		try {
			Optional<LPTransaction> lpRequest = requestTransformer.createQuotationRequest(fraudRequest);
			if(!lpRequest.isPresent()) {
				throw new ACIException("Failed to Form ACI Request");
			}
			fraudResponse = fraudClient.call(lpRequest.get());
		} catch(ACIException e) {
			log.error("{} checkFraud failure", fraudRequest.getOrderId(), e);
		}
		FraudResponse restResponse = responseTransformer.createFraudResponse(fraudResponse);
		return ResponseEntity.status(findStatus(restResponse)).body(restResponse);
	}
	
	@Trace(dispatcher = true, metricName = "/fraud/token#POST")
	@PostMapping("/fraud/token")
	public ResponseEntity<FraudTokenResponse> generateToken(@RequestBody FraudTokenRequest tokenRequest) {
		log.info("Fraud Token called {}", v(CommonKeys.ORDER_ID.key(), tokenRequest.getOrderId()));
		LPTransaction fraudResponse = null;
		try {
			Optional<LPTransaction> lpRequest = requestTransformer.createTokenRequest(tokenRequest);
			if(!lpRequest.isPresent()) {
				throw new ACIException("Failed to Form ACI Request");
			}
			fraudResponse = fraudClient.call(lpRequest.get());
		} catch (ACIException e) {
			log.error("{} generateToken failure", tokenRequest.getOrderId(), e);
		}
		FraudTokenResponse restResponse = responseTransformer.createFraudTokenResponse(fraudResponse);
		return ResponseEntity.status(findStatus(restResponse)).body(restResponse);
	}
	
	protected HttpStatus findStatus(APIResponse response) {
		HttpStatus status = HttpStatus.OK;
		if(!response.isSuccess()) {
			if(FraudTokenResponse.Error.INVALID_CARD_NUMBER.equals(response.getError()) 
					|| FraudTokenResponse.Error.OTHER.equals(response.getError())) {
				status = HttpStatus.BAD_REQUEST;
			} else if(response.isTimeout()) {
				status = HttpStatus.GATEWAY_TIMEOUT;
			} else {
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		}
		return status;
	}
	
	protected void handleFraudToken(FraudRequest request) {
		Optional<PaymentMethod> method = request.getPaymentMethods().stream()
				.filter(pm -> (pm.getCreditDebitTender() != null)).findFirst();
		if(method.isPresent()) {
			CreditDebitTender cc = method.get().getCreditDebitTender();
			if(TransformerUtils.isBlank(cc.getFraudToken())) {
				FraudTokenRequest ftr = new FraudTokenRequest();
				ftr.setOrderId(request.getCustomerOrder().getCustomerOrderId());
				ftr.setCardNumber(cc.getMaskedAccountNumber());
				ftr.setCardExpDate(TransformerUtils.formatExpirationDate(cc.getCreditCardExpDate()));
				
				String newFraudToken = generateToken(ftr).getBody().getTokenId();
				log.debug("Adding New fraud token to order {}: {}", request.getOrderId(), newFraudToken);
				cc.setFraudToken(newFraudToken);
			}
		}
	}
	
	private ResponseEntity<FraudResponse> makeDisabledResponse(String orderId) throws InterruptedException {
		log.info("Fraud Check call disabled, returning positive response {} ", v(CommonKeys.ORDER_ID.key(), orderId));
		Thread.sleep(1000);
		FraudResponse mockFraudSuccessResponse = new FraudResponse();
		mockFraudSuccessResponse.setSuccess(true);
		mockFraudSuccessResponse.setTimeout(false);
		mockFraudSuccessResponse.setStatusCode("PENDING");
		mockFraudSuccessResponse.setStatusCodeDetail("ACCEPT");
		return ResponseEntity.ok(mockFraudSuccessResponse);
	}

}
