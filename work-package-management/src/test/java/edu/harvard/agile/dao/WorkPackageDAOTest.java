package edu.harvard.agile.dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.harvard.agile.model.UsersDTO;
import edu.harvard.agile.model.WorkPackageDTO;
import edu.harvard.agile.util.DBUtil;



/**
 * This is a test class for Work Package DAO.
 * @author Incredibles Team
 * 
 *
 */
public class WorkPackageDAOTest {

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



	/**
	 * This test method tests the findByPackageId method
	 * @throws Exception
	 */
	@Test
	public void testFindByPackageId() throws Exception {
		WorkPackageDAO workPackageDAO = new WorkPackageDAO();
		WorkPackageDTO workPackageDTO = workPackageDAO.findByPackageId(1);
		assertTrue(workPackageDTO != null);
	}

	/**
	 * This test is to test findBypackage Id with invalid package id
	 * @throws Exception
	 */
	@Test
	public void testFindByInvalidPackageId() throws Exception {
		WorkPackageDAO workPackageDAO = new WorkPackageDAO();
		WorkPackageDTO workPackageDTO = workPackageDAO.findByPackageId(10000);
		assertTrue(workPackageDTO == null);
	}

	/**
	 * This test method tests the findByPackageId method
	 * @throws Exception
	 */
	@Test
	public void testFindByPackageName() throws Exception {
		WorkPackageDAO workPackageDAO = new WorkPackageDAO();
		WorkPackageDTO workPackageDTO = workPackageDAO.findByPackageName("support continuous testing");
		assertTrue(workPackageDTO != null);
	}

	/**
	 * This test is to test findBypackage name with invalid package name
	 * @throws Exception
	 */
	@Test
	public void testFindByInvalidPackageName() throws Exception {
		WorkPackageDAO workPackageDAO = new WorkPackageDAO();
		WorkPackageDTO workPackageDTO = workPackageDAO.findByPackageName("Package name does not exist");
		assertTrue(workPackageDTO == null);
	}

	/** 
	 * This test is to test findAllPackages method of the DAO 
	 * @throws Exception
	 */
	@Test
	public void testFindAllPackages() throws Exception {
		WorkPackageDAO workPackageDAO = new WorkPackageDAO();
		List<WorkPackageDTO> workPackageDTOs = workPackageDAO.findAllPackages();

		assertTrue(workPackageDTOs.size() > 0);
	}

	/**
	 * This test is to test createPackage method of DAO
	 * @throws Exception
	 */
	@Test
	public void testCreatePackage() throws Exception {
		Connection connection = DBUtil.getConnection();

		try
		{
			WorkPackageDAO workPackageDAO  = new WorkPackageDAO();
			WorkPackageDTO workPackage = new WorkPackageDTO();
			workPackage.setContractFromYear(new Date());
			workPackage.setContractToYear(new Date());
			workPackage.setPackageName("TestPackage for delete");
			workPackage.setPackageDesc("TestPackageDesc");
			workPackage.setRequestorName("Joe");
			workPackage.setTestingProgramCode("GRE");
			workPackage.setStatus("Open");
			workPackage.setStartDate(new Date());
			workPackage.setEndDate(new Date());
			workPackage.setCreateBy("junit");
			workPackage.setModifiedBy("junit");

			WorkPackageDTO workDTO = workPackageDAO.createPackage(workPackage, connection);
			assertTrue(workDTO.getPackageId()!=0);

			connection.commit();
		}
		catch(Exception ex)
		{
			if(connection!= null)
			{
				connection.rollback();
			}
		}
		finally
		{
			DBUtil.closeConnection(connection);
		}

	}


	/**
	 * This test is to test an invalid scenario of createPackage method of DAO
	 * Uses annotation for expected exception.
	 * @throws Exception
	 */
	@Test(expected = SQLIntegrityConstraintViolationException.class)

	public void testCreatePackageWithoutPackageName() throws Exception {

		Connection connection = DBUtil.getConnection();

		try
		{
			WorkPackageDAO workPackageDAO  = new WorkPackageDAO();
			WorkPackageDTO workPackage = new WorkPackageDTO();
			workPackage.setContractFromYear(new Date());
			workPackage.setContractToYear(new Date());
			workPackage.setPackageDesc("TestPackageDesc");
			workPackage.setTestingProgramCode("GRE");
			workPackage.setRequestorName("George");
			workPackage.setStatus("Open");
			workPackage.setStartDate(new Date());
			workPackage.setEndDate(new Date());
			workPackage.setCreateBy("uannipu");
			workPackage.setModifiedBy("uannipu");
			workPackageDAO.createPackage(workPackage, connection);
		}
		catch(Exception ex)
		{
			if(connection!=null){
				connection.rollback();
			}
			throw ex;
		}
		finally
		{
			DBUtil.closeConnection(connection);
		}
	}


