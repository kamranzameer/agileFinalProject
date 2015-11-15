package edu.harvard.agile.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.harvard.agile.model.WorkPackageDTO;
import edu.harvard.agile.util.DBUtil;

/**
 * @author Incredibles Team
 * 
 *         This DAO class contains methods to perform actions on the database
 *         against Work Package table
 *
 */
public class WorkPackageDAO {

	/**
	 * Find by primary key method to find the record by package id.
	 * 
	 * @param id
	 *            - primary key of the table
	 * @return - a workPackage DTO
	 * @throws Exception
	 */
	public WorkPackageDTO findByPackageId(int id) throws Exception {

		/*
		 * Get connection from DBUtil, executes select query and initializes the
		 * object with values returned from the database and returns the work
		 * package DTO.
		 */

		Connection con = null;
		PreparedStatement stmt = null;
		WorkPackageDTO workPackage = null;
		try {
			con = DBUtil.getConnection();
			String query = "SELECT PACKAGE_ID,PACKAGE_NAME,PACKAGE_DESC,TESTING_PROGRAM_CODE,CONTRACT_FROM_YEAR,CONTRACT_TO_YEAR,START_DATE,END_DATE,STATUS FROM WORK_PACKAGE where package_id = ?";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				workPackage = new WorkPackageDTO();
				workPackage.setPackageId(rs.getInt("PACKAGE_ID"));
				workPackage.setPackageName(rs.getString("PACKAGE_NAME"));
				workPackage.setPackageDesc(rs.getString("PACKAGE_DESC"));
				workPackage.setTestingProgramCode(rs.getString("TESTING_PROGRAM_CODE"));
				workPackage.setContractFromYear(rs.getDate("CONTRACT_FROM_YEAR"));
				workPackage.setRequestorName(rs.getString("REQUESTOR_NAME"));
				workPackage.setContractToYear(rs.getDate("CONTRACT_TO_YEAR"));
				workPackage.setStartDate(rs.getDate("START_DATE"));
				workPackage.setEndDate(rs.getDate("END_DATE"));
				workPackage.setStatus(rs.getString("STATUS"));
			}
		} finally {
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(con);

		}

