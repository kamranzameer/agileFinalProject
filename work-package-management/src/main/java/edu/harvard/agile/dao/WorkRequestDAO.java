package edu.harvard.agile.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.harvard.agile.model.WorkRequestDTO;
import edu.harvard.agile.util.DBUtil;

/**
 * @author Incredibles Team
 * 
 *         This DAO class contains methods to perform actions on the database
 *         against Work Request table
 *
 */
public class WorkRequestDAO {

	private Connection connection;
	
	public WorkRequestDAO(Connection connection) {
		super();
		this.connection = connection;
	}
	
	//TODO : This constructor should be removed and SQL connection should be accepted from service class for better transaction management
	public WorkRequestDAO()
	{
		
	}

	/**
	 * Find by primary key method to find the record by WorkRequest id.
	 * 
	 * @param id
	 *            - Application ID
	 * @return - a WorkRequest DTO
	 * @throws Exception
	 */
	public List<WorkRequestDTO> findRequestsByApplicationId(String id) throws Exception {

		/*
		 * Get connection from DBUtil, executes select query and initializes the
		 * object with values returned from the database and returns the work
		 * package DTO.
		 */

		Connection con = null;
		PreparedStatement stmt = null;
		List<WorkRequestDTO> workRequestDTOs = new ArrayList<WorkRequestDTO>();
		
		try {
			con = DBUtil.getConnection();
			String query = "SELECT WORK_REQUEST_ID,PACKAGE_ID,STATUS,START_DATE,END_DATE FROM WORK_REQUEST where APPLICATION_ID = ?";
			stmt = con.prepareStatement(query);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			WorkRequestDTO workRequest = null;
			
			while (rs.next()) {
				workRequest = new WorkRequestDTO();
				workRequest.setPackageId(rs.getInt("PACKAGE_ID"));
				workRequest.setWorkRequestId(rs.getInt("WORK_REQUEST_ID"));
				workRequest.setStartDate(rs.getDate("START_DATE"));
				workRequest.setEndDate(rs.getDate("END_DATE"));
				workRequest.setStatus(rs.getString("STATUS"));
				workRequest.setApplicationId(id);
				
				workRequestDTOs.add(workRequest);
			}
		} finally {
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(con);

		}

		return workRequestDTOs;
	}
	
	/**
	 * Find by package name
	 * 
	 * @param packageName
	 * @return - a WorkRequest DTO
	 * @throws Exception
	 */
	public WorkRequestDTO findByWorkRequestId(int id) throws Exception {

		/*
		 * Get connection from DBUtil, executes select query and initializes the
		 * object with values returned from the database and returns the work
		 * request DTO.
		 */

		Connection con = null;
		PreparedStatement stmt = null;
		WorkRequestDTO WorkRequest = null;
		try {
			con = DBUtil.getConnection();
			String query = "SELECT PACKAGE_ID,STATUS,START_DATE,END_DATE,APPLICATION_ID FROM WORK_REQUEST where WORK_REQUEST_ID = ?";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				WorkRequest = new WorkRequestDTO();
				WorkRequest.setWorkRequestId(id);
				WorkRequest.setPackageId(rs.getInt("PACKAGE_ID"));	
				WorkRequest.setApplicationId(rs.getString("APPLICATION_ID"));
				WorkRequest.setStartDate(rs.getDate("START_DATE"));
				WorkRequest.setEndDate(rs.getDate("END_DATE"));
				WorkRequest.setStatus(rs.getString("STATUS"));
			}
		} finally {
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(con);

		}

