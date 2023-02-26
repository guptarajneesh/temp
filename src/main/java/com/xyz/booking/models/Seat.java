package com.xyz.booking.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="seat")
public class Seat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    private boolean isReserved;
    private double price;
    
    @ManyToOne
	@JoinColumn(name = "booking_id", referencedColumnName = "id")
    private Booking booking;

    private Show show;

    public boolean book() {
        if (!isReserved) {
            isReserved = true;
            return true;
        }
        return false;
    }

    public void markAsAvailable() {
        isReserved = false;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public double getPrice() {
        return price;
    }

    public void updatePrice(double price) {
        this.price = price;
    }

    public Show getShow() {
        return show;
    }

    public void updateShow(Show show) {
        this.show = show;
    }

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setShow(Show show) {
		this.show = show;
	}
    
    
}