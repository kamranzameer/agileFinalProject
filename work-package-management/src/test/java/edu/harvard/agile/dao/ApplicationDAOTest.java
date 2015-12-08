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

public class ApplicationDAOTest {

	static String appId;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
		Connection con = null; 
		PreparedStatement st = null;
		
		try
		{
		
		con = DBUtil.getConnection();
		String sql = "DELETE FROM APPLICATION WHERE APPLICATION_ID = ?";
		st = con.prepareStatement(sql);
		st.setString(1, appId);
		st.executeUpdate();
		con.commit();
		}
		catch(Exception ex)
		{
			con.rollback();
			throw ex;
		}
		finally
		{
			DBUtil.closeStatement(st);
			DBUtil.closeConnection(con);
			appId = null;
		}
		
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreateApplication() throws Exception {
		ApplicationDAO application = new ApplicationDAO();
		ApplicationDTO appDTO = new ApplicationDTO();
		appId = "testapp"+System.currentTimeMillis();
		appDTO.setApplicationId(appId);
		appDTO.setApplicationDesc(appId + " Desc ");
		appDTO.setApplicationName(appId + " Name ");
		appDTO.setCreateBy("yetish");
		appDTO.setModifiedBy("yetish");
		appDTO.setIsActive("Y");
		
		appDTO = application.createApplication(appDTO);
		
		assertTrue(appDTO.getApplicationId().equals(appId));
	}
	
	@Test (expected = SQLException.class)
	public void testCreateApplicationWithoutAppId() throws Exception {
		ApplicationDAO application = new ApplicationDAO();
		ApplicationDTO appDTO = new ApplicationDTO();
		appDTO.setApplicationDesc(appId + " Desc ");
		appDTO.setApplicationName(appId + " Name ");
		appDTO.setCreateBy("yetish");
		appDTO.setModifiedBy("yetish");
		appDTO.setIsActive("Y");
		
		appDTO = application.createApplication(appDTO);
		
	}
	
	@Test (expected = SQLException.class)
	public void testCreateApplicationWithoutAppName() throws Exception {
		ApplicationDAO application = new ApplicationDAO();
		ApplicationDTO appDTO = new ApplicationDTO();
		appId = "testapp"+System.currentTimeMillis();
		appDTO.setApplicationId(appId);
		appDTO.setApplicationDesc(appId + " Desc ");
		appDTO.setCreateBy("yetish");
		appDTO.setModifiedBy("yetish");
		appDTO.setIsActive("Y");
		
		appDTO = application.createApplication(appDTO);
		
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindByApplicationId() throws Exception {
		ApplicationDAO appDAO = new ApplicationDAO();
		ApplicationDTO appDTO = appDAO.findByApplicationId("eSS");
		assertNotNull(appDTO);
	}
	
	@Test
	public void testFindByInvalidApplicationId() throws Exception {
		ApplicationDAO appDAO = new ApplicationDAO();
		ApplicationDTO appDTO = appDAO.findByApplicationId("InvalidApp");
		assertNull(appDTO);
	}

	@Test
	public void testFindAllApplications() throws Exception {
		ApplicationDAO appDAO = new ApplicationDAO();
		assertTrue(appDAO.findAllApplications().size() > 0);
	}

	@Test
	public void testUpdateApplicationStatus() throws Exception {
		ApplicationDAO appDAO = new ApplicationDAO();
		ApplicationDTO appDTO = new ApplicationDTO();
		appDTO.setApplicationId(appId);
		appDTO.setIsActive("N");
		appDTO.setModifiedBy("Yetish");
		assertTrue(appDAO.updateApplicationStatus(appDTO) > 0);
	}
	
	@Test (expected = SQLException.class)
	public void testUpdateApplicationWithInvalidStatus() throws Exception {
		ApplicationDAO appDAO = new ApplicationDAO();
		ApplicationDTO appDTO = new ApplicationDTO();
		appDTO.setIsActive("ACTIVE");
		appDTO.setApplicationId(appId);
		appDTO.setModifiedBy("Yetish");
		appDAO.updateApplicationStatus(appDTO);
		assertTrue(appDAO.updateApplicationStatus(appDTO) == 0);
		
	}
	
	@Test
	public void testUpdateApplicationStatusForInvalidApp() throws Exception {
		ApplicationDAO appDAO = new ApplicationDAO();
		ApplicationDTO appDTO = new ApplicationDTO();
		appDTO.setApplicationId("InvalidApp");
		appDTO.setIsActive("N");
		appDTO.setModifiedBy("Yetish");
		assertTrue(appDAO.updateApplicationStatus(appDTO) == 0);
		
	}

}
