package com.aeo.framework.model.order;

import lombok.Data;

@Data
public class OrderDetails {

	private String currencyCode;
	
	private HeaderCharges headerCharges;
	
	private HeaderTaxes headerTaxes;
	
	private HeaderPromos headerPromos;
	
	private String orderTotal;
	
	private String itemsTotalAfterDiscount;
	
}