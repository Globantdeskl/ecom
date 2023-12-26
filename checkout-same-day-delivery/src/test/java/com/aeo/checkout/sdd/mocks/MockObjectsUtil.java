package com.aeo.checkout.sdd.mocks;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import com.aeo.checkout.sdd.model.SRSDDRequestVO;
import com.aeo.checkout.sdd.model.SRSDDShippingAddressRequestVO;

public class MockObjectsUtil {	
	
	public Message<SRSDDRequestVO> getMockRequestObject() {
		SRSDDRequestVO request = new SRSDDRequestVO();
		request.setSddToken("sdtkn-6e77cc6092774fd3a814f195ee959903");
		request.setDeliveryInstructions("lonk");
		request.setEmail("ambatim@ae.com");
		SRSDDShippingAddressRequestVO address = new SRSDDShippingAddressRequestVO();
		address.setFirstName("Jack");
		address.setLastName("Madson");
		address.setPhone("9258609639");
		request.setShippingAddress(address);
		return MessageBuilder.withPayload(request).build();
	}
}
