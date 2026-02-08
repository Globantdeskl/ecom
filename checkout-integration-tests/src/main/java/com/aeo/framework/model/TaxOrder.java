package com.aeo.framework.model;

import lombok.Data;

import java.util.List;

@Data
public class TaxOrder {

    String orderId;
    String taxDate;
    String currencyCode;
    String addressLine1;
    String addressLine2;
    String city;
    String country;
    String state;
    String staUSte;
    String postalCode;
    String shippingGroupId;
    Double shippingCost;
    List<TaxableItems> taxableItems;

}
