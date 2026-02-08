package com.aeo.checkout.sdd.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestClientException;

import com.aeo.checkout.sdd.messaging.SDDPatchReprocessorPublisher;
import com.aeo.checkout.sdd.model.SRSDDRequestVO;
import com.aeo.checkout.sdd.model.SRSDDShippingAddressRequestVO;

public class SameDayDeliveryPatchServiceTest {
	
	private SameDayDeliveryPatchService service;
	
	@Mock
	private SDDPatchReprocessorPublisher reprocessorService;
	
	@Mock
	private HttpPatchCallService httpService;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		service = new SameDayDeliveryPatchService(reprocessorService, httpService);
	}
	
	@Test
	public void doPatchCallSuccess() {
		Mockito.when(service.performPatchCall(mockRequest())).thenReturn(true);
		assertEquals(true, service.performPatchCall(mockRequest()));
	}
	
	@Test
	public void doPatchCallFail() {
		Mockito.when(service.performPatchCall(mockRequest())).thenThrow(RestClientException.class);
		assertThrows(RestClientException.class, () -> {
			service.performPatchCall(mockRequest());
		});
		Mockito.when(reprocessorService.putSddPatchFailedOrderInMessageQueue(mockRequest())).thenReturn(true);
		assertEquals(false,service.fallback(new RestClientException("fail"), mockRequest()));
	}
	
	@Test
	public void fallbackSuccesstoQueue() {
		Mockito.when(reprocessorService.putSddPatchFailedOrderInMessageQueue(mockRequest())).thenReturn(true);
		assertEquals(true, reprocessorService.putSddPatchFailedOrderInMessageQueue(mockRequest()));
	}
	
	@Test
	public void fallbackFailedtoQueue() {
		Mockito.when(reprocessorService.putSddPatchFailedOrderInMessageQueue(null)).thenReturn(false);
		assertEquals(false, reprocessorService.putSddPatchFailedOrderInMessageQueue(null));
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
