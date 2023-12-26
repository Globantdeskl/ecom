package com.aeo.framework.model.order;

import lombok.Data;

import java.util.List;

@Data
public class OrderBillingDetails {

    private List<CustomerBillingDetail> customerDtl;

}
