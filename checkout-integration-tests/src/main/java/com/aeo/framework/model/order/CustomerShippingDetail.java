package com.aeo.framework.model.order;

import lombok.Data;

@Data
public class CustomerShippingDetail {
	
	private String firstName;
	
	private String lastName;
	
	private String emailAddress;
	
	private String phoneNumber;
	
	private CustomerAddress address;

}
