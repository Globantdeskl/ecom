package com.aeo.checkout.sdd.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.aeo.checkout.sdd.messaging.SDDPatchReprocessorPublisher;
import com.aeo.checkout.sdd.model.SRSDDRequestVO;
import com.aeo.logging.CommonKeys;
import com.newrelic.api.agent.Trace;
import static net.logstash.logback.argument.StructuredArguments.v;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SameDayDeliveryPatchService {
	
	private final SDDPatchReprocessorPublisher reprocessorService;
	
	private final HttpPatchCallService httpService;
	
	
	@Autowired
	public SameDayDeliveryPatchService (SDDPatchReprocessorPublisher pReprocessorService, HttpPatchCallService httpService) {
		this.reprocessorService = pReprocessorService;
		this.httpService = httpService;
	}
	
	@Trace
	@Retryable(value = { RestClientException.class }, maxAttempts = 3, backoff = @Backoff(delay = 1000))
	public boolean performPatchCall(SRSDDRequestVO request) {
		log.debug("::SameDayDeliveryPatchService:: doPatchCall()");
		return httpService.patchCall(request);
	}

	@Trace
	@Recover
	public boolean fallback(RestClientException e, SRSDDRequestVO request) {
		log.info("::Fallback:: Call to ShopRunner failed and Request {} for OrderNumber and Reprocessing ", v(CommonKeys.ORDER_ID.key(), request.getOrderNumber()));
		request.setErrorCode(e.getMessage());
		boolean pushedToRepreocessQ =  reprocessorService.putSddPatchFailedOrderInMessageQueue(request);
		log.info("::Fallback Pushed:: Order pushed to reprocess queue : {}", v(CommonKeys.ORDER_ID.key(), request.getOrderNumber()),
				pushedToRepreocessQ);
		return  pushedToRepreocessQ;
	}
	
}
