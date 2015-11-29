package edu.harvard.agile.service;

import static org.junit.Assert.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.harvard.agile.dao.WorkPackageDAO;
import edu.harvard.agile.dao.WorkRequestDAO;
import edu.harvard.agile.model.ApplicationDTO;
import edu.harvard.agile.model.WorkPackageDTO;

public class WorkPackageServiceTest {

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
	public void testCreatePackage() throws Exception 
	{
		List<String> impactedApps = new ArrayList<String>();
		impactedApps.add("eRS");
		impactedApps.add("eSS");
		
		WorkPackageDTO workPackage = new WorkPackageDTO();
		workPackage.setContractFromYear(new Date());
		workPackage.setContractToYear(new Date());
		workPackage.setPackageName("TestPackageService : "+System.currentTimeMillis());
		workPackage.setPackageDesc("TestPackage through service");
		workPackage.setRequestorName("Joe");
		workPackage.setTestingProgramCode("GRE");
		workPackage.setStatus("Open");
		workPackage.setStartDate(new Date());
		workPackage.setEndDate(new Date());
		workPackage.setCreateBy("junit");
		workPackage.setModifiedBy("junit");
		workPackage.setImpactedApplications(impactedApps);
		WorkPackageService wps = new WorkPackageService();
		wps.setWorkPackageDAO(new WorkPackageDAO());
		wps.setWorkRequestDAO(new WorkRequestDAO());
		
		
		wps.createPackage(workPackage);
		
		assertTrue(true);
	}
	
	@Test(expected = SQLIntegrityConstraintViolationException.class)
	public void testCreatePackageWithoutPackageName() throws Exception
	{
		List<String> impactedApps = new ArrayList<String>();
		impactedApps.add("eRS");
		impactedApps.add("eSS");
		
		WorkPackageDTO workPackage = new WorkPackageDTO();
		workPackage.setContractFromYear(new Date());
		workPackage.setContractToYear(new Date());
		workPackage.setPackageDesc("TestPackage through service");
		workPackage.setRequestorName("Joe");
		workPackage.setTestingProgramCode("GRE");
		workPackage.setStatus("Open");
		workPackage.setStartDate(new Date());
		workPackage.setEndDate(new Date());
		workPackage.setCreateBy("junit");
		workPackage.setModifiedBy("junit");
		workPackage.setImpactedApplications(impactedApps);
		
		WorkPackageService wps = new WorkPackageService();
		wps.setWorkPackageDAO(new WorkPackageDAO());
		wps.setWorkRequestDAO(new WorkRequestDAO());
		
		
		wps.createPackage(workPackage);
		
	}
	
	@Test
	public void testFindCountBystatus() throws Exception {
		WorkPackageService workPackageService = new WorkPackageService();
		workPackageService.setWorkPackageDAO(new WorkPackageDAO());
		int count = workPackageService.findCountByStatus("Open");
		assertTrue(count >0);
	}
	
	@Test
	public void testFindByPackageId() throws Exception
	{
		WorkPackageService wps = new WorkPackageService();
		wps.setWorkPackageDAO(new WorkPackageDAO());
		wps.setWorkRequestDAO(new WorkRequestDAO());
		
		assertNotNull(wps.findByPackageId(1));
	}
	
	@Test
	public void testFindByInvalidPackageId() throws Exception
	{
		WorkPackageService wps = new WorkPackageService();
		wps.setWorkPackageDAO(new WorkPackageDAO());
		wps.setWorkRequestDAO(new WorkRequestDAO());
		
		assertNull(wps.findByPackageId(123456));
	}
	
	@Test
	public void testFindAllPackages() throws Exception
	{
		WorkPackageService wps = new WorkPackageService();
		wps.setWorkPackageDAO(new WorkPackageDAO());
		wps.setWorkRequestDAO(new WorkRequestDAO());
		
		assertTrue(wps.findAllPackages().size() > 0);
	}


}