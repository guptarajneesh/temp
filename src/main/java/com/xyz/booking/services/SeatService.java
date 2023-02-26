package com.xyz.booking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyz.booking.enums.BookingStatus;
import com.xyz.booking.models.Booking;
import com.xyz.booking.models.Seat;
import com.xyz.booking.repos.SeatRepo;

@Service
public class SeatService {

	@Autowired
	private SeatRepo seatRepo;
	
	@Autowired
	private BookingService bookingService;

	public Seat createSeat(Seat seat) throws Exception {
		Booking booking = bookingService.createBooking(seat.getBooking());
		if (booking.getStatus().equals(BookingStatus.CONFIRMED))
			seat.setReserved(true);
		else
			seat.setReserved(true);
		
		return seatRepo.save(seat);
	}
}
