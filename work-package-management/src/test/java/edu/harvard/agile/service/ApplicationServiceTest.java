package edu.harvard.agile.service;

import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.harvard.agile.dao.ApplicationContactsDAO;
import edu.harvard.agile.dao.ApplicationDAO;
import edu.harvard.agile.model.ApplicationContactsDTO;
import edu.harvard.agile.model.ApplicationDTO;

public class ApplicationServiceTest {

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
	public void testFindAllApplications() throws Exception {
		ApplicationService appService = new ApplicationService();
		appService.setApplicationDAO(new ApplicationDAO());
		
		List<ApplicationDTO> applications = appService.findAllApplications();
		
		Assert.assertTrue(applications.size() > 0);
	}
	
	@Test (expected = NullPointerException.class)
	public void testFindAllApplicationsWithoutDAO() throws Exception {
		ApplicationService appService = new ApplicationService();
		List<ApplicationDTO> applications = appService.findAllApplications();
	}

	@Test
	public void testFindApplicationContactByUser() throws Exception {
		ApplicationService appService = new ApplicationService();
		appService.setApplicationContactsDAO(new ApplicationContactsDAO());
		ApplicationContactsDTO applicationContact = appService.findApplicationContactByUser("userapp1");
		Assert.assertNotNull(applicationContact);
	}
	
	@Test
	public void testFindApplicationContactByInvalidUser() throws Exception {
		ApplicationService appService = new ApplicationService();
		appService.setApplicationContactsDAO(new ApplicationContactsDAO());
		ApplicationContactsDTO applicationContact = appService.findApplicationContactByUser("invaliduser");
		Assert.assertNull(applicationContact);
	}
}
