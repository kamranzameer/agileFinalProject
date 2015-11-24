package edu.harvard.agile.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.harvard.agile.model.ApplicationDTO;
import edu.harvard.agile.util.DBUtil;

public class TestingProgramDAOTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
		
	}

	@Before
	public void setUp() throws Exception {
	}

	
	
	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testFindAllTestingPrograms() throws Exception {
		TestingProgramDAO testProgramDAO = new TestingProgramDAO();
		assertTrue(testProgramDAO.findAllTestingPrograms().size() > 0);
	}

}
