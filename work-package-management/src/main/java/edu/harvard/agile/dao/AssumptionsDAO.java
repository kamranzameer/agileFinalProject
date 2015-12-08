package edu.harvard.agile.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import edu.harvard.agile.model.ActivityLineDTO;
import edu.harvard.agile.model.AssumptionsDTO;
import edu.harvard.agile.util.DBUtil;

/**
 * @author Incredibles Team This DAO class contains methods to perform actions
 *         on the database against Assumptions table
 *
 */
public class AssumptionsDAO {
	
	/**
	 * Method to create Activity Phase record
	 * @param assumption
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public AssumptionsDTO createAssumption(AssumptionsDTO assumption, Connection con) throws SQLException
	{
		String sql = "INSERT INTO ASSUMPTIONS (ASSUMPTIONS_ID, ASSUMPTIONS_DESC, WORK_REQUEST_ID, "
				+ "ACTIVITY_LINE_ID, CREATE_DATE, MODIFIED_DATE, CREATE_BY, MODIFIED_BY ) VALUES ("
				+ "?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = null;
		
		try
		{
			
			assumption.setAssumptionsId(DBUtil.getNextSequence("ASSUMPTIONS_ID_SEQ", con));
			
			statement = con.prepareStatement(sql);
			statement.setInt(1, assumption.getAssumptionsId());
			statement.setString(2, assumption.getAssumptionsDesc());
			statement.setInt(3, assumption.getWorkRequestId());
			if(assumption.getActivityLineId() != null)
			{
				statement.setInt(4,  assumption.getActivityLineId());
			}
			else
			{
				statement.setNull(4, Types.INTEGER);
			}
			statement.setDate(5, new Date(System.currentTimeMillis()));
			statement.setDate(6, new Date(System.currentTimeMillis()));
			statement.setString(7,  assumption.getCreateBy());
			statement.setString(8,  assumption.getModifiedBy());
			
			int rowsUpdated = statement.executeUpdate();
			return assumption;
		}
		finally
		{
			DBUtil.closeStatement(statement);
		}
		
	}
	
	/**
	 * Method to create Activity Phase records at one go
	 * @param assumption
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public int[] createAssumptions(List<AssumptionsDTO> assumptions, Connection con) throws SQLException
	{
		String sql = "INSERT INTO ASSUMPTIONS (ASSUMPTIONS_ID, ASSUMPTIONS_DESC, WORK_REQUEST_ID, "
				+ "ACTIVITY_LINE_ID, CREATE_DATE, MODIFIED_DATE, CREATE_BY, MODIFIED_BY ) VALUES ("
				+ "?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = null;
		
		try
		{
			for (AssumptionsDTO assumption : assumptions) 
			{
				assumption.setAssumptionsId(DBUtil.getNextSequence("ASSUMPTIONS_ID_SEQ", con));
				
				statement = con.prepareStatement(sql);
				statement.setInt(1, assumption.getAssumptionsId());
				statement.setString(2, assumption.getAssumptionsDesc());
				statement.setInt(3, assumption.getWorkRequestId());
				statement.setInt(4,  assumption.getActivityLineId());
				statement.setDate(5, new Date(System.currentTimeMillis()));
				statement.setDate(6, new Date(System.currentTimeMillis()));
				statement.setString(7,  assumption.getCreateBy());
				statement.setString(8,  assumption.getModifiedBy());
				
				statement.addBatch();
			}
			
			
			int[] rowsUpdated = statement.executeBatch();
			return rowsUpdated;
		}
		finally
		{
			DBUtil.closeStatement(statement);
		}
		
	}

	/**
	 * Find all assumptions by Activity line item
	 * 
	 * @param id
	 * @return - List<Assumptions>
	 * @throws Exception
	 */
	public List<String> findAssumptionsByActivityLineId(int activityLineId)
			throws Exception {

		/*
		 * Get connection from DBUtil, executes select query and initializes the
		 * object with values returned from the database and returns the
		 * Activity Line DTO.
		 */

		Connection con = null;
		PreparedStatement stmt = null;
		List<String> assumptions = new ArrayList<String>();
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();

			String query = "SELECT  ASSUMPTIONS_DESC FROM ASSUMPTIONS WHERE ACTIVITY_LINE_ID = ?";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, activityLineId);
			rs = stmt.executeQuery();

			while (rs.next()) {
				assumptions.add(rs.getString("ASSUMPTIONS_DESC"));
			}
		} finally {
			DBUtil.closeRS(rs);
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(con);

		}

		return assumptions;
	}

}
