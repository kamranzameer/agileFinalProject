package edu.harvard.agile.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ActivityPhaseResourcesDAOTest {

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
		assertTrue(new ActivityPhaseResourcesDAO().findByActivityLineId(1).size() > 0);
	}
	
	@Test
	public void testFindByInvalidActivityLineId() throws Exception {
		assertTrue(new ActivityPhaseResourcesDAO().findByActivityLineId(123456).size() == 0);
	}

	@Test
	public void testGetTotalCost() throws Exception {
		assertTrue(new ActivityPhaseResourcesDAO().getTotalCost(1) > 0);
	}
	
	@Test
	public void testGetTotalCostByInvalidActivityLineId() throws Exception {
		assertTrue(new ActivityPhaseResourcesDAO().getTotalCost(123456) == 0);
	}

	@Test
	public void testGetTotalHours() throws Exception {
		assertTrue(new ActivityPhaseResourcesDAO().getTotalHours(1) > 0);
	}
	
	@Test
	public void testGetTotalHoursByInvalidActivityLineId() throws Exception {
		assertTrue(new ActivityPhaseResourcesDAO().getTotalHours(123456) == 0);
	}

}
