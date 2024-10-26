package com.payments.gateways.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payments.gateways.models.StripePaymentRequest;
import com.payments.gateways.services.StripePaymentService;
import com.stripe.model.PaymentIntent;

@RestController
@RequestMapping("/api/stripe")
public class StripeController {

    @Autowired
    private StripePaymentService stripePaymentService;

    @PostMapping("/paymentIntent")
    public ResponseEntity<Object> createPaymentIntent(@RequestBody StripePaymentRequest paymentRequest) {

       PaymentIntent intent = stripePaymentService.createPaymentIntent(paymentRequest.getAmount());
       return ResponseEntity.ok().build();
    }

}
