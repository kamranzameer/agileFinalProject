package edu.harvard.agile.util;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.theories.Theory;

/**
 * This test is test all the methods of the DBUtil class
 * @author Incredibles Team
 *
 */
public class DBUtilTest {

	OracleConnectionPoolDataSource ds;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception 
	{

		
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * This test is to test the getConnection method of DBUtil 
	 * @throws Exception
	 */
	@Test
	public void testGetConnection() throws Exception {
		Connection connection = DBUtil.getConnection();
		assertNotNull(connection);
	}
	
	
	/**
	 * This method is to test the closeconnection method of DBUtil
	 * @throws Exception
	 */
	@Test
	public void testCloseConnection() throws Exception {
		Connection connection = DBUtil.getConnection();
		assertTrue(DBUtil.closeConnection(connection));
	}
	
	/**
	 * This method is to test the getNextSequence method of DBUtil
	 * @throws Exception
	 */
	@Test
	public void testGetNextSequence() throws Exception {
		int seq = DBUtil.getNextSequence("package_id_seq");
		assertNotEquals(0, seq);
	}
	
	/**
	 * This method is to test the invalid scenario of getNextSequence method 
	 * with an invalid sequence name 
	 * @throws Exception
	 */
	@Test(expected = SQLSyntaxErrorException.class)
	
	public void testGetNextSequenceInvalid() throws Exception{
		DBUtil.getNextSequence("package_id_sequence");
	}

}
