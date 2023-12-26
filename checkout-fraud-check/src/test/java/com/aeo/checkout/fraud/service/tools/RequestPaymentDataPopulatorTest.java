package com.aeo.checkout.fraud.service.tools;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aeo.checkout.fraud.model.FraudRequest;
import com.aeo.checkout.fraud.model.GiftCardTender;
import com.aeo.checkout.fraud.model.PaymentMethod;
import com.aeo.checkout.fraud.model.aci.ACIConstants;
import com.aeo.checkout.fraud.model.aci.LPTransactionProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestPaymentDataPopulatorTest {
	
	private RequestPaymentDataPopulator paymentDataPopulator;
	
	private Map<LPTransactionProperty, String> requestMap;
	
	@BeforeEach
	void setup() {
		requestMap = new EnumMap<>(LPTransactionProperty.class);
		paymentDataPopulator = new RequestPaymentDataPopulator();
	}
	
	@Test
	void populate() {
		assertDoesNotThrow(() -> paymentDataPopulator.populate(mockCCRequest(), requestMap));
		assertDoesNotThrow(() -> paymentDataPopulator.populate(mockSplitPayRequest(), requestMap));
		assertDoesNotThrow(() -> paymentDataPopulator.populate(mockGCRequest(), requestMap));
		assertDoesNotThrow(() -> paymentDataPopulator.populate(mockDWRequest(), requestMap));
		assertDoesNotThrow(() -> paymentDataPopulator.populate(mockPPRequest(), requestMap));
		
		FraudRequest noPG = mockCCRequest();
		noPG.getPaymentMethods().get(0).setCreditDebitTender(null);
		assertDoesNotThrow(() -> paymentDataPopulator.populate(noPG, requestMap));
	}
	
	@Test
	void populateCreditCardData() {
		FraudRequest noToken = mockCCRequest();
		noToken.getPaymentMethods().get(0).getCreditDebitTender().setFraudToken(null);
		assertDoesNotThrow(() -> paymentDataPopulator.populate(noToken, requestMap));
		
		FraudRequest badAuth = mockCCRequest();
		badAuth.getPaymentMethods().get(0).getCreditDebitTender().setCardVerificationNumber(null);
		badAuth.getPaymentMethods().get(0).getCreditDebitTender().getAuthorizationDtls().setTransactionSuccess(false);
		badAuth.getPaymentMethods().get(0).getCreditDebitTender().getAuthorizationDtls().setCvvResponse(null);
		assertDoesNotThrow(() -> paymentDataPopulator.populate(badAuth, requestMap));
		badAuth.getPaymentMethods().get(0).getCreditDebitTender().getAuthorizationDtls().setErrorMessage(ACIConstants.AJB_AUTH_DECLINED_MESSAGE);
		assertDoesNotThrow(() -> paymentDataPopulator.populate(badAuth, requestMap));
		badAuth.getPaymentMethods().get(0).getCreditDebitTender().setAuthorizationDtls(null);
		badAuth.getCustomerOrder().setDeviceData(null);
		assertDoesNotThrow(() -> paymentDataPopulator.populate(badAuth, requestMap));
		
		FraudRequest plcc = mockCCRequest();
		plcc.getOrderMetaData().setHasPLCCPayment(true);
		assertDoesNotThrow(() -> paymentDataPopulator.populate(plcc, requestMap));
		
		FraudRequest plccWithExpDate = mockPLCCRequest();
		plcc.getOrderMetaData().setHasPLCCPayment(true);
		assertDoesNotThrow(() -> paymentDataPopulator.populate(plccWithExpDate, requestMap));
	}
	
	@Test
	void populatePayPalData() {
		FraudRequest badAuth = mockPPRequest();
		badAuth.getPaymentMethods().get(0).getPaypalTender().getAuthorizationDtls().setTransactionSuccess(false);
		assertDoesNotThrow(() -> paymentDataPopulator.populate(badAuth, requestMap));
		badAuth.getPaymentMethods().get(0).getPaypalTender().setAuthorizationDtls(null);
		assertDoesNotThrow(() -> paymentDataPopulator.populate(badAuth, requestMap));
		
		// one number month
		assertDoesNotThrow(() -> paymentDataPopulator.populateOneYearExpireDate(LocalDate.of(2020, 5, 6).atStartOfDay(), requestMap));
		// two number month
		assertDoesNotThrow(() -> paymentDataPopulator.populateOneYearExpireDate(LocalDate.of(2020, 11, 11).atStartOfDay(), requestMap));
	}
	
	@Test
	void populateAltPayData() {
		FraudRequest badAuth = mockDWRequest();
		badAuth.getPaymentMethods().get(0).getDigitalWalletTender().getAuthorizationDtls().setTransactionSuccess(false);
		assertDoesNotThrow(() -> paymentDataPopulator.populate(badAuth, requestMap));
		badAuth.getPaymentMethods().get(0).getDigitalWalletTender().setAuthorizationDtls(null);
		assertDoesNotThrow(() -> paymentDataPopulator.populate(badAuth, requestMap));
	}
	
	@Test
	void populateGiftCardsData() {
		FraudRequest oneGC = mockGCRequest(1);
		assertDoesNotThrow(() -> paymentDataPopulator.populate(oneGC, requestMap));
		
		FraudRequest pin = mockGCRequest(1);
		pin.getPaymentMethods().get(0).getGiftCardTender().setGiftCardPin("123");
		assertDoesNotThrow(() -> paymentDataPopulator.populate(pin, requestMap));
		
		FraudRequest noPin = mockGCRequest(1);
		noPin.getPaymentMethods().get(0).getGiftCardTender().setGiftCardPin(null);
		assertDoesNotThrow(() -> paymentDataPopulator.populate(noPin, requestMap));
		
		FraudRequest badTx = mockGCRequest(1);
		badTx.getPaymentMethods().get(0).getGiftCardTender().setTransactionSuccess(false);
		assertDoesNotThrow(() -> paymentDataPopulator.populate(badTx, requestMap));
	}
	
	@Test
	void populateSplitPaymentData() {
		FraudRequest oneGC = mockGCRequest(1);
		FraudRequest multiGCSplitPay = mockSplitPayRequest();
		multiGCSplitPay.getPaymentMethods().add(oneGC.getPaymentMethods().get(0));
		assertDoesNotThrow(() -> paymentDataPopulator.populate(multiGCSplitPay, requestMap));
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
	
	private FraudRequest mockPLCCRequest() {
		String jsonFraudRequest = "{\"orderId\":\"o730312780290\",\"website\":\"https:\\/\\/sit.aezone.com\\/us\\/en\",\"orderTimeZone\":\"-5\",\"userId\":\"ugp497433936\",\"freightAmount\":\"7.00\",\"amount\":\"29.66\",\"resubmittedOrder\":true,\"customerOrder\":{\"customerOrderId\":\"0001042953\",\"currencyCode\":\"USD\",\"activityDate\":\"2020-08-12 15:36:26\",\"carrierCode\":\"STD\",\"freeReturnLabel\":true,\"discount\":\"12.29\",\"taxAmount\":\"0.0\",\"deviceData\":\"0400CIfeAe15Cx8Nf94lis1ztlZtWBcopyaUR+pTQYYOz6QWsCSDK87JBqNk4KLqcj2WaHjoci9mfzLBOmoLto4X8btxUT7HF5Mfhlz5wlRFwWJi0FRulruXQQGCQaJkXU7G2OhaugKLvc1nzkHbqmuUufbaSn0SOxUyALLrQla3b6kYUZefgV6xf2W2aNwGMIcKh2qzWAF0e3DQtVCYANQUGQ4vEesFTVfa+qqMRKptoEO9f2PXvHogeO3Gk9aWzC1qVJJneDzKUwFI185O+yC2f3lLEO0Tay66NZEyiLNePemJKSIdwO9O5ZtntuUkG6NTZImP0SX1nBT5eVVu1G91gETvexTGSphD5mNV6QxgbcnqT3LYd4+PRXwk03OExCYy5W9eRIUjXx16GwaX5DA1pKqrjk1eJ4o7aUnxQDT1EIAQjvHiE3XtFCO7Idkyj9s\\/2\\/Ec1nc2SuEaTRn0G1NCZX4cq0m8QPH\\/dOIYgHC\\/3QY1fZwSVtWNySwAqo7XEZwL8ydRdFuSL63vUSbJ+Ltz3R3+1lLYqHZEfxx0Qm2MQh6zh6CHDh6VJlbrfzJFk+CKKULPxBs5mS927hswgTjK\\/PDLTlZTeY4dIkQNgVvPfUoEMUscz7kbcnG9B+SIx5AnCkrOClWCgeL392LRlUign4sNxP\\/kRpVwRw6NL2GAwt8apG44isAWX3Sw7PtSQtUR3qs+07R991O4XX2TWOi8\\/RYM8x0moWVyvIWQkhxgVBkG8+OF4jH\\/3mPdoTUpq\\/pNvBLLD2l+arONRAsa6aqqFxKePA1UZdKAZDwic+y5\\/r+SkyAbziDM7k8xAXTS4l7D1erHMnjL6rjVsJnU7qNs4gVNLjcH\\/6QbWZ\\/dBFUtmFyWMCVbBcdxP+fMxqv4WdGaMrHg9Btf04cRCL7CUahnxfbKRXey06cYiFW+\\/3S0f2nqtNuBmE4W+vmeG2mvWtA2vFQ3SxgXyvTx\\/y4JwLTE4P4M9O7lUiDQIMyfBSWv\\/vuXVqFEs8cInemT9zrgXhXD\\/2JiuEvP+ciyYpVPqp1j20KilZ\\/h758N+6R6J8MlSMy21DIFUPfRgZtSR2Du9U1pi5Ud7vp9mC9dcLDAL3V02E7tQ+TXoZ2ETJIhrBn9lkDMdh7g6Exs10YBKknoROYtdCujZOCEfYY3TJG+dLNRawalR6tq92sLof950W4kmx4Hyf83JPkBAvdbw86vRscVZ\\/lrwsKFYh1C4MHuHozkPSBfcDhwAT1javSu9sFFV3ncE4nZ3meVnqg0ESQ1nWNXzz8g3vl43JiK6\\/pdx\\/gqwpNtfUHgxkxhO4WrvgcY8U5KiQ31+n9if1Ew0P9\\/IsxjGyMDDor8\\/MmeYWtVjUPYYAVz5arDjoJTgdHTK320dk1q1Bp0PgWLLZ5q+sKcbPxbjobIiBAMUjEvjmKzAv2fNEdLPsGzAeJctcu8Me69xU4=\",\"freeReturnLabelCode\":\"USA\",\"freeGiftReceipt\":false,\"profileId\":\"ugp497433936\",\"sourceApplication\":\"ATG\",\"channel\":\"WEB\",\"ipAddress\":\"162.250.148.187\",\"profileLoginDate\":\"2019-10-04\"},\"customerBillingDetail\":{\"loyaltyId\":\"94054872614215\",\"firstName\":\"Caitlyn\",\"lastName\":\"Horn\",\"emailAddress\":\"testing120923@gmail.com\",\"phoneNumber\":\"14444444444\",\"address\":{\"address1\":\"19 South Water Street\",\"address2\":null,\"city\":\"Pittsburgh\",\"stateName\":\"PA\",\"countryCode\":\"US\",\"postalCode\":\"15203\"}},\"customerShippingDetail\":{\"firstName\":\"Caitlyn\",\"lastName\":\"Horn\",\"emailAddress\":null,\"phoneNumber\":null,\"address\":{\"address1\":\"12222 Smallman St\",\"address2\":\"\",\"city\":\"Pittsburgh\",\"stateName\":\"PA\",\"countryCode\":\"US\",\"postalCode\":\"15222\"}},\"orderMetaData\":{\"userType\":\"registered\",\"hasPLCCPayment\":true,\"bopisOrder\":false,\"vgcorder\":false,\"userOrder\":true,\"guestOrder\":false},\"appliedCoupons\":[],\"items\":[{\"quantity\":1,\"productClass\":\"037\",\"recipientEmail\":null,\"recipientName\":null,\"recipientMobile\":null,\"senderEmail\":null,\"senderName\":null,\"giftMessage\":null,\"giftCardAmount\":null,\"amount\":\"34.95\",\"listPrice\":\"34.95\",\"catalogRefId\":\"0027305739\",\"pickupPromiseDate\":null,\"productClassId\":\"2371\",\"equityName\":\"AE EYELET SLEEVE T-SHIRT\",\"sizeDescDefault\":\"S\",\"egifterGiftId\":null,\"egifterOrderId\":null}],\"paymentMethods\":[{\"creditDebitTender\":{\"maskedAccountNumber\":\"604410******0336\",\"creditCardExpDate\":\"12\\/9999\",\"authorizationDtls\":{\"transactionSuccess\":true,\"amount\":29.66,\"cvvResponse\":null,\"errorMessage\":null,\"avsCode\":\"N\"},\"cardToken\":\"9804191927980336\",\"cardVerificationNumber\":\"012618\",\"fraudToken\":\"b83ebd6808932a925af3de89f73b243a1af2c24aae77cb80f6d6b501a6daa536\"},\"paypalTender\":null,\"giftCardTender\":null,\"digitalWalletTender\":null}]}";
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
	
	private FraudRequest mockGCRequest() {
		return mockGCRequest(3);
	}
	
	private FraudRequest mockGCRequest(int gcToAdd) {
		FraudRequest split = mockSplitPayRequest();
		PaymentMethod one = new PaymentMethod();
		PaymentMethod two = new PaymentMethod();
		PaymentMethod three = new PaymentMethod();
		GiftCardTender gc1 = new GiftCardTender();
		gc1.setCardNumber("6006493301499935044");
		gc1.setTransactionSuccess(true);
		gc1.setProcessedAmount("100.00");
		one.setGiftCardTender(gc1);
		GiftCardTender gc2 = new GiftCardTender();
		gc2.setCardNumber("6006493301499935043");
		gc2.setTransactionSuccess(true);
		gc2.setProcessedAmount("100.00");
		two.setGiftCardTender(gc2);
		GiftCardTender gc3 = new GiftCardTender();
		gc3.setCardNumber("6006493301499935042");
		gc3.setTransactionSuccess(true);
		gc3.setProcessedAmount("46.79");
		three.setGiftCardTender(gc3);
		List<PaymentMethod> pms = new ArrayList<>();
		switch (gcToAdd) {
		case 1:
			pms.add(one);
			break;
		case 2:
			pms.add(one);
			pms.add(two);
			break;
		case 3:
			pms.add(one);
			pms.add(two);
			pms.add(three);
			break;
		default:
			break;
		}
		split.setPaymentMethods(pms);
		return split;
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
