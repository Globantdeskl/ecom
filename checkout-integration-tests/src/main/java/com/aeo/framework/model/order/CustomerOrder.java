package com.aeo.framework.model.order;

import lombok.Data;

import java.util.List;

@Data
public class CustomerOrder {

    private String customerOrderId;

    private String currencyCode;

    private String activityDate;

    private String carrierCode;

    private boolean freeReturnLabel;

    private String discount;

    private String taxAmount;

    private String deviceData;

    private String freeReturnLabelCode;

    public boolean hasFreeReturnLabel() {
        return this.isFreeReturnLabel();
    }

    private boolean freeGiftReceipt;

    public boolean hasFreeGiftReceipt() {
        return this.isFreeGiftReceipt();
    }

    private String profileId;

    private String sourceApplication;

    private String channel;

    private String ipAddress;

    private String profileLoginDate;

}
