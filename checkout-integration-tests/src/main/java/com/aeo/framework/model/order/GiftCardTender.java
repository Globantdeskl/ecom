package com.aeo.framework.model.order;

import lombok.Data;

@Data
public class GiftCardTender {
	
    private String cardNumber;
    private String processedAmount;
    private String remainingBalance;
    private String maxChargeLimit;

}
