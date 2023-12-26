package com.aeo.checkout.tax.rest;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;

import java.net.SocketException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.aeo.checkout.tax.model.CalculateRequest;
import com.aeo.checkout.tax.model.CalculateResponse;
import com.aeo.checkout.tax.service.RequestTransformer;
import com.aeo.checkout.tax.service.ResponseTransformer;
import com.aeo.checkout.tax.service.VertexService;
import com.aeo.checkout.tax.service.exception.VertexAddressException;
import com.aeo.checkout.tax.service.exception.VertexException;

import aeo.integration.vertex.client.QuotationRequestType;
import aeo.integration.vertex.client.QuotationResponseType;

public class TaxServiceRestControllerTest {
	
	private TaxServiceRestController taxServiceRestController;
	
	@Mock
	private RequestTransformer requestTransformer;
	
	@Mock
	private VertexService vertexService;
	
	@Mock
	private ResponseTransformer responseTransformer;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
		taxServiceRestController = new TaxServiceRestController(
				vertexService, requestTransformer, responseTransformer);
	}
	
	@Test
	void testSuccessful() throws VertexException, VertexAddressException {
		Mockito.when(requestTransformer.createVertexRequest(
				ArgumentMatchers.any(CalculateRequest.class))).thenReturn(new QuotationRequestType());
		Mockito.when(vertexService.calculateTaxes(
				ArgumentMatchers.any(QuotationRequestType.class))).thenReturn(new QuotationResponseType());
		Mockito.when(responseTransformer.createCalculateResponse(
				ArgumentMatchers.any(QuotationResponseType.class))).thenReturn(new CalculateResponse());
		
		ResponseEntity<CalculateResponse> resp = taxServiceRestController.calculateTaxes(mockRequest());
		
		assertTrue(HttpStatus.OK.equals(resp.getStatusCode()));
		Mockito.verify(requestTransformer, times(1)).createVertexRequest(
				ArgumentMatchers.any(CalculateRequest.class));
		Mockito.verify(vertexService, times(1)).calculateTaxes(
				ArgumentMatchers.any(QuotationRequestType.class));
		Mockito.verify(responseTransformer, times(1)).createCalculateResponse(
				ArgumentMatchers.any(QuotationResponseType.class));
		Mockito.verify(responseTransformer, times(0)).createErrorResponse(
				ArgumentMatchers.any(Exception.class), ArgumentMatchers.anyString());
	}
	
	@Test
	void testBadAddressInformation() throws VertexException, VertexAddressException {
		Mockito.when(requestTransformer.createVertexRequest(
				ArgumentMatchers.any(CalculateRequest.class))).thenThrow(
						new VertexAddressException(VertexAddressException.BAD_ADDRESS_MSG));
		Mockito.when(responseTransformer.createErrorResponse(
				ArgumentMatchers.any(Exception.class), ArgumentMatchers.anyString())).thenCallRealMethod();
		
		ResponseEntity<CalculateResponse> resp = taxServiceRestController.calculateTaxes(mockRequest());
		
		assertTrue(HttpStatus.BAD_REQUEST.equals(resp.getStatusCode()));
		Mockito.verify(requestTransformer, times(1)).createVertexRequest(
				ArgumentMatchers.any(CalculateRequest.class));
		Mockito.verify(vertexService, times(0)).calculateTaxes(
				ArgumentMatchers.any(QuotationRequestType.class));
		Mockito.verify(responseTransformer, times(0)).createCalculateResponse(
				ArgumentMatchers.any(QuotationResponseType.class));
		Mockito.verify(responseTransformer, times(1)).createErrorResponse(
				ArgumentMatchers.any(Exception.class), ArgumentMatchers.anyString());
	}
	
	@Test
	void testIssueCallingVertex() throws VertexException, VertexAddressException {
		Mockito.when(requestTransformer.createVertexRequest(
				ArgumentMatchers.any(CalculateRequest.class))).thenReturn(new QuotationRequestType());
		Mockito.when(vertexService.calculateTaxes(
				ArgumentMatchers.any(QuotationRequestType.class))).thenThrow(
						new VertexException(new SocketException("Connection reset")));
		Mockito.when(responseTransformer.createErrorResponse(
				ArgumentMatchers.any(VertexException.class), ArgumentMatchers.anyString()))
				.thenCallRealMethod();
		
		ResponseEntity<CalculateResponse> resp = taxServiceRestController.calculateTaxes(mockRequest());
		
		assertTrue(HttpStatus.INTERNAL_SERVER_ERROR.equals(resp.getStatusCode()));
		Mockito.verify(requestTransformer, times(1)).createVertexRequest(
				ArgumentMatchers.any(CalculateRequest.class));
		Mockito.verify(vertexService, times(1)).calculateTaxes(
				ArgumentMatchers.any(QuotationRequestType.class));
		Mockito.verify(responseTransformer, times(0)).createCalculateResponse(
				ArgumentMatchers.any(QuotationResponseType.class));
		Mockito.verify(responseTransformer, times(1)).createErrorResponse(
				ArgumentMatchers.any(Exception.class), ArgumentMatchers.anyString());
	}
	
	@Test
	void testMilitaryCountryCode() throws VertexException, VertexAddressException {
		Mockito.when(requestTransformer.createVertexRequest(
				ArgumentMatchers.any(CalculateRequest.class))).thenReturn(new QuotationRequestType());
		Mockito.when(vertexService.calculateTaxes(
				ArgumentMatchers.any(QuotationRequestType.class))).thenReturn(new QuotationResponseType());
		Mockito.when(responseTransformer.createCalculateResponse(
				ArgumentMatchers.any(QuotationResponseType.class))).thenReturn(new CalculateResponse());
		
		CalculateRequest request = mockRequest();
		request.setCountry("APO/FPO/DPO");
		ResponseEntity<CalculateResponse> resp = taxServiceRestController.calculateTaxes(request);
		
		assertTrue(HttpStatus.OK.equals(resp.getStatusCode()));
		Mockito.verify(requestTransformer, times(1)).createVertexRequest(
				ArgumentMatchers.any(CalculateRequest.class));
		Mockito.verify(vertexService, times(1)).calculateTaxes(
				ArgumentMatchers.any(QuotationRequestType.class));
		Mockito.verify(responseTransformer, times(1)).createCalculateResponse(
				ArgumentMatchers.any(QuotationResponseType.class));
		Mockito.verify(responseTransformer, times(0)).createErrorResponse(
				ArgumentMatchers.any(Exception.class), ArgumentMatchers.anyString());
	}
	
	@Test
	void testInternationalCountryCode() throws VertexException, VertexAddressException {
		Mockito.when(requestTransformer.createVertexRequest(
				ArgumentMatchers.any(CalculateRequest.class))).thenReturn(new QuotationRequestType());
		Mockito.when(vertexService.calculateTaxes(
				ArgumentMatchers.any(QuotationRequestType.class))).thenReturn(new QuotationResponseType());
		Mockito.when(responseTransformer.createCalculateResponse(
				ArgumentMatchers.any(QuotationResponseType.class))).thenReturn(new CalculateResponse());
		
		CalculateRequest request = mockRequest();
		request.setCountry("IN");
		ResponseEntity<CalculateResponse> resp = taxServiceRestController.calculateTaxes(request);
		
		assertTrue(HttpStatus.OK.equals(resp.getStatusCode()));
		Mockito.verify(requestTransformer, times(0)).createVertexRequest(
				ArgumentMatchers.any(CalculateRequest.class));
		Mockito.verify(vertexService, times(0)).calculateTaxes(
				ArgumentMatchers.any(QuotationRequestType.class));
		Mockito.verify(responseTransformer, times(0)).createCalculateResponse(
				ArgumentMatchers.any(QuotationResponseType.class));
		Mockito.verify(responseTransformer, times(0)).createErrorResponse(
				ArgumentMatchers.any(Exception.class), ArgumentMatchers.anyString());
	}
	
	private CalculateRequest mockRequest() {
		CalculateRequest req = new CalculateRequest();
		req.setOrderId("mockOrderId");
		req.setCountry("US");
		return req;
	}

}
