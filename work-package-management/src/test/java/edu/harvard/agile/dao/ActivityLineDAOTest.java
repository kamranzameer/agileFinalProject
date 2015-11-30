package edu.harvard.agile.dao;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.harvard.agile.util.DBUtil;

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
		Connection con = DBUtil.getConnection();
		assertTrue(new ActivityLineDAO().getTotalCost(10, con) > 0);
		DBUtil.closeConnection(con);
	}
	
	@Test
	public void testGetTotalCostByInvalidActivityLineId() throws Exception {
		Connection con = DBUtil.getConnection();
		assertTrue(new ActivityLineDAO().getTotalCost(1234565, con) == 0);
		DBUtil.closeConnection(con);
	}

	@Test
	public void testGetTotalHours() throws Exception {
		Connection con = DBUtil.getConnection();
		assertTrue(new ActivityLineDAO().getTotalHours(10, con) > 0);
		DBUtil.closeConnection(con);
	}
	
	@Test
	public void testGetTotalHoursByInvalidActivityLineId() throws Exception {
		Connection con = DBUtil.getConnection();
		assertTrue(new ActivityLineDAO().getTotalHours(12345, con) == 0);
		DBUtil.closeConnection(con);
	}

}
