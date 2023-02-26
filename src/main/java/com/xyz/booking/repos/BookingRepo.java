package com.xyz.booking.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xyz.booking.models.Booking;

public interface BookingRepo extends JpaRepository<Booking, Long>{

}
