package com.aeo.framework.model;

import lombok.Data;

import java.util.List;

@Data
public class OrderTaxes {
    String transactionId;
    String transactionTimestamp;
    Double subTotal;
    Double total;
    Double totalTax;
    Double amount;
    Double countryTax;
    Double stateTax;
    Double countyTax;
    Double cityTax;
    Double districtTax;
    Double miscTax;
    List<LineItemTaxes> lineItemTaxes;
    ShippingTaxes shippingTaxes;
}
