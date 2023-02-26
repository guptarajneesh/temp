package com.xyz.booking.models;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Member {

	private List<Booking> currentBookings = new ArrayList<>();

	public Customer(String name, String email, String phone) {
		super(name, email, phone);
	}

	public boolean makeBooking(Booking booking) {
		// making a booking for a movie show
		// if booking goes through successfully:
		// add the booking to currentBookings list
		// currentBookings.add(booking);
		// return true

		// if the booking fails:
		// return false;
		return true;
	}

	public List<Booking> getBookings() {
		return currentBookings;
	}

	public boolean cancelBooking(Booking booking) {
		// if the cancelation go through
		// remove the booking from currentBookings list and
		// return true
		//
		// otherwise return false

		return true;
	}

}