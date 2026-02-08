package com.aeo.checkout.tax.model;

public enum TaxCode {
	GIFT_CARDS("61900"),
	DEFAULT_TAXABLE("89998"),
	DEFAULT_NON_TAXABLE("89999");
	
	private String code;
	TaxCode(String code) {
		this.code = code;
	}
	
	public String code() {
		return this.code;
	}
}