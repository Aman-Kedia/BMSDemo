package com.bms.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "bms_user")
public class User {
	
	@Id
	@SequenceGenerator(name = "bms_user_seq", initialValue = 1001, allocationSize = 1)
	@GeneratedValue(generator = "bms_user_seq", strategy = GenerationType.SEQUENCE)
	int userId;
	
	String firstName;
	String lastName;
	LocalDate dateOfBirth;
	String phoneNo;
	GenderType gender;
	@Column(unique = true)
	String email;
	boolean isAdmin;
	double walletBalance;
	String userPassword;
	
	@OneToMany(mappedBy = "user")
	List<Booking> bookings;
}
