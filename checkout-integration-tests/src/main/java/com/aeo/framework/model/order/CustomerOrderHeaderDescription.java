package com.aeo.framework.model.order;

import lombok.Data;

@Data
public class CustomerOrderHeaderDescription {

    private String paymentStatus;

    private OrderDetails orderDetails;

    private CustomerPreference custPreference;

    private OrderBillingDetails orderBillingDtls;

    private OrderDeliveryDetails orderDeliveryDtls;

    private String giftReceiptAssigned;

    private Items items;

    private PaymentMethods paymentMethods;
    
    private HeaderInstructions headerInstructions;

}
