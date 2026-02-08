package com.aeo.checkout.fraud.service.tools;

import java.util.Map;

import com.aeo.checkout.fraud.model.FraudRequest;
import com.aeo.checkout.fraud.model.aci.ACIConstants;
import com.aeo.checkout.fraud.model.aci.LPTransactionProperty;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RequestOrderDataPopulator implements FraudRequestDataPopulator {
	
	@Override
	public void populate(FraudRequest request, Map<LPTransactionProperty, String> requestMap) {
		
		requestMap.put(LPTransactionProperty.ORD_DTM, request.getCustomerOrder().getActivityDate());
		requestMap.put(LPTransactionProperty.ORD_ID, request.getCustomerOrder().getCustomerOrderId());
		requestMap.put(LPTransactionProperty.EBT_USER_DATA5, request.getCustomerOrder().getCustomerOrderId());
		requestMap.put(LPTransactionProperty.EBT_USER_DATA16,
				Boolean.toString(request.getCustomerOrder().isFreeGiftReceipt()).toUpperCase());

		if (request.getAppliedCoupons() != null 
				&& !request.getAppliedCoupons().isEmpty()) {
			requestMap.put(LPTransactionProperty.EBT_USER_DATA9, TransformerUtils.collectionToDelimitedString(
					request.getAppliedCoupons(), LPTransactionProperty.EBT_USER_DATA9.getMax()));
			requestMap.put(LPTransactionProperty.EBT_USER_DATA18,
					Integer.toString(request.getAppliedCoupons().size()));
		} else {
			requestMap.put(LPTransactionProperty.EBT_USER_DATA9, 
					LPTransactionProperty.EBT_USER_DATA9.defaultValue());
			requestMap.put(LPTransactionProperty.EBT_USER_DATA18, 
					LPTransactionProperty.EBT_USER_DATA18.defaultValue());
		}

		if (TransformerUtils.isNotBlank(request.getCustomerBillingDetail().getLoyaltyId())) {
			requestMap.put(LPTransactionProperty.EBT_USER_DATA15, ACIConstants.YES);
			requestMap.put(LPTransactionProperty.EBT_USER_DATA10, request.getCustomerBillingDetail().getLoyaltyId());
		} else {
			requestMap.put(LPTransactionProperty.EBT_USER_DATA15, ACIConstants.NO);
		}

		requestMap.put(LPTransactionProperty.EBT_DEVICEPRINT, request.getCustomerOrder().getDeviceData());

		requestMap.put(LPTransactionProperty.AMT, TransformerUtils.cleanNumberString(request.getAmount(), 2));
		requestMap.put(LPTransactionProperty.CURR_CD, request.getCustomerOrder().getCurrencyCode());
		requestMap.put(LPTransactionProperty.EBT_USER_DATA2, request.getCustomerOrder().getCurrencyCode());
		requestMap.put(LPTransactionProperty.SLS_TAX_AMT, 
				TransformerUtils.cleanNumberString(request.getCustomerOrder().getTaxAmount(), 2));
		requestMap.put(LPTransactionProperty.EBT_USER_DATA5, request.getCustomerOrder().getDiscount());

		requestMap.put(LPTransactionProperty.EBT_USER_DATA20, request.getCustomerOrder().getChannel());
		requestMap.put(LPTransactionProperty.EBT_USER_DATA23, 
				request.isResubmittedOrder() ? ACIConstants.YES : ACIConstants.NO);
		
		populateProfileData(request, requestMap);
	}
	
	private void populateProfileData(FraudRequest order, Map<LPTransactionProperty, String> requestMap) {
		
		requestMap.put(LPTransactionProperty.CUST_ID, order.getCustomerOrder().getProfileId());
		requestMap.put(LPTransactionProperty.CUST_IP_ADDR, order.getCustomerOrder().getIpAddress());

		if (!order.getOrderMetaData().isUserOrder()) {
			// no login name, user isn't registered, make sure days = 0;
			requestMap.put(LPTransactionProperty.EBT_PREVCUST, ACIConstants.NO);
			requestMap.put(LPTransactionProperty.EBT_TOF, "0");
		} else {
			long daysSinceRegistration = TransformerUtils.calculateDaysSinceRegistration(
					order.getCustomerOrder().getProfileLoginDate());
			requestMap.put(LPTransactionProperty.EBT_PREVCUST, ACIConstants.YES);
			// user is registered, make sure days since registration >= 1
			requestMap.put(LPTransactionProperty.EBT_TOF, daysSinceRegistration <= 0L ?
					LPTransactionProperty.EBT_TOF.defaultValue() : Long.toString(daysSinceRegistration));
		}
	}

	@Override
	public boolean returnsItems() {
		return false;
	}
	
}
