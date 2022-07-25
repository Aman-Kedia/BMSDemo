package com.bms.dao;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.bms.entity.Bus;
import com.bms.entity.Passenger;

@Component
public class BusDaoImpl implements BusDao {

	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;
	Query qry;

	public BusDaoImpl() {
		emf = Persistence.createEntityManagerFactory("oracle-pu");
		em = emf.createEntityManager();
	}

	//tested
	public Bus addOrUpdateBus(Bus bus) {
		tx = em.getTransaction();
		tx.begin();
		Bus busPersisted = em.merge(bus);
		tx.commit();
		return busPersisted;
	}
	
	//tested
	public Bus findBusByBusId(int busId) {
		return em.find(Bus.class, busId);
	}

	public List<Passenger> findAllPassengersByBusId(int busId) {
		Bus bus = findBusByBusId(busId);
		List<Passenger> passengers = bus.getPassengers();
		return passengers;
	}

}