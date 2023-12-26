package com.aeo.framework.model.response;

import com.aeo.framework.model.OrderTaxes;
import lombok.Data;

@Data
public class TaxResponseBody {

    String orderId;
    String errorMessage;
    OrderTaxes orderTaxes;
}
