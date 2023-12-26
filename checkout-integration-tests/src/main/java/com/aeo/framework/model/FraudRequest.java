package com.aeo.framework.model;

import com.aeo.framework.model.order.CustomerBillingDetail;
import com.aeo.framework.model.order.CustomerOrder;
import com.aeo.framework.model.order.CustomerShippingDetail;
import com.aeo.framework.model.order.Item;
import com.aeo.framework.model.order.OrderMetaData;
import com.aeo.framework.model.order.PaymentMethod;
import lombok.Data;

import java.util.List;

@Data
public class FraudRequest {

    private String orderId;
    private String website;
    private String orderTimeZone;
    private String userId;
    private String freightAmount;
    private String amount;
    private boolean resubmittedOrder;
    private CustomerOrder customerOrder;
    private CustomerBillingDetail customerBillingDetail;
    private CustomerShippingDetail customerShippingDetail;
    private OrderMetaData orderMetaData;
    private List<String> appliedCoupons;
    private List<FraudItem> items;
    private List<PaymentMethod> paymentMethods;

}
