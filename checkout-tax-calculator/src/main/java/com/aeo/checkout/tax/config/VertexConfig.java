package com.aeo.checkout.tax.config;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "vertex")
@PropertySource("classpath:application.yml")
@Data
public class VertexConfig {
	
	public static final String COMPANY_NAME = "AEHoldings";
	public static final String DEFAULT_DIVISION = "AED";
	public static final String US_DIVISION = "AED";
	public static final String CA_DIVISION = "AEDCND";
	public static final String SHIPPING_TAX_CODE = "40000";
	public static final String SHIPPING_PRD_NAME = "Freight";
	
	public enum CalculableCountryCode {
		US,
		CA,
		APO; //handle calling US for military base APO/FPO/DPO
	}
	
	private String serviceEndpoint;
	private String wsdlLocation;
	private String userName;
	private String password;
	private int timeout;
	
	@Bean
    public DatatypeFactory datatypeFactory() throws DatatypeConfigurationException {
    	return DatatypeFactory.newInstance();
    }

}
