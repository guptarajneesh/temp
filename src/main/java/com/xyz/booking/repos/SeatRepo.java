package com.xyz.booking.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xyz.booking.models.Seat;

@Repository
public interface SeatRepo extends JpaRepository<Seat, Long> {
	public Seat findByBooking(Long bookingId);
}