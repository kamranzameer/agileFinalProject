package edu.harvard.agile.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.harvard.agile.dao.ActivityTypeDAO;

public class ActivityTypeServiceTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindAllActivityTypes() throws Exception {
		ActivityTypeService ats = new ActivityTypeService();
		ats.setActivityTypeDAO(new ActivityTypeDAO());
		assertTrue(ats.findAllActivityTypes().size() > 0);
	}

}
