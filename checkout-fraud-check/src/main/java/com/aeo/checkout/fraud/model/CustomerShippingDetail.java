package com.aeo.checkout.fraud.model;

import lombok.Data;

@Data
public class CustomerShippingDetail {
	
	private String firstName;
	
	private String lastName;
	
	private String emailAddress;
	
	private String phoneNumber;
	
	private CustomerAddress address;

}
