package com.aeo.framework.model.order;

import lombok.Data;

import java.util.List;

@Data
public class PaymentMethods {

    private List<PaymentMethod> paymentMethod;

}
