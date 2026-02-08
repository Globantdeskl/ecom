package com.aeo.checkout.submitorder.model.atg;

import java.util.List;

import lombok.Data;

@Data
public class ATGResponseErrors {
	
	private List<ATGResponseError> errors;
	private int status;

}
