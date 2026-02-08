package com.aeo.checkout.tax.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class CalculateRequest {

	private String orderId;
	private String taxDate;
	private String currencyCode;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String country;
	private String postalCode;
	private String shippingGroupId;
	private double shippingCost;
	private List<TaxableItem> taxableItems = new ArrayList<>();
	@Deprecated
	private List<Double> orderDiscountAmounts = new ArrayList<>();
	
}
