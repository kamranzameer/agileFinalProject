package edu.harvard.agile.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.harvard.agile.model.WorkPackageDTO;
import edu.harvard.agile.util.DBUtil;

public class WorkPackageDAO {

	public WorkPackageDTO findByPackageId(int id) throws Exception {
		Connection con = DBUtil.getConnection();
		String query = "SELECT PACKAGE_ID,PACKAGE_NAME,PACKAGE_DESC,TESTING_PROGRAM_CODE,CONTRACT_FROM_YEAR,CONTRACT_TO_YEAR,START_DATE,END_DATE,STATUS FROM WORK_PACKAGE where package_id = ?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();

		WorkPackageDTO workPackage = null;
		if (rs.next()) {
			workPackage = new WorkPackageDTO();
			workPackage.setPackageId(rs.getInt("PACKAGE_ID"));
			workPackage.setPackageName(rs.getString("PACKAGE_NAME"));
			workPackage.setPackageDesc(rs.getString("PACKAGE_DESC"));
			workPackage.setTestingProgramCode(rs
					.getString("TESTING_PROGRAM_CODE"));
			workPackage.setContractFromYear(rs.getDate("CONTRACT_FROM_YEAR"));
			workPackage.setContractToYear(rs.getDate("CONTRACT_TO_YEAR"));
			workPackage.setStartDate(rs.getDate("START_DATE"));
			workPackage.setEndDate(rs.getDate("END_DATE"));
			workPackage.setStatus(rs.getString("STATUS"));
		}

		return workPackage;
	}

	public List<WorkPackageDTO> findAllPackages() throws Exception {
		Connection con = DBUtil.getConnection();
		String query = "SELECT PACKAGE_ID,PACKAGE_NAME,PACKAGE_DESC,TESTING_PROGRAM_CODE,CONTRACT_FROM_YEAR,CONTRACT_TO_YEAR,START_DATE,END_DATE,STATUS FROM WORK_PACKAGE";
		PreparedStatement stmt = con.prepareStatement(query);

		ResultSet rs = stmt.executeQuery();

		List<WorkPackageDTO> workPackages = new ArrayList<WorkPackageDTO>();
		WorkPackageDTO workPackage = null;

		while (rs.next()) {
			workPackage = new WorkPackageDTO();
			workPackage.setPackageId(rs.getInt("PACKAGE_ID"));
			workPackage.setPackageName(rs.getString("PACKAGE_NAME"));
			workPackage.setPackageDesc(rs.getString("PACKAGE_DESC"));
			workPackage.setTestingProgramCode(rs
					.getString("TESTING_PROGRAM_CODE"));
			workPackage.setContractFromYear(rs.getDate("CONTRACT_FROM_YEAR"));
			workPackage.setContractToYear(rs.getDate("CONTRACT_TO_YEAR"));
			workPackage.setStartDate(rs.getDate("START_DATE"));
			workPackage.setEndDate(rs.getDate("END_DATE"));
			workPackage.setStatus(rs.getString("STATUS"));

			workPackages.add(workPackage);
		}

		return workPackages;
	}

	public WorkPackageDTO createPackage(WorkPackageDTO workPackage)
			throws Exception {

		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			int seqId = DBUtil.getNextSequence("package_id_seq");
			
			String query = "Insert into WORK_PACKAGE (PACKAGE_ID,PACKAGE_NAME,PACKAGE_DESC,TESTING_PROGRAM_CODE,CONTRACT_FROM_YEAR,CONTRACT_TO_YEAR,START_DATE,END_DATE,STATUS,CREATE_DATE,MODIFIED_DATE,CREATE_BY,MODIFIED_BY) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, seqId);
			stmt.setString(2, workPackage.getPackageName());
			stmt.setString(3, workPackage.getPackageDesc());
			stmt.setString(4, workPackage.getTestingProgramCode());
			stmt.setDate(5, new Date(workPackage.getContractFromYear()
					.getTime()));
			stmt.setDate(6, new Date(workPackage.getContractToYear().getTime()));
			stmt.setDate(7, new Date(workPackage.getStartDate().getTime()));
			stmt.setDate(8, new Date(workPackage.getEndDate().getTime()));
			stmt.setString(9, workPackage.getStatus());

			stmt.setDate(10, new Date(System.currentTimeMillis()));
			stmt.setDate(11, new Date(System.currentTimeMillis()));
			stmt.setString(12, workPackage.getCreateBy());
			stmt.setString(13, workPackage.getModifiedBy());
			int rowsUpdated = stmt.executeUpdate();
			con.commit();
			workPackage.setPackageId(seqId);

			return findByPackageId(seqId);
		} catch ( Exception e ){
			con.rollback();
			throw e;
		} 	
		finally {
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(con);

		}
	}
	
	public WorkPackageDTO updatePackage(WorkPackageDTO workPackage)
			throws Exception {

		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			
			String query = "Update WORK_PACKAGE SET PACKAGE_NAME = ?, PACKAGE_DESC = ?,TESTING_PROGRAM_CODE = ?,CONTRACT_FROM_YEAR = ?,CONTRACT_TO_YEAR = ?,START_DATE = ?,"
					+ "END_DATE = ?,STATUS = ?,MODIFIED_DATE = ?,MODIFIED_BY = ? WHERE PACKAGE_ID = ?";
			stmt = con.prepareStatement(query);
			stmt.setString(1, workPackage.getPackageName());
			stmt.setString(2, workPackage.getPackageDesc());
			stmt.setString(3, workPackage.getTestingProgramCode());
			stmt.setDate(4, new Date(workPackage.getContractFromYear()
					.getTime()));
			stmt.setDate(5, new Date(workPackage.getContractToYear().getTime()));
			stmt.setDate(6, new Date(workPackage.getStartDate().getTime()));
			stmt.setDate(7, new Date(workPackage.getEndDate().getTime()));
			stmt.setString(8, workPackage.getStatus());

			stmt.setDate(9, new Date(System.currentTimeMillis()));
			stmt.setString(10, workPackage.getModifiedBy());
			stmt.setInt(11, workPackage.getPackageId());

			int rowsUpdated = stmt.executeUpdate();
			con.commit();

			return findByPackageId(workPackage.getPackageId());
		} catch ( Exception e ){
			con.rollback();
			throw e;
		} 	
		finally {
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(con);

		}
	}
	
}
