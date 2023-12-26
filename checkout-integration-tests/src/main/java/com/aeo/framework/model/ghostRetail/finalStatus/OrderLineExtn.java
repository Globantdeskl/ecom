package com.aeo.framework.model.ghostRetail.finalStatus;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrderLineExtn {

    @JsonProperty("ExtnCommerceItemID")
    private String extnCommerceItemID;
}
