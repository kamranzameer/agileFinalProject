package edu.harvard.agile.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.harvard.agile.model.WorkRequestDTO;
import edu.harvard.agile.util.DBUtil;

public class WorkRequestDAOTest {

	
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
	public void testCreateWorkRequest() throws Exception {
		Connection con = null;

		try
		{
			con = DBUtil.getConnection();
			WorkRequestDAO workRequestDAO  = new WorkRequestDAO();
			WorkRequestDTO workRequest = new WorkRequestDTO();
			workRequest.setPackageId(2);
			workRequest.setApplicationId("eSS");
			workRequest.setStatus("Open");
			workRequest.setStartDate(new Date());
			workRequest.setEndDate(new Date());
			workRequest.setCreateBy("junit");
			workRequest.setModifiedBy("junit");

			workRequest = workRequestDAO.createWorkRequest(workRequest, con);
			assertTrue(workRequest.getWorkRequestId()!=0);
			
			//cleanup
			workRequestDAO.deleteWorkRequest(workRequest, con);
			con.commit();
			
			
			
		}
		catch(Exception ex)
		{
			DBUtil.rollBack(con);
			throw ex;
		}
		finally
		{
			DBUtil.closeConnection(con);
		}
	}

	@Test (expected = Exception.class)
	public void testCreateWorkRequestWithoutPackageId() throws Exception {

		Connection con = null;

		try
		{
			con = DBUtil.getConnection();
			WorkRequestDAO workRequestDAO  = new WorkRequestDAO();

			WorkRequestDTO workRequest = new WorkRequestDTO();
			workRequest.setApplicationId("eSS");
			workRequest.setStatus("Open");
			workRequest.setStartDate(new Date());
			workRequest.setEndDate(new Date());
			workRequest.setCreateBy("junit");
			workRequest.setModifiedBy("junit");

			workRequest = workRequestDAO.createWorkRequest(workRequest, con);
			con.commit();
		}
		catch(Exception ex)
		{
			DBUtil.rollBack(con);
			throw ex;
		}
		finally
		{
			DBUtil.closeConnection(con);
		}
	}

	@Test (expected = SQLException.class)
	public void testCreateWorkRequestWithoutApplicationId() throws Exception {
		Connection con = null;

		try
		{
			con = DBUtil.getConnection();
			WorkRequestDAO workRequestDAO  = new WorkRequestDAO();
			WorkRequestDTO workRequest = new WorkRequestDTO();
			workRequest.setPackageId(1);
			workRequest.setStatus("Open");
			workRequest.setStartDate(new Date());
			workRequest.setEndDate(new Date());
			workRequest.setCreateBy("junit");
			workRequest.setModifiedBy("junit");

			workRequest = workRequestDAO.createWorkRequest(workRequest, con);
			con.commit();
		}
		catch(Exception ex)
		{
			if(con != null)
				DBUtil.rollBack(con);
			throw ex;
		}
		finally
		{
			DBUtil.closeConnection(con);
		}
	}

	@Test (expected = SQLException.class)
	public void testCreateWorkRequestWithInvalidPackageId() throws Exception {
		Connection con = null;

		try
		{
			con = DBUtil.getConnection();
			WorkRequestDAO workRequestDAO  = new WorkRequestDAO();
			WorkRequestDTO workRequest = new WorkRequestDTO();
			workRequest.setPackageId(123456);
			workRequest.setApplicationId("eSS");
			workRequest.setStatus("Open");
			workRequest.setStartDate(new Date());
			workRequest.setEndDate(new Date());
			workRequest.setCreateBy("junit");
			workRequest.setModifiedBy("junit");

			workRequest = workRequestDAO.createWorkRequest(workRequest, con);
			con.commit();
		}
		catch(Exception ex)
		{
			DBUtil.rollBack(con);
			throw ex;
		}
		finally
		{
			DBUtil.closeConnection(con);
		}
	}

	@Test (expected = SQLException.class)
	public void testCreateWorkRequestWithInvalidApplicationId() throws Exception {
		Connection con = null;

		try
		{
			con = DBUtil.getConnection();
			WorkRequestDAO workRequestDAO  = new WorkRequestDAO();
			WorkRequestDTO workRequest = new WorkRequestDTO();
			workRequest.setPackageId(1);
			workRequest.setApplicationId("invalid application id");
			workRequest.setStatus("Open");
			workRequest.setStartDate(new Date());
			workRequest.setEndDate(new Date());
			workRequest.setCreateBy("junit");
			workRequest.setModifiedBy("junit");

			workRequest = workRequestDAO.createWorkRequest(workRequest, con);
			con.commit();
		}
		catch(Exception ex)
		{
			DBUtil.rollBack(con);
			throw ex;
		}
		finally
		{
			DBUtil.closeConnection(con);
		}
	}
	
	@Test
	public void testDeleteRequest() throws Exception {
		Connection con = null;

		try
		{
			con = DBUtil.getConnection();
			
			//setup
			WorkRequestDAO workRequestDAO  = new WorkRequestDAO();
			WorkRequestDTO workRequest = new WorkRequestDTO();
			workRequest.setPackageId(2);
			workRequest.setApplicationId("eSS");
			workRequest.setStatus("Open");
			workRequest.setStartDate(new Date());
			workRequest.setEndDate(new Date());
			workRequest.setCreateBy("junit");
			workRequest.setModifiedBy("junit");

			workRequest = workRequestDAO.createWorkRequest(workRequest, con);
			assertTrue(workRequestDAO.deleteWorkRequest(workRequest, con) > 0);
			
			con.commit();
			
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			DBUtil.rollBack(con);
			throw ex;
		}
		finally
		{
			DBUtil.closeConnection(con);
		}
	}

