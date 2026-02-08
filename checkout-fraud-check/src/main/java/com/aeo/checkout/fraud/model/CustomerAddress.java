package com.aeo.checkout.fraud.model;

import lombok.Data;

@Data
public class CustomerAddress {
	
	private String address1;
	
	private String address2;
	
	private String city;
	
	private String stateName;
	
	private String countryCode;
	
	private String postalCode;
	
}
