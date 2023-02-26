package com.xyz.booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyz.booking.enums.BookingStatus;
import com.xyz.booking.models.Booking;
import com.xyz.booking.models.Payment;
import com.xyz.booking.models.Seat;
import com.xyz.booking.repos.BookingRepo;
import com.xyz.booking.repos.SeatRepo;

@Service
public class BookingService {
	private List<Seat> seats;
	private BookingStatus status;
	private SeatRepo seatRepo;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private BookingRepo bookingRepo;

	public Booking createBooking(Booking bookingData) throws Exception {
		Seat seat = seatRepo.findByBooking(Long.valueOf(bookingData.getNumber()));
		Booking booking = seat.getBooking();
		booking.setStatus(BookingStatus.PENDING);
		Payment payment = paymentService.createPayment(bookingData.getPayment());
		
		if(makePayment(payment)) {
			booking.setStatus(BookingStatus.CONFIRMED);
			booking = bookingRepo.save(booking);
		}
		else {
			booking.setStatus(BookingStatus.PENDING);
			booking = bookingRepo.save(booking);
			//throw new Exception("Payment gets failed");
		}
		return booking;
	}

	public boolean makePayment(Payment payment) {
		payment = paymentService.createPayment(payment);
		int txId = payment.getTransactionId();
		String paymentStatus = payment.getStatus().toString();
		if(txId !=0 && paymentStatus.equalsIgnoreCase("COMPLETED"))
			return true;
		else return false;
	}

	public boolean cancel() {
		if (status != BookingStatus.CHECKED_IN) {
			status = BookingStatus.CANCELED;
			return true;
		}
		return false;
	}

	public boolean reserveSeat(Seat seat) {
		return seat.book();
	}

	public boolean reserveSeats(List<Seat> requestedSeats) {
		for (Seat seat : requestedSeats) {
			if (!seat.book()) {
				unreserve(seats); // if we are not able to
				// reserve all the requested seats we do NOT do partial booking
				return false;
			}
		}
		return true;
	}

	private void unreserve(List<Seat> seats) {
		for (Seat seat : seats) {
			if (!seat.isReserved()) {
				return;
			}
			seat.markAsAvailable();
		}
	}

	public boolean confirmBooking() {
		if (status == BookingStatus.PENDING) {
			status = BookingStatus.CONFIRMED;
			return true;
		}
		return false;
	}

	public boolean checkIn() {
		if (status == BookingStatus.CONFIRMED) {
			status = BookingStatus.CHECKED_IN;
			return true;
		}
		return false;
	}
}
