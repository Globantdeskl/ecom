package com.aeo.framework;

public enum Environment {
    SIT("https://fulfillment-utility-sit.int-np.ae-gcp.io",
            "https://checkout-submit-order-sit.int-np.ae-gcp.io",
            "https://checkout-fraud-check-sit.int-np.ae-gcp.io/",
            "https://checkout-same-day-delivery-sit.int-np.ae-gcp.io/",
            "https://checkout-tax-calculator-sit.int-np.ae-gcp.io",
            "pcf_sb_38_1568661261946464230",
            300000),
    DEV("https://fulfillment-utility-dev.apps.non-prod.ae-cf.io",
            "https://application-example-url",
            "",
            "",
            "",
            "pcf_sb_37_1568661014664713627",
            20000);


    public final String fulfillmentUtility;
    public final String submitOrderRestController;
    public final String checkoutFraudCheck;
    public final String checkoutSDD;
    public final String checkoutTaxCalculator;
    public final String orderPublisherPubSubTopicName;
    public final long remorsePeriod;

    Environment(String fulfillmentUtility,
                String submitOrderRestController,
                String checkoutFraudCheck,
                String checkoutSDD,
                String checkoutTaxCalculator,
                String orderPublisherPubSubTopicName,
                long remorsePeriod) {
        this.fulfillmentUtility = fulfillmentUtility;
        this.submitOrderRestController = submitOrderRestController;
        this.checkoutFraudCheck = checkoutFraudCheck;
        this.checkoutSDD = checkoutSDD;
        this.checkoutTaxCalculator = checkoutTaxCalculator;
        this.orderPublisherPubSubTopicName = orderPublisherPubSubTopicName;
        this.remorsePeriod = remorsePeriod;
    }

}