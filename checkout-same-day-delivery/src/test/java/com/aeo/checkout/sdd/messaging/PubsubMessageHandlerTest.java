package com.aeo.checkout.sdd.messaging;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.messaging.Message;

import com.aeo.checkout.sdd.model.SRSDDRequestVO;
import com.aeo.checkout.sdd.service.SameDayDeliveryPatchService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PubsubMessageHandlerTest {

	private PubsubMessageHandler pubsubMessageHandler;
	
	@Mock
	private ObjectMapper objectMapper;
	
	@Mock
	private SameDayDeliveryPatchService service;
	
	@SuppressWarnings("unchecked")
	private static Message<String> mockMessage = Mockito.mock(Message.class);
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		when(mockMessage.getPayload()).thenReturn("mockOrderId");
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		pubsubMessageHandler = new PubsubMessageHandler(objectMapper, service);
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void testHandleOrderMessage() throws JsonParseException, JsonMappingException, IOException {
		when(objectMapper.readValue(ArgumentMatchers.anyString(), ArgumentMatchers.any(Class.class))).thenReturn(new SRSDDRequestVO());
		when(service.performPatchCall(ArgumentMatchers.any(SRSDDRequestVO.class))).thenReturn(true);
		assertAll(() -> pubsubMessageHandler.handleMessage(mockMessage));
		Mockito.verify(objectMapper, times(1)).readValue(ArgumentMatchers.anyString(), ArgumentMatchers.any(Class.class));
		Mockito.verify(service, times(1)).performPatchCall(ArgumentMatchers.any(SRSDDRequestVO.class));
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void testParsingError() throws JsonParseException, JsonMappingException, IOException {
		when(objectMapper.readValue(ArgumentMatchers.anyString(), ArgumentMatchers.any(Class.class))).thenThrow(JsonParseException.class);
		assertAll(() -> pubsubMessageHandler.handleMessage(mockMessage));
		Mockito.verify(objectMapper, times(1)).readValue(ArgumentMatchers.anyString(), ArgumentMatchers.any(Class.class));
		Mockito.verify(service, times(0)).performPatchCall(ArgumentMatchers.any(SRSDDRequestVO.class));
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void testOrderNull() throws JsonParseException, JsonMappingException, IOException {
		when(objectMapper.readValue(ArgumentMatchers.anyString(), ArgumentMatchers.any(Class.class))).thenReturn(null);
		assertAll(() -> pubsubMessageHandler.handleMessage(mockMessage));
		Mockito.verify(objectMapper, times(1)).readValue(ArgumentMatchers.anyString(), ArgumentMatchers.any(Class.class));
		Mockito.verify(service, times(0)).performPatchCall(ArgumentMatchers.any(SRSDDRequestVO.class));
	}
}
