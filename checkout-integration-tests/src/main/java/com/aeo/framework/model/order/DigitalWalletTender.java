package com.aeo.framework.model.order;

import com.aeo.framework.model.FraudAuthorizationDetails;
import lombok.Data;

@Data
public class DigitalWalletTender {

    private String lastFourCC;
    private String authToken;
    private String walletType;
    private String cardType;
    private String unlimitedCharges;
    private String creditCardExpDate;
    private String maxChargeLimit;
    private FraudAuthorizationDetails authorizationDtls;

}
