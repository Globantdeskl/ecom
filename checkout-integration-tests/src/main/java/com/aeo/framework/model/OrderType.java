package com.aeo.framework.model;

public enum OrderType {

    REGULAR_ORDER("regularOrder.json"),
    REGULAR_UNSPLIT_ORDER("regularUnsplitOrder.json"),
    SDD_ORDER("sddOrder.json"),
    VGC_ONLY_ORDER("vgcOnlyOrder.json"),
    VGC_MIXED_ORDER("vgcMixedOrder.json"),
    ORDER_EXAMPLE_2("orderExample2.json"),
    FRAUD_DENY_ORDER("fraudDenyOrder.json");

    private final String orderTypeExample;

    private OrderType(String orderTypeExample) {
        this.orderTypeExample = orderTypeExample;
    }

    @Override
    public String toString(){
        return orderTypeExample;
    }
}
