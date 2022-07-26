package com.bms.test;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import com.bms.dao.BookingDao;
import com.bms.dao.BookingDaoImpl;
import com.bms.dao.BusDao;
import com.bms.dao.BusDaoImpl;
import com.bms.dao.PassengerDao;
import com.bms.dao.PassengerDaoImpl;
import com.bms.entity.Booking;
import com.bms.entity.Bus;
import com.bms.entity.Passenger;

public class PassengerTest {

	PassengerDao passengerDao = new PassengerDaoImpl();
	BookingDao bookingDao = new BookingDaoImpl();
	BusDao busDao = new BusDaoImpl();

	@Test
	public void addPassengerTest() {
		Passenger passenger = new Passenger();
		Booking booking = bookingDao.findBookingByBookingId(2002);
		Bus bus = busDao.findBusByBusId(4021);
		passenger.setFirstName("Ian");
		passenger.setLastName("Kan");
		passenger.setDateOfBirth(LocalDate.of(2002, 7, 9));
		passenger.setPhoneNo("8438468138");
		passenger.setSeatNo("2");
		passenger.setTravelDate(LocalDate.of(2022, 8, 16));
		passenger.setBooking(booking);
		passenger.setEmailId("ian@gmail.com");
		passenger.setBus(bus);
		Passenger savedPassenger = passengerDao.addPassenger(passenger);

		assertNotNull(savedPassenger);
	}

	@Test
	public void findAllPassengersByBookingId() {
		List<Passenger> allPassengersByBookingId = passengerDao.findAllPassengersByBookingId(2001);
		for (Passenger passenger : allPassengersByBookingId) {
			System.out.println(passenger.getEmailId());
		}

	}

	@Test
	public void findAllPassengersByBusId() {
		List<Passenger> allPassengersByBusId = passengerDao.findAllPassengersByBusId(4021);
		for (Passenger passenger : allPassengersByBusId) {
			System.out.println(passenger.getEmailId());
		}
	}

}
