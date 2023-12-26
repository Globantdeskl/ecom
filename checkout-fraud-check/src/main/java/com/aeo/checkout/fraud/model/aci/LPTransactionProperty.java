package com.aeo.checkout.fraud.model.aci;

import java.util.ArrayList;
import java.util.List;

public enum LPTransactionProperty {

	EBT_WRAPPED(LPTransactionPropertyType.REQUEST, "Gift Wrapping", 1),
	OI_REPEAT(LPTransactionPropertyType.REQUEST, "Order Item Repeat", 2),
	RSP_DT(LPTransactionPropertyType.REQUEST, "Response Date"),
	CARD_SEC_CD(LPTransactionPropertyType.REQUEST, "Card Security Code"),
	CUST_LNAME(LPTransactionPropertyType.REQUEST, "Customer Last Name", 30),
	ITEM_DESC(LPTransactionPropertyType.REQUEST, "Product Description", 127),
	USER_ID(LPTransactionPropertyType.REQUEST, "User ID"),
	CUST_WORK_PHONE(LPTransactionPropertyType.REQUEST, "Customer Work Phone", 19),
	FRAUD_RSP_DESC(LPTransactionPropertyType.RESPONSE, "Fraud Response Description"),
	CUST_CNTRY_CD(LPTransactionPropertyType.REQUEST, "Customer Country", 3),
	CUST_EMAIL(LPTransactionPropertyType.REQUEST, "Customer Email ID", 60),
	SHIP_MNAME(LPTransactionPropertyType.REQUEST, "Ship To Middle Name", 1),
	RSP_AUTH_NUM(LPTransactionPropertyType.REQUEST, "Auth Code"),
	ORD_ID(LPTransactionPropertyType.BOTH, "Order ID", 22, false),
	RSP_SEC_CD(LPTransactionPropertyType.REQUEST, "Security Code", 1),
	RSP_TM(LPTransactionPropertyType.REQUEST, "Response Time"),
	ITEM_SHIP_NO(LPTransactionPropertyType.REQUEST, "Tracking Number", 19),
	DIV_NUM(LPTransactionPropertyType.REQUEST, "ReD1 Division Number", 16),
	CUST_ADDR1(LPTransactionPropertyType.REQUEST, "Customer Address Line1", 30),
	EBT_TOF(LPTransactionPropertyType.REQUEST, "Account Age", 7, "1"),
	CUST_ADDR2(LPTransactionPropertyType.REQUEST, "Customer Address Line2", 30),
	SHIP_TYPE_CD(LPTransactionPropertyType.REQUEST, "Ship Type Code", 1),
	SHIP_MTHD_CD(LPTransactionPropertyType.REQUEST, "Shipping Method", 1),
	CARD_EXP_DT(LPTransactionPropertyType.REQUEST, "Expiration Date", 4),
	SHIP_CNTRY_CD(LPTransactionPropertyType.REQUEST, "Ship To Country", 3),
	ITEM_MAN_PART_NO(LPTransactionPropertyType.REQUEST, "Manufacture Part Number", 30),
	PROD_DEL_CD(LPTransactionPropertyType.REQUEST, "Product Delivery Code", 3),
	EBT_Name(LPTransactionPropertyType.REQUEST, "ReDShield Client ID", 40),
	CURR_BAL_AMT(LPTransactionPropertyType.REQUEST, "Current Balance"),
	HOST_ID(LPTransactionPropertyType.RESPONSE, "Host ID"),
	SHIP_FNAME(LPTransactionPropertyType.REQUEST, "Ship To Firstname", 30),
	FRT_AMT(LPTransactionPropertyType.REQUEST, "Freight Amount", 12),
	ITEM_COMM_CD(LPTransactionPropertyType.REQUEST, "Unique Product SKU", 12, false),
	CARD_SEC_IND_CD(LPTransactionPropertyType.REQUEST, "Card Security Indicator Code", 1, "0"),
	ITEM_GIFT_MSG(LPTransactionPropertyType.REQUEST, "Item Gift Message", 160),
	S_ACCT_NUM(LPTransactionPropertyType.REQUEST, "Encrypted Card Number"),
	MOP_TYPE_CD(LPTransactionPropertyType.REQUEST, "Card Type", 2),
	CUST_POSTAL_CD(LPTransactionPropertyType.REQUEST, "Customer Postal Code", 10),
	CURR_CD(LPTransactionPropertyType.REQUEST, "Currency Code", 3),
	TOKEN_STAT_CD(LPTransactionPropertyType.RESPONSE, "Token Status Code"),
	CUST_FNAME(LPTransactionPropertyType.REQUEST, "Customer First Name", 30),
	CUST_ID(LPTransactionPropertyType.REQUEST, "Customer ID", 16, false),
	ITEM_QTY(LPTransactionPropertyType.REQUEST, "Quantity of Each Unique Item", 12),
	SHIP_CITY(LPTransactionPropertyType.REQUEST, "Ship To City", 20),
	EBT_DEVICEPRINT(LPTransactionPropertyType.REQUEST, "PC Finger Print", 4000),
	EBT_USER_DATA1(LPTransactionPropertyType.REQUEST, "Concatenated Billing Info", 256),
	ACT_CD(LPTransactionPropertyType.REQUEST, "Action Code", 2),
	EBT_USER_DATA5(LPTransactionPropertyType.REQUEST, "Total Discount Amount", 256),
	EBT_USER_DATA4(LPTransactionPropertyType.REQUEST, "Paypal Email Address", 256),
	EBT_USER_DATA3(LPTransactionPropertyType.REQUEST, "Paypal Payment and Address Status", 256),
	EBT_USER_DATA2(LPTransactionPropertyType.REQUEST, "Currency Code", 256),
	CUST_MNAME(LPTransactionPropertyType.REQUEST, "Customer Middle Name", 30),
	ebCARRIER(LPTransactionPropertyType.REQUEST, "Shipment Carrier", 1),
	FRAUD_STAT_CD(LPTransactionPropertyType.BOTH, "Fraud Status Code"),
	ITEM_AMT(LPTransactionPropertyType.REQUEST, "Item Price Amount", 12),
	EBT_USER_DATA11(LPTransactionPropertyType.REQUEST, "Number Line Items", 30),
	EBT_USER_DATA12(LPTransactionPropertyType.REQUEST, "eGC Recipient Email", 30),
	EBT_USER_DATA10(LPTransactionPropertyType.REQUEST, "Loyalty Number", 30),
	EBT_USER_DATA15(LPTransactionPropertyType.REQUEST, "Loyalty Customer", 30),
	SHIP_ADDR2(LPTransactionPropertyType.REQUEST, "Ship To Address Line2", 30),
	EBT_USER_DATA16(LPTransactionPropertyType.REQUEST, "Order Gift Receipt", 30),
	SHIP_ADDR1(LPTransactionPropertyType.REQUEST, "Ship To Address Line1", 30),
	EBT_USER_DATA13(LPTransactionPropertyType.REQUEST, "eGC Recipient Name", 30),
	TOKEN_ID(LPTransactionPropertyType.BOTH, "Token ID", 64),
	EBT_SHIPNO(LPTransactionPropertyType.REQUEST, "Shipping ID", 19, false),
	ebGIFTMESSAGE(LPTransactionPropertyType.REQUEST, "Gift Message", 160),
	EBT_USER_DATA14(LPTransactionPropertyType.REQUEST, "Order Placed Instance Type", 30),
	STAT_CD(LPTransactionPropertyType.RESPONSE, "Status Code"),
	FRAUD_NEURAL(LPTransactionPropertyType.RESPONSE, "Fraud Score"),
	EBT_USER_DATA17(LPTransactionPropertyType.REQUEST, "3DS ECI Response Code", 30),
	SHIP_STPR_CD(LPTransactionPropertyType.REQUEST, "Ship To State/Province Code", 2),
	TOKEN_EXP_DT(LPTransactionPropertyType.RESPONSE, "Token Expiration Date"),
	REQ_ID(LPTransactionPropertyType.BOTH, "Transaction ID"),
	SHIP_POSTAL_CD(LPTransactionPropertyType.REQUEST, "Ship To Postal Code", 10),
	RSP_MSG(LPTransactionPropertyType.REQUEST, "Message"),
	FRAUD_USE_CD(LPTransactionPropertyType.BOTH, "Fraud Used Code"),
	SHIP_HOME_PHONE(LPTransactionPropertyType.REQUEST, "Ship To Home Phone", 19),
	AMT(LPTransactionPropertyType.REQUEST, "Authorization Amount", 12),
	CUST_TYPE_CD(LPTransactionPropertyType.REQUEST, "Customer Type Code", 1),
	CUST_HOME_PHONE(LPTransactionPropertyType.REQUEST, "Customer Home Phone", 19),
	SHIP_LNAME(LPTransactionPropertyType.REQUEST, "Ship To Last Name", 30),
	PROC_CD(LPTransactionPropertyType.RESPONSE, "PROC_CD"),
	ACCT_NUM(LPTransactionPropertyType.REQUEST, "Card Number", 19),
	ORD_TZ(LPTransactionPropertyType.REQUEST, "Order Timezone", 3),
	EBT_USER_DATA25(LPTransactionPropertyType.REQUEST, "NOT USED", 30),
	EBT_Service(LPTransactionPropertyType.REQUEST, "ReDShield Service Code", 1),
	RSP_AVS_CD(LPTransactionPropertyType.REQUEST, "AVS Code", 1),
	ebWEBSITE(LPTransactionPropertyType.REQUEST, "Website", 60),
	CUST_BIRTH_DT(LPTransactionPropertyType.REQUEST, "Customer Birth Date", 10),
	CUST_CITY(LPTransactionPropertyType.REQUEST, "Customer City", 20),
	RSP_CD(LPTransactionPropertyType.REQUEST, "Response Code", 2),
	CUST_IP_ADDR(LPTransactionPropertyType.REQUEST, "Customer IP Address", 45),
	CUST_STPR_CD(LPTransactionPropertyType.REQUEST, "Customer State", 2),
	ORD_DTM(LPTransactionPropertyType.REQUEST, "Order Date and Time", 19),
	FRAUD_RSP_CD(LPTransactionPropertyType.RESPONSE, "Fraud Response Code"),
	ITEM_PROD_CD(LPTransactionPropertyType.REQUEST, "Item Product Code", 12, false),
	EBT_PREVCUST(LPTransactionPropertyType.REQUEST, "Previous Customer", 1),
	SLS_TAX_AMT(LPTransactionPropertyType.REQUEST, "Sales Tax Amount", 12),
	S_KEY_ID(LPTransactionPropertyType.REQUEST, "SSL Key ID", 6),
	ebSHIPCOMMENTS(LPTransactionPropertyType.REQUEST, "Shipping Comments", 160),
	FRAUD_REC_ID(LPTransactionPropertyType.RESPONSE, "Fraud Record ID"),
	EBT_USER_DATA9(LPTransactionPropertyType.REQUEST, "Applied Coupon Codes", 256, ""),
	EBT_USER_DATA8(LPTransactionPropertyType.REQUEST, "Alternate Payment Type", 256),
	EBT_USER_DATA7(LPTransactionPropertyType.REQUEST, "Split Payment Account Number", 256),
	REQ_TYPE_CD(LPTransactionPropertyType.REQUEST, "Payment Method", 1),
	ITEM_CST_AMT(LPTransactionPropertyType.REQUEST, "Unit Price of Item", 10),
	EBT_USER_DATA6(LPTransactionPropertyType.REQUEST, "Split Payment Value", 256),
	PREV_BAL_AMT(LPTransactionPropertyType.REQUEST, "Previous Balance"),
	FRAUD_RCF(LPTransactionPropertyType.RESPONSE, "Fraud Rule Flag"),
	SHIP_EMAIL(LPTransactionPropertyType.REQUEST, "Ship To Email", 60),
	S_CARD_EXP_DT(LPTransactionPropertyType.REQUEST, "Encrypted Expiration Date"),
	EBT_USER_DATA18(LPTransactionPropertyType.REQUEST, "Total Nubmer of Coupon Codes", 30, "0"),
	EBT_USER_DATA19(LPTransactionPropertyType.REQUEST, "Sizes", 30),
	EBT_USER_DATA20(LPTransactionPropertyType.REQUEST, "Origin of Order", 30),
	EBT_USER_DATA21(LPTransactionPropertyType.REQUEST, "Gift Card Message", 30),
	EBT_USER_DATA22(LPTransactionPropertyType.REQUEST, "Bopis Expedited Flag", 1),
	EBT_USER_DATA23(LPTransactionPropertyType.REQUEST, "Resubmit Order Flag", 1);
	
			
	private LPTransactionPropertyType type;
	private String description;
	private boolean hasMax;
	private int max;
	private boolean preferFirst;
	private String defaultValue;

