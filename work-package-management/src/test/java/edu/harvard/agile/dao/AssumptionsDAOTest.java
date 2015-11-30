package edu.harvard.agile.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AssumptionsDAOTest {

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
		assertTrue(new AssumptionsDAO().findAssumptionsByActivityLineId(4).size() > 0);
	}
	
	@Test
	public void testFindAssumptionsByInvalidActivityLineId() throws Exception {
		assertTrue(new AssumptionsDAO().findAssumptionsByActivityLineId(123456).size() == 0);
	}

}
