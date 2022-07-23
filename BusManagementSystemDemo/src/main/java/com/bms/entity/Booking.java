package com.bms.entity;

import java.time.LocalDate;
import java.util.List;

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
@Table(name = "bms_booking")
public class Booking {
	
	@Id
	@SequenceGenerator(name = "bms_booking_seq", initialValue = 2001, allocationSize = 1)
	@GeneratedValue(generator = "bms_booking_seq", strategy = GenerationType.SEQUENCE)
	int bookingId;
	
	double bookingFare;
	LocalDate bookingDate;
	boolean bookingStatus;
	int noOfPassengers;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	User user;
	
	@OneToMany(mappedBy = "passenger")
	List<Passenger> passengers;
	
	@OneToOne
	@JoinColumn(name = "busId")
	Bus bus;
	
}
