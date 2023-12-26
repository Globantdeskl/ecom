package com.aeo.checkout.fraud.model;

import lombok.Data;

@Data
public class PaypalTender {

    private String payerId;
    private AuthorizationDetails authorizationDtls;
    private String payerStatus;
    private String payerEmail;

}
