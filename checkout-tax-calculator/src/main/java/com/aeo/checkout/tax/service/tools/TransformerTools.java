package com.aeo.checkout.tax.service.tools;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Component;

import com.aeo.checkout.tax.model.CalculateRequest;
import com.aeo.checkout.tax.service.exception.VertexAddressException;
import com.aeo.checkout.tax.service.exception.VertexException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TransformerTools {
	
	private DatatypeFactory datatypeFactory;
	
	public TransformerTools(DatatypeFactory datatypeFactory) {
		this.datatypeFactory = datatypeFactory;
	}
	
	public void validCalculateRequest(CalculateRequest request) throws VertexAddressException {
		if (!validObject(request.getAddressLine1())
				|| !validObject(request.getCity())
				|| !validObject(request.getPostalCode())) {
			StringBuilder sb = new StringBuilder();
			sb.append(VertexAddressException.BAD_ADDRESS_MSG);
			sb.append(". ");
			sb.append(request.getOrderId());
			sb.append(" has no address information in request");
			throw new VertexAddressException(sb.toString());
		}
	}
	
	public static boolean validObject(Object o) {
		if(o == null) {
			return false;
		}
		if(o instanceof String) {
			return !((String)o).isEmpty();
		}
		return true;
	}
	
	public XMLGregorianCalendar getXmlDate(CalculateRequest request) throws VertexException {
		Optional<XMLGregorianCalendar> optDate = validObject(request.getTaxDate()) ? 
				getXmlDate(request.getTaxDate()) : getXmlDate(new Date());
		if(!optDate.isPresent()) {
			StringBuilder sb = new StringBuilder();
			sb.append("Unable to determine a taxDate for order ");
			sb.append(request.getOrderId());
			throw new VertexException(sb.toString());
		}
		return optDate.get();
	}
	
	private Optional<XMLGregorianCalendar> getXmlDate(String date) {
		try {
			return Optional.of(datatypeFactory.newXMLGregorianCalendar(date));
		} catch (IllegalArgumentException e) {
			log.error("getXmlDate error with {}", date, e);
		}
		return Optional.empty();
	}
	
	private Optional<XMLGregorianCalendar> getXmlDate(Date date) {
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(date);
		try {
			return Optional.of(datatypeFactory.newXMLGregorianCalendar(c));
		} catch (IllegalArgumentException e) {
			log.error("getXmlDate error with {}", date, e);
		}
		return Optional.empty();
	}
	
	public double round(double amount) {
		return BigDecimal.valueOf(amount).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}
	
	public BigDecimal roundBD(double amount) {
		return BigDecimal.valueOf(amount).setScale(2, RoundingMode.HALF_UP);
	}

}
