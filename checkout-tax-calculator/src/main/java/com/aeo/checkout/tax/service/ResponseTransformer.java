package com.aeo.checkout.tax.service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aeo.checkout.tax.config.VertexConfig;
import com.aeo.checkout.tax.model.CalculateResponse;
import com.aeo.checkout.tax.model.LineItemTaxes;
import com.aeo.checkout.tax.model.OrderTaxes;
import com.aeo.checkout.tax.service.exception.VertexAddressException;
import com.aeo.checkout.tax.service.tools.TransformerTools;
import com.newrelic.api.agent.Trace;

import aeo.integration.vertex.client.JurisdictionLevelCodeType;
import aeo.integration.vertex.client.LineItemQSOType;
import aeo.integration.vertex.client.QuotationResponseType;
import aeo.integration.vertex.client.TaxesType;
import aeo.integration.vertex.client.TaxesType.Imposition;
import aeo.integration.vertex.client.TaxesType.Jurisdiction;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ResponseTransformer {
	
	private enum TaxBucket {
		COUNTRY_TAX,
		STATE_TAX,
		COUNTY_TAX,
		CITY_TAX,
		DISTRICT_TAX,
		MISC_TAX,
		STATE_TAXTYPE,
		COUNTRY_TAXTYPE,
		STATE;
	}
	
	private TransformerTools tools;
	
	public ResponseTransformer(TransformerTools tools) {
		this.tools = tools;
	}
	
	@Trace
	public CalculateResponse createCalculateResponse(QuotationResponseType quotationResponse) {
		CalculateResponse response = new CalculateResponse();
		response.setOrderTaxes(processVertexEnvelopeToTaxStatus(quotationResponse));
		response.setOrderId(quotationResponse.getDocumentNumber());
		return response;
	}
	
	private OrderTaxes processVertexEnvelopeToTaxStatus(QuotationResponseType quotationResponse) {
		
		OrderTaxes taxStatus = new OrderTaxes();
		taxStatus.setTransactionId(quotationResponse.getTransactionId());
		
		// We need total summed taxes for each category on the order level
		double countryTaxSum = 0.0d;
		double stateTaxSum = 0.0d;
		double countyTaxSum = 0.0d;
		double cityTaxSum = 0.0d;
		double districtTaxSum = 0.0d;
		double miscTaxSum = 0.0d;
		boolean isCanada = VertexConfig.CA_DIVISION.equalsIgnoreCase(quotationResponse.getSeller().getDivision());

		// Process line items
		for (LineItemQSOType li : quotationResponse.getLineItem()) {
			LineItemTaxes liTaxStatus = processLineItem(li, isCanada);
			if(VertexConfig.SHIPPING_PRD_NAME.equalsIgnoreCase(li.getProduct().getValue())) {
				taxStatus.setShippingTaxes(liTaxStatus);
			} else {
				taxStatus.getLineItemTaxes().add(liTaxStatus);
			}
			countryTaxSum += liTaxStatus.getCountryTax();
			stateTaxSum += liTaxStatus.getStateTax();
			countyTaxSum += liTaxStatus.getCountyTax();
			cityTaxSum += liTaxStatus.getCityTax();
			districtTaxSum += liTaxStatus.getDistrictTax();
			miscTaxSum += liTaxStatus.getMiscTax();
		}

		// Round summed values, note we cannot have an off by penny scenario
		// here as this rounding is only to ensure there have been no floating
		// point summation issues throughout the process. The most we could be
		// rounding off is extremely fractional pennies.
		double totalCalculated = countryTaxSum + stateTaxSum + countyTaxSum + districtTaxSum + miscTaxSum + cityTaxSum;
		totalCalculated = tools.round(totalCalculated);
		countryTaxSum = tools.round(countryTaxSum);
		stateTaxSum = tools.round(stateTaxSum);
		countyTaxSum = tools.round(countyTaxSum);
		cityTaxSum = tools.round(cityTaxSum);
		districtTaxSum = tools.round(districtTaxSum);
		miscTaxSum = tools.round(miscTaxSum);
		double totalTax = quotationResponse.getTotalTax().doubleValue();
		if (Double.compare(totalCalculated, totalTax) != 0) {
			log.warn("Summation error has occurred. Total tax returned by Vertex : {}, Summed Total Tax : {}",
					totalTax, totalCalculated);
		}

		// Set summed values on the main tax status. Note that the order level
		// tax status does not get tax rates
		taxStatus.setCityTax(cityTaxSum);
		taxStatus.setCountyTax(countyTaxSum);
		taxStatus.setStateTax(stateTaxSum);
		taxStatus.setDistrictTax(districtTaxSum);
		taxStatus.setCountryTax(countryTaxSum);
		taxStatus.setMiscTax(miscTaxSum);
		taxStatus.setAmount(totalCalculated);
		taxStatus.setSubTotal(quotationResponse.getSubTotal().doubleValue());
		taxStatus.setTotal(quotationResponse.getTotal().doubleValue());
		taxStatus.setTotalTax(totalTax);

		return taxStatus;
	}

	private LineItemTaxes processLineItem(LineItemQSOType lineItem, boolean isCanada) {
		
		LineItemTaxes liTaxStatus = new LineItemTaxes();
		
		Map<TaxBucket,Object> taxBuckets = sumTaxBuckets(lineItem.getTaxes());
		
		double countryTax = (double) taxBuckets.get(TaxBucket.COUNTRY_TAX);
		double stateTax = (double) taxBuckets.get(TaxBucket.STATE_TAX);
		double countyTax = (double) taxBuckets.get(TaxBucket.COUNTY_TAX);
		double cityTax = (double) taxBuckets.get(TaxBucket.CITY_TAX);
		double districtTax = (double) taxBuckets.get(TaxBucket.DISTRICT_TAX);
		double miscTax = (double) taxBuckets.get(TaxBucket.MISC_TAX);
		String stateTaxType = (String) taxBuckets.get(TaxBucket.STATE_TAXTYPE);
		String countryTaxType = (String) taxBuckets.get(TaxBucket.COUNTRY_TAXTYPE);
		String state = (String) taxBuckets.get(TaxBucket.STATE);
		
		// Round summed values, note we cannot have an off by penny scenario
		// here as this rounding is only to ensure there have been no floating
		// point summation issues throughout the process. The most we could be
		// rounding off is extremely fractional pennies.
		double totalCalculated = countryTax + stateTax + countyTax + cityTax + districtTax + miscTax;
		countryTax = tools.round(countryTax);
		stateTax = tools.round(stateTax);
		countyTax = tools.round(countyTax);
		cityTax = tools.round(cityTax);
		districtTax = tools.round(districtTax);
		miscTax = tools.round(miscTax);
		totalCalculated = tools.round(totalCalculated);
		
		double totalProvided = lineItem.getTotalTax().doubleValue();
		if (Double.compare(totalCalculated, totalProvided) != 0) {
			log.warn("Summation error has occurred. Total tax returned by Vertex : {}, Summed Total Tax : {}",
					totalProvided, totalCalculated);
		}
		
		double price = lineItem.getExtendedPrice().doubleValue();
		liTaxStatus.setLineItemId(lineItem.getLineItemId());
		liTaxStatus.setAmount(totalCalculated);
		liTaxStatus.setCityTax(cityTax);
		liTaxStatus.setCityTaxRate(price == 0.0d ? 0.0d : cityTax / price);
		liTaxStatus.setCountyTax(countyTax);
		liTaxStatus.setCountyTaxRate(price == 0.0d ? 0.0d : countyTax / price);
		liTaxStatus.setStateTax(stateTax);
		liTaxStatus.setStateTaxRate(price == 0.0d ? 0.0d : stateTax / price);
		liTaxStatus.setDistrictTax(districtTax);
		liTaxStatus.setDistrictTaxRate(price == 0.0d ? 0.0d : districtTax / price);
		liTaxStatus.setCountryTax(countryTax);
		liTaxStatus.setCountryTaxRate(price == 0.0d ? 0.0d : countryTax / price);
		liTaxStatus.setMiscTax(miscTax);
		liTaxStatus.setMiscTaxRate(price == 0.0d ? 0.0d : miscTax / price);

		if (isCanada) {
			liTaxStatus.setStateTaxType(stateTaxType);
			liTaxStatus.setCountryTaxType(countryTaxType);
			liTaxStatus.setState(state);
		}
		
		return liTaxStatus;
	}
	
	private Map<TaxBucket,Object> sumTaxBuckets(List<TaxesType> taxBreakdown) {
		
		EnumMap<TaxBucket,Object> retMap = new EnumMap<>(TaxBucket.class);
		
		double countryTax = 0.0d;
		double stateTax = 0.0d;
		double countyTax = 0.0d;
		double cityTax = 0.0d;
		double districtTax = 0.0d;
		double miscTax = 0.0d;
		String stateTaxType = null;
		String countryTaxType = null;
		String state = null;
		
		// Each tax level could have multiple tax items and must be summed up
		for (TaxesType tt : taxBreakdown) {
			Imposition imposition = tt.getImposition();
			String impositionValue = null;
			if (imposition != null) {
				impositionValue = imposition.getValue();
			}
			Jurisdiction jurisdiction = tt.getJurisdiction();
			JurisdictionLevelCodeType jLevel = jurisdiction.getJurisdictionLevel();
			switch (jLevel) {
			case CITY:
				cityTax += tt.getCalculatedTax().doubleValue();
				break;
			case PARISH: // Fall through to COUNTY
			case COUNTY:
				countyTax += tt.getCalculatedTax().doubleValue();
				break;
			case PROVINCE: // Fall through to STATE
			case STATE:
				stateTax += tt.getCalculatedTax().doubleValue();
				stateTaxType = impositionValue;
				state = jurisdiction.getValue();
				break;
			case DISTRICT:
				districtTax += tt.getCalculatedTax().doubleValue();
				break;
			case COUNTRY:
				countryTax += tt.getCalculatedTax().doubleValue();
				countryTaxType = impositionValue;
				break;
			default: // ALL ELSE
				miscTax += tt.getCalculatedTax().doubleValue();
				break;
			}
		}
		
		retMap.put(TaxBucket.COUNTRY_TAX, countryTax);
		retMap.put(TaxBucket.STATE_TAX, stateTax);
		retMap.put(TaxBucket.COUNTY_TAX, countyTax);
		retMap.put(TaxBucket.CITY_TAX, cityTax);
		retMap.put(TaxBucket.DISTRICT_TAX, districtTax);
		retMap.put(TaxBucket.MISC_TAX, miscTax);
		retMap.put(TaxBucket.STATE_TAXTYPE, stateTaxType);
		retMap.put(TaxBucket.COUNTRY_TAXTYPE, countryTaxType);
		retMap.put(TaxBucket.STATE, state);
		return retMap;
	}
	
	@Trace
	public ResponseEntity<CalculateResponse> createErrorResponse(Exception e, String orderId) {
		CalculateResponse response = new CalculateResponse();
		response.setOrderId(orderId);
		response.setErrorMessage(e.getMessage());
		if(response.getErrorMessage() != null 
				&& response.getErrorMessage().contains(VertexAddressException.BAD_ADDRESS_MSG)) {
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}

}
