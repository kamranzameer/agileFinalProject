package edu.harvard.agile.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.harvard.agile.dao.WorkPackageDAO;
import edu.harvard.agile.dao.WorkRequestDAO;
import edu.harvard.agile.model.StatusEnum;
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
			DBUtil.rollBack(connection);
			throw ex;
			
		}
		finally
		{
			DBUtil.closeConnection(connection);
		}
		
		return workPackage;

	}
	
	/**
	 * This method finds work package count by status. 
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
	
	
	/**
	 * @param workPackageId
	 * @return workpackageDTO
	 * @throws Exception
	 */
	public WorkPackageDTO findByPackageId(int workPackageId) throws Exception {
		WorkPackageDTO workPackage = workPackageDAO.findByPackageId(workPackageId);
		List<WorkRequestDTO> workRequests =  workRequestDAO.findRequestsByPackageId(workPackageId);
		List<String> apps = new ArrayList<String>();
		for(WorkRequestDTO workRequest : workRequests){
			apps.add(workRequest.getApplicationId());
		}
		
		workPackage.setImpactedApplications(apps);
		
		return workPackage ;
	}
	
	
	/**
	 * This method 1. updates work package in the system 
	 * 2.updates work request status that belong to work package
	 * 
	 * 
	 * @param workPackage
	 * @return
	 * @throws Exception
	 */
	public WorkPackageDTO updatePackageStatus(WorkPackageDTO workPackage) throws Exception {
		
		Connection connection = null;
	//	WorkRequestDTO workRequest = null;
		
		try
		{
			connection = DBUtil.getConnection();
			workPackage = workPackageDAO.updatePackageStatus(workPackage, connection);
			
			List<WorkRequestDTO> workRequests = workRequestDAO.findRequestsByPackageId(workPackage.getPackageId());
			
		
			for (WorkRequestDTO workRequest : workRequests) 
			{
				
				workRequest.setStatus(workPackage.getStatus());
				workRequest.setModifiedDate(new Date());
				workRequest.setModifiedBy(workPackage.getModifiedBy());
				
				workRequestDAO.updateWorkRequestStatus(workRequest, connection);
			}
			
			connection.commit();
			
		}
		catch(Exception ex)
		{
			DBUtil.rollBack(connection);
			throw ex;
			
		}
		finally
		{
			DBUtil.closeConnection(connection);
		}
		
		return workPackage;

	}	
	
	
	public void updatePackage(WorkPackageDTO workPackage) throws Exception {
		Connection connection = DBUtil.getConnection();
		
	 try{ 
			 
			workPackageDAO.updatePackage(workPackage);
	        if(workPackage.getStatus().equals(StatusEnum.OPEN.name())){
	        	List<WorkRequestDTO> workRequests = workRequestDAO.findRequestsByPackageId(workPackage.getPackageId());
	        	for (WorkRequestDTO workRequest : workRequests) { 
		    		workRequestDAO.deleteWorkRequest(workRequest, connection);
			}
	        	
	        
	    	List<String> apps = workPackage.getImpactedApplications();
			for (String application : apps) { 
				WorkRequestDTO workRequest = new WorkRequestDTO();
				workRequest.setApplicationId(application);
				workRequest.setPackageId(workPackage.getPackageId());
				workRequest.setStatus(workPackage.getStatus());
				workRequest.setCreateBy(workPackage.getCreateBy());
				workRequest.setStartDate(workPackage.getStartDate());
				workRequest.setEndDate(workPackage.getEndDate());
				workRequest.setModifiedBy(workPackage.getModifiedBy());
				
				workRequestDAO.createWorkRequest(workRequest, connection);
			}
       
		}
        connection.commit();
	} catch(Exception ex) {
			DBUtil.rollBack(connection);
			throw ex;
	} finally {
			DBUtil.closeConnection(connection);
	}


}

}