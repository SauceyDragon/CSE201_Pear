package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.User;

class UserTest {

	@Test
	void userTest() {
		User user = new User("johndoe", "password", 1);
		assertEquals("johndoe", user.getUsername());
		assertEquals("password", user.getPassword());
		assertEquals(1, user.getID());
	}
	
	@Test
	void userSampleTest() {
		User user = new User();
		
		assertEquals("", user.getUsername());
		assertEquals("", user.getPassword());
		assertEquals(-1, user.getID());
		
	}

}
