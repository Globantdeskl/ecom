package com.aeo.checkout.fraud.service.tools;

import java.util.Map;

import com.aeo.checkout.fraud.model.FraudRequest;
import com.aeo.checkout.fraud.model.aci.LPTransactionProperty;

public interface FraudRequestDataPopulator {
	
	public abstract void populate(FraudRequest order, Map<LPTransactionProperty, String> requestMap);
	
	public abstract boolean returnsItems();

}
