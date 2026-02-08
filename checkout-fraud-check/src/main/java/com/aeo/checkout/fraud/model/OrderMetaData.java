package com.aeo.checkout.fraud.model;

import lombok.Data;

@Data
public class OrderMetaData {
	
	private String userType;
	private boolean isVGCOrder;
	private boolean isBopisOrder;
	private boolean hasPLCCPayment;
	
	public boolean isUserOrder() {
		return "registered".equals(this.getUserType());
	}
	
	public boolean isGuestOrder() {
		return "guest".equals(this.getUserType());
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("userType").append("=").append(this.getUserType()).append(", ");
		sb.append("isVGCOrder").append("=").append(this.isVGCOrder()).append(", ");
		sb.append("isBopisOrder").append("=").append(this.isBopisOrder()).append(", ");
		sb.append("hasPLCCPayment").append("=").append(this.isHasPLCCPayment());
		return sb.toString();
	}

}
