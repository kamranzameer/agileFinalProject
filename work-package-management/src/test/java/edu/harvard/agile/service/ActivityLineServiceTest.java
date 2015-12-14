package edu.harvard.agile.service;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.harvard.agile.dao.ActivityLineDAO;
import edu.harvard.agile.dao.ActivityPhaseResourcesDAO;
import edu.harvard.agile.dao.AssumptionsDAO;
import edu.harvard.agile.model.ActivityLineDTO;
import edu.harvard.agile.model.ActivityPhaseResourcesDTO;
import edu.harvard.agile.model.AssumptionsDTO;
import edu.harvard.agile.util.DBUtil;

public class ActivityLineServiceTest {

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
		ActivityLineService als = new ActivityLineService();
		als.setActivityLineDAO(new ActivityLineDAO());
		
		assertTrue(als.findByRequestId(12).size() > 0);
	}
	
	@Test
	public void testFindByInvalidRequestId() throws Exception {
		ActivityLineService als = new ActivityLineService();
		als.setActivityLineDAO(new ActivityLineDAO());
		
		assertTrue(als.findByRequestId(123456).size() == 0);
	}
	
	@Test
	public void testCreateActivityLine() throws Exception {
		ActivityLineService als = new ActivityLineService();
		als.setActivityLineDAO(new ActivityLineDAO());
		als.setActivityPhaseResourceDAO(new ActivityPhaseResourcesDAO());
		als.setAssumptionsDAO(new AssumptionsDAO());
		
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
		
		ActivityPhaseResourcesDTO activityPhaseResourcesDTO = new ActivityPhaseResourcesDTO();
		activityPhaseResourcesDTO.setCreateBy("junit");
		activityPhaseResourcesDTO.setModifiedBy("junit");
		activityPhaseResourcesDTO.setCreateDate(new Date(System.currentTimeMillis()));
		activityPhaseResourcesDTO.setModifiedDate(new Date(System.currentTimeMillis()));
		activityPhaseResourcesDTO.setResourceTypeId(2);
		activityPhaseResourcesDTO.setEstimatedHours(40);
		
		List<ActivityPhaseResourcesDTO> phaseResourceDTOs = new ArrayList<ActivityPhaseResourcesDTO>();
		phaseResourceDTOs.add(activityPhaseResourcesDTO);
		activityLineDTO.setActivityPhaseResourcesDTOs(phaseResourceDTOs);
		
		AssumptionsDTO assumption = new AssumptionsDTO();
		assumption.setAssumptionsDesc("Junit assumption");
		assumption.setWorkRequestId(12);
		assumption.setCreateBy("junit");
		assumption.setModifiedBy("junit");
		assumption.setCreateDate(new Date(System.currentTimeMillis()));
		assumption.setModifiedDate(new Date(System.currentTimeMillis()));
		
		List<AssumptionsDTO> assumptions = new ArrayList<AssumptionsDTO>();
		assumptions.add(assumption);
		activityLineDTO.setAssumptionDTOs(assumptions);
		
		activityLineDTO = als.createActivityLine(activityLineDTO);
		
		assertTrue(activityLineDTO.getActivityLineId() > 0);
		
		//cleanup
		deleteActivityLine(activityLineDTO.getActivityLineId());
	}

	private void deleteActivityLine(Integer activityLineId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		String sql1 = "DELETE ACTIVITY_PHASE_RESOURCES WHERE ACTIVITY_LINE_ID = ?";
		String sql2 = "DELETE FROM ASSUMPTIONS WHERE WORK_REQUEST_ID = 12 AND ACTIVITY_LINE_ID = ?";
		String sql3 = "DELETE ACTIVITY_LINE WHERE ACTIVITY_LINE_ID = ?";
		
		try
		{
			con = DBUtil.getConnection();
			st = con.prepareStatement(sql1);
			st.setInt(1, activityLineId);
			st.executeUpdate();
			st.close();
			
			st = con.prepareStatement(sql2);
			st.setInt(1, activityLineId);
			st.executeUpdate();
			
			st = con.prepareStatement(sql3);
			st.setInt(1, activityLineId);
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
	
}
