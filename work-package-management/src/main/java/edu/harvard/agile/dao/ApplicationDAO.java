package edu.harvard.agile.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.harvard.agile.model.ApplicationDTO;
import edu.harvard.agile.util.DBUtil;

/**
 * @author Incredibles Team
 * 
 *         This DAO class contains methods to perform actions on the database
 *         against Application table
 *
 */
public class ApplicationDAO {

	/**
	 * Find by primary key method to find the record by Application id.
	 * 
	 * @param id
	 *            - Application ID
	 * @return - a Application DTO
	 * @throws Exception
	 */
	public ApplicationDTO findByApplicationId(String id) throws Exception {

		/*
		 * Get connection from DBUtil, executes select query and initializes the
		 * object with values returned from the database and returns the work
		 * package DTO.
		 */

		Connection con = null;
		PreparedStatement stmt = null;
		ApplicationDTO application = null;
		ResultSet rs = null;
		
		try {
			con = DBUtil.getConnection();
			String query = "SELECT APPLICATION_NAME, APPLICATION_DESC, IS_ACTIVE, CREATE_DATE, MODIFIED_DATE, CREATE_BY, MODIFIED_BY FROM APPLICATION where APPLICATION_ID = ?";
			stmt = con.prepareStatement(query);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			
			
			while (rs.next()) {
				application = new ApplicationDTO();
				application.setApplicationName(rs.getString("APPLICATION_NAME"));
				application.setApplicationId(id);
				application.setApplicationDesc(rs.getString("APPLICATION_DESC"));
				application.setIsActive(rs.getString("IS_ACTIVE"));
				
			}
		} finally {
			DBUtil.closeRS(rs);
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(con);

		}

		return application;
	}
	
	

	/**
	 * This method returns all the applications from the table
	 * 
	 * @return a list application DTOs
	 * @throws Exception
	 */
	public List<ApplicationDTO> findAllApplications() throws Exception {
		 /* Get connection from DBUtil, executes select query. Iterates through
		 * result set, initialize new applicationDTO object with the values
		 * returned from the database, add to the list and return the list of
		 * objects.
		 */

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ApplicationDTO> applicationDTOs = null;
		try {

			con = DBUtil.getConnection();
			String query = "SELECT APPLICATION_ID, APPLICATION_NAME, APPLICATION_DESC, IS_ACTIVE, CREATE_DATE, MODIFIED_DATE, CREATE_BY, MODIFIED_BY FROM APPLICATION";
			stmt = con.prepareStatement(query);

			rs = stmt.executeQuery();

			applicationDTOs = new ArrayList<ApplicationDTO>();
			ApplicationDTO application = null;

			while (rs.next()) {
				application = new ApplicationDTO();
				application.setApplicationName(rs.getString("APPLICATION_NAME"));
				application.setApplicationId(rs.getString("APPLICATION_ID"));
				application.setApplicationDesc(rs.getString("APPLICATION_DESC"));
				application.setIsActive(rs.getString("IS_ACTIVE"));
				
				applicationDTOs.add(application);
			}
		} finally {
			DBUtil.closeRS(rs);
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(con);

		}

		return applicationDTOs;
	}

	/**
	 * This method creates anew application and saves to the database.
	 * 
	 * @param application
	 * @return
	 * @throws Exception
	 */
	public ApplicationDTO createApplication(ApplicationDTO application) throws Exception {
		/*
		 * Get connection from DBUtil, set the parameters for the statement and
		 * executes insert query. Uses oracle sequence as primary key. Returns
		 * the object that was saved to the database by using findby method.
		 * Commits the transaction and rolls back if any exception occurs.
		 */

		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();

			String query = "Insert into APPLICATION (APPLICATION_ID, APPLICATION_NAME, APPLICATION_DESC, IS_ACTIVE, CREATE_DATE, MODIFIED_DATE, CREATE_BY, MODIFIED_BY) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = con.prepareStatement(query);
			stmt.setString(1, application.getApplicationId());
			stmt.setString(2, application.getApplicationName());
			stmt.setString(3, application.getApplicationDesc());
			stmt.setString(4, application.getIsActive());
			stmt.setDate(5, new Date(System.currentTimeMillis()));
			stmt.setDate(6, new Date(System.currentTimeMillis()));
			stmt.setString(7, application.getCreateBy());
			stmt.setString(8, application.getModifiedBy());
			int rowsUpdated = stmt.executeUpdate();
			con.commit();

			return findByApplicationId(application.getApplicationId());
		} catch (Exception e) {
			con.rollback();
			throw e;
		} finally {
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(con);

		}
	}

	/**
	 * This method updates status of application record in the database
	 * 
	 * @param Application
	 * @return
	 * @throws Exception
	 */
	public ApplicationDTO updateApplicationStatus(ApplicationDTO Application) throws Exception {

		/*
		 * Get connection from DBUtil, set the parameters for the statement and
		 * executes update query with a where condition. Returns the object that
		 * was updated by using findby method. Commits the transaction and rolls
		 * back if any exception occurs.
		 */

		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();

			String query = "Update APPLICATION SET IS_ACTIVE = ?, MODIFIED_DATE = ?,MODIFIED_BY = ? WHERE APPLICATION_ID = ?";
			stmt = con.prepareStatement(query);
			stmt.setString(1, Application.getIsActive());

			stmt.setDate(2, new Date(System.currentTimeMillis()));
			stmt.setString(3, Application.getModifiedBy());
			stmt.setString(4, Application.getApplicationId());

			int rowsUpdated = stmt.executeUpdate();
			con.commit();

			return findByApplicationId(Application.getApplicationId());
		} catch (Exception e) {
			con.rollback();
			throw e;
		} finally {
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(con);

		}
	}

}
