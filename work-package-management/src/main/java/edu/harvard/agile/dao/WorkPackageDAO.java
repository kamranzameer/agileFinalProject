package edu.harvard.agile.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.harvard.agile.model.UsersDTO;
import edu.harvard.agile.model.WorkPackageDTO;
import edu.harvard.agile.util.DBUtil;

/**
 * @author Incredibles Team
 * 
 *         This DAO class contains methods to perform actions on the database against Work
 *         Package table
 *
 */
public class WorkPackageDAO {

  /**
   * Find by primary key method to find the record by package id.
   * 
   * @param id - primary key of the table
   * @return - a workPackage DTO
   * @throws Exception
   */
  public WorkPackageDTO findByPackageId(int id) throws Exception {

    /*
     * Get connection from DBUtil, executes select query and initializes the object with
     * values returned from the database and returns the work package DTO.
     */

    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    WorkPackageDTO workPackage = null;
    try {
      con = DBUtil.getConnection();
      String query = "SELECT PACKAGE_ID,PACKAGE_NAME,PACKAGE_DESC,TESTING_PROGRAM_CODE, REQUESTOR_NAME, CONTRACT_FROM_YEAR,CONTRACT_TO_YEAR,START_DATE,END_DATE,UPPER(STATUS) AS STATUS "
          + "FROM WORK_PACKAGE where package_id = ?";
      stmt = con.prepareStatement(query);
      stmt.setInt(1, id);
      rs = stmt.executeQuery();

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
        workPackage.setTotalApplications(getTotalApplications(rs.getInt("PACKAGE_ID"), con));
        workPackage.setTotalCost(getWorkPackageTotalCost(rs.getInt("PACKAGE_ID"), con));

      }
    } finally {
      DBUtil.closeRS(rs);
      DBUtil.closeStatement(stmt);
      DBUtil.closeConnection(con);

    }

