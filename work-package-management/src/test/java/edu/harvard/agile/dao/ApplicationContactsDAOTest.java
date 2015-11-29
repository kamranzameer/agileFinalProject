package edu.harvard.agile.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.harvard.agile.model.ApplicationContactsDTO;

public class ApplicationContactsDAOTest {

	//static String appId;
	
	@Before
	public void setUp() throws Exception {
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
	
	}
	
	@Test
	public void testFindByUserid() throws Exception {
		ApplicationContactsDAO appContactsDAO = new ApplicationContactsDAO();
		ApplicationContactsDTO appContactsDTO = appContactsDAO.findContactsByUser("userapp1");
		assertNotNull(appContactsDTO);
	}
	
	@Test
	public void testFindByInvalidUserId() throws Exception {
		ApplicationContactsDAO appContactsDAO = new ApplicationContactsDAO();
		ApplicationContactsDTO appContactsDTO = appContactsDAO.findContactsByUser("invaliduser");
		assertNull(appContactsDTO);
	}

}
