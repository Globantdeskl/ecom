package com.aeo.framework.model.order;

import lombok.Data;

@Data
public class CustomerShippingDetails {

    private CustomerInfo customerInfo;

    private CustomerEmails emails;

    private CustomerPhoneNumbers phoneNumbers;

    private CustomerAddresses addresses;

}
