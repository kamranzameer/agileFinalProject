package edu.harvard.agile.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ActivityLineDAOTest {

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
		assertTrue(new ActivityLineDAO().findByRequestId(12).size() > 0);
	}
	
	@Test
	public void testFindByInvalidRequestId() throws Exception {
		assertTrue(new ActivityLineDAO().findByRequestId(123456).size() == 0);
	}

	@Test
	public void testGetTotalCost() throws Exception {
		assertTrue(new ActivityLineDAO().getTotalCost(12) > 0);
	}
	
	@Test
	public void testGetTotalCostByInvalidActivityLineId() throws Exception {
		assertTrue(new ActivityLineDAO().getTotalCost(1234565) > 0);
	}

	@Test
	public void testGetTotalHours() throws Exception {
		assertTrue(new ActivityLineDAO().getTotalHours(1) > 0);
	}
	
	@Test
	public void testGetTotalHoursByInvalidActivityLineId() throws Exception {
		assertTrue(new ActivityLineDAO().getTotalHours(12345) > 0);
	}

}
