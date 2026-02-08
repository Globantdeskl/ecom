package com.aeo.framework.model.ghostRetail.finalStatus;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrderLine {

    @JsonProperty("Status")
    private String status;

    @JsonProperty("ItemID")
    private String itemID;

    @JsonProperty("Extn")
    private OrderLineExtn extn;
}
