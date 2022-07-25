package com.bms.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import com.bms.dao.BookingDao;
import com.bms.dao.BookingDaoImpl;
import com.bms.entity.Booking;
import com.bms.entity.Passenger;

public class BookingTest {

	BookingDao dao = new BookingDaoImpl();
	
	@Test
	public void addBookingTest() {
		Booking booking = new Booking();
		
		booking.setBookingFare(50.0);
		booking.setBookingDate(LocalDate.of(2022,07,20));
		booking.setBookingStatus(true);
		booking.setNoOfPassengers(1);
		
		Booking savedBooking = dao.addBooking(booking);
		
		assertNotNull(savedBooking);
	}
	
	@Test
	public void findBookingByBookingId() {
		Booking booking = dao.findBookingByBookingId(2001);
		assertNotNull(booking);
	}
	
	@Test
	public void findAllPassengersByBookingIdTest() {
		List<Passenger> passengers = dao.findAllPassengersByBookingId(2001);
		assertNotEquals(0, passengers.size());
		
		for(Passenger p:passengers) {
			System.out.println(p.getFirstName() + " " + p.getLastName());
		}
	}
	
	@Test
	public void findAllBookingsByBusId() {
		
	}
	
	@Test
	public void cancelBookingTest() {
		Booking booking = dao.cancelBooking(2001);
		System.out.println(booking.isBookingStatus());
	}

}
