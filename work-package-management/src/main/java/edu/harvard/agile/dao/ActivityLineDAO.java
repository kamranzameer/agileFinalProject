package edu.harvard.agile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	 * Find by work request method to find the record by work request id.
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
			
			
			
			String query = "SELECT  ACTIVITY_LINE_ID, ACTIVITY_LINE_DESC, WORK_REQUEST_ID,  ACTIVITY_TYPE_CODE, START_DATE, END_DATE,  CREATE_DATE, MODIFIED_DATE, CREATE_BY, MODIFIED_BY FROM ACTIVITY_LINE WHERE WORK_REQUEST_ID = ?";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, workRequestId);
			rs = stmt.executeQuery();
			
			
			while (rs.next()) {
				activityLine = new ActivityLineDTO();
				
				activityLine.setActivityLineDesc(rs.getString("ACTIVITY_LINE_DESC"));
				activityLine.setActivityLineId(rs.getInt("ACTIVITY_LINE_ID"));
				activityLine.setActivityTypeCode(rs.getString("ACTIVITY_TYPE_CODE"));
				activityLine.setCreateBy(rs.getString("CREATE_BY"));
				activityLine.setCreateDate(rs.getDate("CREATE_DATE"));
				activityLine.setEndDate(rs.getDate("END_DATE"));
				activityLine.setStartDate(rs.getDate("START_DATE"));
				activityLine.setWorkRequestId(rs.getInt("WORK_REQUEST_ID"));
				
				activityLine.setTotalCost(getTotalCost(rs.getInt("ACTIVITY_LINE_ID")));
				activityLine.setTotalHours(getTotalHours(rs.getInt("ACTIVITY_LINE_ID")));
				
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
	public Integer getTotalCost(Integer activityLineId)
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
		query.append("                AND D.ACTIVITY_LINE_ID = ?  ");
		query.append("         GROUP  BY A.RESOURCE_TYPE_ID,  ");
		query.append("                   B.HOURLY_RATE) ");

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(query.toString());
			stmt.setInt(1, activityLineId);
			rs = stmt.executeQuery();

			if (rs.next()) {
				return rs.getInt(1);
			}
		} finally {
			DBUtil.closeRS(rs);
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(con);

		}

		return null;

	}
	
	
	/**
	 * @param activityLineId
	 * @return total hours for all the activity phases that belong to an activity line
	 * @throws Exception
	 */
	public Integer getTotalHours(Integer activityLineId) throws Exception{
		
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
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(query.toString());
			stmt.setInt(1, activityLineId);
			rs = stmt.executeQuery();

			if (rs.next()) {
				return rs.getInt(1);
			}
		} finally {
			DBUtil.closeRS(rs);
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(con);

		}

		return null;
		
	}
}
