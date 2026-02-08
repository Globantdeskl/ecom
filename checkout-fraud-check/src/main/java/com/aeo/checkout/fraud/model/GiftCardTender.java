package com.aeo.checkout.fraud.model;

import lombok.Data;

@Data
public class GiftCardTender {
	
    private String cardNumber;
    private String processedAmount;
    private String giftCardPin;
    private boolean transactionSuccess;
}
