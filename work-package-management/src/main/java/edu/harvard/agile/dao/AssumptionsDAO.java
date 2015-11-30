package edu.harvard.agile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.harvard.agile.model.ActivityLineDTO;
import edu.harvard.agile.model.AssumptionsDTO;
import edu.harvard.agile.util.DBUtil;

/**
 * @author Incredibles Team This DAO class contains methods to perform actions
 *         on the database against Activity Line table
 *
 */
public class AssumptionsDAO {

	/**
	 * Find by work request method to find the record by work request id.
	 * 
	 * @param id
	 *            - work request id
	 * @return - List<Assumptions>
	 * @throws Exception
	 */
	public List<String> findAssumptionsVyActivityLineId(int activityLineId)
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

			String query = "SELECT  ASSUMPTIONS_ID, ASSUMPTIONS_DESC, WORK_REQUEST_ID,  ACTIVITY_LINE_ID, CREATE_DATE, MODIFIED_DATE,  CREATE_BY, MODIFIED_BY FROM ASSUMPTIONS WHERE ACTIVITY_LINE_ID = ?";
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
