package com.payments.gateways.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

@Service
public class StripePaymentService {


    @Value("${stripe.api.key}")
    private String stripeApiKey;

    public PaymentIntent createPaymentIntent(Long amount)  {
        Stripe.apiKey = stripeApiKey;
        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
        .setAmount(amount)
        .setCurrency("usd")
        .build();

        try{
           return PaymentIntent.create(params);
        }
        catch(Exception ex) {
            throw new RuntimeException("Payment creation failed: " + ex.getMessage());
        }
    }
}
