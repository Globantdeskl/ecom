package com.aeo.checkout.tax.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Service;

import com.aeo.checkout.tax.config.VertexConfig;
import com.aeo.checkout.tax.config.VertexConfig.CalculableCountryCode;
import com.aeo.checkout.tax.model.CalculateRequest;
import com.aeo.checkout.tax.model.TaxCode;
import com.aeo.checkout.tax.model.TaxableItem;
import com.aeo.checkout.tax.service.exception.VertexAddressException;
import com.aeo.checkout.tax.service.exception.VertexException;
import com.aeo.checkout.tax.service.tools.TransformerTools;
import com.newrelic.api.agent.Trace;

import aeo.integration.vertex.client.CurrencyType;
import aeo.integration.vertex.client.CustomerType;
import aeo.integration.vertex.client.LineItemQSIType;
import aeo.integration.vertex.client.LocationType;
import aeo.integration.vertex.client.MeasureType;
import aeo.integration.vertex.client.Product;
import aeo.integration.vertex.client.QuotationRequestType;
import aeo.integration.vertex.client.SaleTransactionType;
import aeo.integration.vertex.client.SellerType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RequestTransformer {
	
	private TransformerTools tools;
	
	public RequestTransformer(TransformerTools tools) {
		this.tools = tools;
	}

	@Trace
	public QuotationRequestType createVertexRequest(CalculateRequest request) 
			throws VertexException, VertexAddressException {
		tools.validCalculateRequest(request);
		return createQuotationRequest(request, tools.getXmlDate(request));
	}
	
	private QuotationRequestType createQuotationRequest(CalculateRequest request, XMLGregorianCalendar date) {
		
		QuotationRequestType quotationRequest = new QuotationRequestType();
		
		quotationRequest.setDocumentDate(date);
		quotationRequest.setDocumentNumber(request.getOrderId());
		quotationRequest.setTransactionType(SaleTransactionType.SALE);

		prorateOrderDiscounts(request);
		createAndSetCurrency(quotationRequest, request.getCurrencyCode());
		createAndSetCustomer(quotationRequest, request);
		createAndSetSeller(quotationRequest, request.getCountry());
		createAndSetLineItems(quotationRequest, request.getTaxableItems(), date);
		createAndSetShippingLineItem(quotationRequest, request, date);

		return quotationRequest;
	}
	
	// temporary process until client can pass discounts[] at item level
	@Deprecated
	private void prorateOrderDiscounts(CalculateRequest request) {
		if(request.getOrderDiscountAmounts().isEmpty()) {
			return;
		}
		
		log.debug("Prorating order discounts for {}", request.getOrderId());
		double total = request.getTaxableItems().stream()
				.filter(includeInProrate())
				.mapToDouble(TaxableItem::getAmount).sum();
		
		request.getTaxableItems().stream()
			.filter(includeInProrate())
			.forEach(item -> {
			
				double prorate = (item.getAmount() / total);
				request.getOrderDiscountAmounts().stream().forEach(discount -> {
				
					double attributedDiscount = tools.round((prorate * discount));
					item.getDiscounts().add(attributedDiscount);
					
					log.debug("Added item discount of {} for {}:{}:{}/{}:{}", 
							attributedDiscount, request.getOrderId(), item.getCommerceItemId(),
							item.getAmount(), tools.round(total), prorate);
			});
		});
	}
	
	private static Predicate<TaxableItem> includeInProrate() {
		return item -> (!TaxCode.DEFAULT_NON_TAXABLE.code().equals(item.getTaxCode())
				&& !TaxCode.GIFT_CARDS.code().equals(item.getTaxCode()));
	}

	private void createAndSetCurrency(QuotationRequestType quotationRequest, String currencyCode) {
		CurrencyType currency = new CurrencyType();
		currency.setIsoCurrencyCodeAlpha(currencyCode);
		quotationRequest.setCurrency(currency);
	}
	
	private void createAndSetCustomer(QuotationRequestType quotationRequest, CalculateRequest request) {

		CustomerType customer = new CustomerType();
		LocationType destination = new LocationType();

		destination.setStreetAddress1(request.getAddressLine1());
		destination.setStreetAddress2(request.getAddressLine2());
		destination.setCity(request.getCity());
		if("APO/FPO/DPO".equalsIgnoreCase(request.getCountry())) {
			destination.setCountry(CalculableCountryCode.US.name());
		} else {
			destination.setCountry(request.getCountry());
		}
		destination.setMainDivision(request.getState());
		destination.setPostalCode(request.getPostalCode());
		
		customer.setDestination(destination);
		quotationRequest.setCustomer(customer);

	}

	private void createAndSetSeller(QuotationRequestType quotationRequest, String country) {
		SellerType seller = new SellerType();
		seller.setCompany(VertexConfig.COMPANY_NAME);
		if(CalculableCountryCode.CA.name().equalsIgnoreCase(country)) {
			seller.setDivision(VertexConfig.CA_DIVISION);
		} else {
			seller.setDivision(VertexConfig.US_DIVISION);
		}
		quotationRequest.setSeller(seller);
	}

	private void createAndSetLineItems(QuotationRequestType quotationRequest, 
			List<TaxableItem> items, XMLGregorianCalendar date) {

		int i = 0;
		for (TaxableItem item : items) {
			
			Product product = new Product();
			product.setValue(item.getSkuId());
			product.setProductClass(item.getTaxCode());

			MeasureType quantity = new MeasureType();
			quantity.setValue(BigDecimal.valueOf(item.getQuantity()));

			LineItemQSIType lineItem = new LineItemQSIType();
			lineItem.setLineItemId(item.getCommerceItemId());
			lineItem.setTaxDate(date);
			lineItem.setLineItemNumber(Long.valueOf(++i));
			lineItem.setProduct(product);
			lineItem.setQuantity(quantity);
			
			double discounts = item.getDiscounts().stream().reduce(0.00d, Double::sum);
			BigDecimal amount = tools.roundBD((item.getAmount() - discounts));
			
			lineItem.setExtendedPrice(amount);
			
			log.debug("Taxable item amount of {} set for {}:{}:{}", amount.doubleValue(), 
					quotationRequest.getDocumentNumber(), item.getCommerceItemId(), item.getAmount());
			
			quotationRequest.getLineItem().add(lineItem);
		}
	}

	private void createAndSetShippingLineItem(QuotationRequestType quotationRequest, 
			CalculateRequest request, XMLGregorianCalendar date) {

		Product product = new Product();
		product.setValue(VertexConfig.SHIPPING_PRD_NAME);
		product.setProductClass(VertexConfig.SHIPPING_TAX_CODE);

		MeasureType quantity = new MeasureType();
		quantity.setValue(BigDecimal.ONE);

		LineItemQSIType lineItem = new LineItemQSIType();
		lineItem.setTaxDate(date);
		lineItem.setLineItemId(request.getShippingGroupId());
		lineItem.setLineItemNumber(Long.valueOf((request.getTaxableItems().size() + 1)));
		lineItem.setProduct(product);
		lineItem.setQuantity(quantity);
		lineItem.setExtendedPrice(tools.roundBD(request.getShippingCost()));
		
		quotationRequest.getLineItem().add(lineItem);
	}
	
}
