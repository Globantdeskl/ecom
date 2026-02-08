package com.aeo.framework.model.order;

import lombok.Data;

@Data
public class CustomerBillDetail {

    private CustomerInfo customerInfo;
    private CustomerAddresses addresses;

}
