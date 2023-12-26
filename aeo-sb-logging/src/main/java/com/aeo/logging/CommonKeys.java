package com.aeo.logging;

public enum CommonKeys {
	ORDER_ID,
	ORDER_NUMBER,
	COMMERCE_ITEM_ID,
	COMMERCE_ITEMS,
	LOYALTY_ID,
	PROFILE_ID,
	USER,
	USER_EMAIL,
	TLTUID,
	SESSION_ID,
	STATE,
	PAYMENT_GROUP_ID,
	STATUS;

	private String key;

	private CommonKeys() {
		this.key = this.name().toLowerCase();
	}

	private CommonKeys(String overrideName) {
		this.key = overrideName;
	}

	public String key() {
		return this.key;
	}

}
