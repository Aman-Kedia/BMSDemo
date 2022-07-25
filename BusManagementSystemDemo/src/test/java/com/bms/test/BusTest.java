package com.bms.test;

import static org.junit.Assert.assertNotNull;

import java.time.LocalTime;
import java.util.List;

import org.junit.Test;

import com.bms.dao.BusDao;
import com.bms.dao.BusDaoImpl;
import com.bms.dao.RouteDao;
import com.bms.dao.RouteDaoImpl;
import com.bms.entity.Bus;
import com.bms.entity.BusType;
import com.bms.entity.Passenger;
import com.bms.entity.Route;

public class BusTest {

	BusDao dao = new BusDaoImpl();
	RouteDao routeDao = new RouteDaoImpl();
	 
	@Test
	public void addOrUpdateBusTest() {
		Bus bus = new Bus();

		bus.setBusNo("RJ05EY1234");
		bus.setBustype(BusType.AC);
		bus.setBusFare(1200.23);
		bus.setArrivalTime("14:00");
		bus.setDepartureTime("10:00");
		bus.setSeatsBooked(12);
		
		Route route = routeDao.findRouteByRouteId(5002);
		
		bus.setRoute(route);

		Bus bus2 = dao.addOrUpdateBus(bus);
		assertNotNull(bus2);
	}

  @Test
  public void findBusByBusIdTest() {
      Bus bus = dao.findBusByBusId(4008);
      System.out.println(bus.getBusId()+" "+bus.getBusNo());
  }

  @Test
  public void findAllPassengersByBusIdTest() {
      List<Passenger> passengers = dao.findAllPassengersByBusId(4001);
      for(Passenger p:passengers) {
          System.out.println(p.getPassengerId()+' '+p.getFirstName()+' '+p.getLastName());
      }
  }
}
