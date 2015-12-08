package edu.harvard.agile.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.harvard.agile.model.ActivityPhaseResourcesDTO;
import edu.harvard.agile.model.AssumptionsDTO;
import edu.harvard.agile.util.DBUtil;

public class AssumptionsDAOTest {

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
	public void testFindAssumptionsByActivityLineId() throws Exception {
		assertTrue(new AssumptionsDAO().findAssumptionsByActivityLineId(4).size() > 0);
	}
	
	@Test
	public void testFindAssumptionsByInvalidActivityLineId() throws Exception {
		assertTrue(new AssumptionsDAO().findAssumptionsByActivityLineId(123456).size() == 0);
	}
	
	@Test
	public void testCreateAssumptions() throws Exception {
		List<AssumptionsDTO> assumptions = new ArrayList<AssumptionsDTO>();
		AssumptionsDTO dto = new AssumptionsDTO();
		dto.setActivityLineId(4);
		dto.setAssumptionsDesc("Junit assumptions 1");
		dto.setWorkRequestId(12);
		dto.setCreateBy("junit");
		dto.setModifiedBy("junit");
		assumptions.add(dto);
		
		dto = new AssumptionsDTO();
		dto.setActivityLineId(4);
		dto.setAssumptionsDesc("Junit assumptions 2");
		dto.setWorkRequestId(12);
		dto.setCreateBy("junit");
		dto.setModifiedBy("junit");
		assumptions.add(dto);

			
		Connection con = DBUtil.getConnection();
		try
		{
			int[] rowsUpdated = new AssumptionsDAO().createAssumptions(assumptions, con);
			con.commit();
			assertTrue(rowsUpdated.length > 0);
		}
		finally
		{
			DBUtil.closeConnection(con);
		}
	}
	
	@Test (expected = SQLException.class)
	public void testCreateAssumptionsWithInvalidActivityLineId() throws Exception {
		List<AssumptionsDTO> assumptions = new ArrayList<AssumptionsDTO>();
		AssumptionsDTO dto = new AssumptionsDTO();
		dto.setActivityLineId(4);
		dto.setAssumptionsDesc("Junit assumptions 1");
		dto.setWorkRequestId(12);
		dto.setCreateBy("junit");
		dto.setModifiedBy("junit");
		assumptions.add(dto);
		
		dto = new AssumptionsDTO();
		dto.setActivityLineId(4566554);
		dto.setAssumptionsDesc("Junit assumptions 2");
		dto.setWorkRequestId(12);
		dto.setCreateBy("junit");
		dto.setModifiedBy("junit");
		assumptions.add(dto);

			
		Connection con = DBUtil.getConnection();
		try
		{
			int[] rowsUpdated = new AssumptionsDAO().createAssumptions(assumptions, con);
			con.commit();
			assertTrue(rowsUpdated.length > 0 && rowsUpdated[0] == 0);
		}
		finally
		{
			DBUtil.closeConnection(con);
		}
	}
	
	@Test (expected = SQLException.class)
	public void testCreateAssumptionsWithInvalidWorkRequestId() throws Exception {
		List<AssumptionsDTO> assumptions = new ArrayList<AssumptionsDTO>();
		AssumptionsDTO dto = new AssumptionsDTO();
		dto.setActivityLineId(4);
		dto.setAssumptionsDesc("Junit assumptions 1");
		dto.setWorkRequestId(12);
		dto.setCreateBy("junit");
		dto.setModifiedBy("junit");
		assumptions.add(dto);
		
		dto = new AssumptionsDTO();
		dto.setActivityLineId(4);
		dto.setAssumptionsDesc("Junit assumptions 2");
		dto.setWorkRequestId(44545);
		dto.setCreateBy("junit");
		dto.setModifiedBy("junit");
		assumptions.add(dto);

			
		Connection con = DBUtil.getConnection();
		try
		{
			int[] rowsUpdated = new AssumptionsDAO().createAssumptions(assumptions, con);
			con.commit();
			assertTrue(rowsUpdated.length > 0 && rowsUpdated[0] == 0);
		}
		finally
		{
			DBUtil.closeConnection(con);
		}
	}
	
	
	@Test
	public void testCreateAssumptionsForWorkRequest() throws Exception {
		AssumptionsDTO dto = new AssumptionsDTO();
		dto.setAssumptionsDesc("Junit assumptions work request 1");
		dto.setWorkRequestId(12);
		dto.setCreateBy("junit");
		dto.setModifiedBy("junit");
		
		Connection con = DBUtil.getConnection();
		try
		{
			dto = new AssumptionsDAO().createAssumption(dto, con);
			con.commit();
			assertTrue(dto.getAssumptionsId() != null);
		}
		finally
		{
			DBUtil.closeConnection(con);
		}
	}
	
	@Test (expected = SQLException.class)
	public void testCreateAssumptionsForInvalidWorkRequest() throws Exception {
		AssumptionsDTO dto = new AssumptionsDTO();
		dto.setAssumptionsDesc("Junit assumptions work request 1");
		dto.setWorkRequestId(124556);
		dto.setCreateBy("junit");
		dto.setModifiedBy("junit");
		
		Connection con = DBUtil.getConnection();
		try
		{
			dto = new AssumptionsDAO().createAssumption(dto, con);
			con.commit();
			assertTrue(dto.getAssumptionsId() == null);
		}
		finally
		{
			DBUtil.closeConnection(con);
		}
	}
	
	@Test(expected = SQLException.class)
	public void testCreateAssumptionsWithNullAssumptionsDesc() throws Exception {
		AssumptionsDTO dto = new AssumptionsDTO();
		dto.setWorkRequestId(12);
		dto.setCreateBy("junit");
		dto.setModifiedBy("junit");
		
		Connection con = DBUtil.getConnection();
		try
		{
			dto = new AssumptionsDAO().createAssumption(dto, con);
			con.commit();
			assertTrue(dto.getAssumptionsId() != null);
		}
		finally
		{
			DBUtil.closeConnection(con);
		}
	}
}
