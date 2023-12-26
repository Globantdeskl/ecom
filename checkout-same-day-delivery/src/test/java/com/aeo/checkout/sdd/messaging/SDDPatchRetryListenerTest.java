package com.aeo.checkout.sdd.messaging;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.aeo.checkout.sdd.model.SRSDDRequestVO;
import com.aeo.checkout.sdd.model.SRSDDShippingAddressRequestVO;
import com.aeo.checkout.sdd.service.SameDayDeliveryPatchRetryService;

public class SDDPatchRetryListenerTest {
	
	private SDDPatchRetryListener retryListener;
	
	@Mock
	private SameDayDeliveryPatchRetryService retryService;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		retryListener = new SDDPatchRetryListener(retryService);
	}	
	
	@Test
	public void shouldReceiveNullSddOrderMessage() {
		retryListener.processRetryFailedSddOrders(null);
		Mockito.verify(retryService, times(0)).doRetryPatchCall(null);
		
	}
	
	@Test
	public void shouldReceiveSddOrderMessage() {
		assertNotNull(mockRequest());
		retryListener.processRetryFailedSddOrders(mockRequest());
		Mockito.verify(retryService, times(1)).doRetryPatchCall(mockRequest());
		
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
