package com.bms.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "bms_route")
public class Route {
	@Id
	@SequenceGenerator(name = "bms_route_seq", initialValue = 5001, allocationSize = 1)
	@GeneratedValue(generator = "bms_route_seq", strategy = GenerationType.SEQUENCE)
	int routeId;
	String origin;
	String destination;

	@OneToMany(mappedBy = "route")
	List<Bus> bus;

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public List<Bus> getBus() {
		return bus;
	}

	public void setBus(List<Bus> bus) {
		this.bus = bus;
	}
	
	
}
