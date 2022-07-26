package com.bms.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "bms_bus")
public class Bus {
	@Id
	@SequenceGenerator(name = "bms_bus_seq", initialValue = 4001, allocationSize = 1)
	@GeneratedValue(generator = "bms_bus_seq", strategy = GenerationType.SEQUENCE)
	int busId;

	String busNo;
	BusType bustype;
	double busFare;

	@Column(columnDefinition = "int default 50")
	int capacity;
	
	@Column(length = 5)
	String arrivalTime;
	
	@Column(length = 5)
	String departureTime;

	@OneToMany(mappedBy = "bus")
	List<Booking> bookings;
	
	@OneToMany(mappedBy = "bus")
	List<Passenger> passengers;
	
	@ManyToOne
	@JoinColumn(name = "routeId")
	Route route;

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getBusNo() {
		return busNo;
	}

	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}

	public BusType getBustype() {
		return bustype;
	}

	public void setBustype(BusType bustype) {
		this.bustype = bustype;
	}

	public double getBusFare() {
		return busFare;
	}

	public void setBusFare(double busFare) {
		this.busFare = busFare;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}
	
	
}
