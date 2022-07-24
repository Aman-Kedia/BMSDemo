package com.bms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.bms.entity.Booking;
import com.bms.entity.User;

@Component
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public User addOrUpdateUser(User user) {
		return em.merge(user);
	}

	public User findUserByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> viewAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public User addOrUpdateAdmin(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Booking> viewAllPreviousBookings() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean login(String emailId, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
