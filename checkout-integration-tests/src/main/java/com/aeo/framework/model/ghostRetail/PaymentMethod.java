package com.aeo.framework.model.ghostRetail;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PaymentMethod {

    @JsonProperty("PaymentType")
    private String paymentType;

    @JsonProperty("PaymentReference")
    private String paymentReference;
}
