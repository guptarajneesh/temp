package com.xyz.booking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xyz.booking.models.Booking;
import com.xyz.booking.services.BookingService;

@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@PostMapping("/booking")
	public Long createBooking(@RequestBody Booking booking) throws Exception {
		/*
		 * Movie m = new Movie(); m.setDescription("dummy desc"); m.setGenre("Comedy");
		 * m.setTitle("Hera Pheri");
		 * 
		 * List<Seat> seats = new ArrayList<>(); Seat s1 = new Seat();
		 * s1.setPrice(250.00); s1.setReserved(false); Show show = new Show();
		 * s1.setShow(show); show.setDurationInMin(120); show.setPlayingAt("1");
		 * show.setShowName("Morning"); show.setStartTime("12.00 PM"); show.setMovie(m);
		 * m.setShows(show); seats.add(s1);
		 * 
		 * Payment p = new Payment(250,9001,PaymentStatus.UNPAID, PaymentMethod.CASH);
		 * 
		 * Booking b = new Booking("B101", show, seats, p);
		 */
		System.out.println(new ObjectMapper().writeValueAsString(booking));
		return bookingService.createBooking(booking).getId();
	}

}
