package com.aeo.framework.model;

public enum RabbitQueues {

    ORDERS_FINAL("orders.final-queue"),
    ORDERS_FINAL_FINAL("orders-final.final-queue"),
    ORDERS_FAILED_FAILED("orders-failed.failed-queue");

    private final String queueName;

    private RabbitQueues(String queueName) {
        this.queueName = queueName;
    }

    @Override
    public String toString(){
        return queueName;
    }
}