	/**
	 * This test is to test the updatePackage method of the DAO
	 * @throws Exception
	 */
	@Test
	public void testUpdatePackage() throws Exception {
		WorkPackageDAO workPackageDAO  = new WorkPackageDAO();
		WorkPackageDTO workPackage = new WorkPackageDTO();
		workPackage.setPackageId(2);
		workPackage.setContractFromYear(new Date());
		workPackage.setContractToYear(new Date());
		workPackage.setPackageName("Add fields to extract - updated");
		workPackage.setPackageDesc("TestPackageDesc updated");
		workPackage.setTestingProgramCode("GRE");
		workPackage.setRequestorName("Ruth");
		workPackage.setStatus("Approved");
		workPackage.setStartDate(new Date());
		workPackage.setEndDate(new Date());
		workPackage.setCreateBy("uannipu");
		workPackage.setModifiedBy("uannipu");

		assertTrue(workPackageDAO.updatePackage(workPackage) > 0);

	}

	/**
	 * This test is to test invlaid scenario of updatePackage where the pk is not found
	 * @throws Exception
	 */
	@Test
	public void testUpdatePackageInvalidPackage() throws Exception {
		WorkPackageDAO workPackageDAO  = new WorkPackageDAO();
		WorkPackageDTO workPackage = new WorkPackageDTO();
		workPackage.setPackageId(100000);
		workPackage.setContractFromYear(new Date());
		workPackage.setContractToYear(new Date());
		workPackage.setPackageName("TestPackage updated");
		workPackage.setPackageDesc("TestPackageDesc updated");
		workPackage.setTestingProgramCode("GRE");
		workPackage.setStatus("Approved");
		workPackage.setStartDate(new Date());
		workPackage.setEndDate(new Date());
		workPackage.setCreateBy("uannipu");
		workPackage.setModifiedBy("uannipu");

		assertTrue(workPackageDAO.updatePackage(workPackage) == 0);


	}

	/**
	 * This test is to test the updatePackage status method of the DAO
	 * @throws Exception
	 */
	@Test
	public void testUpdatePackageStatus() throws Exception {
		WorkPackageDAO workPackageDAO  = new WorkPackageDAO();
		WorkPackageDTO workPackage = new WorkPackageDTO();
		workPackage.setPackageId(2);
		workPackage.setStatus("Approved");
		workPackage.setModifiedBy("uannipu");

		Connection connection = DBUtil.getConnection();

		try
		{
			WorkPackageDTO workDTO = workPackageDAO.updatePackageStatus(workPackage, connection);
			assertTrue("Approved".equals(workDTO.getStatus()));
		}
		catch(Exception ex)
		{
			if(connection!=null){
				connection.rollback();
			}
			throw ex;
		}
		finally
		{
			DBUtil.closeConnection(connection);
		}

	}

	/**
	 * This test is to test the updatePackage status method of the DAO
	 * @throws Exception
	 */
	@Test(expected = SQLException.class)
	public void testUpdatePackageStatusNull() throws Exception {
		WorkPackageDAO workPackageDAO  = new WorkPackageDAO();
		WorkPackageDTO workPackage = new WorkPackageDTO();
		workPackage.setPackageId(2);
		workPackage.setModifiedBy("uannipu");

		Connection connection = DBUtil.getConnection();

		try
		{

			WorkPackageDTO workDTO = workPackageDAO.updatePackageStatus(workPackage, connection);
			assertTrue("Approved".equals(workDTO.getStatus()));
		}
		catch(Exception ex)
		{
			if(connection!=null){
				connection.rollback();
			}
			throw ex;
		}
		finally
		{
			DBUtil.closeConnection(connection);
		}

	}

	/**
	 * This test is to test the updatePackage method of the DAO
	 * @throws Exception
	 */
	@Test (expected = SQLException.class)
	public void testUpdatePackageWithMissingNotColumn() throws Exception {
		WorkPackageDAO workPackageDAO  = new WorkPackageDAO();
		WorkPackageDTO workPackage = new WorkPackageDTO();
		workPackage.setPackageId(2);
		workPackage.setContractFromYear(new Date());
		workPackage.setContractToYear(new Date());
		workPackage.setPackageName("Add fields to extract - updated");
		workPackage.setPackageDesc("TestPackageDesc updated");
		workPackage.setTestingProgramCode("GRE");
		workPackage.setStatus("Approved");
		workPackage.setStartDate(new Date());
		workPackage.setEndDate(new Date());
		workPackage.setCreateBy("uannipu");
		workPackage.setModifiedBy("uannipu");

		assertTrue(workPackageDAO.updatePackage(workPackage) == 0);

	}


