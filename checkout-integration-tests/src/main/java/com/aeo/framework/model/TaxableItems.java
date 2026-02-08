package com.aeo.framework.model;

import lombok.Data;

@Data
public class TaxableItems {
    String skuId;
    String taxCode;
    int quantity;
    String commerceItemId;
    Double amount;
}
