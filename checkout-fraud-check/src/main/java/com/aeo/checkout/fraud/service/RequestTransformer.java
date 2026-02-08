package com.aeo.checkout.fraud.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.aeo.checkout.fraud.config.FraudConfig;
import com.aeo.checkout.fraud.config.FraudConfig.RequestTypeToOriginOfOrder;
import com.aeo.checkout.fraud.config.FraudConfig.SiteToClientId;
import com.aeo.checkout.fraud.model.FraudRequest;
import com.aeo.checkout.fraud.model.FraudTokenRequest;
import com.aeo.checkout.fraud.model.aci.ACIConstants;
import com.aeo.checkout.fraud.model.aci.ACIException;
import com.aeo.checkout.fraud.model.aci.LPTransactionProperty;
import com.aeo.checkout.fraud.service.tools.FraudRequestDataPopulator;
import com.aeo.checkout.fraud.service.tools.RequestItemDataPopulator;
import com.aeo.checkout.fraud.service.tools.TransformerUtils;
import com.liveprocessor.LPClient.LPTransaction;
import com.newrelic.api.agent.Trace;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RequestTransformer {
	
	private FraudConfig config;

	public RequestTransformer(FraudConfig config) {
		this.config = config;
	}

	@Trace
	public Optional<LPTransaction> createTokenRequest(FraudTokenRequest request) {
		if(request == null) {
			return Optional.empty();
		}
		Map<String, String> transactionPropertyMap = populateTokenRequest(request);
		LPTransaction transaction = createLPTransaction(transactionPropertyMap);
		logLPTransactionRequest(transaction);
		return Optional.of(transaction);
	}

	@Trace
	public Optional<LPTransaction> createQuotationRequest(FraudRequest request) throws ACIException {
		if(request == null) {
			return Optional.empty();
		}
		validateCreditCardToken(request);
		Map<String, String> transactionPropertyMap = populateQuotationRequest(request);
		LPTransaction transaction = createLPTransaction(transactionPropertyMap);
		logLPTransactionRequest(transaction);
		return Optional.of(transaction);
	}

	private Map<String, String> populateTokenRequest(FraudTokenRequest tokenRequest) {

		Map<LPTransactionProperty, String> requestMap = new EnumMap<>(LPTransactionProperty.class);

		requestMap.put(LPTransactionProperty.DIV_NUM, config.getDivisionNumber());
		requestMap.put(LPTransactionProperty.S_KEY_ID, config.getSslKeyId());
		requestMap.put(LPTransactionProperty.ACT_CD, ACIConstants.ActionCode.GET_TOKEN.code());
		
		requestMap.put(LPTransactionProperty.ACCT_NUM, tokenRequest.getCardNumber());
		requestMap.put(LPTransactionProperty.CARD_EXP_DT, 
				TransformerUtils.formatExpirationDate(tokenRequest.getCardExpDate()));
		if (TransformerUtils.isNotBlank(tokenRequest.getOrderId())) {
			requestMap.put(LPTransactionProperty.ORD_ID, tokenRequest.getOrderId());
		} else {
			requestMap.put(LPTransactionProperty.ORD_ID, Long.toString(System.currentTimeMillis()));
		}
		
		return requestMap.entrySet().stream()
				.filter(e -> e.getValue() != null)
				.collect(Collectors.toMap(e -> e.getKey().name(), e -> e.getValue()));
	}
	
	private void validateCreditCardToken(FraudRequest request) throws ACIException {
		boolean hasCCWithoutToken = request.getPaymentMethods().stream()
			.filter(pm -> pm.getCreditDebitTender() != null)
			.map(pm -> pm.getCreditDebitTender())
			.anyMatch(cc -> TransformerUtils.isBlank(cc.getFraudToken()));
		if(hasCCWithoutToken) {
			throw new ACIException("Fraud Token not Found: " + request.getOrderId());
		}
	}
	
	private Map<String, String> populateQuotationRequest(FraudRequest request) throws ACIException {

		Map<LPTransactionProperty, String> requestMap = new EnumMap<>(LPTransactionProperty.class);

		// populate RedACI configuration attributes
		populateCommonFields(request, requestMap);
		
		List<Map<LPTransactionProperty, String>> itemList = new ArrayList<>();
		for(FraudRequestDataPopulator dataPopulator : config.getRequestDataPopulators()) {
			if(dataPopulator.returnsItems()) {
				itemList = ((RequestItemDataPopulator) dataPopulator).populateAndGetItemData(request, requestMap);
				continue;
			}
			dataPopulator.populate(request, requestMap);
		}
		
		// convert request map keys from LPTransactionProperty to String
		Map<String, String> stringRequestMap = new HashMap<>();
		TransformerUtils.fillAndTruncateRedACIRequestFields(requestMap, stringRequestMap, null);

		// merge itemList maps into stringRequestMap, adding counter to keys
		for (int i = 0; i < itemList.size(); i++) {
			TransformerUtils.fillAndTruncateRedACIRequestFields(
					itemList.get(i), stringRequestMap, Integer.toString(i + 1));
		}

		// filter out null values from the map
		stringRequestMap = stringRequestMap.entrySet().stream()
				.filter(e -> e.getValue() != null)
				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

		// report required fields
		List<String> missingRequiredFields = new ArrayList<>();
		for (String key : ACIConstants.REQUIRED_REQUEST_FIELDS) {
			if (TransformerUtils.isBlank(stringRequestMap.get(key))) {
				missingRequiredFields.add(key);
			}
		}
		if (!missingRequiredFields.isEmpty()) {
			log.warn("Missing Required Fields for order {}: {}", 
					request.getOrderId(), missingRequiredFields.toString());
		}

		return stringRequestMap;
	}
	
	private void populateCommonFields(FraudRequest order, Map<LPTransactionProperty, String> requestMap) {
		
		Optional<RequestTypeToOriginOfOrder> optRequestType = Arrays.asList(
				RequestTypeToOriginOfOrder.values()).stream()
				.filter(rtoo -> rtoo.origins().contains(order.getCustomerOrder().getChannel()))
				.findFirst();
		
		String requestType = optRequestType.isPresent() ? 
				optRequestType.get().name() : ACIConstants.REQUEST_TYPE_ECOMMERCE;
				
		Optional<SiteToClientId> optClientId = Arrays.asList(SiteToClientId.values()).stream()
				.filter(sci -> sci.country()
						.equalsIgnoreCase(order.getCustomerShippingDetail().getAddress().getCountryCode()))
				.findFirst();
		
		SiteToClientId clientIdConfig = optClientId.isPresent() ? optClientId.get() : SiteToClientId.AEO_INTL;
		
		String clientId = order.getOrderMetaData().isBopisOrder() ? 
				clientIdConfig.bopisClientId() : clientIdConfig.clientId();
		
		requestMap.put(LPTransactionProperty.REQ_TYPE_CD, requestType);
		requestMap.put(LPTransactionProperty.ACT_CD, ACIConstants.ActionCode.FRAUD_CHECK_ONLY.code());
		requestMap.put(LPTransactionProperty.DIV_NUM, config.getDivisionNumber());
		requestMap.put(LPTransactionProperty.S_KEY_ID, config.getSslKeyId());
		requestMap.put(LPTransactionProperty.ebWEBSITE, order.getWebsite());
		requestMap.put(LPTransactionProperty.EBT_USER_DATA14, ACIConstants.INSTANCE_TYPE_FRAUD_CHECK_APP);
		requestMap.put(LPTransactionProperty.EBT_Name, clientId);
		requestMap.put(LPTransactionProperty.ORD_TZ, order.getOrderTimeZone());
	}
	
	private LPTransaction createLPTransaction(Map<String, String> requestMap) {
		LPTransaction transaction = new LPTransaction();
		for (Map.Entry<String, String> entry : requestMap.entrySet()) {
			transaction.setField(entry.getKey(), entry.getValue());
		}
		return transaction;
	}
	
	private void logLPTransactionRequest(LPTransaction transaction) {
		StringBuilder sb = new StringBuilder();
		for (LPTransactionProperty property : LPTransactionProperty.requestProperties) {
			String value = transaction.getField(property.name());
			if (TransformerUtils.isNotBlank(value)) {
				if(sb.toString().isEmpty()) {
					sb.append(property.toString()).append(": ").append(value);
				} else {
					sb.append(", ").append(property.toString()).append(": ").append(value);
				}
			}
		}
		appendItemsToLog(sb, transaction);
		log.debug("RedACI Request: " + sb.toString());
	}
	
	private void appendItemsToLog(StringBuilder sb, LPTransaction transaction) {
		String itemCountString = transaction.getField(LPTransactionProperty.OI_REPEAT.name());
		if (TransformerUtils.isNotBlank(itemCountString)) {
			int itemCount = Integer.parseInt(itemCountString);
			for (int i = 0; i < itemCount; i++) {
				for (String itemRequestField : ACIConstants.ITEM_REQUEST_FIELDS) {
					String value = transaction.getField(itemRequestField + (i + 1));
					if (TransformerUtils.isNotBlank(value)) {
						sb.append(", [").append((i + 1)).append("] ")
							.append(itemRequestField).append(": ").append(value);
					}
				}
			}
		}
	}
	
}
