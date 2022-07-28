package com.bms.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.bms.entity.Booking;
import com.bms.entity.User;

@Component
public class UserDaoImpl implements UserDao {

	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;
	
	public UserDaoImpl() {
		emf = Persistence.createEntityManagerFactory("oracle-pu");
		em = emf.createEntityManager();
	}
	
	//tested
	public User addOrUpdateUser(User user) {
		tx = em.getTransaction();
		tx.begin();
		user.setDateOfBirth(user.getDateOfBirth());
		User persistedUser =  em.merge(user);
		tx.commit();
		return persistedUser;
	}

	//tested
	public User findUserByUserId(int userId) {
		return em.find(User.class, userId);
	}

	//tested
	public List<User> viewAllUsers() {
		String jpql = "select u from User u";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		return query.getResultList();
	}

	//tested
	public User addOrUpdateAdmin(User user) {
		return em.merge(user);
	}

	
	public List<Booking> viewAllPreviousBookings() {
		String jpql = "select b from Booking b";
		TypedQuery<Booking> query = em.createQuery(jpql, Booking.class);
		return query.getResultList();
	}
	
	//tested
	public boolean login(String email, String password) {
		String jpql = "Select u from User u where u.email=:eid and u.userPassword=:pwd";
		TypedQuery<User> qry = em.createQuery(jpql, User.class);
		qry.setParameter("eid", email);
		qry.setParameter("pwd", password);
		User user = qry.getSingleResult();
		return user!=null?true:false;
	}

}
