package com.aeo.framework.model.order;

import lombok.Data;

@Data
public class CustomerAddress {

    private String addressType;

    private String address1;

    private String address2;

    private String city;

    private String stateName;

    private String countryCode;

    private String postalCode;

}
