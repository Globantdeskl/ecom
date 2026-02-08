package com.aeo.checkout.sdd.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

import com.newrelic.api.agent.Trace;

public interface SDDPatchReprocessor {
	
	@Trace(leaf = true)
	@Output("sddFailedPatchOrdersReprocessor")
	MessageChannel resendSddFailedPatchOrders();
	
}
