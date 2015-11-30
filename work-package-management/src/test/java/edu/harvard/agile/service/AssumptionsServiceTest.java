package edu.harvard.agile.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.harvard.agile.dao.AssumptionsDAO;

public class AssumptionsServiceTest {

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
	public void testFindAssumptionsByActivityLineId() throws Exception {
		AssumptionsService assumptionService = new AssumptionsService();
		assumptionService.setAssumptionsDAO(new AssumptionsDAO());
		
		assertTrue(assumptionService.findAssumptionsByActivityLineId(4).size() > 0);
	}
	
	@Test
	public void testFindAssumptionsByInvalidActivityLineId() throws Exception {
		AssumptionsService assumptionService = new AssumptionsService();
		assumptionService.setAssumptionsDAO(new AssumptionsDAO());
		
		assertTrue(assumptionService.findAssumptionsByActivityLineId(124568).size() == 0);
	}

}
