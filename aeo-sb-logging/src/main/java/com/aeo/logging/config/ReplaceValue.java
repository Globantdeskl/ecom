package com.aeo.logging.config;

import com.aeo.logging.EnvProperty;

import lombok.Data;

@Data
public class ReplaceValue {
	
	private EnvProperty key;
	private String value;

}
