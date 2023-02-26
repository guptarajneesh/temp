package com.xyz.booking.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xyz.booking.models.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Long>{

}
