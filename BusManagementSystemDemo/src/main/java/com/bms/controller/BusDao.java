package com.bms.controller;

import java.util.List;

import com.bms.entity.Bus;
import com.bms.entity.Passenger;

public interface BusDao {
	Bus addOrUpdateBus(Bus bus);

	Bus findBusByBusId(int busId);

	List<Passenger> findAllPassengersByBusId(int busId);
}
