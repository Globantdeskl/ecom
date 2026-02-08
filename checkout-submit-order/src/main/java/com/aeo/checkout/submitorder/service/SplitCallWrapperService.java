package com.aeo.checkout.submitorder.service;

import com.aeo.checkout.submitorder.config.APISGCircuitBreakerConfig;
import com.aeo.checkout.submitorder.config.ApplicationConfigs;
import com.aeo.checkout.submitorder.model.atg.ATGResponse;
import com.aeo.logging.CommonKeys;
import com.aeo.postcheckout.model.order.ATGOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static net.logstash.logback.argument.StructuredArguments.v;

@Slf4j
@Service
public class SplitCallWrapperService implements APISGCircuitBreakerConfig {
	
	private final ATGSplitOrderService atgSplitOrderService;
	private final ApplicationConfigs configs;
	private final ObjectMapper mapper;

	public SplitCallWrapperService(ATGSplitOrderService atgSplitOrderService,
								   ApplicationConfigs configs,
								   ObjectMapper mapper) {
		this.atgSplitOrderService = atgSplitOrderService;
		this.configs = configs;
		this.mapper = mapper;
	}
	
	@HystrixCommand(groupKey = GROUP_KEY_NAME, commandKey = COMMAND_KEY_NAME, fallbackMethod = "fallback")
	public Optional<ATGOrder> call(String orderId) {
		
		if(!configs.isSplitCallEnabled()) {
			return disabledResponse(orderId);
		}
		
		String endpoint = String.format(configs.getSplitCallEndpoint(), orderId);
		
		log.debug("SplitOrder :: APISG Circuit {} for call {} :: {}",
				v(STATE_LOG_KEY, APISGCircuitBreakerConfig.findCircuitBreakerState()), 
				v("target_endpoint", endpoint),
				v(CommonKeys.ORDER_ID.key(), orderId));

		ResponseEntity<ATGResponse> response = atgSplitOrderService.splitCall(endpoint, orderId);

		ATGResponse responseBody = response.getBody();

		log.debug("SplitOrder :: ATG response for {} {}", v(CommonKeys.ORDER_ID.key(), orderId), response.toString());

		if(!orderExists(responseBody)) {
			log.error("SplitOrder :: ATG Returned empty body for split order : {}", v(CommonKeys.ORDER_ID.key(), orderId));
			return Optional.empty();
		} else {
			return Optional.of(responseBody.fetchOrder());
		}
	}

	public Optional<ATGOrder> fallback(String orderId) {
		log.error("SplitOrder :: APISG Circuit {} for {}",
				v(STATE_LOG_KEY, APISGCircuitBreakerConfig.findCircuitBreakerState()),
				v(CommonKeys.ORDER_ID.key(), orderId));
		return Optional.empty();
	}
	
	private Optional<ATGOrder> disabledResponse(String orderId) {
		log.warn("SplitOrder :: Disabled :: {}", v(CommonKeys.ORDER_ID.key(), orderId));
		return Optional.of(createMockATGResponse(orderId, mapper).getMessage());
	}
	
	private boolean orderExists(ATGResponse response) {
		return response != null && !response.hasError() && response.hasOrder();
	}
	
