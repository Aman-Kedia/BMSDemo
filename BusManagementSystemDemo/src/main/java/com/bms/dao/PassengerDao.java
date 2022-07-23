package com.bms.dao;

import java.util.List;

import com.bms.entity.Passenger;

public interface PassengerDao {
	void addPassenger(Passenger passenger);

	List<Passenger> findPassengersByBookingId(int bookingId);

	List<Passenger> findPassengersByBusId(int busId);
}
