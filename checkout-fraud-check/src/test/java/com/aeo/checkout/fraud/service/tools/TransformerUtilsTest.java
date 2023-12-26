package com.aeo.checkout.fraud.service.tools;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.aeo.checkout.fraud.model.aci.ACIConstants;
import com.aeo.checkout.fraud.model.aci.LPTransactionProperty;


public class TransformerUtilsTest {
	
	@Test
	void constuctor() {
		TransformerUtils tu = new TransformerUtils();
		assertNotNull(tu);
	}
	
	@Test
	void findISO3CodeForCountry() {
		assertNull(TransformerUtils.findISO3CodeForCountry(null));
		assertNull(TransformerUtils.findISO3CodeForCountry(""));
		assertNotNull(TransformerUtils.findISO3CodeForCountry("US"));
	}
	
	@Test
	void truncate() {
		assertNull(TransformerUtils.truncate(null, 2, true));
		assertEquals("ab", TransformerUtils.truncate("abcd", 2, true));
		assertEquals("ab", TransformerUtils.truncate("ab", 2, true));
		assertEquals("cd", TransformerUtils.truncate("abcd", 2, false));
	}
	
	@Test
	void concatAddressInfo() {
		assertNull(TransformerUtils.concatAddressInfo(null, null, null));
		assertEquals("1 St|15203", TransformerUtils.concatAddressInfo("1 St", null, "15203"));
		assertEquals("1 St Apt 2", TransformerUtils.concatAddressInfo("1 St", "Apt 2", null));
		assertEquals("1 St Apt 2|15203", TransformerUtils.concatAddressInfo("1 St", "Apt 2", "15203"));
	}
	
	@Test
	void isBlank() {
		assertNotNull(TransformerUtils.isBlank("value"));
		assertTrue(TransformerUtils.isBlank(""));
		assertTrue(TransformerUtils.isBlank(" "));
		assertTrue(TransformerUtils.isBlank(null));
	}
	
	@Test
	void isNotBlank() {
		assertNotNull(TransformerUtils.isNotBlank("value"));
		assertFalse(TransformerUtils.isNotBlank(""));
		assertFalse(TransformerUtils.isNotBlank(null));
	}
	
	@Test
	void collectionToDelimitedString() {
		List<String> itemSizes = new ArrayList<>();
		itemSizes.add("One Size");
		itemSizes.add("Small");
		itemSizes.add("Medium");
		itemSizes.add(null);
		assertNotNull(TransformerUtils.collectionToDelimitedString(itemSizes,2));
		assertAll(() -> TransformerUtils.collectionToDelimitedString(itemSizes,2));
	}
	
	@Test
	void cleanNumberString() {
		String output = TransformerUtils.cleanNumberString("0.99",2);
		assertNotNull(output);
		assertEquals("099", output);
		
		output = TransformerUtils.cleanNumberString("100",2);
		assertNotNull(output);
		assertEquals("10000", output);
		
		output = TransformerUtils.cleanNumberString(null,2);
		assertNull(output);
		
		output = TransformerUtils.cleanNumberString("abcd",2);
		assertNull(output);
	}
	
	@Test
	void calculateDaysSinceRegistration() {
		String strDate = "2020-03-05";
		assertNotNull(TransformerUtils.calculateDaysSinceRegistration(strDate));
		assertAll(() -> TransformerUtils.calculateDaysSinceRegistration(strDate));
		assertEquals(0L, TransformerUtils.calculateDaysSinceRegistration(null));
		assertEquals(0L, TransformerUtils.calculateDaysSinceRegistration(""));
		assertEquals(0L, TransformerUtils.calculateDaysSinceRegistration("abcd"));
	}
	
	@Test
	void formatExpirationDate() {
		assertNull(TransformerUtils.formatExpirationDate(null));
		assertEquals("", TransformerUtils.formatExpirationDate(""));
		assertEquals("0123", TransformerUtils.formatExpirationDate("01/2023"));
		assertEquals("0123", TransformerUtils.formatExpirationDate("0123"));
	}
	
	@Test
	void fillAndTruncateRedACIRequestFields() {
		Map<LPTransactionProperty, String> requestMap = new HashMap<>();
		requestMap.put(LPTransactionProperty.DIV_NUM, "ae_ugp_rs");
		requestMap.put(LPTransactionProperty.S_KEY_ID, "20171");
		requestMap.put(LPTransactionProperty.ACT_CD, ACIConstants.ActionCode.GET_TOKEN.code());
		requestMap.put(LPTransactionProperty.ACCT_NUM, "4111111111111111");
		requestMap.put(LPTransactionProperty.CARD_EXP_DT, "0123");
		requestMap.put(LPTransactionProperty.ORD_ID, "o123456");
		requestMap.put(LPTransactionProperty.RSP_DT, LocalDate.now().toString());
		
		Map<String, String> stringRequestMap = new HashMap<>();
		assertDoesNotThrow(() -> 
			TransformerUtils.fillAndTruncateRedACIRequestFields(requestMap, stringRequestMap, null));
	}
	
}
