package com.aeo.framework.model.order;

import com.aeo.framework.model.FraudAuthorizationDetails;
import lombok.Data;

import java.util.List;

@Data
public class AfterpayTender {

    private String payerId;
    private String cardToken;
    private String unlimitedCharges;
    private String maxChargeLimit;
    private List<FraudAuthorizationDetails> authorizationDtls;

}
