package com.aeo.checkout.tax.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class LineItemTaxes {
	
	private String lineItemId;
	
	private double amount;
	private double countryTax;
	private double stateTax;
	private double countyTax;
	private double cityTax;
	private double districtTax;
	private double miscTax;
	
	private double countryTaxRate;
	private double stateTaxRate;
	private double countyTaxRate;
	private double cityTaxRate;
	private double districtTaxRate;
	private double miscTaxRate;
	
	private String countryTaxType;
	private String stateTaxType;
	private String state;

}
