package com.aeo.checkout.tax.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class TaxableItem {
	
	private String skuId;
	private String taxCode;
	private int quantity;
	private String commerceItemId;
	private double amount;
	private List<Double> discounts = new ArrayList<>();
	
}
