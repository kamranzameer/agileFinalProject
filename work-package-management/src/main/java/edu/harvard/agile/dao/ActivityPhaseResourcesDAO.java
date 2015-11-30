package edu.harvard.agile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.harvard.agile.model.ActivityPhaseResourcesDTO;
import edu.harvard.agile.util.DBUtil;

public class ActivityPhaseResourcesDAO {

	/**
	 * Find by work request method to find the record by work request id.
	 * 
	 * @param id - work request id
	 * @return - ActivityLineDTOs
	 * @throws Exception
	 */
	public List<ActivityPhaseResourcesDTO> findByActivityLineId(int activityLineId) throws Exception {

		/*
		 * Get connection from DBUtil, executes select query and initializes the
		 * object with values returned from the database and returns the work
		 * package DTO.
		 */

		Connection con = null;
		PreparedStatement stmt = null;
		ActivityPhaseResourcesDTO activityPhaseResource = null;
		List<ActivityPhaseResourcesDTO> activityPhaseResources = new ArrayList<ActivityPhaseResourcesDTO>();
		ResultSet rs = null;
		
		try {
			con = DBUtil.getConnection();
			
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT A.ACTIVITY_PHASE_RESOURCE_ID,  ");
			query.append("        B.RESOURCE_TYPE_NAME,   ");
			query.append("        A.RESOURCE_TYPE_ID,   ");
			query.append("        B.HOURLY_RATE,   ");
			query.append("        SUM (A.ESTIMATED_HOURS) AS TOTAL_HOURS   ");
			query.append(" FROM   ACTIVITY_PHASE_RESOURCES A,   ");
			query.append("        RESOURCE_TYPE B,   ");
			query.append("        ACTIVITY_LINE C,   ");
			query.append("        WORK_REQUEST D   ");
			query.append(" WHERE  A.RESOURCE_TYPE_ID = B.RESOURCE_TYPE_ID   ");
			query.append("        AND A.ACTIVITY_LINE_ID = C.ACTIVITY_LINE_ID   ");
			query.append("        AND C.WORK_REQUEST_ID = D.WORK_REQUEST_ID   ");
			query.append("        AND C.ACTIVITY_LINE_ID = ?  ");
			query.append(" GROUP  BY A.ACTIVITY_PHASE_RESOURCE_ID,  "); 
			query.append("           B.RESOURCE_TYPE_NAME,   ");
			query.append("           A.RESOURCE_TYPE_ID,   ");
			query.append("           B.HOURLY_RATE   ");
			
			stmt = con.prepareStatement(query.toString());
			stmt.setInt(1, activityLineId);
			rs = stmt.executeQuery();
			
			
			while (rs.next()) {
				activityPhaseResource = new ActivityPhaseResourcesDTO();
				activityPhaseResource.setActivityPhaseResourceId(rs.getInt("ACTIVITY_PHASE_RESOURCE_ID"));
				activityPhaseResource.setResourceTypeName(rs.getString("RESOURCE_TYPE_NAME"));
				activityPhaseResource.setResourceTypeId(rs.getInt("RESOURCE_TYPE_ID"));
				activityPhaseResource.setEstimatedHours(rs.getInt("TOTAL_HOURS"));
				activityPhaseResource.setHourlyRate(rs.getInt("HOURLY_RATE"));
				activityPhaseResource.setTotalCost(rs.getInt("TOTAL_HOURS") * rs.getInt("HOURLY_RATE"));
				
				activityPhaseResources.add(activityPhaseResource);
			}
		} finally {
			DBUtil.closeRS(rs);
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(con);

		}

		return activityPhaseResources;
	}
	
	
	
	public Integer getTotalCost(Integer activityLineId, Connection con)
			throws Exception {
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
	
	
	public Integer getTotalHours(Integer activityLineId, Connection con) throws Exception{
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
}
