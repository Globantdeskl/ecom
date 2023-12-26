package com.aeo.checkout.fraud.model;

import lombok.Data;

@Data
public class DigitalWalletTender {

    private AuthorizationDetails authorizationDtls;
    private String paymentMethodNonce;

}
