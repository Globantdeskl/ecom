package com.aeo.framework.model.ghostRetail.returnSummary;

import com.aeo.framework.model.ghostRetail.OrderInfo;
import com.aeo.framework.model.ghostRetail.PaymentMethod;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ReturnSummary {

    @JsonProperty("Order")
    private OrderInfo order;

    @JsonProperty("Payments")
    private List<PaymentMethod> paymentMethods;

    @JsonProperty("Refunds")
    private Refunds refunds;
}
