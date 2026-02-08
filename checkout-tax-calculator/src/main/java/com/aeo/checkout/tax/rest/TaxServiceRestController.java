package com.aeo.checkout.tax.rest;
import static net.logstash.logback.argument.StructuredArguments.v;


import java.util.Arrays;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aeo.checkout.tax.config.VertexConfig.CalculableCountryCode;
import com.aeo.checkout.tax.model.CalculateRequest;
import com.aeo.checkout.tax.model.CalculateResponse;
import com.aeo.checkout.tax.model.LineItemTaxes;
import com.aeo.checkout.tax.model.OrderTaxes;
import com.aeo.checkout.tax.service.RequestTransformer;
import com.aeo.checkout.tax.service.ResponseTransformer;
import com.aeo.checkout.tax.service.VertexService;
import com.aeo.logging.CommonKeys;
import com.newrelic.api.agent.Trace;

import aeo.integration.vertex.client.QuotationRequestType;
import aeo.integration.vertex.client.QuotationResponseType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TaxServiceRestController {
	
	private VertexService vertexService;
	private RequestTransformer requestTransformer;
	private ResponseTransformer responseTransformer;
	
	public TaxServiceRestController(VertexService vertexService,
			RequestTransformer requestTransformer, ResponseTransformer responseTransformer) {
		this.vertexService = vertexService;
		this.requestTransformer = requestTransformer;
		this.responseTransformer = responseTransformer;
	}
	
	@Trace(dispatcher = true, metricName = "/calculate#POST")
	@PostMapping("/calculate")
	public ResponseEntity<CalculateResponse> calculateTaxes(@RequestBody CalculateRequest calcRequest) {
		log.info("Calculate Taxes called for {}", v(CommonKeys.ORDER_ID.key(), calcRequest.getOrderId()));
		if(!Arrays.asList(CalculableCountryCode.values()).stream().anyMatch(code -> 
			calcRequest.getCountry().toUpperCase().startsWith(code.name()))) {
			CalculateResponse restResponse = new CalculateResponse();
			restResponse.setOrderId(calcRequest.getOrderId());
			OrderTaxes orderTaxes = new OrderTaxes();
			orderTaxes.setShippingTaxes(new LineItemTaxes());
			restResponse.setOrderTaxes(orderTaxes);
			return ResponseEntity.ok(restResponse);
		}
		try {
			QuotationRequestType taxRequest = requestTransformer.createVertexRequest(calcRequest);
			QuotationResponseType taxResponse = vertexService.calculateTaxes(taxRequest);
			CalculateResponse restResponse = responseTransformer.createCalculateResponse(taxResponse);
			return ResponseEntity.ok(restResponse);
		} catch (Exception e) {
			return responseTransformer.createErrorResponse(e, calcRequest.getOrderId());
		}
	}

}
