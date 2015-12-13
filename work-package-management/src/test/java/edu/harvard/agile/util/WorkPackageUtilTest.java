package edu.harvard.agile.util;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class WorkPackageUtilTest {

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
	public void testConvertDateWithyyyyMMddFormat() throws ParseException {
		assertNotNull(new WorkPackageUtil().convertDate("2011-11-14", "yyyy-MM-dd"));
	}
	
	@Test
	public void testConvertDateWithMMddyyyyFormat() throws ParseException {
		assertNotNull(new WorkPackageUtil().convertDate("11-14-2015", "MM-dd-yyyy"));
	}
	
	@Test (expected = ParseException.class)
	public void testConvertDateWithInvalidFormat() throws ParseException {
		assertNotNull(new WorkPackageUtil().convertDate("11-14-2015", "dd/MM/yyyy"));
	}
	
	@Test 
	public void testConvertDateWithNullDate() throws ParseException {
		assertNull(new WorkPackageUtil().convertDate(null, "MM-dd-yyyy"));
	}
	
	@Test 
	public void testConvertDateWithEmptyDate() throws ParseException {
		assertNull(new WorkPackageUtil().convertDate("", "MM-dd-yyyy"));
	}
	
	@Test 
	public void testGetValidStatuses() throws ParseException {
		assertEquals(4, new WorkPackageUtil().getValidStatus().size());
	}

}
