package com.aeo.checkout.fraud.service.tools;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import com.aeo.checkout.fraud.config.FraudConfig.ShippingMethodCode;
import com.aeo.checkout.fraud.model.CustomerAddress;
import com.aeo.checkout.fraud.model.CustomerBillingDetail;
import com.aeo.checkout.fraud.model.CustomerShippingDetail;
import com.aeo.checkout.fraud.model.FraudRequest;
import com.aeo.checkout.fraud.model.aci.ACIConstants;
import com.aeo.checkout.fraud.model.aci.LPTransactionProperty;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RequestAddressDataPopulator implements FraudRequestDataPopulator {

	@Override
	public void populate(FraudRequest request, Map<LPTransactionProperty, String> requestMap) {
		
		requestMap.put(LPTransactionProperty.FRT_AMT, 
				TransformerUtils.cleanNumberString(request.getFreightAmount(), 2));

		Optional<ShippingMethodCode> optCode = Arrays.asList(ShippingMethodCode.values()).stream()
				.filter(smc -> smc.method().equalsIgnoreCase(request.getCustomerOrder().getCarrierCode()))
				.findFirst();
		requestMap.put(LPTransactionProperty.SHIP_MTHD_CD,
				(optCode.isPresent() ? optCode.get().code() : ShippingMethodCode.SM_DEFAULT.code()));
		
		populateBillingAddressData(request.getCustomerBillingDetail(), requestMap);
		populateShippingData(request.getCustomerShippingDetail(), requestMap);
	}
	
	private void populateBillingAddressData(CustomerBillingDetail billingAddress, 
			Map<LPTransactionProperty, String> requestMap) {

		if (billingAddress == null) {
			return;
		}

		requestMap.put(LPTransactionProperty.CUST_FNAME, billingAddress.getFirstName());
		requestMap.put(LPTransactionProperty.CUST_LNAME, billingAddress.getLastName());
		requestMap.put(LPTransactionProperty.CUST_EMAIL,billingAddress.getEmailAddress());

		if (billingAddress.getAddress() != null) {
			CustomerAddress ca = billingAddress.getAddress();
			requestMap.put(LPTransactionProperty.CUST_ADDR1, ca.getAddress1());
			requestMap.put(LPTransactionProperty.CUST_ADDR2, ca.getAddress2());
			requestMap.put(LPTransactionProperty.CUST_CITY, ca.getCity());
			requestMap.put(LPTransactionProperty.CUST_STPR_CD, ca.getStateName());
			requestMap.put(LPTransactionProperty.CUST_POSTAL_CD, ca.getPostalCode());
			requestMap.put(LPTransactionProperty.CUST_CNTRY_CD, 
					TransformerUtils.findISO3CodeForCountry(ca.getCountryCode()));
			requestMap.put(LPTransactionProperty.EBT_USER_DATA1,
					TransformerUtils.concatAddressInfo(ca.getAddress1(), ca.getAddress2(), ca.getPostalCode()));
		}

		String phoneNumber = billingAddress.getPhoneNumber();
		if(TransformerUtils.isNotBlank(phoneNumber)) {
			requestMap.put(LPTransactionProperty.CUST_HOME_PHONE, phoneNumber.replaceAll("[\\D]", "").trim() );
		}
	}

	private void populateShippingData(CustomerShippingDetail shippingDetails, Map<LPTransactionProperty, String> requestMap) {

		if (shippingDetails == null) {
			// may happen for a vgc only order
			return;
		}

		if (shippingDetails.getAddress() != null) {
			CustomerAddress ca = shippingDetails.getAddress();
			requestMap.put(LPTransactionProperty.SHIP_ADDR1, ca.getAddress1());
			requestMap.put(LPTransactionProperty.SHIP_ADDR2, ca.getAddress2());
			requestMap.put(LPTransactionProperty.SHIP_CITY, ca.getCity());
			requestMap.put(LPTransactionProperty.SHIP_CNTRY_CD, 
					TransformerUtils.findISO3CodeForCountry(ca.getCountryCode()));
			requestMap.put(LPTransactionProperty.SHIP_POSTAL_CD, ca.getPostalCode());
			requestMap.put(LPTransactionProperty.SHIP_STPR_CD, ca.getStateName());

			if (TransformerUtils.isBlank(shippingDetails.getFirstName())
					|| TransformerUtils.isBlank(shippingDetails.getLastName())
					|| TransformerUtils.isBlank(ca.getAddress1()) 
					|| TransformerUtils.isBlank(ca.getCity())
					|| TransformerUtils.isBlank(ca.getCountryCode()) 
					|| TransformerUtils.isBlank(ca.getPostalCode())) {
				requestMap.put(LPTransactionProperty.SHIP_TYPE_CD, ACIConstants.SHIPPING_DETAILS_PRESENT);
			} else {
				requestMap.put(LPTransactionProperty.ebSHIPCOMMENTS, shippingDetails.getEmailAddress());
			}

			requestMap.put(LPTransactionProperty.ebSHIPCOMMENTS,
					TransformerUtils.concatAddressInfo(ca.getAddress1(), ca.getAddress2(), ca.getPostalCode()));
		}
		requestMap.put(LPTransactionProperty.SHIP_FNAME, shippingDetails.getFirstName());
		requestMap.put(LPTransactionProperty.SHIP_LNAME, shippingDetails.getLastName());
		requestMap.put(LPTransactionProperty.SHIP_EMAIL, shippingDetails.getEmailAddress());
	}

	@Override
	public boolean returnsItems() {
		return false;
	}

}
