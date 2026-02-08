package com.aeo.checkout.sdd.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface SDDPatchRetry {
	
	@Input("sddFailedPatchOrdersRetry") 
	SubscribableChannel retrySddFailedPatchOrders();
	 
}
