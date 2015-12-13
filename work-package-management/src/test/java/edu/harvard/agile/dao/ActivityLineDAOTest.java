package edu.harvard.agile.dao;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.harvard.agile.model.ActivityLineDTO;
import edu.harvard.agile.util.DBUtil;

public class ActivityLineDAOTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

		Connection con = null;
		PreparedStatement st = null;
		String sql1 = "DELETE ACTIVITY_PHASE_RESOURCES WHERE CREATE_BY = 'junit'";
		String sql2 = "DELETE ASSUMPTIONS WHERE CREATE_BY = 'junit'";
		String sql = "DELETE ACTIVITY_LINE WHERE CREATE_BY = 'junit'";

		try
		{
			con = DBUtil.getConnection();

			st = con.prepareStatement(sql1);
			st.executeUpdate();
			st.close();

			st = con.prepareStatement(sql2);
			st.executeUpdate();
			st.close();

			st = con.prepareStatement(sql);
			st.executeUpdate();
			st.close();

			con.commit();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
			con.rollback();
			throw ex;
		}
		finally
		{
			DBUtil.closeStatement(st);
			DBUtil.closeConnection(con);
		}

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
		try
		{
			assertTrue(new ActivityLineDAO().getTotalCost(10, con) > 0);
		}
		finally
		{
			DBUtil.closeConnection(con);
		}
	}

	@Test
	public void testGetTotalCostByInvalidActivityLineId() throws Exception {
		Connection con = DBUtil.getConnection();
		try
		{
			assertTrue(new ActivityLineDAO().getTotalCost(1234565, con) == 0);
		}
		finally
		{
			DBUtil.closeConnection(con);
		}
	}

	@Test
	public void testGetTotalHours() throws Exception {
		Connection con = DBUtil.getConnection();
		try
		{
			assertTrue(new ActivityLineDAO().getTotalHours(10, con) > 0);
		}
		finally
		{
			DBUtil.closeConnection(con);
		}
	}

	@Test
	public void testGetTotalHoursByInvalidActivityLineId() throws Exception {
		Connection con = DBUtil.getConnection();
		try
		{
			assertTrue(new ActivityLineDAO().getTotalHours(12345, con) == 0);
		}
		finally
		{
			DBUtil.closeConnection(con);
		}
	}

	@Test
	public void testCreateActivityLine() throws Exception {
		Connection con = DBUtil.getConnection();
		try
		{
			ActivityLineDTO activityLineDTO = new ActivityLineDTO();
			activityLineDTO.setActivityLineDesc("Junit desc");
			activityLineDTO.setActivityTypeCode("OM");
			activityLineDTO.setCreateBy("junit");
			activityLineDTO.setModifiedBy("junit");
			activityLineDTO.setCreateDate(new Date(System.currentTimeMillis()));
			activityLineDTO.setModifiedDate(new Date(System.currentTimeMillis()));
			activityLineDTO.setEndDate(new Date(System.currentTimeMillis()));
			activityLineDTO.setStartDate(new Date(System.currentTimeMillis()));
			activityLineDTO.setWorkRequestId(12);
			assertTrue(new ActivityLineDAO().createActivityLine(activityLineDTO, con).getActivityLineId() > 0);
		}
		finally
		{
			DBUtil.closeConnection(con);
		}
	}

}
