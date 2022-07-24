package com.bms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.bms.entity.Booking;
import com.bms.entity.Bus;
import com.bms.entity.Passenger;

@Component
public class PassengerDaoImpl implements PassengerDao {

	@PersistenceContext
	EntityManager em;

	@Transactional
	public Passenger addPassenger(Passenger passenger) {
		return em.merge(passenger);
	}

	public List<Passenger> findAllPassengersByBookingId(int bookingId) {
		BookingDao dao = new BookingDaoImpl();
		Booking book = dao.findBookingByBookingId(bookingId);
		List<Passenger> passengers = book.getPassengers();
		return passengers;
	}

	public List<Passenger> findAllPassengersByBusId(int busId) {
		BusDao dao = new BusDaoImpl();
		Bus bus = dao.findBusByBusId(busId);
		List<Passenger> passengers = bus.getPassengers();
		return passengers;
	}

}
