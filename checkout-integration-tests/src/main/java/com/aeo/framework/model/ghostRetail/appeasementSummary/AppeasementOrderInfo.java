package com.aeo.framework.model.ghostRetail.appeasementSummary;

import com.aeo.framework.model.ghostRetail.OrderInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper=false)
public class AppeasementOrderInfo extends OrderInfo {

    @JsonProperty("ItemAmount")
    private BigDecimal itemAmount;

    @JsonProperty("ShippingAmount")
    private BigDecimal shippingAmount;

    @JsonProperty("TaxAmount")
    private BigDecimal taxAmount;
}
