package it.vitux.tuesou.test;

import static org.junit.Assert.*;
import it.vitux.tuesou.entity.Coordinate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CoordinateTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test (expected=IllegalArgumentException.class)
	public void testSetLatitude() {
		Coordinate coordinate = new Coordinate();
		coordinate.setLatitude(-1);
	}

	
	@Test
	public void testSetLongitude() {
		Coordinate coordinate = new Coordinate();
		coordinate.setLongitude(1);
		assertEquals(1, coordinate.getLongitude() , 0);
	}

}
