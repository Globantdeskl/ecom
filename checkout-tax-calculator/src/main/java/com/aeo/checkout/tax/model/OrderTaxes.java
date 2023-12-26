package com.aeo.checkout.tax.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class OrderTaxes {
	
	private String transactionId;
	private Date transactionTimestamp = new Date();
	
	private double subTotal;
	private double total;
	private double totalTax;
	
	private double amount;
	private double countryTax;
	private double stateTax;
	private double countyTax;
	private double cityTax;
	private double districtTax;
	private double miscTax;

	private List<LineItemTaxes> lineItemTaxes = new ArrayList<>();
	private LineItemTaxes shippingTaxes;

}
