package com.aeo.framework.model.ghostRetail;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Item {

    @JsonProperty("ItemID")
    private String itemID;
}
