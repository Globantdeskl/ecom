package com.aeo.checkout.sdd.model;

import lombok.Data;

@Data
public class SRSDDRequestVO {
	private String orderNumber;
	private String sddToken;
	private String email;
	private String deliveryInstructions;
	private boolean smsOptIn;
	private String smsPhone;
	private SRSDDShippingAddressRequestVO shippingAddress;
	private String errorCode;
}
