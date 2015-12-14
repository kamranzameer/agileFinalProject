package edu.harvard.agile.service;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
import edu.harvard.agile.model.StatusEnum;
import edu.harvard.agile.model.WorkPackageDTO;
import edu.harvard.agile.model.WorkRequestDTO;
import edu.harvard.agile.util.DBUtil;

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
		workPackage.setStatus(StatusEnum.OPEN.name());
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
		workPackage.setStatus(StatusEnum.OPEN.name());
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
		int count = workPackageService.findCountByStatus(StatusEnum.OPEN.name());
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

	@Test
	public void testUpdatePackageStatus() throws Exception 
	{
				
		WorkPackageService wps = new WorkPackageService();
		wps.setWorkPackageDAO(new WorkPackageDAO());
		wps.setWorkRequestDAO(new WorkRequestDAO());
		
		
		WorkPackageDTO workPackage = wps.findByPackageId(1);
		workPackage.setStatus(StatusEnum.APPROVED.name());
		workPackage.setModifiedBy("junit");
		workPackage.setModifiedDate(new Date());
		wps.updatePackageStatus(workPackage);
		WorkPackageDTO newwp = wps.findByPackageId(1);
		assertEquals(newwp.getStatus(),StatusEnum.APPROVED.name());
		assertTrue(true);
		
	}
	
	@Test
	public void testUpdatePackage() throws Exception 
	{
		
		List<String> impactedApps = new ArrayList<String>();
		impactedApps.add("eReg");
		WorkPackageDAO wpdao =  new WorkPackageDAO();
		WorkRequestDAO wrdao =  new WorkRequestDAO();
		WorkPackageService wps = new WorkPackageService();
		
		wps.setWorkRequestDAO(wrdao);
		wps.setWorkPackageDAO(wpdao);
		setUpPackage();
		
		WorkPackageDTO workPackage = wpdao.findByPackageName("UpdatePackage400");
		assertNotNull(workPackage);
		workPackage.setStatus(StatusEnum.OPEN.name());
		workPackage.setTestingProgramCode("GRE");
		workPackage.setImpactedApplications(impactedApps);

		workPackage.setModifiedBy("junit");
		workPackage.setModifiedDate(new Date());
		workPackage.setCreateBy("junit");
		workPackage.setCreateDate(new Date());

		wps.updatePackage(workPackage);
		
		WorkPackageDTO newPackage = wpdao.findByPackageName("UpdatePackage400");
		assertNotNull(newPackage);
		
		assertEquals(newPackage.getStatus(),StatusEnum.OPEN.name());
		assertEquals(newPackage.getTestingProgramCode(),"GRE");
		List<WorkRequestDTO> workRequests =  wrdao.findRequestsByPackageId(newPackage.getPackageId());
		
		assertEquals(workRequests.size(),1);
		assertTrue(true);
	//	List<WorkRequestDTO> workRequests =  wrdao.findRequestsByPackageId(newPackage.getPackageId());
		cleanup(wrdao, workPackage, workRequests);

	}
	
	@Test
	public void testFindAllPackagesForSearch() throws Exception
	{
		WorkPackageDAO wpdao =  new WorkPackageDAO();
		WorkRequestDAO wrdao =  new WorkRequestDAO();
		WorkPackageService wps = new WorkPackageService();
		wps.setWorkRequestDAO(wrdao);
		wps.setWorkPackageDAO(wpdao);
		
		List<String> impactedApps = new ArrayList<String>();
		impactedApps.add("eRS");
		impactedApps.add("eSS");
		
		WorkPackageDTO workPackage = new WorkPackageDTO();
		workPackage.setContractFromYear(new Date());
		workPackage.setContractToYear(new Date());
		workPackage.setPackageDesc("TestPackage through service");
		workPackage.setRequestorName("Joe");
		workPackage.setTestingProgramCode("GRE");
		workPackage.setStatus(StatusEnum.OPEN.name());
		workPackage.setContractFromYear(new Date());
		workPackage.setContractToYear(new Date());
		workPackage.setStartDate(new Date());
		workPackage.setEndDate(new Date());
		workPackage.setCreateBy("junit");
		workPackage.setModifiedBy("junit");
		workPackage.setImpactedApplications(impactedApps);
		List packages = wps.findAllPackages(workPackage);
		assertTrue(packages == null ||  packages.size() >= 0);
	}

	private void cleanup(WorkRequestDAO wrdao, WorkPackageDTO workPackage,
			List<WorkRequestDTO> workRequests) throws Exception {
		Connection connection = null;
		try{
			connection = DBUtil.getConnection();
			for(WorkRequestDTO workRequest : workRequests){
				wrdao.deleteWorkRequest(workRequest, connection);
			}
			deletePackage(connection, workPackage.getPackageId());
			connection.commit();
		} catch(Exception ex) {
			DBUtil.rollBack(connection);
			throw ex;
		} finally {
			DBUtil.closeConnection(connection);
		}
	}

	
	private void setUpPackage() throws Exception 
	{
		List<String> impactedApps = new ArrayList<String>();
		impactedApps.add("eRS");
		impactedApps.add("eSS");
		
		WorkPackageDTO workPackage = new WorkPackageDTO();
		workPackage.setContractFromYear(new Date());
		workPackage.setContractToYear(new Date());
		workPackage.setPackageName("UpdatePackage400");
		workPackage.setPackageDesc("TestPackage for update");
		workPackage.setRequestorName("Bill");
		workPackage.setTestingProgramCode("SAT");
		workPackage.setStatus(StatusEnum.OPEN.name());
		workPackage.setStartDate(new Date());
		workPackage.setEndDate(new Date());
		workPackage.setCreateBy("junit");
		workPackage.setModifiedBy("junit");
		workPackage.setCreateDate(new Date());
	
		workPackage.setImpactedApplications(impactedApps);
		WorkPackageService wps = new WorkPackageService();
		wps.setWorkPackageDAO(new WorkPackageDAO());
		wps.setWorkRequestDAO(new WorkRequestDAO());
		wps.createPackage(workPackage);
		
		
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