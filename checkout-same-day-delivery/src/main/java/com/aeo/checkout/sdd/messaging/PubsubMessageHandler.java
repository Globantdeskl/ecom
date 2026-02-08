package com.aeo.checkout.sdd.messaging;

import static net.logstash.logback.argument.StructuredArguments.v;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.stereotype.Component;

import com.aeo.checkout.sdd.model.SRSDDRequestVO;
import com.aeo.checkout.sdd.service.SameDayDeliveryPatchService;
import com.aeo.logging.CommonKeys;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PubsubMessageHandler implements MessageHandler {
	
	private final ObjectMapper objectMapper;
	
	private final SameDayDeliveryPatchService service;
	
	@Autowired
	public PubsubMessageHandler(ObjectMapper objectMapper, SameDayDeliveryPatchService service) {
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		this.objectMapper = objectMapper;
		this.service = service;
	}
	
	@ServiceActivator(inputChannel = "pubsubInputChannel")
	@Override
	@Trace(dispatcher = true)
	public void handleMessage(Message<?> message) {
		try {
			String messageString = (String) message.getPayload();
			log.debug("Message arrived! Payload: {}", messageString);
			SRSDDRequestVO request = objectMapper.readValue(messageString, SRSDDRequestVO.class);
			if(request == null) {
				log.error("SDDOrderRequest is null. Message from pubsub failure {}", message);
			} else {
				initiateNewrelicTransaction(request);
				log.info("SDDOrderRequest Received {}: {}", v(CommonKeys.ORDER_ID.key(), request.getOrderNumber()), v("request", request));
				service.performPatchCall(request);
			}
		} catch (Exception e) {
			log.error("Error in handleMessage {}", message, e);
		}	
	}
	
	private void initiateNewrelicTransaction(SRSDDRequestVO request) {
		NewRelic.setTransactionName("checkout-same-day-delivery", "pubsubInputChannel");
		NewRelic.addCustomParameter("orderNumber", request.getOrderNumber());
		NewRelic.addCustomParameter("TLTUID", UUID.randomUUID().toString());
	}
	
}
