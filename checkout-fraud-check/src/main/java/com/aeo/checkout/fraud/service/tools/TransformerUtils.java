package com.aeo.checkout.fraud.service.tools;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.aeo.checkout.fraud.model.aci.LPTransactionProperty;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class TransformerUtils {
	
	private static final Map<String, String> ISO2_TO_ISO3_COUNTRY_CODE;
	
	static {
		String[] countries = Locale.getISOCountries();
		Map<String, String> map = new HashMap<>(countries.length);
		for (String country : countries) {
			Locale locale = new Locale("", country);
			map.put(country.toUpperCase(), locale.getISO3Country().toUpperCase());
		}
		ISO2_TO_ISO3_COUNTRY_CODE = map;
	}
	
	public static String findISO3CodeForCountry(String countryCode) {
		if(countryCode == null || countryCode.isEmpty()) {
			return null;
		}
		return ISO2_TO_ISO3_COUNTRY_CODE.get(countryCode.toUpperCase());
	}
			
	/**
	 * Truncates a string (toTruncate) by a max character limit (maxCharacters)
	 * preferring either the first or last half (keepFirst)
	 * 
	 * @param toTruncate
	 * @param maxCharacters
	 * @param keepFirst
	 * @return
	 */
	public static String truncate(String toTruncate, int maxCharacters, boolean keepFirst) {
		if (toTruncate == null || toTruncate.length() <= maxCharacters) {
			return toTruncate;
		}
		if (keepFirst) {
			return toTruncate.substring(0, maxCharacters);
		}
		return toTruncate.substring(toTruncate.length() - maxCharacters);
	}
	
	public static String concatAddressInfo(String addr1, String addr2, String postalCode) {
		if (isBlank(addr1)) {
			return null;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(addr1.trim());
		if (isNotBlank(addr2)) {
			sb.append(" ").append(addr2.trim());
		}
		if (!isBlank(postalCode)) {
			sb.append("|").append(postalCode.trim());
		}
		return sb.toString();

	}
	
	public static boolean isBlank(String pStr){
		return (pStr == null) || (pStr.length() == 0) || (pStr.trim().length() == 0);
	}
	
	public static boolean isNotBlank(String pStr){
		return !isBlank(pStr);
	}
	
	/**
	 * Format a collection of strings as a pipe-delimited string.
	 * 
	 * Elements will stop being appended when the next element to be appended would
	 * cause the string length to exceed maxCharacters, preventing a partial value
	 * from being added and subsequently truncated to the maximum field size.
	 * 
	 * @param strings
	 * @param maxCharacters
	 * @return
	 */
	public static String collectionToDelimitedString(Collection<String> strings, int maxCharacters) {
		StringBuilder sb = new StringBuilder();
		for (String string : strings) {
			String stringValue = string.trim();
			// if there's not enough space left, stop trying
			if ((sb.length() == 0 && stringValue.length() > maxCharacters)  
					|| stringValue.length() > (maxCharacters - sb.length() - 1)) {
				break;
			}
			// add | if this isn't the first entry in the string builder
			if (sb.length() > 0) {
				sb.append('|');
			}
			sb.append(stringValue);
		}
		return sb.toString();
	}
	
	public static String cleanNumberString(String numberString, int decimalPlaces) {
		if (numberString == null) {
			return null;
		}
		try {
			double number = (Double.parseDouble(numberString) * Math.pow(10, decimalPlaces));
			StringBuilder numAsStr = new StringBuilder(
					BigDecimal.valueOf(number).setScale(0, RoundingMode.HALF_UP).toString());
			while (numAsStr.length() < (decimalPlaces + 1)) {
				// Add leading zeros so 0.99 will be represented as 099, etc.
				numAsStr.insert(0, "0");
			}
			return numAsStr.toString();
		} catch (NumberFormatException nfe) {
			return null;
		}
	}
	
	public static long calculateDaysSinceRegistration(String profileDate) {
		Date regDate = null;
		if(profileDate != null) {
			try {
				regDate = new SimpleDateFormat("yyyy-MM-dd").parse(profileDate);
			} catch (ParseException e) {
				regDate = null;
			}
		}
		if (regDate == null) {
			return 0;
		}
		return TimeUnit.DAYS.convert(System.currentTimeMillis() - regDate.getTime(), TimeUnit.MILLISECONDS);
	}
	
	public static String formatExpirationDate(String pExpDate) {
		String expDate = pExpDate;
		if(expDate != null 
				&& !expDate.isEmpty()
				&& expDate.contains("/")) {
			String month = expDate.substring(0, 2);
			String year = expDate.substring(expDate.length() - 2);
			expDate = month + year;
		}
		return expDate;
	}
	
	/**
	 * Converts a mapping of LPTransactionProperty -> String to a mapping of String
	 * -> String using the LPTransactionProperty.name + an optional append value
	 * (Useful for remapping a List<Map<>>) as the key and the trucated to the
	 * maximum length of the request string as the value
	 * 
	 * @param requestMap
	 * @param stringRequestMap
	 * @param appendToKeys
	 */
	public static void fillAndTruncateRedACIRequestFields(Map<LPTransactionProperty, String> requestMap,
			Map<String, String> stringRequestMap, String appendToKeys) {
		for (Map.Entry<LPTransactionProperty, String> entry : requestMap.entrySet()) {
			LPTransactionProperty key = entry.getKey();
			String name = key.name();
			if (appendToKeys != null) {
				name += appendToKeys;
			}
			if (key.hasMax()) {
				String truncated = TransformerUtils.truncate(entry.getValue(), key.getMax(), key.isPreferFirst());
				if (truncated != null && truncated.length() != entry.getValue().length()) {
					log.info("Property for RedACI request {} was too long. It has been truncated from {} to {}", 
							name, entry.getValue(), truncated);
				}
				stringRequestMap.put(name, truncated);
			} else {
				stringRequestMap.put(name, entry.getValue());
			}
		}
	}
	
}
