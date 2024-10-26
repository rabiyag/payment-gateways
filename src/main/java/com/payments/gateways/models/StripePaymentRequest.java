package com.payments.gateways.models;

public class StripePaymentRequest {

    private Long amount;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

}
