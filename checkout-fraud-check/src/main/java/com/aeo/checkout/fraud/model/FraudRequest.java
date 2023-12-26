package com.aeo.checkout.fraud.model;

import java.util.List;

import lombok.Data;

@Data
public class FraudRequest {
	
	private String orderId;
	
	private String website;
	
	private String orderTimeZone;
	
	private String userId;

	private String freightAmount;

	private String amount;
	
	private boolean resubmittedOrder;

	private CustomerOrder customerOrder;

	private CustomerBillingDetail customerBillingDetail;

	private CustomerShippingDetail customerShippingDetail;

	private OrderMetaData orderMetaData;
	
	private List<String> appliedCoupons;

	private List<Item> items;

	private List<PaymentMethod> paymentMethods;
}