package com.bms.test;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import com.bms.dao.BookingDao;
import com.bms.dao.BookingDaoImpl;
import com.bms.dao.PassengerDao;
import com.bms.dao.PassengerDaoImpl;
import com.bms.entity.Booking;
import com.bms.entity.Passenger;

public class PassengerTest {

	PassengerDao passengerDao = new PassengerDaoImpl();
	BookingDao bookingDao = new BookingDaoImpl();

	@Test
	public void addPassengerTest() {
		Passenger passenger = new Passenger();
		Booking booking = bookingDao.findBookingByBookingId(2002);

		passenger.setFirstName("Jane");
		passenger.setLastName("Fonda");
		passenger.setDateOfBirth(LocalDate.of(1986, 4, 5));
		passenger.setPhoneNo("9846843168");
		passenger.setSeatNo("4");
		passenger.setTravelDate(LocalDate.of(2022, 8, 16));
		passenger.setBooking(booking);
		passenger.setEmailId("jane@gmail.com");
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

//	@Test
//	public void findAllPassengersByBusId() {
//		List<Passenger> allPassengersByBusId = passengerDao.findAllPassengersByBusId(201);
//		for (Passenger passenger : allPassengersByBusId) {
//			System.out.println(passenger.getEmailId());
//		}
//	}

}
