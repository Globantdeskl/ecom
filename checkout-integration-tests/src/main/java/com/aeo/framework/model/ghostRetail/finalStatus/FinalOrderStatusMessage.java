package com.aeo.framework.model.ghostRetail.finalStatus;

import com.aeo.framework.model.ghostRetail.BaseMessage;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
public class FinalOrderStatusMessage extends BaseMessage {

    @JsonProperty("TransactionType")
    private String transactionType;

    @JsonProperty("TransactionID")
    private String transactionID;

    @JsonProperty("OrderNo")
    private String orderNo;

    @JsonProperty("OrderDate")
    public String orderDate;

    @JsonProperty("Status")
    private String status;

    @JsonProperty("GatewayIndicator")
    private String gatewayIndicator;

    @JsonProperty("OrderLines")
    private List<OrderLine> orderLines;

    @JsonProperty("PaymentMethods")
    private List<PaymentMethod> paymentMethods;
}
