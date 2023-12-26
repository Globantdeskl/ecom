package com.aeo.framework.model;

import lombok.Data;

@Data
public class Tax {
    Double amount;
    Double countryTax;
    Double stateTax;
    Double countyTax;
    Double districtTax;
    Double miscTax;
    Double countryTaxRate;
    Double stateTaxRate;
    Double countyTaxRate;
    Double cityTaxRate;
    Double districtTaxRate;
    Double miscTaxRate;
    String countryTaxType;
    String stateTaxType;
    String state;
}
