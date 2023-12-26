package com.aeo.checkout.sdd.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.aeo.checkout.sdd.config.SDDApplicationProperties;
import com.aeo.checkout.sdd.model.SRSDDRequestVO;
import com.aeo.checkout.sdd.model.SRSDDShippingAddressRequestVO;

public class HttpPatchCallServiceTest {
	
	private HttpPatchCallService service;
	
	@Mock
	private RestTemplate restTemplate;
	
	@Mock
	private SDDApplicationProperties yamlConfig;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		yamlConfig = new SDDApplicationProperties();
		yamlConfig.setPatchurl("https://samedaysession.stg.shoprunner.io/retailers/AEGL/checkouts/");
		yamlConfig.setAuth("Basic YWVnbDJAc2hvcHJ1bm5lci5jb20uc3JzdGc6TFNCWjZQT0Fla29s");
		service = new HttpPatchCallService(restTemplate, yamlConfig);
	}
	
	@Test
	public void patchCallSuccess() {
		Mockito.when(restTemplate.exchange(ArgumentMatchers.anyString(), ArgumentMatchers.eq(HttpMethod.PATCH),
				ArgumentMatchers.any(HttpEntity.class), ArgumentMatchers.eq(String.class))).thenReturn(ResponseEntity.ok().build());
		assertEquals(true, service.patchCall(mockRequest()));
	}
	
	@Test
	public void patchCallFail() {
		Mockito.when(restTemplate.exchange(ArgumentMatchers.anyString(), ArgumentMatchers.eq(HttpMethod.PATCH),
				ArgumentMatchers.any(HttpEntity.class),  ArgumentMatchers.eq(String.class))).thenReturn(ResponseEntity.badRequest().build());
		assertEquals(false, service.patchCall(mockRequestFail()));
	}
	
	public SRSDDRequestVO mockRequest() {
		SRSDDRequestVO request = new SRSDDRequestVO();
		request.setSddToken("sdtkn-6e77cc6092774fd3a814f195ee959903");
		request.setDeliveryInstructions("lonk");
		request.setEmail("ambatim@ae.com");
		SRSDDShippingAddressRequestVO address = new SRSDDShippingAddressRequestVO();
		address.setFirstName("Jack");
		address.setLastName("Madson");
		address.setPhone("9258609639");
		request.setShippingAddress(address);
		return request;
	}
	
	public SRSDDRequestVO mockRequestFail() {
		SRSDDRequestVO request = new SRSDDRequestVO();
		request.setSddToken("sdtkn-6e77cc6092774fd3a814f195ee959903");
		return request;
	}
	
	
}
