package com.xyz.booking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyz.booking.models.Payment;
import com.xyz.booking.repos.PaymentRepo;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepo paymentRepo;
	
	public Payment createPayment(Payment payment) {
		return paymentRepo.save(payment);
	}
}
