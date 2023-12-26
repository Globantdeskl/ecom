package com.aeo.checkout.submitorder.service;

import com.aeo.checkout.submitorder.config.ApplicationConfigs;
import com.aeo.checkout.submitorder.model.atg.ATGResponse;
import com.aeo.checkout.submitorder.model.atg.ATGResponseError;
import com.aeo.postcheckout.model.order.ATGOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;

class SplitCallWrapperServiceTest {
	
	private SplitCallWrapperService splitOrderCallService;
	
	@Mock
	private ApplicationConfigs configs;

	@Mock
	private ATGSplitOrderService atgSplitOrderService;

	private ObjectMapper mapper;

	@BeforeEach
	void setup() throws JsonProcessingException {
		MockitoAnnotations.initMocks(this);
		mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		splitOrderCallService = new SplitCallWrapperService(atgSplitOrderService, configs, mapper);
		Mockito.when(configs.getSplitCallEndpoint()).thenReturn("https://apisg.ae.com/order/%s/split");
		Mockito.when(configs.isSplitCallEnabled()).thenReturn(true);
	}
	
	@Test
	void testSplitCall() {
		String orderId = "mockOrderId01";
		Mockito.when(atgSplitOrderService.splitCall(ArgumentMatchers.anyString(), ArgumentMatchers.anyString()))
			.thenReturn(ResponseEntity.ok(SplitCallWrapperService.createMockATGResponse(orderId, mapper)));
		
		Optional<ATGOrder> response = splitOrderCallService.call(orderId);
		
		assertTrue(response.isPresent());
		assertEquals(orderId, response.get().getHeader().getMessageId());
		
		Mockito.verify(atgSplitOrderService, times(1))
				.splitCall(ArgumentMatchers.anyString(), ArgumentMatchers.anyString());
	}

	@SuppressWarnings("unchecked")
	@Test
	void testSplitCallNoResponse() {
		String orderId = "mockOrderId01";
		
		ATGResponseError error = new ATGResponseError();
		error.setKey("mock_error");
		ATGResponse atgErrorResp = SplitCallWrapperService.createMockATGResponse(orderId, mapper);
		atgErrorResp.setError(error);
		
		ATGResponse atgNoOrderResp = SplitCallWrapperService.createMockATGResponse(orderId, mapper);
		atgNoOrderResp.setMessage(new ATGOrder());

		Mockito.when(atgSplitOrderService.splitCall(ArgumentMatchers.anyString(), ArgumentMatchers.anyString()))
			.thenReturn(ResponseEntity.ok(null),
					ResponseEntity.ok(atgErrorResp),
					ResponseEntity.ok(atgNoOrderResp));
		
		Optional<ATGOrder> nullResp = splitOrderCallService.call(orderId);
		assertFalse(nullResp.isPresent());
		
		Optional<ATGOrder> errorResp = splitOrderCallService.call(orderId);
		assertFalse(errorResp.isPresent());
		
		Optional<ATGOrder> noOrderResp = splitOrderCallService.call(orderId);
		assertFalse(noOrderResp.isPresent());
		
		Mockito.verify(atgSplitOrderService, times(3))
				.splitCall(ArgumentMatchers.anyString(), ArgumentMatchers.anyString());
	}
	
	@Test
	void testSplitCallFailed() {
		String orderId = "mockOrderId01";
		Mockito.when(atgSplitOrderService.splitCall(ArgumentMatchers.anyString(), ArgumentMatchers.anyString()))
			.thenThrow(RestClientException.class);
		
		assertThrows(RestClientException.class, () -> splitOrderCallService.call(orderId));
		
		Mockito.verify(atgSplitOrderService, times(1))
				.splitCall(ArgumentMatchers.anyString(), ArgumentMatchers.anyString());
	}
	
	@Test
	void testCircuitOpen() {
		assertFalse(splitOrderCallService.fallback("mockOrderId01").isPresent());
	}
	
	@Test
	void testSplitCallDisabled() throws JsonProcessingException {
		Mockito.when(configs.isSplitCallEnabled()).thenReturn(false);
		
		Optional<ATGOrder> response = splitOrderCallService.call("mockOrderId01");
		assertTrue(response.isPresent());
		assertEquals("mockOrderId01", response.get().getHeader().getMessageId());
		
		mapper = Mockito.mock(ObjectMapper.class);
		splitOrderCallService = new SplitCallWrapperService(atgSplitOrderService, configs, mapper);
		Mockito.when(mapper.readValue(ArgumentMatchers.anyString(), ArgumentMatchers.eq(ATGResponse.class)))
			.thenThrow(JsonProcessingException.class);
		
		assertThrows(NullPointerException.class, () -> splitOrderCallService.call("mockOrderId01"));
		
		Mockito.verify(atgSplitOrderService, times(0))
				.splitCall(ArgumentMatchers.anyString(), ArgumentMatchers.anyString());
	}

}
