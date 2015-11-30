package edu.harvard.agile.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.harvard.agile.util.DBUtil;

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
		assertTrue(new ActivityPhaseResourcesDAO().findByActivityLineId(10).size() > 0);
	}
	
	@Test
	public void testFindByInvalidActivityLineId() throws Exception {
		assertTrue(new ActivityPhaseResourcesDAO().findByActivityLineId(123456).size() == 0);
	}

	@Test
	public void testGetTotalCost() throws Exception {
		Connection con = DBUtil.getConnection();
		assertTrue(new ActivityPhaseResourcesDAO().getTotalCost(10, con) > 0);
		DBUtil.closeConnection(con);
	}
	
	@Test
	public void testGetTotalCostByInvalidActivityLineId() throws Exception {
		Connection con = DBUtil.getConnection();
		assertTrue(new ActivityPhaseResourcesDAO().getTotalCost(123456, con) == 0);
		DBUtil.closeConnection(con);
	}

	@Test
	public void testGetTotalHours() throws Exception {
		Connection con = DBUtil.getConnection();
		assertTrue(new ActivityPhaseResourcesDAO().getTotalHours(10, con) > 0);
		DBUtil.closeConnection(con);
		
	}
	
	@Test
	public void testGetTotalHoursByInvalidActivityLineId() throws Exception {
		Connection con = DBUtil.getConnection();
		assertTrue(new ActivityPhaseResourcesDAO().getTotalHours(123456, con) == 0);
		DBUtil.closeConnection(con);
	}

}
