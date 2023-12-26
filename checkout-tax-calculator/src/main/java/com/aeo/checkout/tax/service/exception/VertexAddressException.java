package com.aeo.checkout.tax.service.exception;

public class VertexAddressException extends Exception {

	private static final long serialVersionUID = -6776410051772990413L;
	public static final String BAD_ADDRESS_MSG = "No tax areas were found during the lookup";
	
	public VertexAddressException(String message) {
		super(message);
	}

}