	@Test
	public void testFindRequestsByApplicationId() throws Exception{
		WorkRequestDAO workRequest = new WorkRequestDAO();
		assertNotEquals(0, workRequest.findRequestsByApplicationId("eSS"));
	}

	@Test
	public void testFindRequestsByInvalidApplicationId() throws Exception{
		WorkRequestDAO workRequest = new WorkRequestDAO();
		assertEquals(0, workRequest.findRequestsByApplicationId("Invalid application id").size());
	}

	@Test
	public void testFindByWorkRequestId() throws Exception {
		WorkRequestDAO workRequest = new WorkRequestDAO();
		assertNotNull(workRequest.findByWorkRequestId(12));
	}

	@Test
	public void testFindByInvalidWorkRequestId() throws Exception {
		WorkRequestDAO workRequest = new WorkRequestDAO();
		assertNull(workRequest.findByWorkRequestId(123456));
	}

	@Test
	public void testFindAllWorkRequests() throws Exception {
		WorkRequestDAO workRequest = new WorkRequestDAO();
		assertNotEquals(0, workRequest.findAllWorkRequests());
	}

	@Test
	public void testUpdateWorkRequestStatus() throws Exception {
		WorkRequestDAO workRequestDAO  = new WorkRequestDAO();
		WorkRequestDTO workRequest = new WorkRequestDTO();
		workRequest.setWorkRequestId(12);
		workRequest.setPackageId(1);
		workRequest.setApplicationId("eSS");
		workRequest.setStatus("Archived");
		workRequest.setModifiedBy("junit");

		Connection connection = DBUtil.getConnection();

		try
		{
		assertTrue(workRequestDAO.updateWorkRequestStatus(workRequest, connection) > 0); 
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			DBUtil.rollBack(connection);
			throw ex;
		}
		finally
		{
			DBUtil.closeConnection(connection);
		}
	}

	@Test
	public void testUpdateWorkRequestStatusWithInvalidWorkRequestId() throws Exception {
		WorkRequestDAO workRequestDAO  = new WorkRequestDAO();
		WorkRequestDTO workRequest = new WorkRequestDTO();
		workRequest.setWorkRequestId(1233445);
		workRequest.setPackageId(1);
		workRequest.setApplicationId("eSS");
		workRequest.setStatus("Archived");
		workRequest.setModifiedBy("junit");

		Connection connection = DBUtil.getConnection();

		try
		{
		assertTrue(workRequestDAO.updateWorkRequestStatus(workRequest, connection) == 0); 
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			DBUtil.rollBack(connection);
			throw ex;
		}
		finally
		{
			DBUtil.closeConnection(connection);
		}
	}
	
	@Test (expected = SQLException.class)
	public void testUpdateWorkRequestStatusWithNullStatus() throws Exception {
		WorkRequestDAO workRequestDAO  = new WorkRequestDAO();
		WorkRequestDTO workRequest = new WorkRequestDTO();
		workRequest.setWorkRequestId(12);
		workRequest.setApplicationId("eSS");
		workRequest.setStatus(null);
		
		Connection connection = DBUtil.getConnection();
		try
		{
		workRequestDAO.updateWorkRequestStatus(workRequest, connection);
		}
		catch(Exception ex)
		{
			DBUtil.rollBack(connection);
			throw ex;
		}
		finally
		{
			DBUtil.closeConnection(connection);
		}
	}
	
	@Test
	public void testfindRequestsByPackageId() throws Exception
	{
		assertTrue(new WorkRequestDAO().findRequestsByPackageId(1).size() > 0);
	}
	
	@Test
	public void testfindRequestsByInvalidPackageId() throws Exception
	{
		assertTrue(new WorkRequestDAO().findRequestsByPackageId(123456).size() == 0);
	}
	
	@Test
	public void testgetWorkRequsetTotalCost() throws Exception
	{
		Connection con = DBUtil.getConnection();
		assertTrue(new WorkRequestDAO().getWorkRequsetTotalCost(12, con) > 0);
		DBUtil.closeConnection(con);
	}
	
	@Test
	public void testgetInvalidWorkRequsetTotalCost() throws Exception
	{
		Connection con = DBUtil.getConnection();
		assertTrue(new WorkRequestDAO().getWorkRequsetTotalCost(123456, con) == 0);
		DBUtil.closeConnection(con);
	}
	
	@Test
	public void testgetWorkRequsetTotalHours() throws Exception
	{
		Connection con = DBUtil.getConnection();
		assertTrue(new WorkRequestDAO().getWorkRequsetTotalHours(12, con) > 0);
		DBUtil.closeConnection(con);
	}
	
	@Test
	public void testgetInvalidWorkRequsetTotalHours() throws Exception
	{
		Connection con = DBUtil.getConnection();
		assertTrue(new WorkRequestDAO().getWorkRequsetTotalHours(123456, con) == 0);
		DBUtil.closeConnection(con);
	}

}
