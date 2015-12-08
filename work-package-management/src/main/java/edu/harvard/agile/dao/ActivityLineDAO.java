package edu.harvard.agile.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.harvard.agile.model.ActivityLineDTO;
import edu.harvard.agile.util.DBUtil;

/**
 * @author Incredibles Team
 * 		   This DAO class contains methods to perform actions on the database
 *         against Activity Line table
 *
 */
public class ActivityLineDAO {

	/**
	 * Find all Activities created for a work request
	 * 
	 * @param id - work request id
	 * @return - ActivityLineDTOs
	 * @throws Exception
	 */
	public List<ActivityLineDTO> findByRequestId(int workRequestId) throws Exception {

		/*
		 * Get connection from DBUtil, executes select query and initializes the
		 * object with values returned from the database and returns the Activity Line
		 * DTO.
		 */

		Connection con = null;
		PreparedStatement stmt = null;
		ActivityLineDTO activityLine = null;
		List<ActivityLineDTO> activityLines = new ArrayList<ActivityLineDTO>();
		ResultSet rs = null;
		
		try {
			con = DBUtil.getConnection();
			
			
			
			String query = "SELECT  ACTIVITY_LINE_ID, ACTIVITY_LINE_DESC, WORK_REQUEST_ID,  ACTIVITY_LINE.ACTIVITY_TYPE_CODE, "
					+ "ACTIVITY_TYPE.ACTIVITY_TYPE_DESC, START_DATE, END_DATE FROM ACTIVITY_LINE, ACTIVITY_TYPE WHERE "
					+ "WORK_REQUEST_ID = ? AND ACTIVITY_LINE.ACTIVITY_TYPE_CODE = ACTIVITY_TYPE.ACTIVITY_TYPE_CODE";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, workRequestId);
			rs = stmt.executeQuery();
			
			
			while (rs.next()) {
				activityLine = new ActivityLineDTO();
				
				activityLine.setActivityLineDesc(rs.getString("ACTIVITY_LINE_DESC"));
				activityLine.setActivityLineId(rs.getInt("ACTIVITY_LINE_ID"));
				activityLine.setActivityTypeCode(rs.getString("ACTIVITY_TYPE_CODE"));
				activityLine.setActivityTypeDesc(rs.getString("ACTIVITY_TYPE_DESC"));
				activityLine.setEndDate(rs.getDate("END_DATE"));
				activityLine.setStartDate(rs.getDate("START_DATE"));
				activityLine.setWorkRequestId(rs.getInt("WORK_REQUEST_ID"));
				
				activityLine.setTotalCost(getTotalCost(rs.getInt("ACTIVITY_LINE_ID"), con));
				activityLine.setTotalHours(getTotalHours(rs.getInt("ACTIVITY_LINE_ID"), con));
				
				activityLines.add(activityLine);
			}
		} finally {
			DBUtil.closeRS(rs);
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(con);

		}

