package com.aeo.framework.model.order;

import com.aeo.framework.model.FraudAuthorizationDetails;
import lombok.Data;

import java.util.List;

@Data
public class CreditDebitTender {

    private String maskedAccountNumber;
    private String cardType;
    private String unlimitedCharges;
    private String creditCardExpDate;
    private String maxChargeLimit;
    private FraudAuthorizationDetails authorizationDtls;
    private List<String> signatureData;
    public String cardToken;
    private String cardVerificationNumber;
}
