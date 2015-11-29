package edu.harvard.agile.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.harvard.agile.dao.ApplicationContactsDAO;
import edu.harvard.agile.dao.WorkRequestDAO;

public class WorkRequestServiceTest {

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
	public void testFindAllWorkRequests() throws Exception{
		WorkRequestService workRequest = new WorkRequestService();
		workRequest.setWorkRequestDAO(new WorkRequestDAO());
		workRequest.setApplicationService(new ApplicationService());
		
		assertTrue(workRequest.findAllWorkRequests().size() > 0);
	}

	@Test
	public void testFindAllWorkRequestsByApplication() throws Exception{
		WorkRequestService workRequest = new WorkRequestService();
		workRequest.setWorkRequestDAO(new WorkRequestDAO());
		workRequest.setApplicationService(new ApplicationService());
		
		assertTrue(workRequest.findAllWorkRequestsByApplication("eSS").size() > 0);
	}
	
	@Test
	public void testFindAllWorkRequestsByInvalidApplication() throws Exception{
		WorkRequestService workRequest = new WorkRequestService();
		workRequest.setWorkRequestDAO(new WorkRequestDAO());
		workRequest.setApplicationService(new ApplicationService());
		
		assertTrue(workRequest.findAllWorkRequestsByApplication("Invalid app").size() == 0);
	}

	@Test
	public void testFindAllWorkRequestsByUser() throws Exception{
		WorkRequestService workRequest = new WorkRequestService();
		workRequest.setWorkRequestDAO(new WorkRequestDAO());
		workRequest.setApplicationService(new ApplicationService());
		workRequest.getApplicationService().setApplicationContactsDAO(new ApplicationContactsDAO());
		
		assertTrue(workRequest.findAllWorkRequestsByUser("userapp1").size() > 0);
	}
	
	@Test(expected = Exception.class)
	
	public void testFindAllWorkRequestsByInvalidUser() throws Exception{
		WorkRequestService workRequest = new WorkRequestService();
		workRequest.setWorkRequestDAO(new WorkRequestDAO());
		workRequest.setApplicationService(new ApplicationService());
		workRequest.getApplicationService().setApplicationContactsDAO(new ApplicationContactsDAO());
		
		assertTrue(workRequest.findAllWorkRequestsByUser("invaliduser").size() == 0);
	}
	
	@Test
	public void testfindRequestsByPackageId() throws Exception
	{
		WorkRequestService wrs = new WorkRequestService();
		wrs.setWorkRequestDAO(new WorkRequestDAO());
		wrs.setApplicationService(new ApplicationService());
		
		assertTrue(wrs.findRequestsByPackageId(1).size() > 0);
	}
	
	@Test
	public void testfindRequestsByInvalidPackageId() throws Exception
	{
		WorkRequestService wrs = new WorkRequestService();
		wrs.setWorkRequestDAO(new WorkRequestDAO());
		wrs.setApplicationService(new ApplicationService());
		
		assertTrue(wrs.findRequestsByPackageId(123456).size() == 0);
	}

}
