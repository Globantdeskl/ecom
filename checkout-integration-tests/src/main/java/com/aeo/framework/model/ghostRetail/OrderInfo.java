package com.aeo.framework.model.ghostRetail;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrderInfo {

    @JsonProperty("OrderNumber")
    private String orderNumber;

    @JsonProperty("EntryType")
    private String entryType;
}
