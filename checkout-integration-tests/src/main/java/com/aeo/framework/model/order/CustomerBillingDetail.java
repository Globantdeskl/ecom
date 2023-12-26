package com.aeo.framework.model.order;

import lombok.Data;

@Data
public class CustomerBillingDetail {

    private String loyaltyId;

    private CustomerInfo customerInfo;

    private CustomerEmails emails;

    private CustomerPhoneNumbers phones;

    private CustomerAddresses addresses;

}