		return activityLines;
	}
	
	
	
	/**
	 * @param activityLineId
	 * @return total cost for all the activity lines within a work request
	 * @throws Exception
	 */
	public Integer getTotalCost(Integer activityLineId, Connection con)
			throws Exception {
		/*
		Build a select query to calculate the total cost for all the activity lines under work request
		by resource type and hourly rate.
		*/
		StringBuilder query = new StringBuilder("");
		query.append(" SELECT SUM (HOURLY_RATE * TOTAL_HOURS) ");
		query.append(" FROM   (SELECT A.RESOURCE_TYPE_ID,  ");
		query.append("                B.HOURLY_RATE,  ");
		query.append("                SUM (ESTIMATED_HOURS) total_hours  ");
		query.append("         FROM   ACTIVITY_PHASE_RESOURCES A,  ");
		query.append("                RESOURCE_TYPE B,  ");
		query.append("                ACTIVITY_LINE C,  ");
		query.append("                WORK_REQUEST D  ");
		query.append("         WHERE  A.RESOURCE_TYPE_ID = B.RESOURCE_TYPE_ID  ");
		query.append("                AND A.ACTIVITY_LINE_ID = C.ACTIVITY_LINE_ID  ");
		query.append("                AND C.WORK_REQUEST_ID = D.WORK_REQUEST_ID  ");
		query.append("                AND C.ACTIVITY_LINE_ID = ?  ");
		query.append("         GROUP  BY A.RESOURCE_TYPE_ID,  ");
		query.append("                   B.HOURLY_RATE) ");

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement(query.toString());
			stmt.setInt(1, activityLineId);
			rs = stmt.executeQuery();

			if (rs.next()) {
				return rs.getInt(1);
			}
		} finally {
			DBUtil.closeRS(rs);
			DBUtil.closeStatement(stmt);

		}

		return null;

	}
	
	
	/**
	 * @param activityLineId
	 * @return total hours for all the activity phases that belong to an activity line
	 * @throws Exception
	 */
	public Integer getTotalHours(Integer activityLineId, Connection con) throws Exception{
		
		/*
		Build a select query to calculate the total hours for all the activity phases under an activity line
		and group by resource type and hourly rate.
		*/
		
		StringBuilder query = new StringBuilder("");
		query.append(" SELECT SUM (TOTAL_HOURS) ");
		query.append(" FROM   (SELECT A.RESOURCE_TYPE_ID,  ");
		query.append("                B.HOURLY_RATE,  ");
		query.append("                SUM (ESTIMATED_HOURS) total_hours  ");
		query.append("         FROM   ACTIVITY_PHASE_RESOURCES A,  ");
		query.append("                RESOURCE_TYPE B,  ");
		query.append("                ACTIVITY_LINE C,  ");
		query.append("                WORK_REQUEST D  ");
		query.append("         WHERE  A.RESOURCE_TYPE_ID = B.RESOURCE_TYPE_ID  ");
		query.append("                AND A.ACTIVITY_LINE_ID = C.ACTIVITY_LINE_ID  ");
		query.append("                AND C.WORK_REQUEST_ID = D.WORK_REQUEST_ID  ");
		query.append("                AND C.ACTIVITY_LINE_ID = ?  ");
		query.append("         GROUP  BY A.RESOURCE_TYPE_ID,  ");
		query.append("                   B.HOURLY_RATE) ");
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = con.prepareStatement(query.toString());
			stmt.setInt(1, activityLineId);
			rs = stmt.executeQuery();

			if (rs.next()) {
				return rs.getInt(1);
			}
		} finally {
			DBUtil.closeRS(rs);
			DBUtil.closeStatement(stmt);
		}

		return null;
	}
	
	public ActivityLineDTO createActivityLine(ActivityLineDTO activityLine, Connection con) throws SQLException
	{
		String sql = "INSERT INTO ACTIVITY_LINE ( ACTIVITY_LINE_ID, ACTIVITY_LINE_DESC, "
				+ "WORK_REQUEST_ID, ACTIVITY_TYPE_CODE, START_DATE, END_DATE, CREATE_DATE, "
				+ "MODIFIED_DATE,CREATE_BY,MODIFIED_BY) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = null;
		
		try {
			statement = con.prepareStatement(sql);
			activityLine.setActivityLineId(DBUtil.getNextSequence("ACTIVITY_LINE_ID_SEQ", con));
			statement.setInt(1, activityLine.getActivityLineId());
			statement.setString(2, activityLine.getActivityLineDesc());
			statement.setInt(3, activityLine.getWorkRequestId());
			statement.setString(4, activityLine.getActivityTypeCode());
			statement.setDate(5, new Date(System.currentTimeMillis()));
			statement.setDate(6, new Date(System.currentTimeMillis()));
			statement.setDate(7, new Date(System.currentTimeMillis()));
			statement.setDate(8, new Date(System.currentTimeMillis()));
			statement.setString(9, activityLine.getCreateBy());
			statement.setString(10, activityLine.getModifiedBy());
			
			int rowsUpdated = statement.executeUpdate();
		}
		finally
		{
			DBUtil.closeStatement(statement);
		}

		return activityLine;
		
	}
}
