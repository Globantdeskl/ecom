package com.aeo.checkout.submitorder.messaging;

import static net.logstash.logback.argument.StructuredArguments.v;

import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import com.aeo.checkout.submitorder.model.SubmittedOrder;
import com.aeo.checkout.submitorder.service.SubmitOrderService;
import com.aeo.logging.CommonKeys;
import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.pubsub.v1.PubsubMessage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class SubmitOrderSubscriber implements MessageReceiver {
	
	private static final String MSG_PAYLOAD_LOG_KEY = "msg_payload";
	private static final String SUBMITTED_ORDER_LOG_KEY = "submitted_order";
	
	private final SubmitOrderService submitOrderService;

	@Override
	public void receiveMessage(PubsubMessage message, AckReplyConsumer consumer) {

		SubmittedOrder submittedOrder = new SubmittedOrder();
		message.getData().toString();
		String payload = message.getData().toStringUtf8();
		log.debug("submitOrderChannel message received: {}", v(MSG_PAYLOAD_LOG_KEY, payload));
		submittedOrder.setOrderId(payload);

		if(submittedOrder.getOrderId().isEmpty()) {
			log.error("no SubmittedOrder orderId for message: {}", v(MSG_PAYLOAD_LOG_KEY, payload));
			throw new MessagingException("Empty Submitted Order");
		}

		try {
			if(!submitOrderService.submit(submittedOrder)) {
				log.error("SubmitOrder Failed for {} :: deliveryAttempt :: ",
						v(CommonKeys.ORDER_ID.key(), submittedOrder.getOrderId()),
						Subscriber.getDeliveryAttempt(message));
				consumer.nack();
				throw new MessagingException("Submit Failed " + submittedOrder.getOrderId());
			}
			consumer.ack();
		} catch (RestClientException | MessagingException e) {
			log.error("Submit Order failed {}", v(CommonKeys.ORDER_ID.key(), submittedOrder.getOrderId()),
					v(SUBMITTED_ORDER_LOG_KEY, submittedOrder));
			consumer.nack();
			throw new MessagingException(e.getMessage(), e);
		}

		log.info("Order Submitted {}", v(CommonKeys.ORDER_ID.key(), submittedOrder.getOrderId()),
				v(SUBMITTED_ORDER_LOG_KEY, submittedOrder));

	}

}
