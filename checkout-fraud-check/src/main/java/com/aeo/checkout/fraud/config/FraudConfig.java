package com.aeo.checkout.fraud.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.aeo.checkout.fraud.service.tools.FraudRequestDataPopulator;
import com.aeo.checkout.fraud.service.tools.RequestAddressDataPopulator;
import com.aeo.checkout.fraud.service.tools.RequestItemDataPopulator;
import com.aeo.checkout.fraud.service.tools.RequestOrderDataPopulator;
import com.aeo.checkout.fraud.service.tools.RequestPaymentDataPopulator;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "aci-client")
@PropertySource("classpath:application.yml")
public class FraudConfig {
	
	private String divisionNumber;
	private String clientId;
	private String sslKeyId;
	private String configPath;
	
	private FraudRequestDataPopulator[] requestDataPopulators = {
			new RequestOrderDataPopulator(),
			new RequestPaymentDataPopulator(),
			new RequestAddressDataPopulator(),
			new RequestItemDataPopulator()
	};
	
	/*
	 * mapping of order.originOfOrder to ACI request type REQ_TYPE_CD, not all originOfOrder values are used in UGP
	 * E = eCommerce, T = telephone
	 */
	public enum RequestTypeToOriginOfOrder {
		E("scheduledOrder", "WEB", "MOBILE_WEB", "STORE", "IOS_APP", "ANDROID_APP", "TABLET"),
		T("contactCenter", "CSC");
		
		private Set<String> origins;
		private RequestTypeToOriginOfOrder(String... orderOrigins) {
			this.origins = new HashSet<String>(Arrays.asList(orderOrigins));
		}
		
		public Set<String> origins() {
			return this.origins;
		}
	}
	
	/*
	 * mapping of site ID to client ID (EBT_Name)
	 */
	public enum SiteToClientId {
		AEO_US("US", "000450030001", "000450040031"),
		AEO_CA("CA", "000450030004", "000450040034"),
		AEO_MX("MX", "000450030003", "000450040033"),
		AEO_INTL("", "000450030002", "000450040032");
		
		private String countryCode;
		private String clientId;
		private String bopisClientId;
		private SiteToClientId(String countryCode, String clientId, String bopisId) {
			this.countryCode = countryCode;
			this.clientId = clientId;
			this.bopisClientId = bopisId;
		}
		
		public String country() {
			return this.countryCode;
		}
		
		public String clientId() {
			return this.clientId;
		}
		
		public String bopisClientId() {
			return this.bopisClientId;
		}
	}
	
	/*
	 * shipping methods to ACI shipping method codes
	 * C=Lowest Cost, N=Next Day, T=Two Day, W=Three Day, O=Other
	 */
	public enum ShippingMethodCode {
		SM_STD("STD", "C"),
		SM_ONT("ONT", "N"),
		SM_2DY("2DY", "T"),
		SM_SHR("SHR", "O"),
		SM_EXP("EXP", "W"),
		SM_SDD("SDD", "D"),
		SM_DEFAULT("", "O");
		
		private String method;
		private String code;
		private ShippingMethodCode(String method, String code) {
			this.method = method;
			this.code = code;
		}
		
		public String method() {
			return this.method;
		}
		
		public String code() {
			return this.code;
		}
	}
	
	public enum ACIResponseCode {
		FRAUD_CHECKED("PENDING","APPROVE","DECLINE","DEPOSIT","CANCEL","REVERSE","REJECT","SUSPEND"),
		ERROR_CONNECTION("ENORSP","ENETLP","ETMOUT","ENETFP","ENETPP","ENETRED","ECHWRTA","ECHWRTB","ECHWRTC","EDBCON","EDBDUP","EDBEXC","EITMOUT"),
		ERROR_CARD_NUMBER("EIVCCN","EIVCCT","EIVBIN"),
		ERROR_FIELD_INVALID("");
		
		Set<String> statusCodes;
		private ACIResponseCode(String... statusCodes) {
			this.statusCodes = new HashSet<String>(Arrays.asList(statusCodes));
		}
		
		public Set<String> statusCodes() {
			return this.statusCodes;
		}
	}
}
