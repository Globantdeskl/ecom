package com.aeo.framework.model.order;

import lombok.Data;

@Data
public class PaymentMethod {

    private long seqNo;
    private String paymentType;
    private String chargeType;
    private String paymentGroupId;
    private CreditDebitTender creditDebitTender;
    private PaypalTender paypalTender;
    private GiftCardTender giftCardTender;
    private DigitalWalletTender digitalWalletTender;
    private CustomerBillDetails custBillDtls;
    private String amount;
    private AfterpayTender afterPayTender;

}
