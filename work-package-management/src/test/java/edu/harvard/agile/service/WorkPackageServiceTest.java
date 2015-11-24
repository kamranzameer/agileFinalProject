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
		List<ApplicationDTO> impactedApps = new ArrayList<ApplicationDTO>();
		ApplicationDTO appDTO = new ApplicationDTO();
		appDTO.setApplicationId("eSS");
		appDTO.setApplicationName("enterprise Scoring System");
		
		ApplicationDTO appDTO1 = new ApplicationDTO();
		appDTO1.setApplicationId("eRS");
		appDTO1.setApplicationName("enterprise Reporting System");
		
		impactedApps.add(appDTO);
		impactedApps.add(appDTO1);
		
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
		
		new WorkPackageService().createPackage(workPackage);
		
		assertTrue(true);
	}
	
	@Test(expected = SQLIntegrityConstraintViolationException.class)
	public void testCreatePackageWithoutPackageName() throws Exception
	{
		List<ApplicationDTO> impactedApps = new ArrayList<ApplicationDTO>();
		ApplicationDTO appDTO = new ApplicationDTO();
		appDTO.setApplicationId("eSS");
		appDTO.setApplicationName("enterprise Scoring System");
		
		ApplicationDTO appDTO1 = new ApplicationDTO();
		appDTO1.setApplicationId("eRS");
		appDTO1.setApplicationName("enterprise Reporting System");
		
		impactedApps.add(appDTO);
		impactedApps.add(appDTO1);
		
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
		
		new WorkPackageService().createPackage(workPackage);
		
	}

}
