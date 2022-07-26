package com.bms.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.bms.dao.RouteDao;
import com.bms.dao.RouteDaoImpl;
import com.bms.entity.Bus;
import com.bms.entity.Route;

public class RouteTest {

	RouteDao dao = new RouteDaoImpl();

	@Test
	public void addOrUpdateRouteTest() {
		Route route = new Route();
		route.setOrigin("Mumabi");
		route.setDestination("Delhi");

		assertNotNull(dao.addOrUpdateRoute(route));
	}

	@Test
	public void findRouteByRouteId() {
		Route route = dao.findRouteByRouteId(5002);
		System.out.println(route.getOrigin() + " " + route.getDestination());
	}

	@Test
	public void findAllBusesByRouteId() {
		Route route = dao.findRouteByRouteId(5021);
		List<Bus> buses = route.getBus();
		for (Bus b : buses) {
			System.out.println(b.getBusId() + " " + b.getBusNo());
		}
	}

}
