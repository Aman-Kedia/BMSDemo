package com.bms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.bms.entity.Bus;
import com.bms.entity.Passenger;

@Component
public class BusDaoImpl implements BusDao {

	@PersistenceContext
	EntityManager em;

	@Transactional
	public Bus addOrUpdateBus(Bus bus) {
		return em.merge(bus);
	}

	public Bus findBusByBusId(int busId) {
		return em.find(Bus.class, busId);
	}

	public List<Passenger> findAllPassengersByBusId(int busId) {
		Bus bus = findBusByBusId(busId);
		List<Passenger> passengers = bus.getPassengers();
		return passengers;
	}

}