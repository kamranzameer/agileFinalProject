package edu.harvard.agile.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.harvard.agile.model.ApplicationContactsDTO;
import edu.harvard.agile.model.ApplicationDTO;
import edu.harvard.agile.util.DBUtil;

/**
 * @author Incredibles Team
 * 
 *         This DAO class contains methods to perform actions on the database
 *         against Application contacts table
 *
 */
public class ApplicationContactsDAO {

	/**
	 * Find application contacts by user id.
	 * 
	 * @param id
	 *            - user ID
	 * @return - a ApplicationContact DTO
	 * @throws Exception
	 */
	public ApplicationContactsDTO findContactsByUser(String userid) throws Exception {

		/*
		 * Get connection from DBUtil, executes select query and initializes the
		 * object with values returned from the database and returns the application contact DTO.
		 */

		Connection con = null;
		PreparedStatement stmt = null;
		ApplicationContactsDTO applicationContact = null;
		ResultSet rs = null;
		
		try {
			con = DBUtil.getConnection();
			String query = "SELECT APPLICATION_ID, USER_ID, IS_ACTIVE, CREATE_DATE, MODIFIED_DATE, CREATE_BY, MODIFIED_BY FROM APPLICATION_CONTACTS where USER_ID = ? and IS_ACTIVE = 'Y'";
			stmt = con.prepareStatement(query);
			stmt.setString(1, userid);
			rs = stmt.executeQuery();
			
			
			while (rs.next()) {
				applicationContact = new ApplicationContactsDTO();
				applicationContact.setApplicationId(rs.getString("APPLICATION_ID"));
				applicationContact.setUserId(rs.getString("USER_ID"));
				applicationContact.setIsActive(rs.getString("IS_ACTIVE"));
			}
		} finally {
			DBUtil.closeRS(rs);
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(con);

		}

		return applicationContact;
	}
	

}
