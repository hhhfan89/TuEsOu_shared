package it.vitux.tuesou.test;

import static org.junit.Assert.*;
import it.vitux.tuesou.entity.Address;

import org.junit.Before;
import org.junit.Test;
  


public class AddressTest {
	//
	@Before
	public void setUp() throws Exception {
	}

	
	/*Test if the control accepts only type in the correct format*/
	@Test (expected=IllegalArgumentException.class)
	public void testSetType() {
		Address address = new Address();
		address.setType("");
	}
	
	/*Test if the control accepts only name in the correct format*/
	@Test 
	public void testSetName(){
		Address address = new Address();
		address.setName("anassimandro");
		assertEquals("anassimandro", address.getName());
	}
	
	/*Test if the control accepts only number in the correct format*/
	@Test (expected= IllegalArgumentException.class)
	public void testSetNumber(){
		Address address = new Address();
		address.setNumber("aaaa");
	}
	
	/*Test if the control accepts only city in the correct format*/
	@Test (expected= IllegalArgumentException.class)
	public void testSetCity() {
		Address address = new Address();
		address.setCity("Roma12");
	}

	/*Test if the control accepts only state in the correct format*/
	@Test
	public void testSetState() {
		Address address = new Address();
		address.setState("Italia");
		assertEquals("Italia", address.getState());
	}

	/*Test if the control accepts only zipCode in the correct format*/
	@Test  (expected= IllegalArgumentException.class)
	public void testSetZipCode() {
		Address address = new Address();
		address.setZipCode("11");
	}

}



