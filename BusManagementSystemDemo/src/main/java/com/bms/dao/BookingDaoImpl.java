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
public class BookingDaoImpl implements BookingDao {

	@PersistenceContext
	EntityManager em;

	@Transactional
	public Booking addBooking(Booking booking) {
		return em.merge(booking);
	}

	public Booking findBookingByBookingId(int bookingId) {
		return em.find(Booking.class, bookingId);
	}

	public List<Passenger> findAllPassengersByBookingId(int bookingId) {
		Booking bk = findBookingByBookingId(bookingId);
		List<Passenger> passengers = bk.getPassengers();
		return passengers;
	}

	public List<Booking> findAllBookingsByBusId(int BusId) {
		BusDao dao = new BusDaoImpl();
        Bus bus = dao.findBusByBusId(BusId);
        List<Booking> bookings = bus.getBookings();
        return bookings;
	}

	public Booking cancelBooking(int BookingId) {
		Booking bk = findBookingByBookingId(BookingId);
		bk.setBookingStatus(false);
		return em.merge(bk);
	}

}
