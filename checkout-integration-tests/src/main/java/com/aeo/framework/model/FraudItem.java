package com.aeo.framework.model;

import lombok.Data;

@Data
public class FraudItem {

    int quantity;
    String productClass;
    String recipientEmail;
    String recipientName;
    String recipientMobile;
    String senderEmail;
    String senderName;
    String giftMessage;
    String giftCardAmount;
    String amount;
    String listPrice;
    String catalogRefId;
    String pickupPromiseDate;
    String productClassId;
    String equityName;
    String sizeDescDefault;
    String egifterGiftId;
    String egifterOrderId;

}
