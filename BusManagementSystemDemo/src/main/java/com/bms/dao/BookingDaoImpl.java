package com.bms.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.bms.entity.Booking;
import com.bms.entity.Bus;
import com.bms.entity.Passenger;
import com.bms.entity.User;

@Component
public class BookingDaoImpl implements BookingDao {
	
	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;
	
	public BookingDaoImpl() {
		emf = Persistence.createEntityManagerFactory("oracle-pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}
	
	
	//tested
	public Booking addBooking(Booking booking) {
		tx.begin();
		Booking persistedBooking =  em.merge(booking);
		tx.commit();
		return persistedBooking;
	}

	//tested
	public Booking findBookingByBookingId(int bookingId) {
		return em.find(Booking.class, bookingId);
	}

	//tested
	public List<Passenger> findAllPassengersByBookingId(int bookingId) {
		Booking bk = findBookingByBookingId(bookingId);
		List<Passenger> passengers = bk.getPassengers();
		return passengers;
	}

	//tested
	public List<Booking> findAllBookingsByBusId(int BusId) {
		BusDao dao = new BusDaoImpl();
        Bus bus = dao.findBusByBusId(BusId);
        List<Booking> bookings = bus.getBookings();
        return bookings;
	}

	//tested
	public Booking cancelBooking(int BookingId) {
		Booking bk = findBookingByBookingId(BookingId);
		bk.setBookingStatus(false);
		tx.begin();
		Booking persistedBooking =  em.merge(bk);
		tx.commit();
		return persistedBooking;
	}

}
