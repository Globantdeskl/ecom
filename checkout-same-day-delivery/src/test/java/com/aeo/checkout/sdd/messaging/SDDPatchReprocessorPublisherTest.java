package com.aeo.checkout.sdd.messaging;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import com.aeo.checkout.sdd.mocks.MockObjectsUtil;
import com.aeo.checkout.sdd.model.SRSDDRequestVO;

public class SDDPatchReprocessorPublisherTest {
	
	@Mock
	private SDDPatchReprocessor reprocessor;
	
	private MessageChannel sddOrdersChannel = Mockito.mock(MessageChannel.class);
	
	private  MockObjectsUtil mockObjectsUtil = new MockObjectsUtil();
	
	private Message<SRSDDRequestVO> requestMessage = mockObjectsUtil.getMockRequestObject();
	
	private SDDPatchReprocessorPublisher publisher;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		Mockito.when(reprocessor.resendSddFailedPatchOrders()).thenReturn(sddOrdersChannel);
		publisher = new SDDPatchReprocessorPublisher(reprocessor);
	}
	
	@Test
	public void putSddPatchFailedOrderInMessageQueueTest() {
		Mockito.when(reprocessor.resendSddFailedPatchOrders()
				.send(ArgumentMatchers.any(requestMessage.getClass()))).thenReturn(true, false);
		
		boolean pushSuccess = publisher.putSddPatchFailedOrderInMessageQueue(mockObjectsUtil.getMockRequestObject().getPayload());
		assertEquals(true, pushSuccess);
		
		boolean pushFail = publisher.putSddPatchFailedOrderInMessageQueue(mockObjectsUtil.getMockRequestObject().getPayload());
		assertEquals(false, pushFail);
	}
}
