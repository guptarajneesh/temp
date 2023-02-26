package com.xyz.booking.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xyz.booking.enums.PaymentMethod;
import com.xyz.booking.enums.PaymentStatus;

@Entity
@Table(name="payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonProperty("amount")
    private double amount;
	
	@JsonProperty("transaction_id")
    private int transactionId;
	
	@JsonProperty("payment_status")
    private PaymentStatus status;
	
	@JsonProperty("payment_method")
    private PaymentMethod paymentMethod;

    public Payment(double amount, int transactionId, PaymentStatus status, PaymentMethod paymentMethod) {
        this.amount = amount;
        this.transactionId = transactionId;
        this.paymentMethod = paymentMethod;
    }

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Long getId() {
		return id;
	}

}
