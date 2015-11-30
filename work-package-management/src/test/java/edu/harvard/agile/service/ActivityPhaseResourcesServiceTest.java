package edu.harvard.agile.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.harvard.agile.dao.ActivityPhaseResourcesDAO;

public class ActivityPhaseResourcesServiceTest {

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
	public void testFindByActivityLineId() throws Exception {
		ActivityPhaseResourcesService aprs = new ActivityPhaseResourcesService();
		aprs.setActivityPhaseResourcesDAO(new ActivityPhaseResourcesDAO());
		
		assertTrue(aprs.findByActivityLineId(10).size() > 0);
	}
	
	@Test
	public void testFindByInvalidActivityLineId() throws Exception {
		ActivityPhaseResourcesService aprs = new ActivityPhaseResourcesService();
		aprs.setActivityPhaseResourcesDAO(new ActivityPhaseResourcesDAO());
		
		assertTrue(aprs.findByActivityLineId(12345).size() == 0);
	}

}
