package com.aeo.checkout.fraud.model;

import lombok.Data;

@Data
public class PaymentMethod {
	
    private CreditDebitTender creditDebitTender;
    private PaypalTender paypalTender;
    private GiftCardTender giftCardTender;
    private DigitalWalletTender digitalWalletTender;

}
