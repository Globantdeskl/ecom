package com.aeo.checkout.submitorder.service;

import com.aeo.checkout.submitorder.model.atg.ATGResponse;
import com.aeo.logging.CommonKeys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static net.logstash.logback.argument.StructuredArguments.v;

@Slf4j
@Service
public class ATGSplitOrderService {

	private final RestTemplate restTemplate;
	private final HttpHeaders headers;
	private static final String AUTH_HEADER = "Authorization";
	private static final String BASIC_PREPEND = "Basic ";
	
	public ATGSplitOrderService(RestTemplate restTemplate, @Value("${app-configs.basic-auth-key}") String basicAuthKey) {
		this.restTemplate = restTemplate;
		HttpHeaders h = new HttpHeaders();
		h.setContentType(MediaType.APPLICATION_JSON);
		h.add(AUTH_HEADER, BASIC_PREPEND + basicAuthKey);
		headers = h;
	}
	
	@Retryable(value = RuntimeException.class, maxAttempts = 3, backoff = @Backoff(delay = 1000))
	public ResponseEntity<ATGResponse> splitCall(String endpoint, String orderId) {
		HttpEntity<String> entityHeaders = new HttpEntity<>(headers);
		try {
			return restTemplate.exchange(endpoint, HttpMethod.GET, entityHeaders, ATGResponse.class);

		} catch(Exception e){
			log.error("ATGSplitOrder :: {} returned {}", v(CommonKeys.ORDER_ID.key(), orderId) , e.toString());
			throw e;
		}
	}
	
	@Recover
	public ResponseEntity<ATGResponse> splitCall(RuntimeException re, String endpoint, String orderId) {
		log.error("ATGSplitOrder Call failed after three tries :: {} :: {}",
					v(CommonKeys.ORDER_ID.key(), orderId), re.toString());
		throw re;
	}

}
