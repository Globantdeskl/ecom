package com.aeo.checkout.tax.service;

import org.springframework.stereotype.Service;
import org.springframework.ws.soap.client.SoapFaultClientException;

import com.aeo.checkout.tax.config.VertexCircuitBreakerConfig;
import com.aeo.checkout.tax.config.VertexConfig;
import com.aeo.checkout.tax.config.VertexSOAPConnector;
import com.aeo.checkout.tax.service.exception.VertexAddressException;
import com.aeo.checkout.tax.service.exception.VertexException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.newrelic.api.agent.Trace;

import aeo.integration.vertex.client.LoginType;
import aeo.integration.vertex.client.QuotationRequestType;
import aeo.integration.vertex.client.QuotationResponseType;
import aeo.integration.vertex.client.VertexEnvelope;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class VertexService {
	
	private final VertexSOAPConnector vertexSOAPConnector;
	private final VertexConfig vertexConfig;
	private final VertexCircuitBreakerConfig circuitBreakerConfig;
	
	public VertexService(VertexSOAPConnector vertexSOAPConnector, 
			VertexConfig vertexConfig,
			VertexCircuitBreakerConfig circuitBreakerConfig) {
		this.vertexSOAPConnector = vertexSOAPConnector;
		this.vertexConfig = vertexConfig;
		this.circuitBreakerConfig = circuitBreakerConfig;
	}
	
	@Trace
	@HystrixCommand(groupKey = VertexCircuitBreakerConfig.GROUP_KEY_NAME, 
			commandKey = VertexCircuitBreakerConfig.COMMAND_KEY_NAME, 
			fallbackMethod = "calculateTaxesFallback", ignoreExceptions = VertexAddressException.class)
	public QuotationResponseType calculateTaxes(QuotationRequestType pQuotationRequest) 
			throws VertexAddressException, VertexException {
		log.debug("Vertex WS Circuit {}: {}", 
				circuitBreakerConfig.findCircuitBreakerState(), pQuotationRequest.getDocumentNumber());
		VertexEnvelope response = null;
		try {
			response = vertexSOAPConnector.callWebService(createRequest(pQuotationRequest));
		} catch (Exception e) {
			SoapFaultClientException sfce = null;
			if(e instanceof SoapFaultClientException) {
				sfce = (SoapFaultClientException) e;
			}
			if(e.getCause() instanceof SoapFaultClientException) {
				sfce = (SoapFaultClientException) e.getCause();
			}
			if(sfce != null
					&& sfce.getFaultStringOrReason() != null
					&& sfce.getFaultStringOrReason().contains(VertexAddressException.BAD_ADDRESS_MSG)) {
				throw new VertexAddressException(sfce.getFaultStringOrReason());
			}
			log.error("Error with calculateTaxes for order {}", pQuotationRequest.getDocumentNumber(), e);
			throw new VertexException(e);
		}
		if(response == null || response.getQuotationResponse() == null) {
			StringBuilder sb = new StringBuilder();
			sb.append("No Response from: ");
			sb.append(vertexConfig.getServiceEndpoint());
			sb.append(" for order: ");
			sb.append(pQuotationRequest.getDocumentNumber());
			log.error(sb.toString());
			throw new VertexException(sb.toString());
		}
		return response.getQuotationResponse();
	}
	
	@Trace(leaf = true)
	public QuotationResponseType calculateTaxesFallback(QuotationRequestType pQuotationRequest) 
			throws VertexAddressException, VertexException {
		log.error("Vertex WS Circuit {}: {}", 
				circuitBreakerConfig.findCircuitBreakerState(), pQuotationRequest.getDocumentNumber());
		StringBuilder sb = new StringBuilder();
		sb.append("calculateTaxes failure to: ");
		sb.append(vertexConfig.getServiceEndpoint());
		sb.append(" for order: ");
		sb.append(pQuotationRequest.getDocumentNumber());
		throw new VertexException(sb.toString());
	}
	
	private VertexEnvelope createRequest(QuotationRequestType pQuotationRequest) {

		LoginType login = new LoginType();
		login.setUserName(vertexConfig.getUserName());
		login.setPassword(vertexConfig.getPassword());

		VertexEnvelope request = new VertexEnvelope();
		request.setLogin(login);
		request.setQuotationRequest(pQuotationRequest);

		return request;
	}

}
