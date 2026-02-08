package com.aeo.checkout.fraud.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import com.aeo.checkout.fraud.config.FraudConfig;
import com.aeo.checkout.fraud.config.FraudConfig.SiteToClientId;
import com.aeo.checkout.fraud.model.FraudRequest;
import com.aeo.checkout.fraud.model.FraudTokenRequest;
import com.aeo.checkout.fraud.model.aci.ACIConstants;
import com.aeo.checkout.fraud.model.aci.ACIException;
import com.aeo.checkout.fraud.model.aci.LPTransactionProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


public class RequestTransformerTest {
	
	private RequestTransformer requestTransformer;
	
	@BeforeEach
	void setup() throws ACIException {
		MockitoAnnotations.initMocks(this);
		FraudConfig config = new FraudConfig();
		config.setClientId("000450030001");
		config.setDivisionNumber("ae_ugp_rs");
		config.setSslKeyId("20171");
		requestTransformer = new RequestTransformer(config);
	}
	
	@Test
	void createTokenRequest() throws ACIException {
		assertFalse(requestTransformer.createTokenRequest(null).isPresent());
		assertTrue(requestTransformer.createTokenRequest(mockTokenRequest()).isPresent());
		
		FraudTokenRequest request = mockTokenRequest();
		request.setOrderId(null);
		assertTrue(requestTransformer.createTokenRequest(request).isPresent());
		
		RequestTransformer missingRequiredFields = new RequestTransformer(new FraudConfig());
		assertTrue(missingRequiredFields.createTokenRequest(mockTokenRequest()).isPresent());
	}
	
	@Test
	void createQuotationRequest() throws ACIException {
		assertFalse(requestTransformer.createQuotationRequest(null).isPresent());
		assertTrue(requestTransformer.createQuotationRequest(mockCCRequest()).isPresent());
		assertTrue(requestTransformer.createQuotationRequest(mockSplitPayRequest()).isPresent());
		assertTrue(requestTransformer.createQuotationRequest(mockDWRequest()).isPresent());
		assertTrue(requestTransformer.createQuotationRequest(mockPPRequest()).isPresent());
		
		FraudRequest defaultFields = mockCCRequest();
		defaultFields.getCustomerOrder().setChannel("mock");
		defaultFields.getCustomerShippingDetail().getAddress().setCountryCode("XX");
		assertEquals(ACIConstants.REQUEST_TYPE_ECOMMERCE, requestTransformer.createQuotationRequest(defaultFields)
				.get().getField(LPTransactionProperty.REQ_TYPE_CD.name()));
		assertEquals(SiteToClientId.AEO_INTL.clientId(), requestTransformer.createQuotationRequest(defaultFields)
				.get().getField(LPTransactionProperty.EBT_Name.name()));
		
		FraudRequest bopis = mockCCRequest();
		bopis.getOrderMetaData().setBopisOrder(true);
		assertEquals(SiteToClientId.AEO_US.bopisClientId(), requestTransformer.createQuotationRequest(bopis)
				.get().getField(LPTransactionProperty.EBT_Name.name()));
		
		FraudRequest ccWithNoToken = mockCCRequest();
		ccWithNoToken.getPaymentMethods().get(0).getCreditDebitTender().setFraudToken(null);
		assertThrows(ACIException.class, () -> requestTransformer.createQuotationRequest(ccWithNoToken));
		
		RequestTransformer missingRequiredFields = new RequestTransformer(new FraudConfig());
		assertTrue(missingRequiredFields.createQuotationRequest(mockCCRequest()).isPresent());
	}
	
	private FraudTokenRequest mockTokenRequest() {
		FraudTokenRequest tokenReq = new FraudTokenRequest();
		tokenReq.setOrderId("mockId");
		tokenReq.setCardNumber("4111111111111111");
		tokenReq.setCardExpDate("01/2023");
		return tokenReq;
	}
	
