package com.aeo.framework.model;

import lombok.Data;

@Data
public class FraudAuthorizationDetails {

    private boolean transactionSuccess;
    private Double amount;
    private String cvvResponse;
    private String errorMessage;
    private String avsCode;

}
