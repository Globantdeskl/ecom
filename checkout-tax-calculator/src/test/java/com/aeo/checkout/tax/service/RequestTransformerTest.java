package com.aeo.checkout.tax.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.aeo.checkout.tax.config.VertexConfig;
import com.aeo.checkout.tax.model.CalculateRequest;
import com.aeo.checkout.tax.model.TaxableItem;
import com.aeo.checkout.tax.service.exception.VertexAddressException;
import com.aeo.checkout.tax.service.exception.VertexException;
import com.aeo.checkout.tax.service.tools.TransformerTools;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import aeo.integration.vertex.client.LineItemQSIType;
import aeo.integration.vertex.client.QuotationRequestType;

public class RequestTransformerTest {
	
	private RequestTransformer requestTransformer;
	
	@Mock
	private TransformerTools tools;
	
	@BeforeEach
	void setup() throws VertexException, DatatypeConfigurationException {
		MockitoAnnotations.initMocks(this);
		Mockito.when(tools.getXmlDate(ArgumentMatchers.any(CalculateRequest.class)))
			.thenReturn(DatatypeFactory.newInstance().newXMLGregorianCalendar());
		Mockito.when(tools.roundBD(ArgumentMatchers.anyDouble())).thenCallRealMethod();
		Mockito.when(tools.round(ArgumentMatchers.anyDouble())).thenCallRealMethod();
		requestTransformer = new RequestTransformer(tools);
	}
	
	@Test
	void testCreateVertexRequest() throws VertexException, VertexAddressException {
		QuotationRequestType reqUS = requestTransformer.createVertexRequest(mockCalculateRequestUS());
		assertNotNull(reqUS);
		assertNotNull(reqUS.getLineItem());
		assertEquals(2, reqUS.getLineItem().size());
		assertEquals(VertexConfig.US_DIVISION, reqUS.getSeller().getDivision());
		
		QuotationRequestType reqCA = requestTransformer.createVertexRequest(mockCalculateRequestCanada());
		assertNotNull(reqCA);
		assertNotNull(reqCA.getLineItem());
		assertEquals(2, reqCA.getLineItem().size());
		assertEquals(VertexConfig.CA_DIVISION, reqCA.getSeller().getDivision());
		
		QuotationRequestType reqMIL = requestTransformer.createVertexRequest(mockCalculateRequestMilitary());
		assertNotNull(reqMIL);
		assertNotNull(reqMIL.getLineItem());
		assertEquals(2, reqMIL.getLineItem().size());
		assertEquals(VertexConfig.US_DIVISION, reqMIL.getSeller().getDivision());
		assertEquals("US", reqMIL.getCustomer().getDestination().getCountry());
	}
	
	@Test
	void testInvalidRequest() throws VertexAddressException {
		Mockito.doThrow(VertexAddressException.class).when(tools)
			.validCalculateRequest(ArgumentMatchers.any(CalculateRequest.class));
		assertThrows(VertexAddressException.class, 
				() -> requestTransformer.createVertexRequest(mockCalculateRequestUS()));
	}
	
	@Test
	void testOrderDiscountProration() throws JsonMappingException, JsonProcessingException, VertexException, VertexAddressException {
		
		CalculateRequest request = mockRequestWithOrderDiscounts();
		QuotationRequestType xml = requestTransformer.createVertexRequest(request);
		assertNotNull(xml);
		
		TaxableItem item1 = request.getTaxableItems().stream()
				.filter(item -> item.getCommerceItemId().equals("testCommerceItemId01"))
				.findFirst().get();
		TaxableItem item2 = request.getTaxableItems().stream()
				.filter(item -> item.getCommerceItemId().equals("testCommerceItemId02"))
				.findFirst().get();
		assertFalse(item1.getDiscounts().isEmpty());
		assertFalse(item2.getDiscounts().isEmpty());
		
		assertEquals(30.00d, request.getOrderDiscountAmounts().get(0));
		assertEquals(107.91d, item1.getAmount());
		assertEquals(112.39d, item2.getAmount());
		// confirm prorated discounts were applied to the items from passed order discounts
		assertEquals(14.69d, item1.getDiscounts().get(0));
		assertEquals(15.31d, item2.getDiscounts().get(0));
		
		LineItemQSIType xItem1 = xml.getLineItem().stream()
			.filter(item -> item.getLineItemId().equals("testCommerceItemId01"))
			.findFirst().get();
		LineItemQSIType xItem2 = xml.getLineItem().stream()
				.filter(item -> item.getLineItemId().equals("testCommerceItemId02"))
				.findFirst().get();
		// confirm discounts were subtracted from item amount
		assertEquals(93.22d, xItem1.getExtendedPrice().doubleValue());
		assertEquals(97.08d, xItem2.getExtendedPrice().doubleValue());
	}
	
