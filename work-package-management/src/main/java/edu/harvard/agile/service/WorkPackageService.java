package edu.harvard.agile.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.harvard.agile.dao.WorkPackageDAO;
import edu.harvard.agile.dao.WorkRequestDAO;
import edu.harvard.agile.model.ApplicationDTO;
import edu.harvard.agile.model.WorkPackageDTO;
import edu.harvard.agile.model.WorkRequestDTO;
import edu.harvard.agile.util.DBUtil;

/**
 * @author Incredibles Team
 * 
 *         This service class contains methods to perform Work Package
 *         management transactions
 *
 */
public class WorkPackageService {

	private WorkPackageDAO workPackageDAO;
	private WorkRequestDAO workRequestDAO;

	/**
	 * This method creates 1. A new work package in the system 2. Creates new
	 * Work Request for each impacted application
	 * 
	 * @param workPackage
	 * @return
	 * @throws Exception
	 */
	public WorkPackageDTO createPackage(WorkPackageDTO workPackage) throws Exception {
		
		Connection connection = null;
		WorkRequestDTO workRequest = null;
		
		try
		{
			connection = DBUtil.getConnection();
		//Create WorkPakcage
			workPackage = workPackageDAO.createPackage(workPackage, connection);
			
			//Create WorkRequest for every impacted application
			List<String> impactedApplications = workPackage.getImpactedApplications();
			for (String application : impactedApplications) 
			{
				workRequest = new WorkRequestDTO();
				workRequest.setApplicationId(application);
				workRequest.setPackageId(workPackage.getPackageId());
				workRequest.setStatus(workPackage.getStatus());
				workRequest.setCreateBy(workPackage.getCreateBy());
				workRequest.setStartDate(workPackage.getStartDate());
				workRequest.setEndDate(workPackage.getEndDate());
				workRequest.setModifiedBy(workPackage.getModifiedBy());
				
				workRequestDAO.createWorkRequest(workRequest, connection);
			}
			
			connection.commit();
			
		}
		catch(Exception ex)
		{
			try {
				connection.rollback();
			} catch (SQLException e) {
				//Do nothing
			}
			throw ex;
			
		}
		finally
		{
			DBUtil.closeConnection(connection);
		}
		
		return workPackage;

	}
	
	/**
	 * This method finds workp package count by status. 
	 * 
	 * @param String status 
	 * @return int count
	 * @throws Exception
	 */
	public int findCountByStatus(String status) throws Exception {
		
		int count = workPackageDAO.findCountByStatus(status);
		return count;
	}

	public void setWorkPackageDAO(WorkPackageDAO workPackageDAO) {
		this.workPackageDAO = workPackageDAO;
	}
	
	public void setWorkRequestDAO(WorkRequestDAO workRequestDAO) {
		this.workRequestDAO = workRequestDAO;
	}

	/**
	 * Fetch all work packages
	 * @return
	 * @throws Exception
	 */
	public List<WorkPackageDTO> findAllPackages() throws Exception {
		return workPackageDAO.findAllPackages();
	}
}