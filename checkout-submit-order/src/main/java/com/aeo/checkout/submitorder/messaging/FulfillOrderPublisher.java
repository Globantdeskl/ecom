package com.aeo.checkout.submitorder.messaging;

import static net.logstash.logback.argument.StructuredArguments.v;

import org.springframework.messaging.MessagingException;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import com.aeo.checkout.submitorder.config.FulfillOrderPublisherConfig.Submit2FulfillmentPubsubOutboundGateway;
import com.aeo.logging.CommonKeys;
import com.aeo.postcheckout.model.order.ATGOrder;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FulfillOrderPublisher {
	
	private static final int MAX_ATTEMPTS = 3;
	
	private final Submit2FulfillmentPubsubOutboundGateway fulfillmentPubsub;
	private final Gson gsonMapper;
	
	public FulfillOrderPublisher(Gson gsonMapper,
			Submit2FulfillmentPubsubOutboundGateway fulfillmentPubsub) {
		this.fulfillmentPubsub = fulfillmentPubsub;
		this.gsonMapper = gsonMapper;
	}
	
	@Retryable(include = MessagingException.class, maxAttempts = MAX_ATTEMPTS)
	public boolean send(ATGOrder order, String orderId) {
		
		String jsonOrder = gsonMapper.toJson(order);
		
		log.debug("Attempting to Post Order to Fulfillment {}: {}", 
				v(CommonKeys.ORDER_ID.key(), orderId), v("json_order", jsonOrder));
		
		fulfillmentPubsub.sendToPubsub(jsonOrder);
		return true;
	}
	
	@Recover
	public boolean send(MessagingException e, ATGOrder order, String orderId) {
		log.error("Order {} Failed Posting to Fulfillment after {} attempts", 
				v(CommonKeys.ORDER_ID.key(), orderId), MAX_ATTEMPTS, e);
		return false;
	}

}
