package com.aeo.framework.model.order;

import com.aeo.framework.model.FraudAuthorizationDetails;
import lombok.Data;

@Data
public class PaypalTender {

    private String payerId;
    private String authToken;
    private String maxChargeLimit;
    private FraudAuthorizationDetails authorizationDtls;

}
