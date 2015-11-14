package edu.harvard.agile.dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.harvard.agile.model.WorkPackageDTO;

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

	@Test
	public void testFindByPackageId() throws Exception {
		WorkPackageDAO workPackageDAO = new WorkPackageDAO();
		WorkPackageDTO workPackageDTO = workPackageDAO.findByPackageId(1);
		assertTrue(workPackageDTO != null);
	}
	
	@Test
	public void testFindByInvalidPackageId() throws Exception {
		WorkPackageDAO workPackageDAO = new WorkPackageDAO();
		WorkPackageDTO workPackageDTO = workPackageDAO.findByPackageId(10000);
		assertTrue(workPackageDTO == null);
	}
	
	@Test
	public void testFindAllPackages() throws Exception {
		WorkPackageDAO workPackageDAO = new WorkPackageDAO();
		List<WorkPackageDTO> workPackageDTOs = workPackageDAO.findAllPackages();
		
		assertTrue(workPackageDTOs.size() > 0);
	}
	
	@Test
	public void testCreatePackage() throws Exception {
		WorkPackageDAO workPackageDAO  = new WorkPackageDAO();
		WorkPackageDTO workPackage = new WorkPackageDTO();
		workPackage.setContractFromYear(new Date());
		workPackage.setContractToYear(new Date());
		workPackage.setPackageName("TestPackage");
		workPackage.setPackageDesc("TestPackageDesc");
		workPackage.setTestingProgramCode("GRE");
		workPackage.setStatus("Open");
		workPackage.setStartDate(new Date());
		workPackage.setEndDate(new Date());
		workPackage.setCreateBy("uannipu");
		workPackage.setModifiedBy("uannipu");
	
		WorkPackageDTO workDTO = workPackageDAO.createPackage(workPackage);
		assertTrue(workDTO.getPackageId()!=0); 
		
	}
	
	
	@Test(expected = SQLIntegrityConstraintViolationException.class)
	
	public void testCreatePackageWithoutPackageName() throws Exception {
		WorkPackageDAO workPackageDAO  = new WorkPackageDAO();
		WorkPackageDTO workPackage = new WorkPackageDTO();
		workPackage.setContractFromYear(new Date());
		workPackage.setContractToYear(new Date());
		workPackage.setPackageDesc("TestPackageDesc");
		workPackage.setTestingProgramCode("GRE");
		workPackage.setStatus("Open");
		workPackage.setStartDate(new Date());
		workPackage.setEndDate(new Date());
		workPackage.setCreateBy("uannipu");
		workPackage.setModifiedBy("uannipu");
		WorkPackageDTO workDTO = workPackageDAO.createPackage(workPackage);
		
	}
	
	
	@Test
	public void testUpdatePackage() throws Exception {
		WorkPackageDAO workPackageDAO  = new WorkPackageDAO();
		WorkPackageDTO workPackage = new WorkPackageDTO();
		workPackage.setPackageId(10);
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
		assertTrue("TestPackage updated".equals(workDTO.getPackageName())); 
		
	}
	
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
	
	

}
