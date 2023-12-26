package com.aeo.checkout.sdd.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.aeo.checkout.sdd.model.SRSDDRequestVO;
import com.newrelic.api.agent.Trace;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SameDayDeliveryPatchRetryService {
	
	private final HttpPatchCallService httpService;
	
	public SameDayDeliveryPatchRetryService(HttpPatchCallService httpService) {
		this.httpService = httpService;
	}
	
	@Trace
	@Retryable(value = { RestClientException.class }, maxAttempts = 3, backoff = @Backoff(delay = 1000))
	public boolean doRetryPatchCall(SRSDDRequestVO request) {
		log.debug("::SameDayDeliveryPatchRetryService:: Patch retry for OrderNumber: {}",request.getOrderNumber());
		return httpService.patchCall(request);
	}
}
