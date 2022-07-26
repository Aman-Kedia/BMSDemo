package com.bms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.bms.entity.Bus;
import com.bms.entity.Passenger;

@Component
public class PassengerDaoImpl implements PassengerDao {

	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;
	
	public PassengerDaoImpl() {
		emf = Persistence.createEntityManagerFactory("oracle-pu");
		em = emf.createEntityManager();
	}

	//tested
	public Passenger addPassenger(Passenger passenger) {
		tx = em.getTransaction();
		tx.begin();
		Passenger persistedPassenger =  em.merge(passenger);
		tx.commit();
		return persistedPassenger;
	}

	//tested
	public List<Passenger> findAllPassengersByBookingId(int bookingId) {
		String jpql="SELECT p from Passenger p where p.booking.bookingId=:bid";
        TypedQuery<Passenger> qry=em.createQuery(jpql,Passenger.class);
        qry.setParameter("bid",bookingId);
        return qry.getResultList();
	}

	//tested
	public List<Passenger> findAllPassengersByBusId(int busId) {
		BusDao dao = new BusDaoImpl();
		Bus bus = dao.findBusByBusId(busId);
		List<Passenger> passengers = bus.getPassengers();
		return passengers;
	}

}
