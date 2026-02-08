package com.aeo.checkout.sdd.messaging;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import static net.logstash.logback.argument.StructuredArguments.v;

import com.aeo.checkout.sdd.model.SRSDDRequestVO;
import com.aeo.checkout.sdd.service.SameDayDeliveryPatchRetryService;
import com.aeo.logging.CommonKeys;
import com.newrelic.api.agent.Trace;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@EnableBinding(SDDPatchRetry.class)
public class SDDPatchRetryListener {
	
	private SameDayDeliveryPatchRetryService httpService;
	
	public SDDPatchRetryListener(SameDayDeliveryPatchRetryService pService) {
		this.httpService = pService;
	}
	
	@Trace(dispatcher = true, metricName = "sddFailedPatchOrdersRetry")
	@StreamListener("sddFailedPatchOrdersRetry")
	public void processRetryFailedSddOrders(SRSDDRequestVO request) {
		
		if (request == null) {
			log.warn("Null object received from Retry queue");
			return;
		}
		
		log.info("::SDDPatchRetryListener:: Patch retry for OrderNumber: {}",v(CommonKeys.ORDER_ID.key(), request.getOrderNumber()));
		httpService.doRetryPatchCall(request);
	}
	
}
