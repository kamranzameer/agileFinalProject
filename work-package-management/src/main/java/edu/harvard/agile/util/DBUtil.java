package edu.harvard.agile.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

public class DBUtil {

	private static DataSource getDataSource() throws SQLException {
		// Construct DataSource

		OracleConnectionPoolDataSource ds = new OracleConnectionPoolDataSource();
		ds.setURL("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUser("incredibles");
		ds.setPassword("incredibles");
		return ds;

	}

	public static Connection getConnection() throws Exception {
		Connection connection = getDataSource().getConnection();
		connection.setAutoCommit(false);
		return connection;
	}

	public static boolean closeStatement(Statement stmt){

		if (stmt != null) {
			try {
				stmt.close();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;

	}

	public static boolean closeConnection(Connection connection) {

		if (connection != null) {
			try {
				if (!connection.isClosed()) {
					connection.close();
					return connection.isClosed();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

		}
		return false;

	}

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
