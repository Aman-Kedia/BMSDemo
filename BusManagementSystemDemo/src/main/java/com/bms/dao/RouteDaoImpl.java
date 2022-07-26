package com.bms.dao;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import com.bms.entity.Bus;
import com.bms.entity.Route;

@Component
public class RouteDaoImpl implements RouteDao {
	
	EntityManagerFactory emf;
    EntityManager em; // persistence context
    EntityTransaction tx;
    Query qry;


    public RouteDaoImpl() {
        emf = Persistence.createEntityManagerFactory("oracle-pu");
        em = emf.createEntityManager();
    }

    //tested
    public Route addOrUpdateRoute(Route route) {
        tx = em.getTransaction();
        tx.begin();
        Route routePersisted = em.merge(route);
        tx.commit();
        return routePersisted;
    }
 
    //tested
    public Route findRouteByRouteId(int routeId) {
        return em.find(Route.class, routeId);
    }
 
    //tested
    public List<Bus> findAllBusesByRouteId(int routeId) {
        Route route = findRouteByRouteId(routeId);
        List<Bus> buses = route.getBus();
        return buses;
    }

}
