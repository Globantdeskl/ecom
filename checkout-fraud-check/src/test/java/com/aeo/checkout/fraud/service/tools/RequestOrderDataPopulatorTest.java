package com.aeo.checkout.fraud.service.tools;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aeo.checkout.fraud.model.FraudRequest;
import com.aeo.checkout.fraud.model.aci.ACIConstants;
import com.aeo.checkout.fraud.model.aci.LPTransactionProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestOrderDataPopulatorTest {
	
	private RequestOrderDataPopulator orderDataPopulator;
	
	private Map<LPTransactionProperty, String> requestMap;
	
	@BeforeEach
	void setup() {
		requestMap = new EnumMap<>(LPTransactionProperty.class);
		orderDataPopulator = new RequestOrderDataPopulator();
	}
	
	@Test
	void populate() {
		FraudRequest request = mockCCRequest();
		request.setAppliedCoupons(null);
		orderDataPopulator.populate(request, requestMap);
		assertEquals(LPTransactionProperty.EBT_USER_DATA18.defaultValue(), 
				requestMap.get(LPTransactionProperty.EBT_USER_DATA18));
		
		request.setAppliedCoupons(new ArrayList<String>());
		orderDataPopulator.populate(request, requestMap);
		assertEquals(LPTransactionProperty.EBT_USER_DATA18.defaultValue(), 
				requestMap.get(LPTransactionProperty.EBT_USER_DATA18));
		
		request.setAppliedCoupons(Arrays.asList("COUPONCODE"));
		orderDataPopulator.populate(request, requestMap);
		assertEquals("1", requestMap.get(LPTransactionProperty.EBT_USER_DATA18));
		
		request.getCustomerBillingDetail().setLoyaltyId("loyaltyId");
		orderDataPopulator.populate(request, requestMap);
		assertEquals(ACIConstants.YES, requestMap.get(LPTransactionProperty.EBT_USER_DATA15));
		
		request.getCustomerBillingDetail().setLoyaltyId(null);
		orderDataPopulator.populate(request, requestMap);
		assertEquals(ACIConstants.NO, requestMap.get(LPTransactionProperty.EBT_USER_DATA15));
		
		request.getOrderMetaData().setUserType("guest");
		orderDataPopulator.populate(request, requestMap);
		assertEquals(ACIConstants.NO, requestMap.get(LPTransactionProperty.EBT_PREVCUST));
		assertEquals("0", requestMap.get(LPTransactionProperty.EBT_TOF));
		
		request.getOrderMetaData().setUserType("registered");
		request.getCustomerOrder().setProfileLoginDate("2019-06-10");
		orderDataPopulator.populate(request, requestMap);
		assertEquals(ACIConstants.YES, requestMap.get(LPTransactionProperty.EBT_PREVCUST));
		assertTrue(Long.valueOf(requestMap.get(LPTransactionProperty.EBT_TOF)) > 
			Long.valueOf(LPTransactionProperty.EBT_TOF.defaultValue()));
		
		request.getOrderMetaData().setUserType("registered");
		request.getCustomerOrder().setProfileLoginDate(null);
		orderDataPopulator.populate(request, requestMap);
		assertEquals(ACIConstants.YES, requestMap.get(LPTransactionProperty.EBT_PREVCUST));
		assertEquals(LPTransactionProperty.EBT_TOF.defaultValue(), requestMap.get(LPTransactionProperty.EBT_TOF));
		
		request.setResubmittedOrder(true);
		orderDataPopulator.populate(request, requestMap);
		assertEquals(ACIConstants.YES, requestMap.get(LPTransactionProperty.EBT_USER_DATA23));
		
		request.setResubmittedOrder(false);
		orderDataPopulator.populate(request, requestMap);
		assertEquals(ACIConstants.NO, requestMap.get(LPTransactionProperty.EBT_USER_DATA23));
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
	
}
