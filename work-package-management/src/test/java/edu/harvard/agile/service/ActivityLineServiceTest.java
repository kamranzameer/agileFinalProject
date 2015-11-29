package edu.harvard.agile.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.harvard.agile.dao.ActivityLineDAO;

public class ActivityLineServiceTest {

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
	public void testFindByRequestId() throws Exception {
		ActivityLineService als = new ActivityLineService();
		als.setActivityLineDAO(new ActivityLineDAO());
		
		assertTrue(als.findByRequestId(12).size() > 0);
	}
	
	@Test
	public void testFindByInvalidRequestId() throws Exception {
		ActivityLineService als = new ActivityLineService();
		als.setActivityLineDAO(new ActivityLineDAO());
		
		assertTrue(als.findByRequestId(123456).size() == 0);
	}
	
}