		return workPackage;
	}

	/**
	 * This method returns all the work packages from the table
	 * 
	 * @return a list work package DTOs
	 * @throws Exception
	 */
	public List<WorkPackageDTO> findAllPackages() throws Exception {
		/*
		 * Get connection from DBUtil, executes select query. Iterates through
		 * result set, initialize new workPakcageDTO object with the values
		 * returned from the database, add to the list and return the list of
		 * objects.
		 */

		Connection con = null;
		PreparedStatement stmt = null;
		List<WorkPackageDTO> workPackages = null;
		try {

			con = DBUtil.getConnection();
			String query = "SELECT PACKAGE_ID,PACKAGE_NAME,PACKAGE_DESC,TESTING_PROGRAM_CODE,CONTRACT_FROM_YEAR,CONTRACT_TO_YEAR,START_DATE,END_DATE,STATUS FROM WORK_PACKAGE";
			stmt = con.prepareStatement(query);

			ResultSet rs = stmt.executeQuery();

			workPackages = new ArrayList<WorkPackageDTO>();
			WorkPackageDTO workPackage = null;

			while (rs.next()) {
				workPackage = new WorkPackageDTO();
				workPackage.setPackageId(rs.getInt("PACKAGE_ID"));
				workPackage.setPackageName(rs.getString("PACKAGE_NAME"));
				workPackage.setPackageDesc(rs.getString("PACKAGE_DESC"));
				workPackage.setTestingProgramCode(rs.getString("TESTING_PROGRAM_CODE"));
				workPackage.setRequestorName(rs.getString("REQUESTOR_NAME"));
				workPackage.setContractFromYear(rs.getDate("CONTRACT_FROM_YEAR"));
				workPackage.setContractToYear(rs.getDate("CONTRACT_TO_YEAR"));
				workPackage.setStartDate(rs.getDate("START_DATE"));
				workPackage.setEndDate(rs.getDate("END_DATE"));
				workPackage.setStatus(rs.getString("STATUS"));

				workPackages.add(workPackage);
			}
		} finally {
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(con);

		}

		return workPackages;
	}

	/**
	 * This method creates anew work package and saves to the database.
	 * 
	 * @param workPackage
	 * @return
	 * @throws Exception
	 */
	public WorkPackageDTO createPackage(WorkPackageDTO workPackage) throws Exception {
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
			int seqId = DBUtil.getNextSequence("package_id_seq");

			String query = "Insert into WORK_PACKAGE (PACKAGE_ID,PACKAGE_NAME,PACKAGE_DESC,TESTING_PROGRAM_CODE,REQUESTOR_NAME,CONTRACT_FROM_YEAR,CONTRACT_TO_YEAR,START_DATE,END_DATE,STATUS,CREATE_DATE,MODIFIED_DATE,CREATE_BY,MODIFIED_BY) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, seqId);
			stmt.setString(2, workPackage.getPackageName());
			stmt.setString(3, workPackage.getPackageDesc());
			stmt.setString(4, workPackage.getTestingProgramCode());
			stmt.setString(5, workPackage.getRequestorName());
			stmt.setDate(6, new Date(workPackage.getContractFromYear().getTime()));
			stmt.setDate(7, new Date(workPackage.getContractToYear().getTime()));
			stmt.setDate(8, new Date(workPackage.getStartDate().getTime()));
			stmt.setDate(9, new Date(workPackage.getEndDate().getTime()));
			stmt.setString(10, workPackage.getStatus());

			stmt.setDate(11, new Date(System.currentTimeMillis()));
			stmt.setDate(12, new Date(System.currentTimeMillis()));
			stmt.setString(13, workPackage.getCreateBy());
			stmt.setString(14, workPackage.getModifiedBy());
			int rowsUpdated = stmt.executeUpdate();
			con.commit();
			workPackage.setPackageId(seqId);

			return findByPackageId(seqId);
		} catch (Exception e) {
			con.rollback();
			throw e;
		} finally {
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(con);

		}
	}

	/**
	 * This method updates work package record in the database
	 * 
	 * @param workPackage
	 * @return
	 * @throws Exception
	 */
	public WorkPackageDTO updatePackage(WorkPackageDTO workPackage) throws Exception {

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

			String query = "Update WORK_PACKAGE SET PACKAGE_NAME = ?, PACKAGE_DESC = ?,TESTING_PROGRAM_CODE = ?, REQUESTOR_NAME = ?, CONTRACT_FROM_YEAR = ?,CONTRACT_TO_YEAR = ?,START_DATE = ?,"
					+ "END_DATE = ?,STATUS = ?,MODIFIED_DATE = ?,MODIFIED_BY = ? WHERE PACKAGE_ID = ?";
			stmt = con.prepareStatement(query);
			stmt.setString(1, workPackage.getPackageName());
			stmt.setString(2, workPackage.getPackageDesc());
			stmt.setString(3, workPackage.getTestingProgramCode());
			stmt.setString(4, workPackage.getRequestorName());
			stmt.setString(5, workPackage.getRequestorName());
			stmt.setDate(6, new Date(workPackage.getContractFromYear().getTime()));
			stmt.setDate(7, new Date(workPackage.getContractToYear().getTime()));
			stmt.setDate(8, new Date(workPackage.getStartDate().getTime()));
			stmt.setDate(9, new Date(workPackage.getEndDate().getTime()));
			stmt.setString(10, workPackage.getStatus());

			stmt.setDate(11, new Date(System.currentTimeMillis()));
			stmt.setString(12, workPackage.getModifiedBy());
			stmt.setInt(13, workPackage.getPackageId());

			int rowsUpdated = stmt.executeUpdate();
			con.commit();

			return findByPackageId(workPackage.getPackageId());
		} catch (Exception e) {
			con.rollback();
			throw e;
		} finally {
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(con);

		}
	}

}
