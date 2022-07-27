package com.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bms.entity.Route;
import com.bms.entity.User;
import com.bms.service.RouteService;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

	@Autowired
	RouteService routeService;
	
	@RequestMapping(value = "/addroute", method = RequestMethod.POST)
	public String addRoute(@RequestBody Route route) {
		String message = routeService.addRoute(route);
		return message;
	}
}
