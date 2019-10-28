package org.stuff.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import org.stuff.entities.User;


@SpringBootTest
@Transactional
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ContextConfiguration(classes=org.stuff.app.RevProject2Application.class)
public class UserServiceTest {


	@Autowired
	UserService us;
	
	
	// saving an instance of user for testing
	static User testUser1;
	static User testUser2;
	
	@Test
	@Order(1)
	@Commit
	void setup() {
		testUser1 = new User();
		testUser1.setUsername("USTestUser1");
		testUser1.setPassword("Pa$$word");
		testUser1.setEmail("TestUser@test.com");
		testUser1.setPhoneNumber("1234567890");
		testUser1 = us.createUser(testUser1);
		assertTrue(testUser1 != null);
		
		testUser2 = new User();
		testUser2.setUsername("USTestUser2");
		testUser2.setPassword("Pa$$word1");
		testUser2.setEmail("TestUser@test.com");
		testUser2.setPhoneNumber("1234567890");
		testUser2 = us.createUser(testUser2);
	}	

	// Read
	@Test
	@Order(2)
	void getUserById() {
		User result = us.getUserById(testUser1.getId());
		assertTrue(result != null);
		assertTrue(result.getId() == testUser1.getId());
	}
	@Test
	@Order(2)
	void getUserByUsername() {
		User result = us.getUserByUsername(testUser1.getUsername());
		assertTrue(result != null);
		assertTrue(result.getUsername().equals(testUser1.getUsername()));
	}
	@Test
	@Order(2)
	void getAllUsers() {		
		Set<User> result = us.getAllUsers();

		assertTrue(result != null);
		assertTrue(result.contains(testUser1), "User1");
		assertTrue(result.contains(testUser2), "User2");
	}
	@Test
	@Order(2)
	void loginSuccess() {
		assertTrue(us.login("USTestUser1", "Pa$$word") != null);
	}
	@Test
	@Order(2)
	void loginFailUsername() {
		assertTrue(!(us.login("wrong", "Pa$$word") != null));
	}
	@Test
	@Order(2)
	void loginFailPassword() {
		assertTrue(!(us.login("USTestUser1", "wrong") != null));
	}
	// Update
	@Test
	@Order(3)
	void updateUser() {
		String oldNumber = new String(testUser1.getPhoneNumber());
		testUser1.setPhoneNumber("9999999999");
		User tempUser = us.updateUser(testUser1);
		assertTrue(tempUser != null);
		assertTrue(!tempUser.getPhoneNumber().equals(oldNumber));
	}
	
	// Delete
	@Test
	@Order(4)
	@Commit
	void deleteUser() {
		assertTrue(us.deleteUser(testUser1));
		assertTrue(us.deleteUser(testUser2));
	}
}
