package it.vitux.tuesou.test;

import static org.junit.Assert.*;
import it.vitux.tuesou.entity.User;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
	//
	@Before
	public void setUp() throws Exception {
		//User user = new User();
	}
	
/*
	@Test
	public void testSetId() {
		fail("Not yet implemented"); // TODO
	}*/

	
	/*Test if the control accepts only username in the correct format*/
	
	@Test  (expected=IllegalArgumentException.class)
	public void testSetUsername() {
		User user = new User();
		user.setUsername("Sil");
		//assertEquals("Silvia", user.getUsername());
	}

	/*Test if the control accepts only name in the correct format*/
	
	@Test  (expected=IllegalArgumentException.class)
	public void testSetName() {
		User user = new User();
		user.setName("silvia12");
		//assertEquals("silvia", user.getName());
	}
	
	
	/*Test if the control accepts only surname in the correct format*/
	@Test
	public void testSetSurname() {
		User user = new User();
		user.setSurname("Naro");
		//assertEquals("Naro", user.getSurname());
	}

	/*Test if the control accepts only password in the correct format*/
	@Test
	public void testSetPassword() {
		User user = new User();
		user.setPassword("TuEsOuPassword");
		assertEquals("TuEsOuPassword", user.getPassword());
	}

	/*Test if the control accepts only email in the correct format*/
	@Test  // (expected = IllegalArgumentException.class)
	public void testSetEmail() {
		User user = new User();
		user.setEmail("naro.silvia@libero.it");
		assertEquals("naro.silvia@libero.it", user.getEmail());
	}

	/*Test if the control accepts only telephone in the correct format*/
	@Test (expected = IllegalArgumentException.class)
	public void testSetTelephone() {
		User user = new User();
		user.setTelephone("");
		//user.setTelephone("3393937210");
		//assertEquals("3393937210", user.getTelephone());
		}

}

