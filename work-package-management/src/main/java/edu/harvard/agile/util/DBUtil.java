package edu.harvard.agile.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

/**
 * This class is a DB util class that contains methods to perform actions on the database
 * @author Incredibles Team
 *
 */
public class DBUtil {

	/**
	 * This method is to retrieve data source from Oracle Connection pool 
	 * @return DataSource
	 * @throws SQLException
	 */
	private static DataSource getDataSource() throws SQLException {
		OracleConnectionPoolDataSource ds = new OracleConnectionPoolDataSource();
		ds.setURL("jdbc:oracle:thin:@52.5.93.209:1521:xe");
		ds.setUser("incredibles");
		ds.setPassword("incredibles");
		return ds;

	}

	/**
	 * this method is to retrieve connection object using datasource
	 * @return connection
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
		Connection connection = getDataSource().getConnection();
		connection.setAutoCommit(false);
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
				if (!connection.isClosed()) {
					connection.close();
					return connection.isClosed();
				}
			} catch (SQLException e) {
				e.printStackTrace();

			}

		}
		return false;

	}

	
	/**
	 * This method is to get the next value of any oracle sequence 
	 * @param seqName is a Sequence name
	 * @return the value of the sequence as int
	 * @throws Exception
	 */
	public static int getNextSequence(String seqName) throws Exception {
		String seqQuery = "Select " + seqName + ".nextVal from DUAL";
		int seq = 0;
		Connection con = null;

		try {
			con = getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(seqQuery);

			if (rs.next()) {
				seq = rs.getInt(1);
			}
		} finally {
			if (con != null) {
				con.close();
			}
		}

		return seq;

	}

}
