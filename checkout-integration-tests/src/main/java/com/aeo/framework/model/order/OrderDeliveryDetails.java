package com.aeo.framework.model.order;

import lombok.Data;

@Data
public class OrderDeliveryDetails {

    private CustomerShippingDetails customerShipDtl;

    private String deliveryMethod;

}
