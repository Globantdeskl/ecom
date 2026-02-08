package com.aeo.checkout.submitorder.model.atg;

import com.aeo.postcheckout.model.order.ATGOrder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Map;

@Data
public class ATGResponse {
	
	private Map<String,Object> diagnostics;
	private ATGOrder message;
	private ATGResponseError error;
	
	@JsonIgnore
	public boolean hasOrder() {
		return this.message != null
				&& this.message.getHeader() != null
				&& this.message.getHeader().getMessageId() != null;
	}
	
	@JsonIgnore
	public boolean hasError() {
		return this.error != null
				&& this.error.getKey() != null;
	}
	
	@JsonIgnore
	public ATGOrder fetchOrder() {
		return this.message == null ? new ATGOrder() : this.message;
	}
}
