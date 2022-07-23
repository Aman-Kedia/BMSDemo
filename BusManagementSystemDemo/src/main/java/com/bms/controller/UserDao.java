package com.bms.controller;

import java.util.List;

import com.bms.entity.Booking;
import com.bms.entity.User;

public interface UserDao {
	User addOrUpdateUser(User user);

	User findUserByUserId(int userId);

	List<User> viewAllUsers();

	User addOrUpdateAdmin(User user);

	List<Booking> viewPreviousBookings();

	boolean login(String emailId, String password);
}
