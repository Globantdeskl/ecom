package com.aeo.checkout.tax.service.exception;

public class VertexException extends Exception {

	private static final long serialVersionUID = 2093450600784401195L;
	
	public VertexException(Exception e) {
		super(e.getMessage(), e);
	}
	
	public VertexException(String message) {
		super(message);
	}
	
	public VertexException(String message, Exception e) {
		super(message, e);
	}

}
