package com.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bms.dto.LoginDto;
import com.bms.dto.UpdateUser;
import com.bms.entity.Booking;
import com.bms.entity.User;
import com.bms.service.BookingService;
import com.bms.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	BookingService bookingService;

	// USER ENTITY

	@RequestMapping(value = "/signup_user", method = RequestMethod.POST)
	public String signup(@RequestBody User user) {
		String message = userService.signUp(user);
		return message;
	}

	@RequestMapping(value = "/update_user", method = RequestMethod.POST)
	public UpdateUser update(@RequestBody User user) {
		return userService.updateUser(user);
	}

	@RequestMapping(value = "/user_login", method = RequestMethod.POST)
	public boolean login(@RequestBody LoginDto loginDto) {
		return userService.userLogin(loginDto.getEmail(), loginDto.getPassword());
	}

	// BOOKING ENTITY

	@RequestMapping(value = "/add_booking", method = RequestMethod.POST)
	public String addBooking(@RequestBody Booking booking) {
		String message = bookingService.addBooking(booking);
		return message;
	}

	// PASSENGER ENTITY

	// BUS ENTITY

	// ROUTE ENTITY

	// EXTRAS
}
