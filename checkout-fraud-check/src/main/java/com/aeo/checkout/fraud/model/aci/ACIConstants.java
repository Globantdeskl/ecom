package com.aeo.checkout.fraud.model.aci;

/**
 * 
 * ACI Constants
 * 
 */
public class ACIConstants {	

	public static final String MOCK = "MOCK";
	
	public static final String FRAUD_SUSPECT = "fraud_suspect";
	public static final String FRAUD_PENDING = "fraud_pending";
	public static final String FRAUD_DENY = "fraud_deny";
	
	// status codes
	public static final String STATUS_CODE_NO_RESPONSE_FROM_SERVER = "ENORSP";
	public static final String STATUS_CODE_UNABLE_TO_CONNECT_TO_SERVER = "ENETLP";
	public static final String STATUS_CODE_PENDING = "PENDING";
	public static final String STATUS_CODE_SUSPEND = "SUSPEND";
	public static final String STATUS_CODE_SUCCESS = "SUCCESS";
	
	// fraud check status codes
	public static final String FRAUD_STATUS_CODE_ACCEPT = "ACCEPT";
	public static final String FRAUD_STATUS_CODE_DENY = "DENY";
	public static final String FRAUD_STATUS_CODE_CHALLENGE = "CHALLENGE";
	public static final String FRAUD_STATUS_CODE_SIMULATED_TIMEOUT = "SIM_TO";

	// token status codes
	public static final String TOKEN_STATUS_CODE_ACTIVE = "ACTIVE";
	public static final String TOKEN_STATUS_CODE_REVOKED = "REVOKED";
	public static final String TOKEN_STATUS_CODE_EXPIRED = "EXPIRED";
	
	// request types
	public static final String REQUEST_TYPE_ECOMMERCE = "E";
	public static final String REQUEST_TYPE_TELEPHONE = "T";
	
	// instance types for EBT_USER_DATA14
	public static final String INSTANCE_TYPE_CAP = "CAP";
	public static final String INSTANCE_TYPE_CSR = "CSR";
	public static final String INSTANCE_TYPE_FRAUD_CHECK_APP = "CFC";

	// general constants
	public static final String YES = "Y";
	public static final String NO = "N";

	// billing constants
	public static final String BILLING_DETAILS_PRESENT = "B";
	public static final String UNKNOWN_CARD_TYPE_MOP_CODE = "??";
	
	public static final String AJB_AUTH_DECLINED_MESSAGE = "error.common.creditCard.declined";
	public static final String AJB_AUTH_REFERRAL_MESSAGE = "error.common.creditCard.referral";
	
	public static final String AJB_CVV_PROVIDER_NO_RESPONSE = "X";
	
	public static final String ALT_PMT_TYPE_PRIVATE_LABEL_CARD = "PRIVATE LABEL";
	public static final String ALT_PMT_TYPE_PAYPAL = "PAYPAL";
	public static final String ALT_PMT_TYPE_GIFT_CARD = "GIFT_CARD";
	
	
	// shipping constants
	public static final String SHIPPING_DETAILS_PRESENT = "S";
	// default shipping code: O (other)
	public static final String DEFAULT_SHIPPING_CODE = "O";

	// order type constants
	public static final String DIGITAL_N_PHYSICAL_GOODS = "DNP";
	public static final String DIGITAL_GOODS = "DIG";
	public static final String PHYSICAL_GOODS = "PHY";

	public static final String[] REQUIRED_REQUEST_FIELDS = {
			LPTransactionProperty.ORD_DTM.name(),
			LPTransactionProperty.AMT.name(),
			LPTransactionProperty.REQ_TYPE_CD.name(),
			LPTransactionProperty.MOP_TYPE_CD.name(),
			LPTransactionProperty.CURR_CD.name(),
			LPTransactionProperty.ORD_ID.name(),
			LPTransactionProperty.ACT_CD.name(),
			LPTransactionProperty.DIV_NUM.name(),
			LPTransactionProperty.EBT_Service.name(),
			LPTransactionProperty.EBT_Name.name(),
			// not required: token_id could be passed instead
			//  LPTransactionProperty.ACCT_NUM.name(),
			LPTransactionProperty.S_KEY_ID.name(),
			LPTransactionProperty.CARD_EXP_DT.name(),
			LPTransactionProperty.RSP_CD.name(),
			LPTransactionProperty.RSP_AVS_CD.name(),
			LPTransactionProperty.RSP_SEC_CD.name()
	};
	
	public static final String[] ITEM_REQUEST_FIELDS = {
			LPTransactionProperty.ITEM_QTY.name(),
			LPTransactionProperty.ITEM_COMM_CD.name(),
			LPTransactionProperty.ITEM_DESC.name(),
			LPTransactionProperty.ITEM_CST_AMT.name(),
			LPTransactionProperty.ITEM_AMT.name(),
			LPTransactionProperty.ITEM_GIFT_MSG.name(),
			LPTransactionProperty.ITEM_MAN_PART_NO.name(),
			LPTransactionProperty.ITEM_PROD_CD.name(),
			LPTransactionProperty.ITEM_SHIP_NO.name()
	};
	
