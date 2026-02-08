package com.aeo.checkout.tax.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.SocketException;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.soap.client.SoapFaultClientException;

import com.aeo.checkout.tax.config.VertexCircuitBreakerConfig;
import com.aeo.checkout.tax.config.VertexConfig;
import com.aeo.checkout.tax.config.VertexSOAPConnector;
import com.aeo.checkout.tax.service.exception.VertexAddressException;
import com.aeo.checkout.tax.service.exception.VertexException;

import aeo.integration.vertex.client.CurrencyType;
import aeo.integration.vertex.client.CustomerType;
import aeo.integration.vertex.client.LineItemQSIType;
import aeo.integration.vertex.client.LocationType;
import aeo.integration.vertex.client.MeasureType;
import aeo.integration.vertex.client.Product;
import aeo.integration.vertex.client.QuotationRequestType;
import aeo.integration.vertex.client.QuotationResponseType;
import aeo.integration.vertex.client.SaleTransactionType;
import aeo.integration.vertex.client.SellerType;
import aeo.integration.vertex.client.VertexEnvelope;

public class VertexServiceTest {
	
	private VertexService vertexService;
	
	@Mock
	private VertexSOAPConnector vertexSOAPConnector;
	
	@Mock
	private SoapFaultClientException sfce;
	
	@Mock
	private WebServiceClientException wsce;
	
	@Mock
	private VertexCircuitBreakerConfig circuitBreakerConfig;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
		VertexConfig config = new VertexConfig();
		config.setTimeout(2000);
		config.setWsdlLocation("https://mock-tax.ae.com/vertex-ws?wsdl");
		config.setServiceEndpoint("https://mock-tax.ae.com/vertex-ws");
		config.setUserName("mockUser");
		config.setPassword("mockPasswrd");
		Mockito.when(circuitBreakerConfig.findCircuitBreakerState()).thenReturn("");
		vertexService = new VertexService(vertexSOAPConnector, config, circuitBreakerConfig);
	}
	
	@Test
	void testSuccessfulSoapCall() throws VertexException, VertexAddressException, DatatypeConfigurationException {
		Mockito.when(vertexSOAPConnector
				.callWebService(ArgumentMatchers.any(VertexEnvelope.class)))
				.thenReturn(mockGoodResponse());
		QuotationResponseType resp = vertexService.calculateTaxes(mockGoodQuotationRequest());
		assertNotNull(resp);
	}
	
	@Test
	void testNullResponseSoapCall() throws VertexException, DatatypeConfigurationException {
		Mockito.when(vertexSOAPConnector
				.callWebService(ArgumentMatchers.any(VertexEnvelope.class)))
				.thenReturn(new VertexEnvelope(), (VertexEnvelope) null);
		
		assertThrows(VertexException.class, () -> 
			vertexService.calculateTaxes(mockGoodQuotationRequest()));
		
		assertThrows(VertexException.class, () -> 
			vertexService.calculateTaxes(mockGoodQuotationRequest()));
	}
	
	@Test
	void testBadAddressSoapCall() {
		Mockito.when(sfce.getFaultStringOrReason()).thenReturn(VertexAddressException.BAD_ADDRESS_MSG);
		Mockito.when(wsce.getCause()).thenReturn(sfce);
		Mockito.when(vertexSOAPConnector
				.callWebService(ArgumentMatchers.any(VertexEnvelope.class)))
				.thenThrow(sfce, wsce);
		
		assertThrows(VertexAddressException.class, () -> 
			vertexService.calculateTaxes(mockBadQuotationRequest()));
		
		assertThrows(VertexAddressException.class, () -> 
			vertexService.calculateTaxes(mockBadQuotationRequest()));
	}
	
	@Test
	void testBadSoapCall() {
		Mockito.when(sfce.getFaultStringOrReason()).thenReturn((String) null, "Connection Issue");
		Mockito.when(wsce.getCause()).thenReturn(new SocketException("Connection reset"));
		Mockito.when(vertexSOAPConnector
				.callWebService(ArgumentMatchers.any(VertexEnvelope.class)))
				.thenThrow(sfce, sfce, wsce, new RuntimeException("Connection Issue"));
		
		assertThrows(VertexException.class, () -> 
			vertexService.calculateTaxes(mockGoodQuotationRequest()));
	
		assertThrows(VertexException.class, () -> 
			vertexService.calculateTaxes(mockGoodQuotationRequest()));
		
		assertThrows(VertexException.class, () -> 
			vertexService.calculateTaxes(mockGoodQuotationRequest()));
		
		assertThrows(VertexException.class, () -> 
			vertexService.calculateTaxes(mockGoodQuotationRequest()));
	}
	
	@Test
	void testFallback() throws VertexException {
		assertThrows(VertexException.class, () -> vertexService.calculateTaxesFallback(mockGoodQuotationRequest()));
	}
	
	private VertexEnvelope mockGoodResponse() {
		VertexEnvelope resp = new VertexEnvelope();
		resp.setQuotationResponse(new QuotationResponseType());
		return resp;
	}
	
	private QuotationRequestType mockBadQuotationRequest() throws DatatypeConfigurationException {
		QuotationRequestType req = mockGoodQuotationRequest();
		req.getCustomer().getDestination().setPostalCode("15203");
		return req;
	}
	
	private QuotationRequestType mockGoodQuotationRequest() throws DatatypeConfigurationException {

		int i = 0;
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(new Date());
		XMLGregorianCalendar date = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		QuotationRequestType quotationRequest = new QuotationRequestType();

		CurrencyType currency = new CurrencyType();
		currency.setIsoCurrencyName("USD");

		LocationType destination = new LocationType();

		destination.setStreetAddress1("ffffff");
		destination.setCity("San Francisco");
		destination.setCountry("US");
		destination.setMainDivision("CA");
		destination.setPostalCode("94107");

		CustomerType customer = new CustomerType();
		customer.setDestination(destination);

		SellerType seller = new SellerType();
		seller.setCompany("AEHoldings");
		seller.setDivision("AED");

		Product product = new Product();
		product.setValue("0021765045");
		product.setProductClass("89998");

		MeasureType quantity = new MeasureType();
		quantity.setValue(BigDecimal.valueOf(4));
		LineItemQSIType lineItem = new LineItemQSIType();
		lineItem.setTaxDate(date);
		lineItem.setLineItemNumber(Long.valueOf(++i));
		lineItem.setProduct(product);
		lineItem.setQuantity(quantity);
		lineItem.setExtendedPrice(
				BigDecimal.valueOf(140.00).setScale(2, RoundingMode.HALF_UP));
		quotationRequest.getLineItem().add(lineItem);

		quotationRequest.setCurrency(currency);
		quotationRequest.setCustomer(customer);
		quotationRequest.setDocumentDate(date);
		quotationRequest.setDocumentNumber("mockOrderId");
		quotationRequest.setTransactionType(SaleTransactionType.SALE);
		quotationRequest.setSeller(seller);

		return quotationRequest;
	}

}
