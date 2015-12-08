package edu.harvard.agile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.harvard.agile.model.ActivityTypeDTO;
import edu.harvard.agile.util.DBUtil;

/**
 * @author Incredibles Team This DAO class contains methods to perform actions
 *         on the database against ACTIVITY_TYPE table
 *
 */
public class ActivityTypeDAO {

	/**
	 * Find all Activity Types 
	 * 
	 * @param id
	 * @return - List<ActivityTypeDTO>
	 * @throws Exception
	 */
	public List<ActivityTypeDTO> findAllActivityTypes()
			throws Exception {

		/*
		 * Get connection from DBUtil, executes select query and initializes the
		 * object with values returned from the database and returns the
		 * ActivityType DTO.
		 */

		Connection con = null;
		PreparedStatement stmt = null;
		List<ActivityTypeDTO> activityTypes = new ArrayList<ActivityTypeDTO>();
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();

			String query = "SELECT  ACTIVITY_TYPE_CODE, ACTIVITY_TYPE_DESC FROM ACTIVITY_TYPE";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			ActivityTypeDTO activity = null;
			while (rs.next()) {
				activity = new ActivityTypeDTO();
				activity.setActivityTypeCode(rs.getString("ACTIVITY_TYPE_CODE"));
				activity.setActivityTypeDesc(rs.getString("ACTIVITY_TYPE_DESC"));
				activityTypes.add(activity);
			}
		} finally {
			DBUtil.closeRS(rs);
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(con);

		}

		return activityTypes;
	}

}