	// Action codes for ACT_CD field
	public enum ActionCode {
		FRAUD_CHECK_ONLY("OA"),
		REVERSAL("OX"),
		ONLINE_REFUND("OR"),
		GET_TOKEN("GT");

		String code;
		ActionCode(String value) {
			code = value;
		}
		public String code() {
			return code;
		}
	}

	public enum AuthResponseCode {
		APPROVE("00"),
		DECLINE("05"),
		ERROR("96"); 

		String code;
		AuthResponseCode(String value) {
			code = value;
		}
		public String code() {
			return code;
		}
	}
	
	public enum EBTServiceCode {
		CC_AUTH_NO_DEVICE("N"),
		CC_AUTH_DEVICE("I"),
		NO_SCORE_NO_DEVICE("A"),
		NO_SCORE_DEVICE("O"),
		ALT_PAYMENT_NO_DEVICE("U"),
		ALT_PAYMENT_DEVICE("X");

		String code;
		private EBTServiceCode(String value) {
			code = value;
		}
		public String code() {
			return code;
		}
	}
	
	public enum CINResponse {
		CIN_MATCH("M"),
		CIN_NOMATCH("N"),
		CIN_NOT_PROCESSED("P"),
		CIN_MISSING_ON_CARD("S"),
		CIN_ISSUER_NOT_CERTIFIED("U");
		
		String code;
		CINResponse(String value) {
			code = value;
		}
		public String code() {
			return code;
		}
	}
	
	/**
	A - Address matches, Postal/Zip code does not match or is missing in request
	B - Address matches, Postal/Zip code not matched due to format incompatibility
	C - Address and Postal/Zip code not matched due to format incompatibility
	D - Address and Postal code match
	E - Amex: Card Member Name incorrect, Billing Address and Postal Code match.
	F - Address and Postal code match for U.K. only
	G - International Issuer Address information not verified
	H - Card member name does not match. Street address and postal code match.
	I - Address information not verified
	K - Amex: Card Member Name matches.
	L - Amex: Card Member Name and Billing Postal Code match.
	M - Address and Postal code match
	N - Street address and postal code do not match.
	O - Amex: Card Member Name and Billing Address match.
	P - Postal/Zip code Match. Acquirer sent Postal/Zip code and address, but address not verified due to incompatible formats
	R - System unavailable.
	S- Bank does not support AVS.
	U - Address not verified. Information is unavailable or Issuer does not participate
	V - Card member's name, billing address, and billing postal code match
	W - Street address and 9-digit postal code match.
	X - Street address and 9-digit postal code match.
	Y - Five-digit Zip and address match
	Z - Five-digit Zip code matches, address does not match
	*/
	public enum AVSResponse {
		AVS_ADD("A"),
		AVS_ADD_NO_ZIP("B"),
		AVS_NO_ADD_NO_ZIP("C"),
		AVS_ADD_ZIP("D"),
		AVS_AMEX_ADD_NO_NAME("E"),
		AVS_UK_ADD("F"),
		AVS_GLOBAL("G"),
		AVS_ADD_ZIP_NO_NAME("H"),
		AVS_NO_ADD("I"),
		AVS_AMEX_NAME("K"),
		AVS_AMEX_NAME_ZIP("L"),
		AVS_ADD_POST("M"),
		AVS_NO_ADD_NO_POST("N"),
		AVS_AMEX_NAME_ADD("O"),
		AVS_ZIP_NO_ADD("P"),
		AVS_SYS_UNAVAIL("R"),
		AVS_NOT_SUPPORTED("S"),
		AVS_NO_DATA("U"),
		AVS_NAME_ADD_POST("V"),
		AVS_ADD_ZIP_NINE("W"),
		AVS_EXACT("X"),
		AVS_ADD_ZIP_FIVE("Y"),
		AVS_NO_ADD_ZIP_FIVE("Z");
	
		String code;
		AVSResponse(String value) {
			code = value;
		}
		public String code() {
			return code;
		}
	}

	public enum MethodOfPaymentType {
		UNKNOWN("??"),
		AMERICAN_EXPRESS("AX"),
		CARTE_BLANCHE("CB"),
		DISCOVER("DI"),
		DINERS_CLUB("DC"),
		JCB("JC"),
		PRIVATE_LABEL("PC"),
		MASTERCARD("MC"),
		VISA("VI"),
		CUSTOMER_ACCOUNT("CA"),
		PAYPAL("PL"),
		GIFT_CARD("GC"),
		CHEQUE("CA"),
		TOKEN("TK");

		String code;
		MethodOfPaymentType(String value) {
			code = value;
		}
		public String code() {
			return code;
		}
	}

	//BOPIS constants
	public static final String PICKUP_TODAY = "PICKUP TODAY";
	public static final String SHIP_TO_STORE = "SHIP TO STORE";
	
}