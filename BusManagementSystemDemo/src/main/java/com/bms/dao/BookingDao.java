package com.bms.dao;

import java.util.List;

import com.bms.entity.Booking;
import com.bms.entity.Passenger;

public interface BookingDao {
	void addBooking(Booking booking);

	Booking findBookingByBookingId(int bookingId);

	Passenger findPassengerByBookingId(int bookingId);

	List<Booking> findAllBookingsByBusId(int BusId);

	void cancelBooking(int BookingId);
}
