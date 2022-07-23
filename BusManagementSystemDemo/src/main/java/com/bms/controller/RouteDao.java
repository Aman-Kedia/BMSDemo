package com.bms.controller;

import java.util.List;

import com.bms.entity.Bus;
import com.bms.entity.Route;

public interface RouteDao {
	Route addOrUpdateRoute(Route route);

	List<Bus> findAllBusesByRouteId(int routeId);
}
