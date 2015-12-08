package edu.harvard.agile.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.image.DataBuffer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.harvard.agile.model.ActivityPhaseResourcesDTO;
import edu.harvard.agile.util.DBUtil;

public class ActivityPhaseResourcesDAOTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String sql = "INSERT INTO ACTIVITY_LINE (ACTIVITY_LINE_ID,"
				+ "ACTIVITY_LINE_DESC,"
				+ "WORK_REQUEST_ID,"
				+ "ACTIVITY_TYPE_CODE,"
				+ "START_DATE,"
				+ "END_DATE,"
				+ "CREATE_DATE,"
				+ "MODIFIED_DATE,"
				+ "CREATE_BY,"
				+ "MODIFIED_BY)"
				+ "VALUES (1,"
				+ "'Web service interface',"
				+ "12,"
				+ "'OM',"
				+ "TO_DATE ('11/29/2015 15:57:42', 'MM/DD/YYYY HH24:MI:SS'),"
				+ "TO_DATE ('01/28/2016 15:57:42', 'MM/DD/YYYY HH24:MI:SS'),"
				+ "TO_DATE ('11/29/2015 15:57:42', 'MM/DD/YYYY HH24:MI:SS'),"
				+ "TO_DATE ('11/29/2015 15:57:42', 'MM/DD/YYYY HH24:MI:SS'),"
				+ "'userapp1',"
				+ "'userapp1')";
		
		Connection con = null;
		PreparedStatement st = null;
		
		try
		{
			con = DBUtil.getConnection();
			st = con.prepareStatement(sql);
			st.executeUpdate();
			con.commit();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
			con.rollback();
		}
		finally
		{
			DBUtil.closeStatement(st);
			DBUtil.closeConnection(con);
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Connection con = null;
		PreparedStatement st = null;
		String sql1 = "DELETE ACTIVITY_PHASE_RESOURCES WHERE ACTIVITY_LINE_ID = 1";
		String sql2 = "DELETE ACTIVITY_LINE WHERE ACTIVITY_LINE_ID = 1";
		
		try
		{
			con = DBUtil.getConnection();
			st = con.prepareStatement(sql1);
			st.executeUpdate();
			st.close();
			
			st = con.prepareStatement(sql2);
			st.executeUpdate();
			
			
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
	public void testFindByActivityLineId() throws Exception {
		assertTrue(new ActivityPhaseResourcesDAO().findByActivityLineId(10).size() > 0);
	}
	
	@Test
	public void testFindByInvalidActivityLineId() throws Exception {
		assertTrue(new ActivityPhaseResourcesDAO().findByActivityLineId(123456).size() == 0);
	}
	
	@Test
	public void testCreateActivityPhaseResource() throws Exception {
		List<ActivityPhaseResourcesDTO> resourceActivities = new ArrayList<ActivityPhaseResourcesDTO>();
		ActivityPhaseResourcesDTO dto = new ActivityPhaseResourcesDTO();
		dto.setActivityLineId(1);
		dto.setEstimatedHours(10);
		dto.setHourlyRate(100);
		dto.setResourceTypeId(3);
		dto.setCreateBy("junit");
		dto.setModifiedBy("junit");
		resourceActivities.add(dto);
		
		dto = new ActivityPhaseResourcesDTO();
		dto.setActivityLineId(1);
		dto.setEstimatedHours(5);
		dto.setHourlyRate(75);
		dto.setResourceTypeId(4);
		dto.setCreateBy("junit");
		dto.setModifiedBy("junit");
		resourceActivities.add(dto);
		
			
		Connection con = DBUtil.getConnection();
		try
		{
			int[] rowsUpdated = new ActivityPhaseResourcesDAO().createActivityPhaseResources(resourceActivities, con);
			con.commit();
			assertTrue(rowsUpdated.length > 0);
		}
		finally
		{
			DBUtil.closeConnection(con);
		}
	}
	
	@Test(expected = SQLException.class)
	public void testCreateActivityPhaseResourceWithInvalidActivityLineId() throws Exception {
		List<ActivityPhaseResourcesDTO> resourceActivities = new ArrayList<ActivityPhaseResourcesDTO>();
		ActivityPhaseResourcesDTO dto = new ActivityPhaseResourcesDTO();
		dto.setActivityLineId(1232454);
		dto.setEstimatedHours(10);
		dto.setHourlyRate(100);
		dto.setResourceTypeId(3);
		dto.setCreateBy("junit");
		dto.setModifiedBy("junit");
		resourceActivities.add(dto);
		
		dto = new ActivityPhaseResourcesDTO();
		dto.setActivityLineId(4);
		dto.setEstimatedHours(5);
		dto.setHourlyRate(75);
		dto.setResourceTypeId(4);
		dto.setCreateBy("junit");
		dto.setModifiedBy("junit");
		resourceActivities.add(dto);
		
			
		Connection con = DBUtil.getConnection();
		try
		{
			int[] rowsUpdated = new ActivityPhaseResourcesDAO().createActivityPhaseResources(resourceActivities, con);
			con.commit();
			fail("Integrity constraint violation exception not thrown");
		}
		finally
		{
			DBUtil.closeConnection(con);
		}
	}
	
	@Test (expected = SQLException.class)
	public void testCreateActivityPhaseResourceWithInvalidResourceTypeId() throws Exception {
		List<ActivityPhaseResourcesDTO> resourceActivities = new ArrayList<ActivityPhaseResourcesDTO>();
		ActivityPhaseResourcesDTO dto = new ActivityPhaseResourcesDTO();
		dto.setActivityLineId(4);
		dto.setEstimatedHours(10);
		dto.setHourlyRate(100);
		dto.setResourceTypeId(5);
		dto.setCreateBy("junit");
		dto.setModifiedBy("junit");
		resourceActivities.add(dto);
		
		dto = new ActivityPhaseResourcesDTO();
		dto.setActivityLineId(4);
		dto.setEstimatedHours(5);
		dto.setHourlyRate(75);
		dto.setResourceTypeId(5485611);
		dto.setCreateBy("junit");
		dto.setModifiedBy("junit");
		resourceActivities.add(dto);
		
			
		Connection con = DBUtil.getConnection();
		try
		{
			int[] rowsUpdated = new ActivityPhaseResourcesDAO().createActivityPhaseResources(resourceActivities, con);
			con.commit();
			fail("Integrity constraint violation exception not thrown");
		}
		finally
		{
			DBUtil.closeConnection(con);
		}
		
		
	}
	
		
	
	

	/*@Test
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
	}*/

}
