package com.xyz.booking.models;

public class FrontDeskAssistant extends Member {

	public FrontDeskAssistant(String id, String name, String email, String phone) {
		super(id, name, email, phone);
	}

	public boolean createBookingAndIssueTicket(Booking booking) {
		// book a movie as requested by a customer
		return true;
	}

	// check in a customer
	public boolean checkIn(Booking booking) {
		return true; //booking.checkIn();
	}
}