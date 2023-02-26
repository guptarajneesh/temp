package com.xyz.booking.models;
public class CustomerCareRepresentative extends Member {

    public CustomerCareRepresentative(String id, String name, String email, String phone) {
        super(id, name, email, phone);
    }

    public boolean createBooking(Booking booking) {
        // book a movie as requested by a customer
    	return true;
    }
}