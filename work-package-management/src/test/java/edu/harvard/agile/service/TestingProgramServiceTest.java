package edu.harvard.agile.service;

import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.harvard.agile.dao.TestingProgramDAO;
import edu.harvard.agile.model.TestingProgramDTO;

public class TestingProgramServiceTest {

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
	public void testFindAllTestingPrograms() throws Exception {
		TestingProgramService appService = new TestingProgramService();
		appService.setTestingProgramDAO(new TestingProgramDAO());
		
		List<TestingProgramDTO> testingPrograms = appService.findAllTestingPrograms();
		
		Assert.assertTrue(testingPrograms.size() > 0);
	}
	
	@Test (expected = NullPointerException.class)
	public void testFindAllTestingProgramsWithoutDAO() throws Exception {
		TestingProgramService appService = new TestingProgramService();
		List<TestingProgramDTO> testingPrograms = appService.findAllTestingPrograms();
	}

}
