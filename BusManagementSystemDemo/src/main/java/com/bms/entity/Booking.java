package com.bms.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "bms_booking")
public class Booking {
	
	@Id
	@SequenceGenerator(name = "bms_booking_seq", initialValue = 2001, allocationSize = 1)
	@GeneratedValue(generator = "bms_booking_seq", strategy = GenerationType.SEQUENCE)
	int bookingId;
	
	double bookingFare;
	LocalDate bookingDate;
	boolean bookingStatus;
	int noOfPassengers;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	User user;
	
	@OneToMany(mappedBy = "booking")
	List<Passenger> passengers;
	
	@ManyToOne
	@JoinColumn(name = "busId")
	Bus bus;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public double getBookingFare() {
		return bookingFare;
	}

	public void setBookingFare(double bookingFare) {
		this.bookingFare = bookingFare;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public boolean isBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(boolean bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public int getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}
	
	
	
}