	protected static ATGResponse createMockATGResponse(String orderId, ObjectMapper mapper) {
		String jsonResp = "{ \"links\": [ { \"method\": \"GET\", \"rel\": \"self\", \"href\": \"https://sit-txn.ugp.aeo.qa:443/public/order/split/" + orderId + "\" }, { \"method\": \"GET\", \"rel\": \"canonical\", \"href\": \"https://sit-txn.ugp.aeo.qa:443/public/order/split/" + orderId + "\" } ], \"message\": { \"collectionSize\": 1, \"customerOrder\": [ { \"sddorderDetails\": null, \"orderType\": \"SALE\", \"shippingSpeed\": \"Standard (3-6 Business Days)\", \"ticketNumber\": null, \"externalRefId\": null, \"sourceLocId\": null, \"destinationLocId\": null, \"customerOrderId\": \"0001325862\", \"orderStatus\": null, \"carrierServiceCode\": null, \"activityDate\": 1617373364984, \"pin\": null, \"consumerDeliveryDate\": null, \"action\": null, \"partnerID\": null, \"additionalData\": [ { \"value\": \"162.250.148.187\", \"key\": \"ipAddress\" }, { \"value\": null, \"key\": \"deviceData\" }, { \"value\": \"9cd9fb5a9c345f7b766791920aa88b7a3a3fa203ef8cdcf4bbea47dabbd86e78\", \"key\": \"fraudToken\" }, { \"value\": \"-5\", \"key\": \"orderTimeZone\" }, { \"value\": \"2021-03-31\", \"key\": \"profileRegistrationDate\" } ], \"orderDesc\": null, \"consumerDeliveryTime\": null, \"comments\": null, \"custOrderHeaderDesc\": { \"orderDetails\": { \"headerPromos\": { \"promo\": [ { \"promotionType\": \"SHIPPING_PROMOTION\", \"promotionName\": \"Shipping: Free STD shipping...\", \"promoAmount\": \"0.00\", \"promoComponentDetailId\": null, \"promoCode\": null, \"currencyCode\": null, \"unitPromoAmount\": null, \"promoComponentId\": null } ], \"promoTotal\": null }, \"adjustmentDate\": null, \"headerCharges\": { \"charge\": [ { \"chargePerUnit\": null, \"chargeCategory\": \"SHIPPING_CHARGE\", \"chargeAmount\": \"0.00\", \"chargeName\": \"Shipping_Charge\" } ] }, \"itemsTotalAfterDiscount\": null, \"orderHdrDiscount\": null, \"orderTaxTotal\": null, \"itemDiscountTotal\": null, \"orderTotal\": null, \"itemsTotal\": null, \"orderDiscountTotal\": null, \"chargeTotal\": null, \"currencyCode\": \"USD\", \"headerTaxes\": { \"taxTotal\": null, \"tax\": [ { \"taxPercentage\": null, \"taxAmount\": \"0.00\", \"taxName\": \"Tax\", \"taxCategory\": \"Service_Tax\" } ] } }, \"orderBillingDtls\": { \"customerDtl\": [ { \"loyaltyId\": \"94055491344558\", \"emails\": { \"email\": [ { \"emailAddress\": \"rigru0dn6kjcyewh@aeemailonly.com\", \"emailType\": null, \"primaryEmailInd\": null, \"emailId\": null } ] }, \"loyaltyPts\": null, \"customerType\": null, \"addresses\": { \"address\": [ { \"address2\": null, \"city\": \"Pittsburgh\", \"stateName\": \"PA\", \"addressType\": null, \"address1\": \"123\", \"countryCode\": \"US\", \"postalCode\": \"15203\", \"county\": null, \"zipOnly\": null, \"stateCode\": null, \"neighborhood\": null, \"countryName\": null } ] }, \"profileId\": null, \"customerId\": null, \"customerInfo\": { \"firstName\": \"Maksym\", \"lastName\": \"Maksym\", \"birthDay\": null, \"birthMonth\": null, \"gender\": null, \"birthYear\": null, \"birthDate\": null }, \"phones\": { \"phone\": [ { \"phoneType\": null, \"phoneNumber\": \"14123231313\", \"phoneCountryCode\": null, \"countryCode\": null, \"phoneExtension\": null, \"primaryPhoneInd\": null, \"phoneId\": null } ] } } ] }, \"giftReceiptAssigned\": \"N\", \"paymentMethods\": { \"paymentMethod\": [ { \"amount\": null, \"custBillDtls\": { \"customerDtl\": [ { \"loyaltyId\": null, \"emails\": null, \"loyaltyPts\": null, \"customerType\": null, \"addresses\": { \"address\": [ { \"address2\": null, \"city\": \"Pittsburgh\", \"stateName\": \"PA\", \"addressType\": null, \"address1\": \"123\", \"countryCode\": \"US\", \"postalCode\": \"15203\", \"county\": null, \"zipOnly\": null, \"stateCode\": null, \"neighborhood\": null, \"countryName\": null } ] }, \"profileId\": null, \"customerId\": null, \"customerInfo\": { \"firstName\": \"Maksym\", \"lastName\": \"Maksym\", \"birthDay\": null, \"birthMonth\": null, \"gender\": null, \"birthYear\": null, \"birthDate\": null }, \"phones\": null } ] }, \"seqNo\": 0, \"settlementOrgCode\": null, \"giftCertTender\": null, \"chargeType\": \"AUTHORIZATION\", \"alternateAmount\": null, \"travelCheckTender\": null, \"alternateCurrencyCode\": null, \"giftCardTender\": null, \"afterPayTender\": null, \"ghostRetailTender\": null, \"creditDebitTender\": { \"additionalSecurityInfo\": null, \"accountAprType\": null, \"promotionDuration\": null, \"reportingToken\": null, \"isCardOnFile\": true, \"cardType\": \"VISA\", \"svcno\": null, \"personalIdState\": null, \"accountApr\": null, \"promotionAprType\": null, \"prepaidBalance\": null, \"unlimitedCharges\": \"N\", \"maskedAccountNumber\": \"401200******7777\", \"cardToken\": \"1508372185067777\", \"settlementData\": null, \"signatureData\": [], \"promotionDescription\": null, \"creditCardExpDate\": \"12/2023\", \"authorizationDtls\": [ { \"authAVS\": \"Y\", \"authCode\": \"OK2680\", \"authorizationDateTime\": null, \"authorizationMethod\": null, \"authorizationExpirationDate\": \"2021-05-02T12:19:10\", \"processedAmount\": \"99.90\", \"authorizationID\": \"OK2680\", \"transactionInfo\": \"00^401269^401269 ^OK2680^W011092076255380G139^0012^59^2312^fxresp-i^0^0^*TrnTime-102245^*AvsResp-y^*TrnAmt-9990^*TableVI-VICR__\" } ], \"personalIdExpirationDate\": null, \"maxChargeLimit\": \"99.90\", \"promotionApr\": null, \"entryMethod\": null, \"personalIdCountry\": null }, \"paymentType\": \"CREDIT\", \"paymentGroupId\": \"pg109890414\", \"gatewayIndicator\": \"AJB\", \"checkTender\": null, \"paypalTender\": null, \"digitalWalletTender\": null, \"purchaseOrdTender\": null, \"storeCreditTender\": null, \"currencyCode\": null, \"couponTender\": null } ] }, \"orderDeliveryDtls\": { \"shipToStoreId\": null, \"deliveryMethod\": \"SHP\", \"customerShipDtl\": { \"loyaltyId\": null, \"emails\": null, \"loyaltyPts\": null, \"customerType\": null, \"addresses\": { \"address\": [ { \"address2\": null, \"city\": \"Pittsburgh\", \"stateName\": \"PA\", \"addressType\": \"REGULAR\", \"address1\": \"123\", \"countryCode\": \"US\", \"postalCode\": \"15203\", \"county\": null, \"zipOnly\": null, \"stateCode\": null, \"neighborhood\": null, \"countryName\": null } ] }, \"profileId\": null, \"customerId\": null, \"customerInfo\": { \"firstName\": \"Maksym\", \"lastName\": \"Maksym\", \"birthDay\": null, \"birthMonth\": null, \"gender\": null, \"birthYear\": null, \"birthDate\": null }, \"phones\": null } }, \"custPreference\": { \"receiptPreference\": null, \"contactByEmail\": null, \"localeDesc\": \"en_US\", \"contactByPhone\": null, \"contactByMail\": null }, \"items\": { \"item\": [ { \"color\": \"Acid Wash\", \"capturedLineItemNo\": null, \"lineTaxes\": { \"taxTotal\": null, \"tax\": [ { \"taxPercentage\": null, \"taxAmount\": \"0.00\", \"taxName\": \"Tax\", \"taxCategory\": \"Merchandise_Tax\" } ] }, \"lineItemNo\": 1, \"overriddenPrice\": null, \"lineInstructions\": null, \"commerceItemId\": \"ci85340976\", \"uom\": \"EACH\", \"isReturnMessage\": false, \"reservationId\": \"ci85390103\", \"itemStatus\": null, \"lineType\": null, \"itemDescription\": \"(Clr: US CA INTL) AE Ne(X)t Level Slim Jean\", \"overriddenPriceReason\": null, \"lineAdditionalData\": [ { \"value\": \"61000\", \"key\": \"taxCode\" }, { \"value\": \"011\", \"key\": \"productDepartment\" } ], \"relatedLineItemNo\": null, \"quantity\": 1, \"productClass\": \"GOOD\", \"isCustomized\": null, \"unitSellPrice\": \"49.95\", \"itemDeliveryDtls\": { \"shipToStoreId\": null, \"deliveryMethod\": \"SHP\", \"customerShipDtl\": null }, \"unitRegularPrice\": \"49.95\", \"isReturnable\": true, \"itemId\": \"0027387570\", \"orderDateDtls\": { \"orderDateDtl\": [ { \"dateTypeId\": \"PROMISE_DATE\", \"requestedDate\": \"2021-04-12T17:00:44\" } ] }, \"itemTotal\": null, \"shipLocationId\": null, \"size\": \"28 X 28\", \"lineCharges\": null, \"style\": \"0117-4318\", \"linePromos\": null, \"giftWrap\": null, \"productURL\": \"sit.aezone.com/us/en/p/0117_4318_764\" }, { \"color\": \"Acid Wash\", \"capturedLineItemNo\": null, \"lineTaxes\": { \"taxTotal\": null, \"tax\": [ { \"taxPercentage\": null, \"taxAmount\": \"0.00\", \"taxName\": \"Tax\", \"taxCategory\": \"Merchandise_Tax\" } ] }, \"lineItemNo\": 2, \"overriddenPrice\": null, \"lineInstructions\": null, \"commerceItemId\": \"ci85340977\", \"uom\": \"EACH\", \"isReturnMessage\": false, \"reservationId\": \"ci85390103\", \"itemStatus\": null, \"lineType\": null, \"itemDescription\": \"(Clr: US CA INTL) AE Ne(X)t Level Slim Jean\", \"overriddenPriceReason\": null, \"lineAdditionalData\": [ { \"value\": \"61000\", \"key\": \"taxCode\" }, { \"value\": \"011\", \"key\": \"productDepartment\" } ], \"relatedLineItemNo\": null, \"quantity\": 1, \"productClass\": \"GOOD\", \"isCustomized\": null, \"unitSellPrice\": \"49.95\", \"itemDeliveryDtls\": { \"shipToStoreId\": null, \"deliveryMethod\": \"SHP\", \"customerShipDtl\": null }, \"unitRegularPrice\": \"49.95\", \"isReturnable\": true, \"itemId\": \"0027387570\", \"orderDateDtls\": { \"orderDateDtl\": [ { \"dateTypeId\": \"PROMISE_DATE\", \"requestedDate\": \"2021-04-12T17:00:44\" } ] }, \"itemTotal\": null, \"shipLocationId\": null, \"size\": \"28 X 28\", \"lineCharges\": null, \"style\": \"0117-4318\", \"linePromos\": null, \"giftWrap\": null, \"productURL\": \"sit.aezone.com/us/en/p/0117_4318_764\" } ], \"lineCollectionSize\": 2 }, \"shipments\": null, \"paymentStatus\": \"AUTHORIZED\", \"headerInstructions\": null }, \"sourceCountryCode\": \"AEO_USA\", \"carrierCode\": \"STD\", \"sourceLocType\": \"WEB\", \"destinationLocType\": null, \"sourceWebStoreId\": \"02953\" } ], \"header\": { \"channel\": \"WEB\", \"messageId\": \"" + orderId + "\", \"sourceApplicationVersion\": null, \"eventType\": null, \"additionalData\": [], \"sourceApplication\": \"ATG\", \"userId\": \"ugp1140903072\", \"businessUnitId\": null, \"touchPointId\": null, \"timestamp\": 1617380350645 } } }";
		try {
			return mapper.readValue(jsonResp, ATGResponse.class);
		} catch (JsonProcessingException e) {
			log.error("createMockATGResponse failed for {}", v(CommonKeys.ORDER_ID.key(), orderId), e);
			return new ATGResponse();
		}
	}

}
