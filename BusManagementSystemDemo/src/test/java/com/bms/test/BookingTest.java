package com.bms.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import com.bms.dao.BookingDao;
import com.bms.dao.BookingDaoImpl;
import com.bms.dao.BusDao;
import com.bms.dao.BusDaoImpl;
import com.bms.entity.Booking;
import com.bms.entity.Bus;
import com.bms.entity.Passenger;

public class BookingTest {

	BookingDao dao = new BookingDaoImpl();
	BusDao busDao = new BusDaoImpl();
	
	@Test
	public void addBookingTest() {
		Booking booking = new Booking();
		Bus bus = busDao.findBusByBusId(4021);
		booking.setBookingFare(100.0);
		booking.setBookingDate(LocalDate.of(2022,07,26));
		booking.setBookingStatus(true);
		booking.setNoOfPassengers(2);
		booking.setBus(bus);
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
		List<Booking> bookings = dao.findAllBookingsByBusId(4021);
		assertNotEquals(0, bookings.size());
		
		for(Booking b:bookings) {
			System.out.println(b.getBookingId() + " " + b.getNoOfPassengers());
		}
	}
	
	@Test
	public void cancelBookingTest() {
		Booking booking = dao.cancelBooking(2001);
		System.out.println(booking.isBookingStatus());
	}

}
