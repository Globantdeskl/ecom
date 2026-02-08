package com.aeo.checkout.fraud.service.tools;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aeo.checkout.fraud.model.FraudRequest;
import com.aeo.checkout.fraud.model.Item;
import com.aeo.checkout.fraud.model.aci.ACIConstants;
import com.aeo.checkout.fraud.model.aci.LPTransactionProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestItemDataPopulatorTest {
	
	private RequestItemDataPopulator itemDataPopulator;
	
	private Map<LPTransactionProperty, String> requestMap;
	
	@BeforeEach
	void setup() {
		requestMap = new EnumMap<>(LPTransactionProperty.class);
		itemDataPopulator = new RequestItemDataPopulator();
	}
	
	@Test
	void populate() {
		assertDoesNotThrow(() -> itemDataPopulator.populate(mockCCRequest(), requestMap));
	}
	
	@Test
	void populateAndGetItemData() {
		FraudRequest request = mockCCRequest();
		List<Map<LPTransactionProperty, String>> itemMaps = 
				itemDataPopulator.populateAndGetItemData(request, requestMap);
		assertNotNull(itemMaps);
		assertNotNull(requestMap.get(LPTransactionProperty.EBT_USER_DATA19));
		assertEquals(request.getItems().size(), itemMaps.size());
		assertEquals(ACIConstants.PHYSICAL_GOODS, requestMap.get(LPTransactionProperty.PROD_DEL_CD));
	}
	
	@Test
	void vgcItems() {
		FraudRequest request = mockCCRequest();
		Item vgc = new Item();
		vgc.setAmount("50.00");
		vgc.setQuantity(1);
		vgc.setRecipientEmail("mock@ae.com");
		request.getItems().add(vgc);
		List<Map<LPTransactionProperty, String>> itemMaps = 
				itemDataPopulator.populateAndGetItemData(request, requestMap);
		assertNotNull(itemMaps);
		assertNotNull(requestMap.get(LPTransactionProperty.EBT_USER_DATA19));
		assertEquals(request.getItems().size(), itemMaps.size());
		assertEquals("mock@ae.com", requestMap.get(LPTransactionProperty.EBT_USER_DATA12));
		assertEquals(ACIConstants.DIGITAL_N_PHYSICAL_GOODS, requestMap.get(LPTransactionProperty.PROD_DEL_CD));
		
		request.getItems().clear();
		request.getItems().add(vgc);
		itemDataPopulator.populateAndGetItemData(request, requestMap);
		assertEquals(ACIConstants.DIGITAL_GOODS, requestMap.get(LPTransactionProperty.PROD_DEL_CD));
	}
	
	@Test
	void bopisItems() {
		FraudRequest request = mockCCRequest();
		request.getOrderMetaData().setBopisOrder(true);
		
		Item eow = mockBopisItem(3);
		request.getItems().clear();
		request.getItems().add(eow);
		List<Map<LPTransactionProperty, String>> itemMaps = 
				itemDataPopulator.populateAndGetItemData(request, requestMap);
		assertEquals(ACIConstants.SHIP_TO_STORE, itemMaps.get(0).get(LPTransactionProperty.ITEM_SHIP_NO));
		assertEquals(ACIConstants.NO, requestMap.get(LPTransactionProperty.EBT_USER_DATA22));
		
		Item tomorrow = mockBopisItem(1);
		request.getItems().clear();
		request.getItems().add(tomorrow);
		itemMaps = itemDataPopulator.populateAndGetItemData(request, requestMap);
		assertEquals(ACIConstants.PICKUP_TODAY, itemMaps.get(0).get(LPTransactionProperty.ITEM_SHIP_NO));
		assertEquals(ACIConstants.YES, requestMap.get(LPTransactionProperty.EBT_USER_DATA22));
		
		Item today = mockBopisItem(0);
		request.getItems().clear();
		request.getItems().add(today);
		itemMaps = itemDataPopulator.populateAndGetItemData(request, requestMap);
		assertEquals(ACIConstants.PICKUP_TODAY, itemMaps.get(0).get(LPTransactionProperty.ITEM_SHIP_NO));
		assertEquals(ACIConstants.YES, requestMap.get(LPTransactionProperty.EBT_USER_DATA22));
	}
	
	private Item mockBopisItem(int promiseDay) {
		Item bopis = new Item();
		bopis.setAmount("50.00");
		bopis.setQuantity(1);
		
		Date promoseDate = promiseDay == 0 ? 
				Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()) :
					Date.from(LocalDate.now().plusDays(promiseDay).atStartOfDay(ZoneId.systemDefault()).toInstant());
		bopis.setPickupPromiseDate(promoseDate);
		return bopis;
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
