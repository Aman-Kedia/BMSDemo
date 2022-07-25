package com.bms.test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bms.dao.UserDao;
import com.bms.dao.UserDaoImpl;
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

}
