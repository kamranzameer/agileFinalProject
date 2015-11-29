package edu.harvard.agile.service;

import java.util.List;

import edu.harvard.agile.dao.WorkRequestDAO;
import edu.harvard.agile.model.ApplicationContactsDTO;
import edu.harvard.agile.model.WorkRequestDTO;

/**
 * @author Incredibles Team
 * 
 *         This service class contains methods to perform Work Request
 *         management transactions
 *
 */
public class WorkRequestService {

	private WorkRequestDAO workRequestDAO;
	private ApplicationService applicationService;

	/**
	 * @return the applicationService
	 */
	public ApplicationService getApplicationService() {
		return applicationService;
	}

	/**
	 * @param applicationService the applicationService to set
	 */
	public void setApplicationService(ApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	public void setWorkRequestDAO(WorkRequestDAO workRequestDAO) {
		this.workRequestDAO = workRequestDAO;
	}

<<<<<<< HEAD

=======
		
>>>>>>> origin/master
		public List<WorkRequestDTO> findRequestsByPackageId(int packageId) throws Exception {
			return workRequestDAO.findRequestsByPackageId(packageId);
		}
	
	
<<<<<<< HEAD
=======

>>>>>>> origin/master
	/**
	 * Method to fetch all work requests
	 * @return
	 * @throws Exception
	 */
	public List<WorkRequestDTO> findAllWorkRequests() throws Exception {
		return workRequestDAO.findAllWorkRequests();
	}
	
	/**
	 * Method to fetch all work requests for an application 
	 * @return
	 * @throws Exception
	 */
	public List<WorkRequestDTO> findAllWorkRequestsByApplication(String appId) throws Exception {
				return workRequestDAO.findRequestsByApplicationId(appId);
	}

	/**
	 * Method to fetch all work requests assigned to a user
	 * @return
	 * @throws Exception
	 */
	public List<WorkRequestDTO> findAllWorkRequestsByUser(String userid) throws Exception {
		ApplicationContactsDTO appContact = applicationService.findApplicationContactByUser(userid);
		return workRequestDAO.findRequestsByApplicationId(appContact.getApplicationId());
<<<<<<< HEAD
}

}
=======
	}
}
>>>>>>> origin/master
