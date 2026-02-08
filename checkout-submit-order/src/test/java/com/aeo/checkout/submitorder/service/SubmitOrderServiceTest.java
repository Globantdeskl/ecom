package com.aeo.checkout.submitorder.service;

import com.aeo.checkout.submitorder.messaging.FulfillOrderPublisher;
import com.aeo.checkout.submitorder.model.SubmittedOrder;
import com.aeo.checkout.submitorder.model.atg.ATGResponse;
import com.aeo.postcheckout.model.order.ATGOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.messaging.MessagingException;
import org.springframework.web.client.RestClientException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;

class SubmitOrderServiceTest {
	
	private SubmitOrderService submitOrderService;
	
	@Mock
	private SplitCallWrapperService splitOrderService;
	
	@Mock
	private FulfillOrderPublisher fulfillmentPublisher;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
		submitOrderService = new SubmitOrderService(splitOrderService, fulfillmentPublisher);
	}
	
	@Test
	void testSubmit() {
		SubmittedOrder order = mockSubmittedOrder("mockId01");
		
		Mockito.when(splitOrderService.call(ArgumentMatchers.anyString()))
			.thenReturn(Optional.of(createMockATGResponse(order.getOrderId())));
		Mockito.when(fulfillmentPublisher.send(ArgumentMatchers.any(ATGOrder.class), ArgumentMatchers.anyString()))
			.thenReturn(true);
		
		assertTrue(submitOrderService.submit(order));
		Mockito.verify(splitOrderService, times(1)).call(ArgumentMatchers.anyString());
		Mockito.verify(fulfillmentPublisher, times(1)).send(ArgumentMatchers.any(ATGOrder.class), ArgumentMatchers.anyString());
	}
	
	@Test
	void testSplitButNotFulfilled() {
		SubmittedOrder order = mockSubmittedOrder("mockId01");
		
		Mockito.when(splitOrderService.call(ArgumentMatchers.anyString()))
			.thenReturn(Optional.of(createMockATGResponse(order.getOrderId())));
		Mockito.when(fulfillmentPublisher.send(ArgumentMatchers.any(ATGOrder.class), ArgumentMatchers.anyString()))
			.thenReturn(false);
		
		assertFalse(submitOrderService.submit(order));
		Mockito.verify(splitOrderService, times(1)).call(ArgumentMatchers.anyString());
		Mockito.verify(fulfillmentPublisher, times(1)).send(ArgumentMatchers.any(ATGOrder.class), ArgumentMatchers.anyString());
	}
	
	@Test
	void testNotSplitAndNotFulfilled() {
		SubmittedOrder order = mockSubmittedOrder("mockId01");
		
		Mockito.when(splitOrderService.call(ArgumentMatchers.anyString()))
			.thenReturn(Optional.empty());
		Mockito.when(fulfillmentPublisher.send(ArgumentMatchers.any(ATGOrder.class), ArgumentMatchers.anyString()))
			.thenReturn(false);
		
		assertFalse(submitOrderService.submit(order));
		Mockito.verify(splitOrderService, times(1)).call(ArgumentMatchers.anyString());
		Mockito.verify(fulfillmentPublisher, times(0)).send(ArgumentMatchers.any(ATGOrder.class), ArgumentMatchers.anyString());
	}
	
	@Test
	void testSplitCallFailed() {
		SubmittedOrder order = mockSubmittedOrder("mockId01");
		
		Mockito.when(splitOrderService.call(ArgumentMatchers.anyString()))
			.thenThrow(RestClientException.class);
		Mockito.when(fulfillmentPublisher.send(ArgumentMatchers.any(ATGOrder.class), ArgumentMatchers.anyString()))
			.thenReturn(false);
		
		assertThrows(RestClientException.class, () -> submitOrderService.submit(order));
		Mockito.verify(splitOrderService, times(1)).call(ArgumentMatchers.anyString());
		Mockito.verify(fulfillmentPublisher, times(0)).send(ArgumentMatchers.any(ATGOrder.class), ArgumentMatchers.anyString());
	}
	
	@Test
	void testFulfillmetPublishFailed() {
		SubmittedOrder order = mockSubmittedOrder("mockId01");
		
		Mockito.when(splitOrderService.call(ArgumentMatchers.anyString()))
			.thenReturn(Optional.of(createMockATGResponse(order.getOrderId())));
		Mockito.when(fulfillmentPublisher.send(ArgumentMatchers.any(ATGOrder.class), ArgumentMatchers.anyString()))
			.thenThrow(MessagingException.class);
		
		assertThrows(MessagingException.class, () -> submitOrderService.submit(order));
		Mockito.verify(splitOrderService, times(1)).call(ArgumentMatchers.anyString());
		Mockito.verify(fulfillmentPublisher, times(1)).send(ArgumentMatchers.any(ATGOrder.class), ArgumentMatchers.anyString());
	}
	
	private SubmittedOrder mockSubmittedOrder(String orderId) {
		SubmittedOrder order = new SubmittedOrder();
		order.setOrderId(orderId);
		return order;
	}
	
	private static ATGOrder createMockATGResponse(String orderId) {
		String jsonResp = "{ \"links\": [ { \"method\": \"GET\", \"rel\": \"self\", \"href\": \"https://sit-txn.ugp.aeo.qa:443/public/order/split/" + orderId + "\" }, { \"method\": \"GET\", \"rel\": \"canonical\", \"href\": \"https://sit-txn.ugp.aeo.qa:443/public/order/split/" + orderId + "\" } ], \"message\": { \"collectionSize\": 1, \"customerOrder\": [ { \"sddorderDetails\": null, \"orderType\": \"SALE\", \"shippingSpeed\": \"Standard (3-6 Business Days)\", \"ticketNumber\": null, \"externalRefId\": null, \"sourceLocId\": null, \"destinationLocId\": null, \"customerOrderId\": \"0001325862\", \"orderStatus\": null, \"carrierServiceCode\": null, \"activityDate\": 1617373364984, \"pin\": null, \"consumerDeliveryDate\": null, \"action\": null, \"partnerID\": null, \"additionalData\": [ { \"value\": \"162.250.148.187\", \"key\": \"ipAddress\" }, { \"value\": null, \"key\": \"deviceData\" }, { \"value\": \"9cd9fb5a9c345f7b766791920aa88b7a3a3fa203ef8cdcf4bbea47dabbd86e78\", \"key\": \"fraudToken\" }, { \"value\": \"-5\", \"key\": \"orderTimeZone\" }, { \"value\": \"2021-03-31\", \"key\": \"profileRegistrationDate\" } ], \"orderDesc\": null, \"consumerDeliveryTime\": null, \"comments\": null, \"custOrderHeaderDesc\": { \"orderDetails\": { \"headerPromos\": { \"promo\": [ { \"promotionType\": \"SHIPPING_PROMOTION\", \"promotionName\": \"Shipping: Free STD shipping...\", \"promoAmount\": \"0.00\", \"promoComponentDetailId\": null, \"promoCode\": null, \"currencyCode\": null, \"unitPromoAmount\": null, \"promoComponentId\": null } ], \"promoTotal\": null }, \"adjustmentDate\": null, \"headerCharges\": { \"charge\": [ { \"chargePerUnit\": null, \"chargeCategory\": \"SHIPPING_CHARGE\", \"chargeAmount\": \"0.00\", \"chargeName\": \"Shipping_Charge\" } ] }, \"itemsTotalAfterDiscount\": null, \"orderHdrDiscount\": null, \"orderTaxTotal\": null, \"itemDiscountTotal\": null, \"orderTotal\": null, \"itemsTotal\": null, \"orderDiscountTotal\": null, \"chargeTotal\": null, \"currencyCode\": \"USD\", \"headerTaxes\": { \"taxTotal\": null, \"tax\": [ { \"taxPercentage\": null, \"taxAmount\": \"0.00\", \"taxName\": \"Tax\", \"taxCategory\": \"Service_Tax\" } ] } }, \"orderBillingDtls\": { \"customerDtl\": [ { \"loyaltyId\": \"94055491344558\", \"emails\": { \"email\": [ { \"emailAddress\": \"rigru0dn6kjcyewh@aeemailonly.com\", \"emailType\": null, \"primaryEmailInd\": null, \"emailId\": null } ] }, \"loyaltyPts\": null, \"customerType\": null, \"addresses\": { \"address\": [ { \"address2\": null, \"city\": \"Pittsburgh\", \"stateName\": \"PA\", \"addressType\": null, \"address1\": \"123\", \"countryCode\": \"US\", \"postalCode\": \"15203\", \"county\": null, \"zipOnly\": null, \"stateCode\": null, \"neighborhood\": null, \"countryName\": null } ] }, \"profileId\": null, \"customerId\": null, \"customerInfo\": { \"firstName\": \"Maksym\", \"lastName\": \"Maksym\", \"birthDay\": null, \"birthMonth\": null, \"gender\": null, \"birthYear\": null, \"birthDate\": null }, \"phones\": { \"phone\": [ { \"phoneType\": null, \"phoneNumber\": \"14123231313\", \"phoneCountryCode\": null, \"countryCode\": null, \"phoneExtension\": null, \"primaryPhoneInd\": null, \"phoneId\": null } ] } } ] }, \"giftReceiptAssigned\": \"N\", \"paymentMethods\": { \"paymentMethod\": [ { \"amount\": null, \"custBillDtls\": { \"customerDtl\": [ { \"loyaltyId\": null, \"emails\": null, \"loyaltyPts\": null, \"customerType\": null, \"addresses\": { \"address\": [ { \"address2\": null, \"city\": \"Pittsburgh\", \"stateName\": \"PA\", \"addressType\": null, \"address1\": \"123\", \"countryCode\": \"US\", \"postalCode\": \"15203\", \"county\": null, \"zipOnly\": null, \"stateCode\": null, \"neighborhood\": null, \"countryName\": null } ] }, \"profileId\": null, \"customerId\": null, \"customerInfo\": { \"firstName\": \"Maksym\", \"lastName\": \"Maksym\", \"birthDay\": null, \"birthMonth\": null, \"gender\": null, \"birthYear\": null, \"birthDate\": null }, \"phones\": null } ] }, \"seqNo\": 0, \"settlementOrgCode\": null, \"giftCertTender\": null, \"chargeType\": \"AUTHORIZATION\", \"alternateAmount\": null, \"travelCheckTender\": null, \"alternateCurrencyCode\": null, \"giftCardTender\": null, \"afterPayTender\": null, \"ghostRetailTender\": null, \"creditDebitTender\": { \"additionalSecurityInfo\": null, \"accountAprType\": null, \"promotionDuration\": null, \"reportingToken\": null, \"isCardOnFile\": true, \"cardType\": \"VISA\", \"svcno\": null, \"personalIdState\": null, \"accountApr\": null, \"promotionAprType\": null, \"prepaidBalance\": null, \"unlimitedCharges\": \"N\", \"maskedAccountNumber\": \"401200******7777\", \"cardToken\": \"1508372185067777\", \"settlementData\": null, \"signatureData\": [], \"promotionDescription\": null, \"creditCardExpDate\": \"12/2023\", \"authorizationDtls\": [ { \"authAVS\": \"Y\", \"authCode\": \"OK2680\", \"authorizationDateTime\": null, \"authorizationMethod\": null, \"authorizationExpirationDate\": \"2021-05-02T12:19:10\", \"processedAmount\": \"99.90\", \"authorizationID\": \"OK2680\", \"transactionInfo\": \"00^401269^401269 ^OK2680^W011092076255380G139^0012^59^2312^fxresp-i^0^0^*TrnTime-102245^*AvsResp-y^*TrnAmt-9990^*TableVI-VICR__\" } ], \"personalIdExpirationDate\": null, \"maxChargeLimit\": \"99.90\", \"promotionApr\": null, \"entryMethod\": null, \"personalIdCountry\": null }, \"paymentType\": \"CREDIT\", \"paymentGroupId\": \"pg109890414\", \"gatewayIndicator\": \"AJB\", \"checkTender\": null, \"paypalTender\": null, \"digitalWalletTender\": null, \"purchaseOrdTender\": null, \"storeCreditTender\": null, \"currencyCode\": null, \"couponTender\": null } ] }, \"orderDeliveryDtls\": { \"shipToStoreId\": null, \"deliveryMethod\": \"SHP\", \"customerShipDtl\": { \"loyaltyId\": null, \"emails\": null, \"loyaltyPts\": null, \"customerType\": null, \"addresses\": { \"address\": [ { \"address2\": null, \"city\": \"Pittsburgh\", \"stateName\": \"PA\", \"addressType\": \"REGULAR\", \"address1\": \"123\", \"countryCode\": \"US\", \"postalCode\": \"15203\", \"county\": null, \"zipOnly\": null, \"stateCode\": null, \"neighborhood\": null, \"countryName\": null } ] }, \"profileId\": null, \"customerId\": null, \"customerInfo\": { \"firstName\": \"Maksym\", \"lastName\": \"Maksym\", \"birthDay\": null, \"birthMonth\": null, \"gender\": null, \"birthYear\": null, \"birthDate\": null }, \"phones\": null } }, \"custPreference\": { \"receiptPreference\": null, \"contactByEmail\": null, \"localeDesc\": \"en_US\", \"contactByPhone\": null, \"contactByMail\": null }, \"items\": { \"item\": [ { \"color\": \"Acid Wash\", \"capturedLineItemNo\": null, \"lineTaxes\": { \"taxTotal\": null, \"tax\": [ { \"taxPercentage\": null, \"taxAmount\": \"0.00\", \"taxName\": \"Tax\", \"taxCategory\": \"Merchandise_Tax\" } ] }, \"lineItemNo\": 1, \"overriddenPrice\": null, \"lineInstructions\": null, \"commerceItemId\": \"ci85340976\", \"uom\": \"EACH\", \"isReturnMessage\": false, \"reservationId\": \"ci85390103\", \"itemStatus\": null, \"lineType\": null, \"itemDescription\": \"(Clr: US CA INTL) AE Ne(X)t Level Slim Jean\", \"overriddenPriceReason\": null, \"lineAdditionalData\": [ { \"value\": \"61000\", \"key\": \"taxCode\" }, { \"value\": \"011\", \"key\": \"productDepartment\" } ], \"relatedLineItemNo\": null, \"quantity\": 1, \"productClass\": \"GOOD\", \"isCustomized\": null, \"unitSellPrice\": \"49.95\", \"itemDeliveryDtls\": { \"shipToStoreId\": null, \"deliveryMethod\": \"SHP\", \"customerShipDtl\": null }, \"unitRegularPrice\": \"49.95\", \"isReturnable\": true, \"itemId\": \"0027387570\", \"orderDateDtls\": { \"orderDateDtl\": [ { \"dateTypeId\": \"PROMISE_DATE\", \"requestedDate\": \"2021-04-12T17:00:44\" } ] }, \"itemTotal\": null, \"shipLocationId\": null, \"size\": \"28 X 28\", \"lineCharges\": null, \"style\": \"0117-4318\", \"linePromos\": null, \"giftWrap\": null, \"productURL\": \"sit.aezone.com/us/en/p/0117_4318_764\" }, { \"color\": \"Acid Wash\", \"capturedLineItemNo\": null, \"lineTaxes\": { \"taxTotal\": null, \"tax\": [ { \"taxPercentage\": null, \"taxAmount\": \"0.00\", \"taxName\": \"Tax\", \"taxCategory\": \"Merchandise_Tax\" } ] }, \"lineItemNo\": 2, \"overriddenPrice\": null, \"lineInstructions\": null, \"commerceItemId\": \"ci85340977\", \"uom\": \"EACH\", \"isReturnMessage\": false, \"reservationId\": \"ci85390103\", \"itemStatus\": null, \"lineType\": null, \"itemDescription\": \"(Clr: US CA INTL) AE Ne(X)t Level Slim Jean\", \"overriddenPriceReason\": null, \"lineAdditionalData\": [ { \"value\": \"61000\", \"key\": \"taxCode\" }, { \"value\": \"011\", \"key\": \"productDepartment\" } ], \"relatedLineItemNo\": null, \"quantity\": 1, \"productClass\": \"GOOD\", \"isCustomized\": null, \"unitSellPrice\": \"49.95\", \"itemDeliveryDtls\": { \"shipToStoreId\": null, \"deliveryMethod\": \"SHP\", \"customerShipDtl\": null }, \"unitRegularPrice\": \"49.95\", \"isReturnable\": true, \"itemId\": \"0027387570\", \"orderDateDtls\": { \"orderDateDtl\": [ { \"dateTypeId\": \"PROMISE_DATE\", \"requestedDate\": \"2021-04-12T17:00:44\" } ] }, \"itemTotal\": null, \"shipLocationId\": null, \"size\": \"28 X 28\", \"lineCharges\": null, \"style\": \"0117-4318\", \"linePromos\": null, \"giftWrap\": null, \"productURL\": \"sit.aezone.com/us/en/p/0117_4318_764\" } ], \"lineCollectionSize\": 2 }, \"shipments\": null, \"paymentStatus\": \"AUTHORIZED\", \"headerInstructions\": null }, \"sourceCountryCode\": \"AEO_USA\", \"carrierCode\": \"STD\", \"sourceLocType\": \"WEB\", \"destinationLocType\": null, \"sourceWebStoreId\": \"02953\" } ], \"header\": { \"channel\": \"WEB\", \"messageId\": \"" + orderId + "\", \"sourceApplicationVersion\": null, \"eventType\": null, \"additionalData\": [], \"sourceApplication\": \"ATG\", \"userId\": \"ugp1140903072\", \"businessUnitId\": null, \"touchPointId\": null, \"timestamp\": 1617380350645 } } }";
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
