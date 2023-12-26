package com.aeo.checkout.submitorder.model.atg;

import java.util.List;

import lombok.Data;

@Data
public class ATGResponseError {
	
	private String key;
	private List<String> fields;

}
