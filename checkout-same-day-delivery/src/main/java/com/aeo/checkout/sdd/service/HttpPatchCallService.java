package com.aeo.checkout.sdd.service;

import static net.logstash.logback.argument.StructuredArguments.v;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aeo.checkout.sdd.config.SDDApplicationProperties;
import com.aeo.checkout.sdd.model.SRSDDRequestVO;
import com.aeo.logging.CommonKeys;
import com.newrelic.api.agent.Trace;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HttpPatchCallService {
	
	private HttpHeaders headers;
	private final RestTemplate restTemplate;
	private final SDDApplicationProperties yamlConfig;
	
	@Autowired
	public HttpPatchCallService (RestTemplate restTemplate, SDDApplicationProperties pYamlConfig) {
		this.restTemplate = restTemplate;
		this.yamlConfig = pYamlConfig;
		HttpHeaders h = new HttpHeaders();
		h.setContentType(MediaType.APPLICATION_JSON);
		h.set(HttpHeaders.AUTHORIZATION, yamlConfig.getAuth());
		headers = h;
	}
	
	@Trace
	public boolean patchCall(SRSDDRequestVO request) {
		HttpEntity<SRSDDRequestVO> httprequest = new HttpEntity<SRSDDRequestVO>(request,headers);
		log.debug("::HttpPatchCallService:: Resttemplate exchange URL : {}",yamlConfig.getPatchurl()+request.getSddToken());
		ResponseEntity<String> reponse = restTemplate.exchange(yamlConfig.getPatchurl()+request.getSddToken(), HttpMethod.PATCH, httprequest, String.class);
		if(HttpStatus.OK.equals(reponse.getStatusCode())) {
			log.info("::HttpPatchCallService:: Patch call successfully to Shoprunner for OrderNumber: {}", v(CommonKeys.ORDER_ID.key(), request.getOrderNumber()));
			return true;
		} else {
			return false;
		}
	}
}
