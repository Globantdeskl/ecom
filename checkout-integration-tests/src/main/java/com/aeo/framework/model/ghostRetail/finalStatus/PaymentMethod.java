package com.aeo.framework.model.ghostRetail.finalStatus;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PaymentMethod {

    @JsonProperty("PaymentReference2")
    private String paymentReference2;

    @JsonProperty("PaymentReference3")
    private String paymentReference3;

    @JsonProperty("PaymentType")
    private String paymentType;
}
