package com.aeo.checkout.submitorder.rest;

import com.aeo.checkout.submitorder.messaging.FulfillOrderPublisher;
import com.aeo.checkout.submitorder.model.SubmittedOrder;
import com.aeo.checkout.submitorder.service.SplitCallWrapperService;
import com.aeo.checkout.submitorder.service.SubmitOrderService;
import com.aeo.logging.CommonKeys;
import com.aeo.postcheckout.model.order.ATGOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static net.logstash.logback.argument.StructuredArguments.v;

@Slf4j
@RestController
public class SubmitOrderRestController {
	
	private final SubmitOrderService submitOrderService;
	private final FulfillOrderPublisher fulfillmentPublisher;
	private final SplitCallWrapperService splitOrderService;
	
	public SubmitOrderRestController(
			SubmitOrderService submitOrderService,
			FulfillOrderPublisher fulfillmentPublisher,
			SplitCallWrapperService splitOrderService) {
		this.submitOrderService = submitOrderService;
		this.fulfillmentPublisher = fulfillmentPublisher;
		this.splitOrderService = splitOrderService;
	}
	
	@PostMapping(path = "/order/{orderId}/submit")
	public ResponseEntity<String> submitOrder(@PathVariable String orderId) {
		log.info("Submitting Order {}", v(CommonKeys.ORDER_ID.key(), orderId));
		SubmittedOrder order = new SubmittedOrder();
		order.setOrderId(orderId);
		try {
			if(submitOrderService.submit(order)) {
				return ResponseEntity.accepted().body(orderId);
			}
		} catch (Exception e) {
			log.error("Submitting Order {} Failed", v(CommonKeys.ORDER_ID.key(), orderId), e);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(orderId);
	}
	
	@PostMapping(path = "/order/{orderId}/fulfill")
	public ResponseEntity<String> fulfillOrder(@RequestBody ATGOrder order) {
		String orderId = order.getHeader().getMessageId();
		log.info("Submitting Order {} to Fulfillment", v(CommonKeys.ORDER_ID.key(), orderId));
		try {
			if(fulfillmentPublisher.send(order, orderId)) {
				return ResponseEntity.accepted().body(orderId);
			}
		} catch (Exception e) {
			log.error("Submitting Order {} to Fulfillment Failed", v(CommonKeys.ORDER_ID.key(), orderId), e);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(orderId);
	}
	
	@GetMapping(path = "/order/{orderId}/split")
	public ResponseEntity<ATGOrder> splitOrder(@PathVariable String orderId) {
		log.info("Splitting Order {}", v(CommonKeys.ORDER_ID.key(), orderId));
		try {
			Optional<ATGOrder> splitResponse = splitOrderService.call(orderId);
			if(splitResponse.isPresent()) {
				return ResponseEntity.ok(splitResponse.get());
			}
		} catch (Exception e) {
			log.error("Splitting Order {} Failed", v(CommonKeys.ORDER_ID.key(), orderId), e);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ATGOrder());
	}

}