	@Test
	void testOrderDiscountProrationWithNonTaxableItems() throws JsonMappingException, JsonProcessingException, VertexException, VertexAddressException {
		
		CalculateRequest request = mockRequestWithOrderDiscountsAndNonTaxableItems();
		QuotationRequestType xml = requestTransformer.createVertexRequest(request);
		assertNotNull(xml);
		
		assertEquals(35.00d, request.getOrderDiscountAmounts().stream().reduce(0d, Double::sum));
		
		LineItemQSIType regularItem = xml.getLineItem().stream()
				.filter(item -> item.getLineItemId().equals("ci80372125"))
				.findFirst().get();
		LineItemQSIType gwpItem = xml.getLineItem().stream()
				.filter(item -> item.getLineItemId().equals("ci80372126"))
				.findFirst().get();
		LineItemQSIType nonTaxableItem = xml.getLineItem().stream()
				.filter(item -> item.getLineItemId().equals("ci80372148"))
				.findFirst().get();
		LineItemQSIType gcItem = xml.getLineItem().stream()
				.filter(item -> item.getLineItemId().equals("ci80372151"))
				.findFirst().get();
		// confirm discounts were only prorated to the taxable item
		assertEquals(51.18d, regularItem.getExtendedPrice().doubleValue()); // amount = 86.18d - 35.00d
		assertEquals(0.00d, gwpItem.getExtendedPrice().doubleValue());
		assertEquals(1.00d, nonTaxableItem.getExtendedPrice().doubleValue());
		assertEquals(50.00d, gcItem.getExtendedPrice().doubleValue());
	}
	
	private CalculateRequest mockCalculateRequestUS() {
		CalculateRequest req = new CalculateRequest();
		
		req.setOrderId("mockOrderIdUS");
		req.setCurrencyCode("USD");
		req.setAddressLine1("Some Street Address");
		req.setAddressLine2("Apt 0");
		req.setCity("Mock");
		req.setCountry("US");
		req.setState("XX");
		req.setPostalCode("00000");
		req.setShippingGroupId("mockShippingGroupId");
		
		TaxableItem item = new TaxableItem();
		item.setCommerceItemId("mockCommerceItemId");
		item.setSkuId("0021765045");
		item.setQuantity(1);
		item.setTaxCode("89998");
		item.setAmount(50.00);
		
		List<TaxableItem> items = new ArrayList<>();
		items.add(item);
		req.setTaxableItems(items);
		
		return req;
	}
	
	private CalculateRequest mockCalculateRequestCanada() {
		CalculateRequest req = mockCalculateRequestUS();
		req.setOrderId("mockOrderIdCA");
		req.setCurrencyCode("CAD");
		req.setCountry("CA");
		return req;
	}
	
	private CalculateRequest mockCalculateRequestMilitary() {
		CalculateRequest req = mockCalculateRequestUS();
		req.setOrderId("mockOrderIdMIL");
		req.setCurrencyCode("USD");
		req.setCountry("APO/FPO/DPO");
		return req;
	}
	
	private CalculateRequest mockRequestWithOrderDiscounts() throws JsonMappingException, JsonProcessingException {
		String orderJson = "{\"serviceUrl\":null,\"orderId\":\"testTaxesOrderId01\",\"taxDate\":null,\"currencyCode\":\"USD\",\"addressLine1\":\"49 Stevenson Street\",\"addressLine2\":\"Suite 10\",\"city\":\"San Francisco\",\"state\":\"CA\",\"country\":\"US\",\"postalCode\":\"94105\",\"shippingGroupId\":\"testShippingGroupId\",\"shippingCost\":7,\"orderDiscountAmounts\":[30.00],\"taxableItems\":[{\"skuId\":\"0027381086\",\"taxCode\":\"89998\",\"quantity\":3,\"commerceItemId\":\"testCommerceItemId01\",\"amount\":107.91},{\"skuId\":\"0027405497\",\"taxCode\":\"89998\",\"quantity\":3,\"commerceItemId\":\"testCommerceItemId02\",\"amount\":112.39}]}";
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.readValue(orderJson, CalculateRequest.class);
	}
	
	private CalculateRequest mockRequestWithOrderDiscountsAndNonTaxableItems() throws JsonMappingException, JsonProcessingException {
		String orderJson = "{\"addressLine1\":\"250 E PALM DR\",\"addressLine2\":\"STE 247\",\"city\":\"FLORIDA CITY\",\"postalCode\":\"33034\",\"country\":\"US\",\"currencyCode\":\"USD\",\"orderId\":\"o730330574398\",\"state\":\"FL\",\"shippingCost\":0,\"taxDate\":\"2021-02-04T15:07:57.507Z\",\"orderDiscountAmounts\":[10,10,15],\"taxableItems\":[{\"amount\":86.18,\"quantity\":8,\"commerceItemId\":\"ci80372125\",\"skuId\":\"0027592625\",\"taxCode\":\"61000\"},{\"amount\":0,\"quantity\":1,\"commerceItemId\":\"ci80372126\",\"skuId\":\"0026836932\",\"taxCode\":\"89998\"},{\"amount\":1,\"quantity\":1,\"commerceItemId\":\"ci80372148\",\"skuId\":\"0031594161\",\"taxCode\":\"89999\"},{\"amount\":50,\"quantity\":1,\"commerceItemId\":\"ci80372151\",\"skuId\":\"0012345678\",\"taxCode\":\"61900\"}]}";
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.readValue(orderJson, CalculateRequest.class);
	}
	
}
