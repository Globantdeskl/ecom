package com.aeo.logging;

public enum RequestProperty {
	RESPONSE_TIME(true),
	REMOTE_HOST(true),
	REMOTE_IP(true),
	REMOTE_PORT(true),
	HTTP_METHOD(true),
	HTTP_ENDPOINT(true),
	HTTP_QUERY(true),
	HTTP_REFERER(true),
	STATUS_CODE(true),
	TRACE_ID(false),
	SPAN_ID(false),
	PARENT_SPAN_ID(false),
	APP_HOST(false),
	APP_IP(false),
	APP_PORT(false);
	
	private final boolean remove;
	private RequestProperty(boolean remove) {
		this.remove = remove;
	}
	
	public boolean remove() {
		return this.remove;
	}
	
	public String key() {
		return this.name().toLowerCase();
	}
 
}
