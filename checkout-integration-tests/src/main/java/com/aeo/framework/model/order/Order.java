package com.aeo.framework.model.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
public class Order {

    private String orderId;

    private String profileId;

    private String sourceApplication;

    private String channel;

    private String state;

    private String stateDetail;
    
    private OrderMetaData metaData;

    private String storeId;

    private List<CustomerOrder> customerOrder;
}
