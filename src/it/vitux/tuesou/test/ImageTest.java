package it.vitux.tuesou.test;

import static org.junit.Assert.*;
import it.vitux.tuesou.Image;

import org.junit.Before;
import org.junit.Test;

public class ImageTest {

	@Before
	public void setUp() throws Exception {
	}
/*
	@Test
	public void testSetId() {
		fail("Not yet implemented"); // TODO
	}*/

	@Test  (expected=IllegalArgumentException.class)
	public void testSetAddress() {

		Image image = new Image();
		image.setAddress("stringafoto.png");
		assertEquals("stringafoto.png", image.getAddress());
	}

}
