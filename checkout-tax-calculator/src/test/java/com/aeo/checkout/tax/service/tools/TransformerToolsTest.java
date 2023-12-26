package com.aeo.checkout.tax.service.tools;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

import com.aeo.checkout.tax.model.CalculateRequest;
import com.aeo.checkout.tax.service.exception.VertexAddressException;
import com.aeo.checkout.tax.service.exception.VertexException;

public class TransformerToolsTest {
	
	private TransformerTools transformerTools;
	
	@Mock
	private DatatypeFactory datatypeFactory;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
		transformerTools = new TransformerTools(datatypeFactory);
	}
	
	@Test
	void testValidCalculateRequest() throws VertexException {
		
		CalculateRequest req = new CalculateRequest();
		req.setAddressLine1("mockStreet");
		req.setCity("mockCity");
		req.setPostalCode("mockZip");
		
		assertAll(() -> transformerTools.validCalculateRequest(req));
		
		req.setPostalCode("");
		assertThrows(VertexAddressException.class, 
				() -> transformerTools.validCalculateRequest(req));
		
		req.setCity("");
		assertThrows(VertexAddressException.class, 
				() -> transformerTools.validCalculateRequest(req));
		
		req.setAddressLine1("");
		assertThrows(VertexAddressException.class, 
				() -> transformerTools.validCalculateRequest(req));
		
		assertThrows(VertexAddressException.class, 
				() -> transformerTools.validCalculateRequest(new CalculateRequest()));
	}
	
	@Test
	void testValidObject() {
		assertFalse(TransformerTools.validObject(null));
		assertFalse(TransformerTools.validObject(""));
		assertTrue(TransformerTools.validObject("valid"));
		assertTrue(TransformerTools.validObject(new CalculateRequest()));
	}
	
	@Test
	void testGetXmlDate() throws VertexException, DatatypeConfigurationException {
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(new Date());
		XMLGregorianCalendar cal = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		Mockito.when(datatypeFactory
				.newXMLGregorianCalendar(ArgumentMatchers.anyString())).thenReturn(cal);
		Mockito.when(datatypeFactory
				.newXMLGregorianCalendar(ArgumentMatchers.any(GregorianCalendar.class))).thenReturn(cal);
		
		String strDate = "2020-02-28T21:43:57.482+0000";
		CalculateRequest req = new CalculateRequest();
		req.setTaxDate(strDate);
		assertNotNull(transformerTools.getXmlDate(req));
		assertNotNull(transformerTools.getXmlDate(new CalculateRequest()));
		
		Mockito.when(datatypeFactory
				.newXMLGregorianCalendar(ArgumentMatchers.anyString()))
				.thenThrow(IllegalArgumentException.class);
		Mockito.when(datatypeFactory
				.newXMLGregorianCalendar(ArgumentMatchers.any(GregorianCalendar.class)))
				.thenThrow(IllegalArgumentException.class);
		
		assertThrows(VertexException.class, () -> transformerTools.getXmlDate(req));
		assertThrows(VertexException.class, () -> transformerTools.getXmlDate(new CalculateRequest()));
	}
	
	@Test
	void testRounding() {
		assertAll(() -> transformerTools.round(2.2222d));
	}

}
