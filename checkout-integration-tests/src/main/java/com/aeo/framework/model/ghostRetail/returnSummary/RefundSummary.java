package com.aeo.framework.model.ghostRetail.returnSummary;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RefundSummary {

    @JsonProperty("MerchandiseCost")
    private BigDecimal merchandiseCost;

    @JsonProperty("TaxAmount")
    private BigDecimal taxAmount;

    @JsonProperty("TotalAmount")
    private BigDecimal totalAmount;
}
