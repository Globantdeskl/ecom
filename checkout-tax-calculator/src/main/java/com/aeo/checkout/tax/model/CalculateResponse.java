package com.aeo.checkout.tax.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CalculateResponse {
	
	private String orderId;
	private String errorMessage;
	private OrderTaxes orderTaxes;
	
}
