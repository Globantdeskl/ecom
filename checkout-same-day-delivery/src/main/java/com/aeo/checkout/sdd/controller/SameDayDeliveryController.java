package com.aeo.checkout.sdd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aeo.checkout.sdd.model.SRSDDRequestVO;
import com.aeo.checkout.sdd.service.SameDayDeliveryPatchService;
import com.newrelic.api.agent.Trace;

@RestController
public class SameDayDeliveryController {
	
	private final SameDayDeliveryPatchService service;
	
	@Autowired
	public SameDayDeliveryController (SameDayDeliveryPatchService pService) {
		this.service = pService;
	}
	
	@Trace(dispatcher = true, metricName = "/sdd/properties#POST")
	@PostMapping(value = "/sdd/properties", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SRSDDRequestVO> postSddProperties(@RequestBody SRSDDRequestVO request) {
		service.performPatchCall(request);
		return ResponseEntity.status(HttpStatus.OK).body(request);
	}

}