		return WorkRequest;
	}

	/**
	 * This method returns all the work requests from the table
	 * 
	 * @return a list work request DTOs
	 * @throws Exception
	 */
	public List<WorkRequestDTO> findAllWorkRequests() throws Exception {
		 /* Get connection from DBUtil, executes select query. Iterates through
		 * result set, initialize new workRequestDTO object with the values
		 * returned from the database, add to the list and return the list of
		 * objects.
		 */

		Connection con = null;
		PreparedStatement stmt = null;
		List<WorkRequestDTO> workRequestDTOs = null;
		try {

			con = DBUtil.getConnection();
			String query = "SELECT WORK_REQUEST_ID,PACKAGE_ID,APPLICATION_ID,STATUS,START_DATE,END_DATE FROM WORK_REQUEST";
			stmt = con.prepareStatement(query);

			ResultSet rs = stmt.executeQuery();

			workRequestDTOs = new ArrayList<WorkRequestDTO>();
			WorkRequestDTO workRequest = null;

			while (rs.next()) {
				workRequest = new WorkRequestDTO();
				workRequest.setPackageId(rs.getInt("PACKAGE_ID"));
				workRequest.setWorkRequestId(rs.getInt("WORK_REQUEST_ID"));
				workRequest.setStartDate(rs.getDate("START_DATE"));
				workRequest.setEndDate(rs.getDate("END_DATE"));
				workRequest.setStatus(rs.getString("STATUS"));
				workRequest.setApplicationId(rs.getString("APPLICATION_ID"));
				
				workRequestDTOs.add(workRequest);
			}
		} finally {
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(con);

		}

		return workRequestDTOs;
	}

	/**
	 * This method creates anew work request and saves to the database.
	 * 
	 * @param workRequest
	 * @return
	 * @throws Exception
	 */
	public WorkRequestDTO createWorkRequest(WorkRequestDTO workRequest) throws Exception {
		/*
		 * Get connection from DBUtil, set the parameters for the statement and
		 * executes insert query. Uses oracle sequence as primary key. Returns
		 * the object that was saved to the database by using findby method.
		 * Commits the transaction and rolls back if any exception occurs.
		 */
		
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			int seqId = DBUtil.getNextSequence("WORK_REQUEST_ID_SEQ");

			String query = "Insert into WORK_REQUEST (WORK_REQUEST_ID,PACKAGE_ID,APPLICATION_ID,STATUS,START_DATE,END_DATE,CREATE_DATE,MODIFIED_DATE,CREATE_BY,MODIFIED_BY) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, seqId);
			stmt.setInt(2, workRequest.getPackageId());
			stmt.setString(3, workRequest.getApplicationId());
			stmt.setString(4, workRequest.getStatus());
			stmt.setDate(5, new Date(workRequest.getStartDate().getTime()));
			stmt.setDate(6, new Date(workRequest.getEndDate().getTime()));
			stmt.setDate(7, new Date(System.currentTimeMillis()));
			stmt.setDate(8, new Date(System.currentTimeMillis()));
			stmt.setString(9, workRequest.getCreateBy());
			stmt.setString(10, workRequest.getModifiedBy());
			int rowsUpdated = stmt.executeUpdate();
			workRequest.setWorkRequestId(seqId);
			con.commit();
			return findByWorkRequestId(seqId);
		}  catch(Exception ex)
		{
			con.rollback();
			throw ex;
		}
		finally {
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(con);

		}
	}

	/**
	 * This method updates status of work request record in the database
	 * 
	 * @param WorkRequest
	 * @return
	 * @throws Exception
	 */
	public WorkRequestDTO updateWorkRequestStatus(WorkRequestDTO WorkRequest) throws Exception {

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

			String query = "Update WORK_REQUEST SET STATUS = ?, MODIFIED_DATE = ?,MODIFIED_BY = ? WHERE WORK_REQUEST_ID = ?";
			stmt = con.prepareStatement(query);
			stmt.setString(1, WorkRequest.getStatus());

			stmt.setDate(2, new Date(System.currentTimeMillis()));
			stmt.setString(3, WorkRequest.getModifiedBy());
			stmt.setInt(4, WorkRequest.getWorkRequestId());

			int rowsUpdated = stmt.executeUpdate();
			con.commit();

			return findByWorkRequestId(WorkRequest.getWorkRequestId());
		} catch (Exception e) {
			con.rollback();
			throw e;
		} finally {
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(con);

		}
	}

}
