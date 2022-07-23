package com.bms.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "bms_passenger")
public class Passenger {
	@Id
	@SequenceGenerator(name = "bms_passenger_seq", initialValue = 3001, allocationSize = 1)
	@GeneratedValue(generator = "bms_passenger_seq", strategy = GenerationType.SEQUENCE)
	int passengerId;

	String firstName;
	String lastName;
	LocalDate dateOfBirth;
	String phoneNo;
	String emailId;
	String seatNo;
	LocalDate travelDate;
	
	@ManyToOne
	@JoinColumn(name = "bookingId")
	Booking booking;
	
	@ManyToOne
	@JoinColumn(name = "busId")
	Bus bus;

}
