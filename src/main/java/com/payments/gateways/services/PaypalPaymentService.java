package com.payments.gateways.services;

import java.lang.ProcessBuilder.Redirect;
import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

@Service
public class PaypalPaymentService {

    @Value("${paypal.client.id}")
    private String clientId;
    @Value("${paypal.client.secret}")
    private String clientSecret;
    @Value("${paypal.mode}")
    private String mode;

     public Payment createPayment(Double total, String currency, String method, String intent) throws PayPalRESTException {

        APIContext apiContext = new APIContext(clientId, clientSecret, mode);

        Amount amount = new Amount();
        amount.setCurrency(currency);
        amount.setTotal(String.valueOf(total));

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDescription("transaction description");

        Payer payer = new Payer();
        payer.setPaymentMethod(method);

        Payment payment = new Payment();
        payment.setPayer(payer);
        payment.setTransactions(Collections.singletonList(transaction));
        payment.setIntent(intent);


        RedirectUrls redirectUrls =new RedirectUrls();
        redirectUrls.setCancelUrl("http://localhost:8080/cancel");
        redirectUrls.setReturnUrl("http://localhost:8080/success");
        return payment.create(apiContext);

     }
    
}
