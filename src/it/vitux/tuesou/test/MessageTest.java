package it.vitux.tuesou.test;

import static org.junit.Assert.*;
import it.vitux.tuesou.entity.Message;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MessageTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/*
	@Test
	public void testSetId() {
		fail("Not yet implemented");
	}*/

	@Test 
	public void testSetText() {
		Message message = new Message();
		message.setText("Ciao come va?");
		assertEquals("Ciao come va?", message.getText());
	}

}
