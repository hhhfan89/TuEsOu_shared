package it.vitux.tuesou.test;

import static org.junit.Assert.*;
import it.vitux.tuesou.User;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

	@Before
	public void setUp() throws Exception {
		//User user = new User();
	}
	
/*
	@Test
	public void testSetId() {
		fail("Not yet implemented"); // TODO
	}*/

	@Test  (expected=IllegalArgumentException.class)
	public void testSetUsername() {
		User user = new User();
		user.setUsername("Sil");
		//assertEquals("Silvia", user.getUsername());
	}

	@Test  (expected=IllegalArgumentException.class)
	public void testSetName() {
		User user = new User();
		user.setName("silvia12");
		//assertEquals("silvia", user.getName());
	}
	

	@Test
	public void testSetSurname() {
		User user = new User();
		user.setSurname("Naro");
		//assertEquals("Naro", user.getSurname());
	}

	@Test
	public void testSetPassword() {
		User user = new User();
		user.setPassword("");
		assertEquals("", user.getPassword());
	}

	/*
	@Test
	public void testSetEmail() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetTelephone() {
		fail("Not yet implemented"); // TODO
	}*/

}
