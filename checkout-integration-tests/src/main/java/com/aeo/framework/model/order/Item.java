package com.aeo.framework.model.order;

import lombok.Data;

import java.util.List;

@Data
public class Item {

    private long lineItemNo;

    private String itemId;

    private String commerceItemId;

    private String reservationId;

    private int quantity;

    private String productClass;

    private String productURL;

    private String uom;

    private String unitSellPrice;

    private String unitRegularPrice;

    private String state;

    private String shipLocationId;

    private LineTaxes lineTaxes;

    private OrderDateDetails orderDateDtls;

    private ItemDeliveryDetails itemDeliveryDtls;
    
    private LinePromos linePromos;

    private List<AdditionalInfo> lineAdditionalData;

}
