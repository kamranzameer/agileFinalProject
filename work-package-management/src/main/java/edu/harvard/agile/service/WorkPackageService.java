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
			WorkPackageDAO workPackageDAO = new WorkPackageDAO();
			WorkRequestDAO workRequestDAO = new WorkRequestDAO();
			workPackage = workPackageDAO.createPackage(workPackage);
			
			//Create WorkRequest for every impacted application
			List<ApplicationDTO> impactedApplications = workPackage.getImpactedApplications();
			for (ApplicationDTO application : impactedApplications) 
			{
				workRequest = new WorkRequestDTO();
				workRequest.setApplicationId(application.getApplicationId());
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

	public void setWorkPackageDAO(WorkPackageDAO workPackageDAO) {
		this.workPackageDAO = workPackageDAO;
	}

	public List<WorkPackageDTO> findAllPackages() throws Exception {
		return workPackageDAO.findAllPackages();
	}
}
