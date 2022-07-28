package com.bms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bms.dto.UpdateBooking;
import com.bms.dto.UpdateBus;
import com.bms.dto.UpdatePassenger;
import com.bms.dto.UpdateRoute;
import com.bms.entity.Booking;
import com.bms.entity.Bus;
import com.bms.entity.Passenger;
import com.bms.entity.Route;
import com.bms.entity.User;
import com.bms.service.BookingService;
import com.bms.service.BusService;
import com.bms.service.PassengerService;
import com.bms.service.RouteService;
import com.bms.service.UserService;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

	@Autowired
	UserService userService;
	@Autowired
	BookingService bookingService;
	@Autowired
	PassengerService passengerService;
	@Autowired
	BusService busService;
	@Autowired
	RouteService routeService;

	// USER ENTITY

	@RequestMapping(value = "/find_user/{user_id}", method = RequestMethod.GET)
	public User findUser(@PathVariable int user_id) {
		return userService.findUser(user_id);
	}

	@RequestMapping(value = "/view_all_users", method = RequestMethod.GET)
	public List<User> viewAll() {
		return userService.viewAllUsers();
	}

	@RequestMapping(value = "/get_user_name/{user_id}", method = RequestMethod.GET)
	public String getUserName(@PathVariable int user_id) {
		return userService.getUserName(user_id);
	}

	// BOOKING ENTITY

	@RequestMapping(value = "/update_booking", method = RequestMethod.POST)
	public UpdateBooking updateBooking(@RequestBody Booking booking) {
		return bookingService.updatebooking(booking);
	}

	@RequestMapping(value = "/find_booking/{booking_id}", method = RequestMethod.GET)
	public Booking findBooking(@PathVariable int booking_id) {
		return bookingService.findBooking(booking_id);
	}

	@RequestMapping(value = "/find_passengers/{booking_id}", method = RequestMethod.GET)
	public List<Passenger> findPassengersByBooking(@PathVariable int booking_id) {
		return bookingService.findPassengersByBookingId(booking_id);
	}

	@RequestMapping(value = "/find_bookings/{bus_id}", method = RequestMethod.GET)
	public List<Booking> findBookings(@PathVariable int bus_id) {
		return bookingService.findAllBookingsbyBusId(bus_id);
	}

	@RequestMapping(value = "/cancel_bookings/{booking_id}", method = RequestMethod.GET)
	public void cancelBooking(int booking_id) {
		bookingService.cancelBooking(booking_id);
	}

	// PASSENGER ENTITY

	@RequestMapping(value = "/add_passenger", method = RequestMethod.POST)
	public String addPassenger(@RequestBody Passenger passenger) {
		String message = passengerService.addPassenger(passenger);
		return message;
	}

	@RequestMapping(value = "/update_passenger", method = RequestMethod.POST)
	public UpdatePassenger updatePassenger(@RequestBody Passenger passenger) {
		return passengerService.updatePassenger(passenger);
	}

	@RequestMapping(value = "/find_passengers/{bus_id}", method = RequestMethod.GET)
	public List<Passenger> findPassengersByBus(@PathVariable int bus_id) {
		return passengerService.findPassengersByBusId(bus_id);
	}

	// BUS ENTITY

	@RequestMapping(value = "/add_bus", method = RequestMethod.POST)
	public String addBus(@RequestBody Bus bus) {
		String message = busService.addBus(bus);
		return message;
	}

	@RequestMapping(value = "/update_bus", method = RequestMethod.POST)
	public UpdateBus updateBus(@RequestBody Bus bus) {
		return busService.updateBus(bus);
	}

	@RequestMapping(value = "/find_bus/{bus_id}", method = RequestMethod.GET)
	public Bus findBus(@PathVariable int bus_id) {
		return busService.findBus(bus_id);
	}

	// ROUTE ENTITY

	@RequestMapping(value = "/add_route", method = RequestMethod.POST)
	public String addRoute(@RequestBody Route route) {
		String message = routeService.addRoute(route);
		return message;
	}

	@RequestMapping(value = "/update_route", method = RequestMethod.POST)
	public UpdateRoute updateRoute(@RequestBody Route route) {
		return routeService.updateRoute(route);
	}

	@RequestMapping(value = "/find_route/{route_id}", method = RequestMethod.GET)
	public Route findRoute(@PathVariable int route_id) {
		return routeService.findRoute(route_id);
	}

	@RequestMapping(value = "/find_all_buses/{route_id}", method = RequestMethod.GET)
	public List<Bus> findAllBuses(@PathVariable int route_id) {
		return routeService.findAllBuses(route_id);
	}
}
