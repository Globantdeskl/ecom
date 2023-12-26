package com.aeo.framework.model;

import lombok.Getter;

@Getter
public enum OrderStatus {

    SUBMITTED("SUBMITTED"),
    RECEIVED_BY_PCF("RECEIVED_BY_PCF"),
    READY_FOR_PROCESSING("READY_FOR_PROCESSING"),
    PROCESSING("PROCESSING"),
    CANCELLED("CANCELLED"),
    ITEM_CANCEL("ITEM_CANCEL"),
    CUSTOMER_PARTIAL_CANCEL("CUSTOMER_PARTIAL_CANCEL"),
    CSC_CANCELLED("CSC_CANCELLED"),
    CSC_PARTIAL_CANCEL("CSC_PARTIAL_CANCEL"),
    RECEIVED_NOT_CANCELLABLE("RECEIVED_NOT_CANCELLABLE"),
    RECEIVED_EXPEDITED("RECEIVED_EXPEDITED"),
    SENT_TO_OMS("SENT_TO_OMS"),
    CANCEL_REQUEST_HELD("CANCEL_REQUEST_HELD"),
    EDIT_REQUEST_HELD("EDIT_REQUEST_HELD"),
    RECEIVED_CANCELLED("RECEIVED_CANCELLED");

    private final String orderStatus;

    private OrderStatus(String orderStatus){
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString(){
        return orderStatus;
    }
}
