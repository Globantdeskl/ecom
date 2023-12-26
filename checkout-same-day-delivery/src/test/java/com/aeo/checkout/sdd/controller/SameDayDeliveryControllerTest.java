package com.aeo.checkout.sdd.controller;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.aeo.checkout.sdd.model.SRSDDRequestVO;
import com.aeo.checkout.sdd.model.SRSDDShippingAddressRequestVO;
import com.aeo.checkout.sdd.service.SameDayDeliveryPatchService;

public class SameDayDeliveryControllerTest {
	
	private SameDayDeliveryController controller;
	
	@Mock
	private SameDayDeliveryPatchService service;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		controller = new SameDayDeliveryController(service);
	}
	
	@Test
	public void postSddPropertiesSuccess() {
		Mockito.when(service.performPatchCall( mockRequest())).thenReturn(true);
		assertEquals(ResponseEntity.status(HttpStatus.OK).body(mockRequest()), controller.postSddProperties(mockRequest()));
	}
	
	@Test
	public void postSddPropertiesFail() {
		Mockito.when(service.performPatchCall(null)).thenReturn(true);
		assertEquals(ResponseEntity.status(HttpStatus.OK).body(null), controller.postSddProperties(null));
	}
	
	public SRSDDRequestVO mockRequest() {
		SRSDDRequestVO request = new SRSDDRequestVO();
		request.setSddToken("sdtkn-e5bffdfc2c5547e7a26d1cba6667e653");
		request.setDeliveryInstructions("lonk");
		SRSDDShippingAddressRequestVO address = new SRSDDShippingAddressRequestVO();
		request.setShippingAddress(address);
		return request;
	}
}
