package com.aeo.checkout.sdd.messaging;

import static net.logstash.logback.argument.StructuredArguments.v;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.aeo.checkout.sdd.model.SRSDDRequestVO;
import com.aeo.logging.CommonKeys;
import com.newrelic.api.agent.Trace;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@EnableBinding(SDDPatchReprocessor.class)
public class SDDPatchReprocessorPublisher {
	
	private final SDDPatchReprocessor reprocessor;
	
	@Autowired
	public SDDPatchReprocessorPublisher(SDDPatchReprocessor pReprocessor) {
		this.reprocessor = pReprocessor;
	}
	
	@Trace
	public boolean putSddPatchFailedOrderInMessageQueue(SRSDDRequestVO request) {
		log.info("::SDDPatchReprocessorPublisher:: Patch retry for OrderNumber: {}",v(CommonKeys.ORDER_ID.key(),request.getOrderNumber()));
		return reprocessor.resendSddFailedPatchOrders()
				.send(MessageBuilder.withPayload(request).build());
	}
}
