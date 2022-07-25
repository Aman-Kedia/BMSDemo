package com.bms.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import com.bms.dao.UserDao;
import com.bms.dao.UserDaoImpl;
import com.bms.entity.Booking;
import com.bms.entity.GenderType;
import com.bms.entity.User;

public class UserTest {

	UserDao userDao = new UserDaoImpl();

//	@Before
//    public void initialize() {
////        ApplicationContext context = new ClassPathXmlApplicationContext("per");
//        userDao = context.getBean(UserDao.class);
//    }

	@Test
	public void addOrUpdateUserTest() {
		User user = new User();
		user.setFirstName("John");
		user.setLastName("Smith");
		user.setDateOfBirth(LocalDate.of(1985, 2, 12));
		user.setPhoneNo("9879879871");
		user.setGender(GenderType.Male);
		user.setEmail("john@gmail.com");
		user.setAdmin(true);
		user.setWalletBalance(100);
		user.setUserPassword("John@123");

		User savedUser = userDao.addOrUpdateUser(user);
		assertNotNull(savedUser);
	}

	@Test
	public void findUserByUserIdTest() {
		User user = userDao.findUserByUserId(1001);
		System.out.println(user.getFirstName() + " " + user.getUserId());
	}

	@Test
	public void viewAllUsersTest() {
		List<User> users = userDao.viewAllUsers();
		for (User u : users) {
			System.out.println(u.getUserId() + " " + u.getFirstName());
		}
	}

	@Test
	public void viewAllPreviousBookingsTest() {
		List<Booking> bookings = userDao.viewAllPreviousBookings();
		for (Booking b : bookings) {
			System.out.println(b.getBookingId() + " " + b.getBookingDate());
		}
	}

	@Test
	public void loginTest() {
		boolean isValid = userDao.login("john@gmail.com", "John@123");
		assertTrue(isValid);
	}

}
