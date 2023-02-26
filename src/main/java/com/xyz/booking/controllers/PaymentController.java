package com.xyz.booking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.booking.models.Payment;
import com.xyz.booking.services.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	public PaymentService paymentService;
	
	public int createPayment(@RequestBody Payment payment) {
		return paymentService.createPayment(payment).getTransactionId();
	}
	
}