	/** 
	 * This test is to test findAllPackagesByUser method of the DAO 
	 * @throws Exception
	 */
	@Test
	public void testFindAllPackagesByUser() throws Exception {
		WorkPackageDAO workPackageDAO = new WorkPackageDAO(); 
		UsersDTO userDTO = new UsersDTO();
		userDTO.setUserId("uannipu");
		List<WorkPackageDTO> workPackageDTOs = workPackageDAO.findAllPackagesCreatedByUser(userDTO);

		assertTrue(workPackageDTOs.size() > 0);
	}

	/**
	 * This test is to test deletePackageByPackageName method of DAO
	 * @throws Exception
	 */
	@Test
	public void testDeleteByPackageName() throws Exception {
		WorkPackageDAO workPackageDAO  = new WorkPackageDAO();

		assertTrue(workPackageDAO.deleteByPackageName("TestPackage for delete") > 0);

	}

	/**
	 * This test is to test deletePackageByPackageName method of DAO
	 * @throws Exception
	 */
	@Test
	public void testDeleteByInvalidPackageName() throws Exception {
		WorkPackageDAO workPackageDAO  = new WorkPackageDAO();

		assertTrue(workPackageDAO.deleteByPackageName("Invalid TestPackage for delete") == 0);

	}

	/**
	 * This test is to test deletePackageByPackageName method of DAO
	 * @throws Exception
	 */
	@Test(expected = SQLException.class)
	public void testDeleteByPackageNameWithChildRecords() throws Exception {
		WorkPackageDAO workPackageDAO  = new WorkPackageDAO();

		assertTrue(workPackageDAO.deleteByPackageName("support continuous testing") == 0);

	}


	/**
	 * This test is to test findCountByStatus method of DAO
	 * @throws Exception
	 */
	@Test
	public void testfindcountByStatus() throws Exception {
		WorkPackageDAO workPackageDAO  = new WorkPackageDAO();

		int count = workPackageDAO.findCountByStatus("Open");
		assertTrue(count > 0); 

	}

	/**
	 * This test is to test getTotalApplications method of DAO
	 * @throws Exception
	 */
	@Test
	public void testGetTotalApplications() throws Exception {
		WorkPackageDAO workPackageDAO  = new WorkPackageDAO();

		Connection con = DBUtil.getConnection();
		try
		{
			assertTrue(workPackageDAO.getTotalApplications(1, con) > 0);
		}
		finally
		{
			DBUtil.closeConnection(con);
		}

	}

	/**
	 * This test is to test getTotalApplications method of DAO
	 * @throws Exception
	 */
	@Test
	public void testGetTotalApplicationsForAnInvalidPackage() throws Exception {
		WorkPackageDAO workPackageDAO  = new WorkPackageDAO();

		Connection con = DBUtil.getConnection();
		try
		{
			assertTrue(workPackageDAO.getTotalApplications(73443322, con) == 0);
		}
		finally
		{
			DBUtil.closeConnection(con);
		}

	}

	/**
	 * This test is to test getWorkPackageTotalCost method of DAO
	 * @throws Exception
	 */
	@Test
	public void testgetWorkPackageTotalCost() throws Exception {
		WorkPackageDAO workPackageDAO  = new WorkPackageDAO();

		Connection con = DBUtil.getConnection();
		try
		{
			assertTrue(workPackageDAO.getWorkPackageTotalCost(73, con) == 0);
		}
		finally
		{
			DBUtil.closeConnection(con);
		}

	}

	/**
	 * This test is to test getWorkPackageTotalCost method of DAO
	 * @throws Exception
	 */
	@Test
	public void testgetWorkPackageTotalCostForAnInvalidPackage() throws Exception {
		WorkPackageDAO workPackageDAO  = new WorkPackageDAO();

		Connection con = DBUtil.getConnection();
		try
		{
			assertTrue(workPackageDAO.getWorkPackageTotalCost(73443322, con) == 0);
		}
		finally
		{
			DBUtil.closeConnection(con);
		}

	}

	private void deletePackage(Connection con, int packageId) throws Exception
	{
		PreparedStatement stmt = null;
		try {
			String query = "DELETE FROM WORK_PACKAGE where PACKAGE_ID = ?";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, packageId);
			int rowsDeleted = stmt.executeUpdate();
		}  finally {
			DBUtil.closeStatement(stmt);

		}
	}

}
