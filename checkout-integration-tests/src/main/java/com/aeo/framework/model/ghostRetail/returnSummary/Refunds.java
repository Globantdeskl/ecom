package com.aeo.framework.model.ghostRetail.returnSummary;

import com.aeo.framework.model.ghostRetail.Item;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Refunds {

    @JsonProperty("RefundSummary")
    private RefundSummary refundSummary;

    @JsonProperty("Items")
    private List<Item> items;
}
