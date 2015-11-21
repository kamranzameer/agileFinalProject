package edu.harvard.agile.dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
		Connection con = null;

		try
		{
			con = DBUtil.getConnection();
			WorkPackageDAO workPackageDAO  = new WorkPackageDAO(con);
			WorkPackageDTO workPackage = new WorkPackageDTO();
			workPackage.setContractFromYear(new Date());
			workPackage.setContractToYear(new Date());
			workPackage.setPackageName("TestPackage");
			workPackage.setPackageDesc("TestPackageDesc");
			workPackage.setRequestorName("Joe");
			workPackage.setTestingProgramCode("GRE");
			workPackage.setStatus("Open");
			workPackage.setStartDate(new Date());
			workPackage.setEndDate(new Date());
			workPackage.setCreateBy("uannipu");
			workPackage.setModifiedBy("uannipu");

			WorkPackageDTO workDTO = workPackageDAO.createPackage(workPackage);
			assertTrue(workDTO.getPackageId()!=0);
			con.commit();
		}
		catch(Exception ex)
		{
			con.rollback();
		}
		finally
		{
			DBUtil.closeConnection(con);
		}

	}


	/**
	 * This test is to test an invalid scenario of createPackage method of DAO
	 * Uses annotation for expected exception.
	 * @throws Exception
	 */
	@Test(expected = SQLIntegrityConstraintViolationException.class)

	public void testCreatePackageWithoutPackageName() throws Exception {

		Connection con = null;

		try
		{
			con = DBUtil.getConnection();
			WorkPackageDAO workPackageDAO  = new WorkPackageDAO(con);
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
			workPackageDAO.createPackage(workPackage);
			con.commit();
		}
		catch(Exception ex)
		{
			con.rollback();
		}
		finally
		{
			DBUtil.closeConnection(con);
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

		WorkPackageDTO workDTO = workPackageDAO.updatePackage(workPackage);
		assertTrue("Add fields to extract - updated".equals(workDTO.getPackageName())); 

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

		WorkPackageDTO workDTO = workPackageDAO.updatePackage(workPackage);
		assertNull(workDTO);

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

		WorkPackageDTO workDTO = workPackageDAO.updatePackageStatus(workPackage);
		assertTrue("Approved".equals(workDTO.getStatus()));

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

		WorkPackageDTO workDTO = workPackageDAO.updatePackageStatus(workPackage);
		assertTrue("Approved".equals(workDTO.getStatus()));

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

		WorkPackageDTO workDTO = workPackageDAO.updatePackage(workPackage);
		assertTrue("Add fields to extract - updated".equals(workDTO.getPackageName())); 

	}



}
