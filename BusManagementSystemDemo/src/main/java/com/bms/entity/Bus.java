package com.bms.entity;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

	@Column(columnDefinition = "int default 0")
	int seatsBooked;
	LocalTime arrivalTime;
	LocalTime departureTime;

	@OneToOne(mappedBy = "booking")
	Booking booking;
	
	@OneToMany(mappedBy = "bus")
	List<Passenger> passengers;
	
	@ManyToOne
	@JoinColumn(name = "routeId")
	Route route;
}
