package it.vitux.tuesou.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Time;



import it.vitux.tuesou.entity.Track;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TrackTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/*
	@Test
	public void testSetName() {
		fail("Not yet implemented");
	}
	*/
	

	@Test
	public void testSetDate() {
		Track track = new Track();
		Date date = new Date(2011-11-02);
		track.setDate(date);
		assertEquals(date , track.getDate());
	}

	/*
	@Test //(expected= NullPointerException.class)
	public void testSetStartTime() {
		Track track = new Track();
	    Time time = new Time(1000);
		track.setStartTime(time);
		assertEquals(time, track.getStartTime());
	}

	
	@Test
	public void testSetFinishTime() {
		fail("Not yet implemented");
	}
	*/

}
