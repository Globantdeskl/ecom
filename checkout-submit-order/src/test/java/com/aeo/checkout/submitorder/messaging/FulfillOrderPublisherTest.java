package com.aeo.checkout.submitorder.messaging;

import com.aeo.checkout.submitorder.config.FulfillOrderPublisherConfig.Submit2FulfillmentPubsubOutboundGateway;
import com.aeo.checkout.submitorder.model.atg.ATGResponse;
import com.aeo.postcheckout.model.order.ATGOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.messaging.MessagingException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;

class FulfillOrderPublisherTest {

	private FulfillOrderPublisher fulfillOrderPublisher;
	
	@Mock
	private Submit2FulfillmentPubsubOutboundGateway fulfillmentPubsub;
	
	private ATGOrder atgOrder;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
		fulfillOrderPublisher = new FulfillOrderPublisher(new Gson(), fulfillmentPubsub);
		atgOrder = createMockATGResponse("mockOrderId");
	}
	
	@Test
	void testSendOrder() {
		Mockito.doNothing().when(fulfillmentPubsub).sendToPubsub(ArgumentMatchers.anyString());
		assertTrue(fulfillOrderPublisher.send(atgOrder, "mockOrderId"));
		Mockito.verify(fulfillmentPubsub, times(1)).sendToPubsub(ArgumentMatchers.anyString());
	}
	
	@Test
	void testSendOrderFailed() {
		Mockito.doThrow(MessagingException.class).when(fulfillmentPubsub).sendToPubsub(ArgumentMatchers.anyString());
		assertThrows(MessagingException.class, () -> fulfillOrderPublisher.send(atgOrder, "mockOrderId"));
		Mockito.verify(fulfillmentPubsub, times(1)).sendToPubsub(ArgumentMatchers.anyString());
	}
	
	@Test
	void testSendOrderRetriesExhausted() {
		assertFalse(fulfillOrderPublisher.send(
				new MessagingException("Recovery Method Called"), atgOrder, "mockOrderId"));
		Mockito.verify(fulfillmentPubsub, times(0)).sendToPubsub(ArgumentMatchers.anyString());
	}
	
	private static ATGOrder createMockATGResponse(String orderId) {
		String jsonResp = "{\"diagnostics\":{\"SECURITY_STATUS\":0,\"requestCount\":110725,\"orderId\":\"" + orderId + "\",\"activePromotionsOnProfile\":[],\"filteredActivePromotions\":[],\"sessionId\":\"kOgNRkZ7g_zL_PjEvI9t_WAIKuFKtL_-XCHIA_9Br2GQUirsnXpu!1347989331!1585065641595\",\"usedPromotionsOnProfile\":[],\"PROFILE_IS_TRANSIENT\":true,\"serverId\":\"aeoCAP1\",\"requestLocale\":\"en_US\",\"requestURIWithQueryString\":\"/public/v1/orders/" + orderId + "/customerEdit\",\"requestHeaders\":\"Content-Type:application/json;User-Agent:PostmanRuntime/7.24.0;Accept:*/*;Cache-Control:no-cache;Postman-Token:c5219b12-dc47-4ea7-bfa3-2bf619889dc5;Host:sit2-cap.ugp.aeo.qa;Accept-Encoding:gzip, deflate, br;Connection:keep-alive;Content-Length:219;Cookie:JSESSIONID=wt6WSfR32HTlWWAQMK_NyojxbNnrZBV7DcOcehHAUQjowt8xKqCH!1965142324;\",\"profileId\":\"ugp805648229\",\"siteId\":\"AEO_US\",\"time\":\"2020-03-24T12:00:41.86\"},\"data\":{\"message\":{\"collectionSize\":1,\"customerOrder\":[{\"orderType\":\"SALE\",\"shippingSpeed\":\"Standard (3-5 Business Days)\",\"consumerDeliveryTime\":null,\"comments\":null,\"externalRefId\":null,\"sourceLocId\":null,\"destinationLocId\":null,\"customerOrderId\":\"0012132226\",\"orderStatus\":null,\"carrierServiceCode\":null,\"custOrderHeaderDesc\":{\"orderDetails\":{\"headerPromos\":{\"promo\":[{\"promotionType\":\"SHIPPING_PROMOTION\",\"promotionName\":\"Free Shipping for Extra Access\",\"promoAmount\":\"7.00\",\"promoComponentDetailId\":null,\"promoCode\":null,\"currencyCode\":null,\"unitPromoAmount\":null,\"promoComponentId\":null}],\"promoTotal\":null},\"adjustmentDate\":null,\"headerCharges\":{\"charge\":[{\"chargePerUnit\":null,\"chargeCategory\":\"SHIPPING_CHARGE\",\"chargeAmount\":\"7.00\",\"chargeName\":\"Shipping_Charge\"}]},\"itemsTotalAfterDiscount\":null,\"orderHdrDiscount\":null,\"orderTaxTotal\":null,\"itemDiscountTotal\":null,\"orderTotal\":null,\"itemsTotal\":null,\"orderDiscountTotal\":null,\"chargeTotal\":null,\"currencyCode\":\"USD\",\"headerTaxes\":{\"taxTotal\":null,\"tax\":[{\"taxPercentage\":null,\"taxAmount\":\"0.00\",\"taxName\":\"Tax\",\"taxCategory\":\"Service_Tax\"}]}},\"orderBillingDtls\":{\"customerDtl\":[{\"loyaltyId\":\"71039864998028\",\"emails\":{\"email\":[{\"emailAddress\":\"keeferc@ae.com\",\"emailType\":null,\"primaryEmailInd\":null,\"emailId\":null}]},\"loyaltyPts\":null,\"customerType\":null,\"addresses\":{\"address\":[{\"address2\":null,\"city\":\"San Francisco\",\"stateName\":\"CA\",\"addressType\":null,\"address1\":\"123 Test St\",\"countryCode\":\"US\",\"postalCode\":\"94107\",\"county\":null,\"zipOnly\":null,\"stateCode\":null,\"countryName\":null}]},\"profileId\":null,\"customerId\":null,\"customerInfo\":{\"firstName\":\"Testing\",\"lastName\":\"Tester\",\"birthDay\":null,\"birthMonth\":null,\"gender\":null,\"birthYear\":null,\"birthDate\":null},\"phones\":{\"phone\":[{\"phoneType\":null,\"phoneNumber\":\"14125555555\",\"phoneCountryCode\":null,\"countryCode\":null,\"phoneExtension\":null,\"primaryPhoneInd\":null,\"phoneId\":null}]}}]},\"giftReceiptAssigned\":\"N\",\"paymentMethods\":{\"paymentMethod\":[{\"amount\":null,\"custBillDtls\":{\"customerDtl\":[{\"loyaltyId\":null,\"emails\":null,\"loyaltyPts\":null,\"customerType\":null,\"addresses\":{\"address\":[{\"address2\":null,\"city\":\"San Francisco\",\"stateName\":\"CA\",\"addressType\":null,\"address1\":\"123 Test St\",\"countryCode\":\"US\",\"postalCode\":\"94107\",\"county\":null,\"zipOnly\":null,\"stateCode\":null,\"countryName\":null}]},\"profileId\":null,\"customerId\":null,\"customerInfo\":{\"firstName\":\"Testing\",\"lastName\":\"Tester\",\"birthDay\":null,\"birthMonth\":null,\"gender\":null,\"birthYear\":null,\"birthDate\":null},\"phones\":null}]},\"seqNo\":0,\"settlementOrgCode\":null,\"giftCertTender\":null,\"chargeType\":\"AUTHORIZATION\",\"alternateAmount\":null,\"travelCheckTender\":null,\"alternateCurrencyCode\":null,\"giftCardTender\":null,\"afterPayTender\":null,\"creditDebitTender\":{\"additionalSecurityInfo\":null,\"accountAprType\":null,\"promotionDuration\":null,\"reportingToken\":null,\"cardType\":\"VISA\",\"svcno\":null,\"personalIdState\":null,\"accountApr\":null,\"promotionAprType\":null,\"prepaidBalance\":null,\"unlimitedCharges\":\"N\",\"maskedAccountNumber\":\"411111******1111\",\"cardToken\":\"1074368326741111\",\"settlementData\":null,\"signatureData\":[],\"promotionDescription\":null,\"creditCardExpDate\":\"01/2023\",\"authorizationDtls\":[{\"authAVS\":\"Y\",\"authCode\":\"OK6234\",\"authorizationDateTime\":null,\"authorizationMethod\":null,\"authorizationExpirationDate\":\"2020-04-23T12:00:41\",\"processedAmount\":\"24.95\",\"authorizationID\":\"OK6234\",\"transactionInfo\":\"00^940537^940537      ^OK6234^W010080333230943G522^0012^59^2301^fxresp-i^0^0^*TrnTime-160907^*CvvResp-x^*TrnAmt-2707^*AvsResp-y^*TableVI-VICRH_\"}],\"personalIdExpirationDate\":null,\"maxChargeLimit\":\"24.95\",\"promotionApr\":null,\"entryMethod\":null,\"personalIdCountry\":null},\"paymentType\":\"CREDIT\",\"paymentGroupId\":\"pg52111149\",\"checkTender\":null,\"paypalTender\":null,\"digitalWalletTender\":null,\"purchaseOrdTender\":null,\"storeCreditTender\":null,\"currencyCode\":null,\"couponTender\":null}]},\"orderDeliveryDtls\":{\"shipToStoreId\":null,\"deliveryMethod\":\"SHP\",\"customerShipDtl\":{\"loyaltyId\":null,\"emails\":null,\"loyaltyPts\":null,\"customerType\":null,\"addresses\":{\"address\":[{\"address2\":\"Floor 5\",\"city\":\"Pittsburgh\",\"stateName\":\"PA\",\"addressType\":\"REGULAR\",\"address1\":\"19 Hot Metal St\",\"countryCode\":\"US\",\"postalCode\":\"15203\",\"county\":null,\"zipOnly\":null,\"stateCode\":null,\"countryName\":null}]},\"profileId\":null,\"customerId\":null,\"customerInfo\":{\"firstName\":\"Editing\",\"lastName\":\"Editor\",\"birthDay\":null,\"birthMonth\":null,\"gender\":null,\"birthYear\":null,\"birthDate\":null},\"phones\":null}},\"custPreference\":{\"receiptPreference\":null,\"contactByEmail\":null,\"localeDesc\":\"en_US\",\"contactByPhone\":null,\"contactByMail\":null},\"items\":{\"item\":[{\"color\":\"Green\",\"capturedLineItemNo\":null,\"lineTaxes\":{\"taxTotal\":null,\"tax\":[{\"taxPercentage\":null,\"taxAmount\":\"0.00\",\"taxName\":\"Tax\",\"taxCategory\":\"Merchandise_Tax\"}]},\"lineItemNo\":1,\"overriddenPrice\":null,\"lineInstructions\":null,\"commerceItemId\":\"ci38000016\",\"uom\":\"EACH\",\"isReturnMessage\":false,\"reservationId\":\"ci38000016\",\"itemStatus\":null,\"lineType\":null,\"itemDescription\":\"40WEFT Destroy T-Shirt\",\"overriddenPriceReason\":null,\"lineAdditionalData\":[{\"value\":\"61000\",\"key\":\"taxCode\"}],\"relatedLineItemNo\":null,\"quantity\":1,\"productClass\":\"GOOD\",\"isCustomized\":null,\"unitSellPrice\":\"24.95\",\"itemDeliveryDtls\":{\"shipToStoreId\":null,\"deliveryMethod\":\"SHP\",\"customerShipDtl\":null},\"unitRegularPrice\":\"24.95\",\"isReturnable\":true,\"itemId\":\"0027822832\",\"orderDateDtls\":null,\"itemTotal\":null,\"shipLocationId\":null,\"size\":\"M\",\"lineCharges\":null,\"style\":\"1162-9294\",\"linePromos\":null,\"giftWrap\":null,\"productURL\":\"sit-stable.aezone.com/us/en/p/1162_9294_300\"}],\"lineCollectionSize\":1},\"shipments\":null,\"paymentStatus\":\"AUTHORIZED\",\"headerInstructions\":null},\"sourceCountryCode\":\"AEO_USA\",\"activityDate\":1584734947557,\"consumerDeliveryDate\":null,\"carrierCode\":\"STD\",\"sourceLocType\":\"WEB\",\"destinationLocType\":null,\"action\":null,\"partnerID\":null,\"additionalData\":[{\"value\":\"-5\",\"key\":\"orderTimeZone\"},{\"value\":\"2019-03-29\",\"key\":\"profileRegistrationDate\"}],\"sourceWebStoreId\":\"02953\",\"orderDesc\":null}],\"header\":{\"channel\":\"WEB\",\"messageId\":\"" + orderId + "\",\"sourceApplicationVersion\":null,\"eventType\":null,\"additionalData\":[],\"sourceApplication\":\"ATG\",\"userId\":\"ugp262330663\",\"businessUnitId\":null,\"touchPointId\":null,\"timestamp\":1585065641795}}},\"error\":{}}";
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			ATGResponse atgResp = mapper.readValue(jsonResp, ATGResponse.class);
			return atgResp.getMessage();
		} catch (JsonProcessingException e) {
			return new ATGOrder();
		}
	}
	
}
