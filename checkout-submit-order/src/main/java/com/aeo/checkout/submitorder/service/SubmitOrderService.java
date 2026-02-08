package com.aeo.checkout.submitorder.service;

import com.aeo.checkout.submitorder.messaging.FulfillOrderPublisher;
import com.aeo.checkout.submitorder.model.SubmittedOrder;
import com.aeo.logging.CommonKeys;
import com.aeo.postcheckout.model.order.ATGOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static net.logstash.logback.argument.StructuredArguments.v;

@Slf4j
@Service
public class SubmitOrderService {
	
	private final SplitCallWrapperService splitOrderService;
	private final FulfillOrderPublisher fulfillmentPublisher;
	
	public SubmitOrderService(SplitCallWrapperService splitOrderService,
							  FulfillOrderPublisher fulfillmentPublisher) {
		this.splitOrderService = splitOrderService;
		this.fulfillmentPublisher = fulfillmentPublisher;
	}
	
	/**
	 * actions for submitting an order
	 * 	1. split order
	 * 	2. send to fulfillment pubsub
	 */
	@Transactional
	public boolean submit(SubmittedOrder order) {
		String orderId = order.getOrderId();
		Optional<ATGOrder> splitOrder = splitOrderService.call(orderId);
		boolean submitted = false;
		if(splitOrder.isPresent() && 
				fulfillmentPublisher.send(splitOrder.get(), orderId)) {
			
			log.info("Post Order to Fulfillment {}",
					v(CommonKeys.ORDER_ID.key(), orderId),
					v("split_order", splitOrder.get()));
			
			submitted = true;
		}else{
			log.error("Post Order to Fulfillment Failed {}",
						v(CommonKeys.ORDER_ID.key(), orderId));
		}
		return submitted;
	}

}
