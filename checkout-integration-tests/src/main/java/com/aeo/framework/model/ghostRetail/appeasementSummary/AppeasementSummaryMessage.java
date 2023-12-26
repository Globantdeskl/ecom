package com.aeo.framework.model.ghostRetail.appeasementSummary;

import com.aeo.framework.model.ghostRetail.BaseMessage;
import com.aeo.framework.model.ghostRetail.Item;
import com.aeo.framework.model.ghostRetail.PaymentMethod;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
public class AppeasementSummaryMessage extends BaseMessage {

    @JsonProperty("Order")
    private AppeasementOrderInfo order;

    @JsonProperty("Payments")
    private List<PaymentMethod> paymentMethods;

    @JsonProperty("Items")
    private List<Item> items;
}