    return workPackage;
  }

  /**
   * Find by package name
   * 
   * @param packageName
   * @return - a workPackage DTO
   * @throws Exception
   */
  public WorkPackageDTO findByPackageName(String packageName) throws Exception {

    /*
     * Get connection from DBUtil, executes select query and initializes the object with
     * values returned from the database and returns the work package DTO.
     */

    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    WorkPackageDTO workPackage = null;
    try {
      con = DBUtil.getConnection();
      String query = "SELECT PACKAGE_ID,PACKAGE_NAME,PACKAGE_DESC,TESTING_PROGRAM_CODE, REQUESTOR_NAME, CONTRACT_FROM_YEAR,CONTRACT_TO_YEAR,START_DATE,END_DATE,UPPER(STATUS) AS STATUS "
          + "FROM WORK_PACKAGE where PACKAGE_NAME = ?";
      stmt = con.prepareStatement(query);
      stmt.setString(1, packageName);
      rs = stmt.executeQuery();

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
      DBUtil.closeRS(rs);
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
    return findAllPackages(null);
  }

  /**
   * This method returns all the work packages from the table
   * 
   * @return a list work package DTOs
   * @throws Exception
   */
  public List<WorkPackageDTO> findAllPackages(WorkPackageDTO wpd) throws Exception {
    /*
     * Get connection from DBUtil, executes select query. Iterates through result set,
     * initialize new workPakcageDTO object with the values returned from the database,
     * add to the list and return the list of objects.
     */

    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    List<WorkPackageDTO> workPackages = null;
    try {

      con = DBUtil.getConnection();

      StringBuilder query = new StringBuilder();

      query
          .append("SELECT PACKAGE_ID,PACKAGE_NAME,PACKAGE_DESC,TESTING_PROGRAM_CODE, REQUESTOR_NAME, CONTRACT_FROM_YEAR,CONTRACT_TO_YEAR,START_DATE,END_DATE,UPPER(STATUS) AS STATUS FROM WORK_PACKAGE");

      if (wpd != null) {

        query.append(" WHERE 1 = 1 ");
        
      //please dont change the order of conditions

        if (wpd.getContractToYear() != null) {
          query.append(" AND ? between CONTRACT_FROM_YEAR and CONTRACT_TO_YEAR");
        }
        if (wpd.getContractFromYear() != null) {
          query.append(" AND ? between CONTRACT_FROM_YEAR and CONTRACT_TO_YEAR");
        }

        if (wpd.getPackageDesc() != null && wpd.getPackageDesc().length()>0) {
          query.append(" AND UPPER(PACKAGE_DESC) LIKE ?");
        }
        if (wpd.getPackageName() != null && wpd.getPackageName().length()>0) {
          query.append(" AND UPPER(PACKAGE_NAME) LIKE ?");
        }
        if (wpd.getRequestorName() != null && wpd.getRequestorName().length()>0) {
          query.append(" AND UPPER(REQUESTOR_NAME) LIKE ?");
        }
        if (wpd.getStartDate() != null) {
          query.append(" AND ? between START_DATE and END_DATE");
        }
        if (wpd.getEndDate() != null) {
          query.append(" AND ? between START_DATE and END_DATE");
        }
        if (wpd.getStatus() != null && wpd.getStatus().length()>0) {
            query.append(" AND UPPER(STATUS) = ?");

        }
        if (wpd.getTestingProgramCode() != null && wpd.getTestingProgramCode().length()>0) {
          query.append(" AND UPPER(TESTING_PROGRAM_CODE) = ?");
        }

      }

      stmt = con.prepareStatement(query.toString());

    //please dont change the order of conditions
      
      if (wpd != null) {

        int i = 0;
        if (wpd.getContractToYear() != null) {
          i++;
          stmt.setDate(i, new Date(wpd.getContractToYear().getTime()));
        }
        if (wpd.getContractFromYear() != null) {
          i++;
          stmt.setDate(i, new Date(wpd.getContractFromYear().getTime()));

        }

        if (wpd.getPackageDesc() != null && wpd.getPackageDesc().length() > 0) {
          i++;
          stmt.setString(i, "%"+wpd.getPackageDesc().toUpperCase()+"%");

        }
        if (wpd.getPackageName() != null && wpd.getPackageName().length() > 0) {
          i++;
          stmt.setString(i, "%"+wpd.getPackageName().toUpperCase()+"%");
        }
        if (wpd.getRequestorName() != null && wpd.getRequestorName().length() > 0) {
          i++;
          stmt.setString(i, "%"+wpd.getRequestorName().toUpperCase()+"%");
        }
        if (wpd.getStartDate() != null) {
          i++;
          stmt.setDate(i, new Date(wpd.getStartDate().getTime()));
        }
        if (wpd.getEndDate() != null) {
          i++;
          stmt.setDate(i, new Date(wpd.getEndDate().getTime()));
        }
        if (wpd.getStatus() != null && wpd.getStatus().length() > 0) {
            i++;
            stmt.setString(i, wpd.getStatus().toUpperCase());
        }
        if (wpd.getTestingProgramCode() != null && wpd.getTestingProgramCode().length() > 0) {
          i++;
          stmt.setString(i, wpd.getTestingProgramCode().toUpperCase());
        }

      }

      rs = stmt.executeQuery();

      workPackages = new ArrayList<WorkPackageDTO>();
      WorkPackageDTO workPackage = null;

      while (rs.next()) {
        workPackage = new WorkPackageDTO();
        workPackage.setPackageId(rs.getInt("PACKAGE_ID"));
        workPackage.setPackageName(rs.getString("PACKAGE_NAME"));
        workPackage.setPackageDesc(rs.getString("PACKAGE_DESC"));
        workPackage.setTestingProgramCode(rs.getString("TESTING_PROGRAM_CODE"));
        workPackage.setRequestorName(rs.getString("REQUESTOR_NAME"));
        workPackage.setRequestorName(rs.getString("REQUESTOR_NAME"));
        workPackage.setContractFromYear(rs.getDate("CONTRACT_FROM_YEAR"));
        workPackage.setContractToYear(rs.getDate("CONTRACT_TO_YEAR"));

        workPackage.setStartDate(rs.getDate("START_DATE"));

        workPackage.setEndDate(rs.getDate("END_DATE"));
        workPackage.setStatus(rs.getString("STATUS"));

        workPackage.setTotalApplications(getTotalApplications(rs.getInt("PACKAGE_ID"), con));
        workPackage.setTotalCost(getWorkPackageTotalCost(rs.getInt("PACKAGE_ID"), con));

        workPackages.add(workPackage);
      }
    } finally {
      DBUtil.closeRS(rs);
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
  public WorkPackageDTO createPackage(WorkPackageDTO workPackage, Connection connection) throws Exception {
    /*
     * Get connection from DBUtil, set the parameters for the statement and executes
     * insert query. Uses oracle sequence as primary key. Returns the object that was
     * saved to the database by using findby method. Commits the transaction and rolls
     * back if any exception occurs.
     */
    PreparedStatement stmt = null;
    try {
      int seqId = DBUtil.getNextSequence("package_id_seq", connection);

      String query = "Insert into WORK_PACKAGE (PACKAGE_ID,PACKAGE_NAME,PACKAGE_DESC,TESTING_PROGRAM_CODE,REQUESTOR_NAME,CONTRACT_FROM_YEAR,CONTRACT_TO_YEAR,START_DATE,END_DATE,STATUS,CREATE_DATE,MODIFIED_DATE,CREATE_BY,MODIFIED_BY) "
          + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, UPPER(?), ?, ?, ?, ? )";
      stmt = connection.prepareStatement(query);
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
      workPackage.setPackageId(seqId);

      return workPackage;
    }

    finally {
      DBUtil.closeStatement(stmt);
    }
  }

  /**
   * This method updates work package record in the database
   * 
   * @param workPackage
   * @return
   * @throws Exception
   */
  public int updatePackage(WorkPackageDTO workPackage) throws Exception {

    /*
     * Get connection from DBUtil, set the parameters for the statement and executes
     * update query with a where condition. Returns the object that was updated by using
     * findby method. Commits the transaction and rolls back if any exception occurs.
     */

    Connection con = null;
    PreparedStatement stmt = null;
    try {
      con = DBUtil.getConnection();

      String query = "Update WORK_PACKAGE SET PACKAGE_NAME = ?, PACKAGE_DESC = ?,TESTING_PROGRAM_CODE = ?, REQUESTOR_NAME = ?, CONTRACT_FROM_YEAR = ?,CONTRACT_TO_YEAR = ?,START_DATE = ?,"
          + "END_DATE = ?,STATUS = UPPER(?),MODIFIED_DATE = ?,MODIFIED_BY = ? WHERE PACKAGE_ID = ?";
      stmt = con.prepareStatement(query);
      stmt.setString(1, workPackage.getPackageName());
      stmt.setString(2, workPackage.getPackageDesc());
      stmt.setString(3, workPackage.getTestingProgramCode());
      stmt.setString(4, workPackage.getRequestorName());
      stmt.setDate(5, new Date(workPackage.getContractFromYear().getTime()));
      stmt.setDate(6, new Date(workPackage.getContractToYear().getTime()));
      stmt.setDate(7, new Date(workPackage.getStartDate().getTime()));
      stmt.setDate(8, new Date(workPackage.getEndDate().getTime()));
      stmt.setString(9, workPackage.getStatus());

      stmt.setDate(10, new Date(System.currentTimeMillis()));
      stmt.setString(11, workPackage.getModifiedBy());
      stmt.setInt(12, workPackage.getPackageId());

      int rowsUpdated = stmt.executeUpdate();
      con.commit();

      return rowsUpdated;
    } catch (Exception e) {
      DBUtil.rollBack(con);
      throw e;
    } finally {
      DBUtil.closeStatement(stmt);
      DBUtil.closeConnection(con);

    }
  }

  /**
   * This method updates status of work package record in the database
   * 
   * @param workPackage
   * @return
   * @throws Exception
   */
  public WorkPackageDTO updatePackageStatus(WorkPackageDTO workPackage, Connection con) throws Exception {

    /*
     * Get connection from DBUtil, set the parameters for the statement and executes
     * update query with a where condition. Returns the object that was updated by using
     * findby method. Commits the transaction and rolls back if any exception occurs.
     */

    PreparedStatement stmt = null;
    try {

      String query = "Update WORK_PACKAGE SET STATUS = UPPER(?), MODIFIED_DATE = ?,MODIFIED_BY = ? WHERE PACKAGE_ID = ?";
      stmt = con.prepareStatement(query);
      stmt.setString(1, workPackage.getStatus());

      stmt.setDate(2, new Date(System.currentTimeMillis()));
      stmt.setString(3, workPackage.getModifiedBy());
      stmt.setInt(4, workPackage.getPackageId());

      int rowsUpdated = stmt.executeUpdate();

      return workPackage;
    } finally {
      DBUtil.closeStatement(stmt);

    }
  }

  /**
   * This method returns all the work packages from the table created by logged in user
   * 
   * @param userDTO UsersDTO
   * @return a list work package DTOs
   * @throws Exception
   */
  public List<WorkPackageDTO> findAllPackagesCreatedByUser(UsersDTO user) throws Exception {
    /*
     * Get connection from DBUtil, set userid param, executes select query. Iterates
     * through result set, initialize new workPakcageDTO object with the values returned
     * from the database, add to the list and return the list of objects.
     */

    Connection con = null;
    PreparedStatement stmt = null;
    List<WorkPackageDTO> workPackages = null;
    ResultSet rs = null;
    try {

      con = DBUtil.getConnection();
      String query = "SELECT PACKAGE_ID,PACKAGE_NAME,PACKAGE_DESC,TESTING_PROGRAM_CODE, REQUESTOR_NAME, CONTRACT_FROM_YEAR,CONTRACT_TO_YEAR,START_DATE,END_DATE,UPPER(STATUS) AS STATUS,CREATE_BY,CREATE_DATE,MODIFIED_BY,MODIFIED_DATE FROM WORK_PACKAGE"
          + "		WHERE CREATE_BY = ?";
      stmt = con.prepareStatement(query);
      stmt.setString(1, user.getUserId());

      rs = stmt.executeQuery();

      workPackages = new ArrayList<WorkPackageDTO>();
      WorkPackageDTO workPackage = null;

      while (rs.next()) {
        workPackage = new WorkPackageDTO();
        workPackage.setPackageId(rs.getInt("PACKAGE_ID"));
        workPackage.setPackageName(rs.getString("PACKAGE_NAME"));
        workPackage.setPackageDesc(rs.getString("PACKAGE_DESC"));
        workPackage.setTestingProgramCode(rs.getString("TESTING_PROGRAM_CODE"));
        workPackage.setRequestorName(rs.getString("REQUESTOR_NAME"));
        workPackage.setRequestorName(rs.getString("REQUESTOR_NAME"));
        workPackage.setContractFromYear(rs.getDate("CONTRACT_FROM_YEAR"));
        workPackage.setContractToYear(rs.getDate("CONTRACT_TO_YEAR"));
        workPackage.setStartDate(rs.getDate("START_DATE"));
        workPackage.setEndDate(rs.getDate("END_DATE"));
        workPackage.setStatus(rs.getString("STATUS"));
        workPackage.setCreateBy(rs.getString("CREATE_BY"));
        workPackage.setCreateDate(rs.getDate("CREATE_DATE"));
        workPackage.setModifiedBy(rs.getString("MODIFIED_BY"));
        workPackage.setModifiedDate(rs.getDate("MODIFIED_DATE"));
        workPackages.add(workPackage);
      }
    } finally {
      DBUtil.closeRS(rs);
      DBUtil.closeStatement(stmt);
      DBUtil.closeConnection(con);

    }

    return workPackages;
  }

  /**
   * Delete by package name
   * 
   * @param packageName
   * @return - null
   * @throws Exception
   */
  public int deleteByPackageName(String packageName) throws Exception {

    /*
     * Get connection from DBUtil, executes delete query
     */

    Connection con = null;
    PreparedStatement stmt = null;
    try {
      con = DBUtil.getConnection();
      String query = "DELETE FROM WORK_PACKAGE where PACKAGE_NAME = ?";
      stmt = con.prepareStatement(query);
      stmt.setString(1, packageName);
      int rowsDeleted = stmt.executeUpdate();
      con.commit();
      return rowsDeleted;
    } catch (Exception e) {
      DBUtil.rollBack(con);
      throw e;
    } finally {
      DBUtil.closeStatement(stmt);
      DBUtil.closeConnection(con);

    }

  }

  /**
   * @param workPackageId
   * @param con
   * @return find total cost by resource type and hourly rate for a work package.
   * @throws Exception
   */
  public Integer getWorkPackageTotalCost(Integer workPackageId, Connection con) throws Exception {
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
    query.append("                AND D.PACKAGE_ID = ?  ");
    query.append("         GROUP  BY A.RESOURCE_TYPE_ID,  ");
    query.append("                   B.HOURLY_RATE) ");

    // Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      // con = DBUtil.getConnection();
      stmt = con.prepareStatement(query.toString());
      stmt.setInt(1, workPackageId);
      rs = stmt.executeQuery();

      if (rs.next()) {
        return rs.getInt(1);
      }
    } finally {
      DBUtil.closeRS(rs);
      DBUtil.closeStatement(stmt);
      // DBUtil.closeConnection(con);

    }

    return null;

  }

  /**
   * @param workPackageId
   * @param con
   * @return find if atleast one work request exist for work package
   * @throws Exception
   */
  public Integer getTotalApplications(Integer workPackageId, Connection con) throws Exception {
    String query = "SELECT COUNT(1) FROM WORK_REQUEST WHERE PACKAGE_ID = ?";

    // Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      // con = DBUtil.getConnection();
      stmt = con.prepareStatement(query.toString());
      stmt.setInt(1, workPackageId);
      rs = stmt.executeQuery();

      if (rs.next()) {
        return rs.getInt(1);
      }
    } finally {
      DBUtil.closeRS(rs);
      DBUtil.closeStatement(stmt);
      // DBUtil.closeConnection(con);

    }

    return null;
  }

  /**
   * Find total count by status.
   * 
   * @param status - such as open, inprogress, approved
   * @return - total count
   * @throws Exception
   */
  public int findCountByStatus(String status) throws Exception {

    /*
     * Get connection from DBUtil, executes select query and initializes the object with
     * values returned from the database and returns the count.
     */

    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    int count = 0;
    try {
      con = DBUtil.getConnection();
      String query = "SELECT count(PACKAGE_ID) " + "FROM WORK_PACKAGE where UPPER(status) = UPPER(?)";
      stmt = con.prepareStatement(query);
      stmt.setString(1, status.toUpperCase());
      rs = stmt.executeQuery();

      if (rs.next()) {
        count = rs.getInt(1);
      }
    } finally {
      DBUtil.closeRS(rs);
      DBUtil.closeStatement(stmt);
      DBUtil.closeConnection(con);

    }

    return count;
  }

}