	private FraudRequest mockCCRequest() {
		String jsonFraudRequest = "{\"orderId\":\"o70981139\",\"website\":\"https://sit.aezone.com/us/en\",\"orderTimeZone\":\"-5\",\"userId\":\"ugp378392987\",\"freightAmount\":\"7.00\",\"amount\":\"36.95\",\"resubmittedOrder\":true,\"customerOrder\":{\"customerOrderId\":\"0000884037\",\"currencyCode\":\"USD\",\"activityDate\":\"2020-04-09 13:32:35\",\"carrierCode\":\"STD\",\"freeReturnLabel\":false,\"discount\":\"0.0\",\"taxAmount\":\"0.0\",\"freeReturnLabelCode\":null,\"freeGiftReceipt\":false,\"profileId\":\"ugp378392987\",\"sourceApplication\":\"ATG\",\"channel\":\"WEB\",\"ipAddress\":\"162.250.148.187\",\"profileLoginDate\":\"2019-06-10\",\"deviceData\":\"null\"},\"customerBillingDetail\":{\"loyaltyId\":\"71039864998028\",\"firstName\":\"Testing\",\"lastName\":\"Tester\",\"emailAddress\":\"keeferc@ae.com\",\"phoneNumber\":\"14125555555\",\"address\":{\"address1\":\"123 Test St\",\"address2\":null,\"city\":\"Pittsburgh\",\"stateName\":\"PA\",\"countryCode\":\"US\",\"postalCode\":\"15203\"}},\"customerShippingDetail\":{\"firstName\":\"Editing\",\"lastName\":\"Editor\",\"emailAddress\":null,\"phoneNumber\":null,\"address\":{\"address1\":\"19 Hot Metal St\",\"address2\":\"Floor 5\",\"city\":\"Pittsburgh\",\"stateName\":\"PA\",\"countryCode\":\"US\",\"postalCode\":\"15203\"}},\"orderMetaData\":{\"userType\":\"registered\",\"hasPLCCPayment\":false,\"bopisOrder\":false,\"vgcorder\":false,\"userOrder\":true,\"guestOrder\":false},\"appliedCoupons\":[],\"items\":[{\"quantity\":1,\"productClass\":\"016\",\"recipientEmail\":null,\"recipientName\":null,\"recipientMobile\":null,\"senderEmail\":null,\"senderName\":null,\"giftMessage\":null,\"giftCardAmount\":null,\"amount\":\"29.95\",\"listPrice\":\"29.95\",\"catalogRefId\":\"0027762947\",\"pickupPromiseDate\":null,\"productClassId\":\"1182\",\"equityName\":\"(Clr: CA) AE LONG SLEEVE GRAPHIC TEE\",\"sizeDescDefault\":\"M\",\"egifterGiftId\":null,\"egifterOrderId\":null}],\"paymentMethods\":[{\"creditDebitTender\":{\"maskedAccountNumber\":\"411111******1111\",\"creditCardExpDate\":\"01/2023\",\"authorizationDtls\":{\"transactionSuccess\":true,\"amount\":36.95,\"cvvResponse\":\"X\",\"errorMessage\":null,\"avsCode\":\"Y\"},\"cardToken\":\"1074368326741111\",\"cardVerificationNumber\":\"OK1584\",\"fraudToken\":\"db8257d4a8d015c53ba4e3a4c21d41fa5bb2a60c4856a9d68694c7487d15a6f5\"},\"paypalTender\":null,\"giftCardTender\":null,\"digitalWalletTender\":null}]}";
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(jsonFraudRequest, FraudRequest.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private FraudRequest mockSplitPayRequest() {
		String jsonFraudRequest = "{\"orderId\":\"o71721588\",\"website\":\"https://sit.aezone.com/us/en\",\"orderTimeZone\":\"-5\",\"userId\":\"ugp709501643\",\"freightAmount\":\"0.00\",\"amount\":\"346.79\",\"resubmittedOrder\":true,\"customerOrder\":{\"customerOrderId\":\"0000886439\",\"currencyCode\":\"USD\",\"activityDate\":\"2020-04-13 12:54:11\",\"carrierCode\":\"STD\",\"freeReturnLabel\":false,\"discount\":\"0.0\",\"taxAmount\":\"32.24\",\"deviceData\":null,\"freeReturnLabelCode\":null,\"freeGiftReceipt\":false,\"profileId\":\"ugp709501643\",\"sourceApplication\":\"ATG\",\"channel\":\"WEB\",\"ipAddress\":\"162.250.148.187\",\"profileLoginDate\":\"2020-04-13\"},\"customerBillingDetail\":{\"loyaltyId\":null,\"firstName\":\"TestFN\",\"lastName\":\"TestLN\",\"emailAddress\":\"qsgcv1uaa2p8dd8h@aeemailonly.com\",\"phoneNumber\":\"15555555555\",\"address\":{\"address1\":\"45 Park Avenue\",\"address2\":\"Apt. 303\",\"city\":\"Florida\",\"stateName\":\"FL\",\"countryCode\":\"US\",\"postalCode\":\"32207\"}},\"customerShippingDetail\":{\"firstName\":\"firstNamee\",\"lastName\":\"lastNamee\",\"emailAddress\":null,\"phoneNumber\":null,\"address\":{\"address1\":\"address12\",\"address2\":\"address22\",\"city\":\"Chicago\",\"stateName\":\"IL\",\"countryCode\":\"US\",\"postalCode\":\"60611\"}},\"orderMetaData\":{\"userType\":\"registered\",\"hasPLCCPayment\":false,\"bopisOrder\":false,\"vgcorder\":false,\"userOrder\":true,\"guestOrder\":false},\"appliedCoupons\":[],\"items\":[{\"quantity\":1,\"productClass\":\"075\",\"recipientEmail\":null,\"recipientName\":null,\"recipientMobile\":null,\"senderEmail\":null,\"senderName\":null,\"giftMessage\":null,\"giftCardAmount\":null,\"amount\":\"34.95\",\"listPrice\":\"34.95\",\"catalogRefId\":\"0027415967\",\"pickupPromiseDate\":null,\"productClassId\":\"2752\",\"equityName\":\"Aerie Push Up Bikini Top\",\"sizeDescDefault\":\"32A\",\"egifterGiftId\":null,\"egifterOrderId\":null},{\"quantity\":1,\"productClass\":\"075\",\"recipientEmail\":null,\"recipientName\":null,\"recipientMobile\":null,\"senderEmail\":null,\"senderName\":null,\"giftMessage\":null,\"giftCardAmount\":null,\"amount\":\"34.95\",\"listPrice\":\"34.95\",\"catalogRefId\":\"0027415967\",\"pickupPromiseDate\":null,\"productClassId\":\"2752\",\"equityName\":\"Aerie Push Up Bikini Top\",\"sizeDescDefault\":\"32A\",\"egifterGiftId\":null,\"egifterOrderId\":null},{\"quantity\":1,\"productClass\":\"075\",\"recipientEmail\":null,\"recipientName\":null,\"recipientMobile\":null,\"senderEmail\":null,\"senderName\":null,\"giftMessage\":null,\"giftCardAmount\":null,\"amount\":\"34.95\",\"listPrice\":\"34.95\",\"catalogRefId\":\"0027415967\",\"pickupPromiseDate\":null,\"productClassId\":\"2752\",\"equityName\":\"Aerie Push Up Bikini Top\",\"sizeDescDefault\":\"32A\",\"egifterGiftId\":null,\"egifterOrderId\":null},{\"quantity\":1,\"productClass\":\"075\",\"recipientEmail\":null,\"recipientName\":null,\"recipientMobile\":null,\"senderEmail\":null,\"senderName\":null,\"giftMessage\":null,\"giftCardAmount\":null,\"amount\":\"34.95\",\"listPrice\":\"34.95\",\"catalogRefId\":\"0027415967\",\"pickupPromiseDate\":null,\"productClassId\":\"2752\",\"equityName\":\"Aerie Push Up Bikini Top\",\"sizeDescDefault\":\"32A\",\"egifterGiftId\":null,\"egifterOrderId\":null},{\"quantity\":1,\"productClass\":\"075\",\"recipientEmail\":null,\"recipientName\":null,\"recipientMobile\":null,\"senderEmail\":null,\"senderName\":null,\"giftMessage\":null,\"giftCardAmount\":null,\"amount\":\"34.95\",\"listPrice\":\"34.95\",\"catalogRefId\":\"0027415967\",\"pickupPromiseDate\":null,\"productClassId\":\"2752\",\"equityName\":\"Aerie Push Up Bikini Top\",\"sizeDescDefault\":\"32A\",\"egifterGiftId\":null,\"egifterOrderId\":null},{\"quantity\":1,\"productClass\":\"075\",\"recipientEmail\":null,\"recipientName\":null,\"recipientMobile\":null,\"senderEmail\":null,\"senderName\":null,\"giftMessage\":null,\"giftCardAmount\":null,\"amount\":\"34.95\",\"listPrice\":\"34.95\",\"catalogRefId\":\"0027415967\",\"pickupPromiseDate\":null,\"productClassId\":\"2752\",\"equityName\":\"Aerie Push Up Bikini Top\",\"sizeDescDefault\":\"32A\",\"egifterGiftId\":null,\"egifterOrderId\":null},{\"quantity\":1,\"productClass\":\"075\",\"recipientEmail\":null,\"recipientName\":null,\"recipientMobile\":null,\"senderEmail\":null,\"senderName\":null,\"giftMessage\":null,\"giftCardAmount\":null,\"amount\":\"34.95\",\"listPrice\":\"34.95\",\"catalogRefId\":\"0027415967\",\"pickupPromiseDate\":null,\"productClassId\":\"2752\",\"equityName\":\"Aerie Push Up Bikini Top\",\"sizeDescDefault\":\"32A\",\"egifterGiftId\":null,\"egifterOrderId\":null},{\"quantity\":1,\"productClass\":\"075\",\"recipientEmail\":null,\"recipientName\":null,\"recipientMobile\":null,\"senderEmail\":null,\"senderName\":null,\"giftMessage\":null,\"giftCardAmount\":null,\"amount\":\"34.95\",\"listPrice\":\"34.95\",\"catalogRefId\":\"0027415967\",\"pickupPromiseDate\":null,\"productClassId\":\"2752\",\"equityName\":\"Aerie Push Up Bikini Top\",\"sizeDescDefault\":\"32A\",\"egifterGiftId\":null,\"egifterOrderId\":null},{\"quantity\":1,\"productClass\":\"075\",\"recipientEmail\":null,\"recipientName\":null,\"recipientMobile\":null,\"senderEmail\":null,\"senderName\":null,\"giftMessage\":null,\"giftCardAmount\":null,\"amount\":\"34.95\",\"listPrice\":\"34.95\",\"catalogRefId\":\"0027415967\",\"pickupPromiseDate\":null,\"productClassId\":\"2752\",\"equityName\":\"Aerie Push Up Bikini Top\",\"sizeDescDefault\":\"32A\",\"egifterGiftId\":null,\"egifterOrderId\":null}],\"paymentMethods\":[{\"creditDebitTender\":{\"maskedAccountNumber\":\"601100******0035\",\"creditCardExpDate\":\"12/2027\",\"authorizationDtls\":{\"transactionSuccess\":true,\"amount\":246.79,\"cvvResponse\":\"M\",\"errorMessage\":null,\"avsCode\":\"Y\"},\"cardToken\":\"7746746627630035\",\"cardVerificationNumber\":\"OK8579\",\"fraudToken\":\"d2be0b1653916aee07e4f06bc28357348b73e9067e9111b4c07f1815be70e013\"},\"paypalTender\":null,\"giftCardTender\":null,\"digitalWalletTender\":null},{\"creditDebitTender\":null,\"paypalTender\":null,\"giftCardTender\":{\"cardNumber\":\"6006493301499935044\",\"processedAmount\":\"100.00\",\"giftCardPin\":null,\"transactionSuccess\":true},\"digitalWalletTender\":null}]}";
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(jsonFraudRequest, FraudRequest.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private FraudRequest mockDWRequest() {
		String jsonFraudRequest = "{\"orderId\":\"o71724046\",\"website\":\"https://sit.aezone.com/us/en\",\"orderTimeZone\":\"-5\",\"userId\":\"ugp709504112\",\"freightAmount\":\"7.00\",\"amount\":\"16.48\",\"resubmittedOrder\":true,\"customerOrder\":{\"customerOrderId\":\"0000887024\",\"currencyCode\":\"USD\",\"activityDate\":\"2020-04-13 14:13:39\",\"carrierCode\":\"STD\",\"freeReturnLabel\":false,\"discount\":\"0.0\",\"taxAmount\":\"1.53\",\"deviceData\":null,\"freeReturnLabelCode\":null,\"freeGiftReceipt\":false,\"profileId\":\"ugp709504112\",\"sourceApplication\":\"ATG\",\"channel\":\"WEB\",\"ipAddress\":\"162.250.148.187\",\"profileLoginDate\":\"2020-04-13\"},\"customerBillingDetail\":{\"loyaltyId\":null,\"firstName\":\"TestFN\",\"lastName\":\"TestLN\",\"emailAddress\":\"ryu78hwcmuxtvfzm@aeemailonly.com\",\"phoneNumber\":\"15555555555\",\"address\":{\"address1\":\"45 Park Avenue\",\"address2\":\"Apt. 303\",\"city\":\"Florida\",\"stateName\":\"FL\",\"countryCode\":\"US\",\"postalCode\":\"32207\"}},\"customerShippingDetail\":{\"firstName\":\"firstName\",\"lastName\":\"lastName\",\"emailAddress\":null,\"phoneNumber\":null,\"address\":{\"address1\":\"155 4th St\",\"address2\":\"Ste 1050 S\",\"city\":\"San Francisco\",\"stateName\":\"CA\",\"countryCode\":\"US\",\"postalCode\":\"94107\"}},\"orderMetaData\":{\"userType\":\"registered\",\"hasPLCCPayment\":false,\"bopisOrder\":false,\"vgcorder\":false,\"userOrder\":true,\"guestOrder\":false},\"appliedCoupons\":[],\"items\":[{\"quantity\":1,\"productClass\":\"042\",\"recipientEmail\":null,\"recipientName\":null,\"recipientMobile\":null,\"senderEmail\":null,\"senderName\":null,\"giftMessage\":null,\"giftCardAmount\":null,\"amount\":\"7.95\",\"listPrice\":\"7.95\",\"catalogRefId\":\"0027260660\",\"pickupPromiseDate\":null,\"productClassId\":\"0425\",\"equityName\":\"AEO Mismatched Quarter Socks\",\"sizeDescDefault\":\"One Size\",\"egifterGiftId\":null,\"egifterOrderId\":null}],\"paymentMethods\":[{\"creditDebitTender\":null,\"paypalTender\":null,\"giftCardTender\":null,\"digitalWalletTender\":{\"authorizationDtls\":{\"transactionSuccess\":true,\"amount\":16.48,\"cvvResponse\":null,\"errorMessage\":null,\"avsCode\":null},\"paymentMethodNonce\":\"fake-apple-pay-discover-nonce\"}}]}";
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(jsonFraudRequest, FraudRequest.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private FraudRequest mockPPRequest() {
		String jsonFraudRequest = "{\"orderId\":\"o71687081\",\"website\":\"https://sit.aezone.com/us/en\",\"orderTimeZone\":\"-5\",\"userId\":\"ugp707728742\",\"freightAmount\":\"0.00\",\"amount\":\"59.95\",\"resubmittedOrder\":true,\"customerOrder\":{\"customerOrderId\":\"0000886984\",\"currencyCode\":\"USD\",\"activityDate\":\"2020-04-13 14:42:12\",\"carrierCode\":\"STD\",\"freeReturnLabel\":true,\"discount\":\"0.0\",\"taxAmount\":\"0.0\",\"deviceData\":null,\"freeReturnLabelCode\":\"USA\",\"freeGiftReceipt\":false,\"profileId\":\"ugp707728742\",\"sourceApplication\":\"ATG\",\"channel\":\"WEB\",\"ipAddress\":\"10.202.16.85\",\"profileLoginDate\":\"2020-04-09\"},\"customerBillingDetail\":{\"loyaltyId\":\"94055054337801\",\"firstName\":\"Consumer\",\"lastName\":\"Account\",\"emailAddress\":\"msat425@ugployalty.com\",\"phoneNumber\":\"+14085854254\",\"address\":{\"address1\":\"1 Main St\",\"address2\":null,\"city\":\"San Jose\",\"stateName\":\"CA\",\"countryCode\":\"US\",\"postalCode\":\"95131\"}},\"customerShippingDetail\":{\"firstName\":\"firstName\",\"lastName\":\"lastName\",\"emailAddress\":null,\"phoneNumber\":null,\"address\":{\"address1\":\"24 street\",\"address2\":\"\",\"city\":\"San Francisco\",\"stateName\":\"CA\",\"countryCode\":\"US\",\"postalCode\":\"94107\"}},\"orderMetaData\":{\"userType\":\"registered\",\"hasPLCCPayment\":false,\"bopisOrder\":false,\"vgcorder\":false,\"userOrder\":true,\"guestOrder\":false},\"appliedCoupons\":[],\"items\":[{\"quantity\":1,\"productClass\":\"043\",\"recipientEmail\":null,\"recipientName\":null,\"recipientMobile\":null,\"senderEmail\":null,\"senderName\":null,\"giftMessage\":null,\"giftCardAmount\":null,\"amount\":\"59.95\",\"listPrice\":\"59.95\",\"catalogRefId\":\"0028285955\",\"pickupPromiseDate\":null,\"productClassId\":\"3437\",\"equityName\":\"High-Waisted Tomgirl Jean\",\"sizeDescDefault\":\"0 X-Short\",\"egifterGiftId\":null,\"egifterOrderId\":null}],\"paymentMethods\":[{\"creditDebitTender\":null,\"paypalTender\":{\"payerId\":\"9P5BDS6BFY4K8\",\"authorizationDtls\":{\"transactionSuccess\":true,\"amount\":59.95,\"cvvResponse\":null,\"errorMessage\":null,\"avsCode\":null},\"payerStatus\":\"VERIFIED\",\"payerEmail\":\"personal_usa_60@paypal.com\"},\"giftCardTender\":null,\"digitalWalletTender\":null}]}";
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(jsonFraudRequest, FraudRequest.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
