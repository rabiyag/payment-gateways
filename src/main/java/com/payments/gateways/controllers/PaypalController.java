package com.payments.gateways.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.payments.gateways.models.PaymentRequest;
import com.payments.gateways.models.PaypalPaymentRequest;
import com.payments.gateways.services.PaypalPaymentService;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

@RestController
@RequestMapping("/api/paypal")
public class PaypalController {

    @Autowired
    PaypalPaymentService paypalPaymentService;

    @PostMapping("/create-payment")
    public ResponseEntity<Payment> createPayment(@RequestBody PaypalPaymentRequest paymentRequest) {
        try {
            Payment payment = paypalPaymentService.createPayment(
                    paymentRequest.getAmount(),
                    "usd",
                    "paypal",
                    "sale");
            return ResponseEntity.ok(payment);
        } catch (PayPalRESTException e) {
            return ResponseEntity.status(500).body(null);

        }
    }

}