package com.aeo.checkout.sdd.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.aeo.checkout.sdd.model.SRSDDRequestVO;
import com.aeo.checkout.sdd.model.SRSDDShippingAddressRequestVO;

public class SameDayDeliveryPatchRetryServiceTest {
	
	private SameDayDeliveryPatchRetryService service;
	
	@Mock
	private HttpPatchCallService httpService;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		service = new SameDayDeliveryPatchRetryService( httpService);
	}
	
	@Test
	public void doRetryPatchCallTest() {
		Mockito.when(service.doRetryPatchCall(mockRequest())).thenReturn(true);
		assertEquals(true, service.doRetryPatchCall(mockRequest()));
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
