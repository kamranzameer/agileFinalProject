package edu.harvard.agile.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

/**
 * This class is a DB util class that contains methods to perform actions on the database
 * @author Incredibles Team
 *
 */
public class DBUtil {

	static OracleConnectionPoolDataSource ds;
	static
	{
		Properties prop = new Properties();
		InputStream in = DBUtil.class.getResourceAsStream("/wpm.properties");
		try {
			prop.load(in);
			ds = new OracleConnectionPoolDataSource();

			ds.setURL(prop.getProperty("dburl"));
			ds.setUser(prop.getProperty("dbuser"));
			ds.setPassword(prop.getProperty("dbpasswd"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1); //Dont continue.
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1); //Dont continue.
		}
		finally
		{
			try {
				in.close();
			} catch (IOException e) {
				// Dont do anything
			}
		}
	}
	/**
	 * This method is to retrieve data source from Oracle Connection pool 
	 * @return DataSource
	 * @throws SQLException
	 */
	/*private static void getDataSource(Properties prop) throws Exception
	{
		
		
	}*/

	/**
	 * this method is to retrieve connection object using datasource
	 * @return connection
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
		
		Connection connection = ds.getConnection();
		connection.setAutoCommit(false);
		
		//System.out.println("================ OPEN CONNECTION =====================");
		return connection;
	}

	/**
	 * This method is to close a statement that is open.
	 * @param stmt
	 * @return
	 */
	public static boolean closeStatement(Statement stmt){

		if (stmt != null) {
			try {
				stmt.close();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;

	}
	
	
	/**
	 * This method is to close a statement that is open.
	 * @param stmt
	 * @return
	 */
	public static boolean closeRS(ResultSet rs){

		if (rs != null) {
			try {
				rs.close();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;

	}

	
	/**
	 * This method is to close the connection that is open.
	 * @param connection
	 * @return
	 */
	public static boolean closeConnection(Connection connection) {

		if (connection != null) {
			try {
				connection.close();
				//System.out.println("================ CLOSE CONNECTION =====================");
				return connection.isClosed();
			} catch (SQLException e) {
				e.printStackTrace();

			}

		}
		return false;

	}
	
	/**
	 * This method is to close the connection that is open.
	 * @param connection
	 * @return
	 */
	public static void rollBack(Connection connection) {

		if (connection != null) {
			try {
				connection.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * This method is to get the next value of any oracle sequence 
	 * @param seqName is a Sequence name
	 * @return the value of the sequence as int
	 * @throws Exception
	 */
	public static int getNextSequence(String seqName, Connection con) throws Exception {
		String seqQuery = "Select " + seqName + ".nextVal from DUAL";
		int seq = 0;
		Statement st = null;
		ResultSet rs = null;

		try {
			st = con.createStatement();
			rs = st.executeQuery(seqQuery);

			if (rs.next()) {
				seq = rs.getInt(1);
			}
		} finally {
			
			closeStatement(st);
			closeRS(rs);
		}

		return seq;

	}

}