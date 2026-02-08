package com.aeo.checkout.submitorder.messaging;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.messaging.MessagingException;
import org.springframework.web.client.RestClientException;

import com.aeo.checkout.submitorder.model.SubmittedOrder;
import com.aeo.checkout.submitorder.service.SubmitOrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;

class SubmitOrderSubscriberTest {
	
	private SubmitOrderSubscriber submitOrderSubscriber;
	
	@Mock
	private ObjectMapper mapper;
	
	@Mock
	private SubmitOrderService submitOrderService;

	@Mock
	private AckReplyConsumer ackReplyConsumer;

	private SubmittedOrder order;
	
	private PubsubMessage message = PubsubMessage.newBuilder().setData(ByteString.copyFromUtf8("mockOrder01")).build();

	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
		submitOrderSubscriber = new SubmitOrderSubscriber(submitOrderService);
		order = new SubmittedOrder();
		order.setOrderId("mockOrderId01");
	}
	
	@Test
	void testHandleMessage() throws JsonProcessingException {

		Mockito.when(submitOrderService.submit(ArgumentMatchers.any(SubmittedOrder.class)))
			.thenReturn(true);
		
		assertDoesNotThrow(() -> submitOrderSubscriber.receiveMessage(message, ackReplyConsumer));

		Mockito.verify(submitOrderService, times(1)).submit(ArgumentMatchers.any(SubmittedOrder.class));
	}
	
	@Test
	void testMessageParseFailed() throws JsonProcessingException {

		PubsubMessage emptyMessage = PubsubMessage.newBuilder().build();

		assertThrows(MessagingException.class, () -> submitOrderSubscriber.receiveMessage(emptyMessage, ackReplyConsumer));

		Mockito.verify(submitOrderService, times(0)).submit(ArgumentMatchers.any(SubmittedOrder.class));
	}

	@Test
	void testSubmitFailed() throws JsonProcessingException {

		Mockito.when(submitOrderService.submit(ArgumentMatchers.any(SubmittedOrder.class)))
			.thenReturn(false)
			.thenThrow(RestClientException.class)
			.thenThrow(MessagingException.class);
		
		assertThrows(MessagingException.class, () -> submitOrderSubscriber.receiveMessage(message, ackReplyConsumer));
		assertThrows(MessagingException.class, () -> submitOrderSubscriber.receiveMessage(message, ackReplyConsumer));
		assertThrows(MessagingException.class, () -> submitOrderSubscriber.receiveMessage(message, ackReplyConsumer));
		
		Mockito.verify(submitOrderService, times(3)).submit(ArgumentMatchers.any(SubmittedOrder.class));
	}

}