	public static List<LPTransactionProperty> requestProperties = new ArrayList<>();
	public static List<LPTransactionProperty> responseProperties = new ArrayList<>();

	static {
		for (LPTransactionProperty prop : LPTransactionProperty.values()) {

			if (prop.getType() == LPTransactionPropertyType.REQUEST
					|| prop.getType() == LPTransactionPropertyType.BOTH) {
				requestProperties.add(prop);
			}
		}
		for (LPTransactionProperty prop : LPTransactionProperty.values()) {
			if (prop.getType() == LPTransactionPropertyType.RESPONSE
					|| prop.getType() == LPTransactionPropertyType.BOTH) {
				responseProperties.add(prop);
			}
		}
	}

	private LPTransactionProperty(LPTransactionPropertyType type, String description) {
		this.type = type;
		this.description = description;
		this.hasMax = false;
		this.preferFirst = true;
		this.defaultValue = null;
	}
	
	private LPTransactionProperty(LPTransactionPropertyType type, String description, int max) {
		this(type, description, max, true);
	}
	
	private LPTransactionProperty(LPTransactionPropertyType type, String description, int max, boolean preferFirst) {
		this(type, description, max, preferFirst, null);
	}
	
	private LPTransactionProperty(LPTransactionPropertyType type, String description, int max, String defaultValue) {
		this(type, description, max, true, defaultValue);
	}
	
	private LPTransactionProperty(LPTransactionPropertyType type, String description, int max, boolean preferFirst, String defaultValue) {
		this.type = type;
		this.description = description;
		this.max = max;
		this.hasMax = true;
		this.preferFirst = preferFirst;
		this.defaultValue = defaultValue;
	}

	public LPTransactionPropertyType getType() {
		return this.type;
	}
	
	public String getDescription() {
		return this.description;
	}

	public boolean hasMax() {
		return hasMax;
	}

	public int getMax() {
		return max;
	}

	public boolean isPreferFirst() {
		return preferFirst;
	}
	
	public String defaultValue() {
		return defaultValue;
	}

	@Override
	public String toString() {
		return name() + "(" + getDescription() + ")";
	}
}

