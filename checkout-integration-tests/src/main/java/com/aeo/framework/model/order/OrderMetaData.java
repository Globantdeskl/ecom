package com.aeo.framework.model.order;

import lombok.Data;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class OrderMetaData {
	
	private String orderType;
	private String carrierCode;
	private String paymentTypes;
	private String itemTypes;
	private String orderClassType;
	private String paymentMethod;
	private String userType;
	private boolean hasFRL;
	private boolean hasLoyaltyCoupon;
	private boolean hasCharityItems;
	private boolean isSplitPayment;
	private boolean hasLoyaltyId;
	private boolean hasCustomizedItems;
	private boolean isVGCOrder;
	private boolean isBopisOrder;
	private boolean hasPLCCPayment;
	private boolean isEdited;
	
	public boolean isUserOrder() {
		return "registered".equals(this.getUserType());
	}
	
	public boolean isGuestOrder() {
		return "guest".equals(this.getUserType());
	}
	
	public boolean isHasPhysicalGiftCards() {
		return this.getItemTypes().contains("PGC");
	}
	
	public boolean isHasVirtualGiftCards() {
		return this.getItemTypes().contains("VGC");
	}
	
	public boolean isHasRegularItems() {
		return this.getItemTypes().contains("REG");
	}
	
	private Object getFieldValue(Field f) {
		try {
			return f.get(this);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			if(Boolean.TYPE.getName().equalsIgnoreCase(f.getType().getName())) {
				return false;
			}
			return "null";
		}
	}

}
