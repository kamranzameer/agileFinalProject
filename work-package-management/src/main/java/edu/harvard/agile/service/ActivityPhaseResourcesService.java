package edu.harvard.agile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import edu.harvard.agile.dao.ActivityLineDAO;
import edu.harvard.agile.dao.ActivityPhaseResourcesDAO;
import edu.harvard.agile.dao.ApplicationContactsDAO;
import edu.harvard.agile.dao.ApplicationDAO;
import edu.harvard.agile.model.ActivityLineDTO;
import edu.harvard.agile.model.ActivityPhaseResourcesDTO;
import edu.harvard.agile.model.ApplicationContactsDTO;
import edu.harvard.agile.model.ApplicationDTO;

/**
 * @author Incredibles Team
 * 
 *         This service class contains methods to perform Activity Line 
 *         management transactions
 *
 */
public class ActivityPhaseResourcesService {

	private ActivityPhaseResourcesDAO activityPhaseResourcesDAO;

	/**
	 * Find by work request method to find the record by work request id.
	 * 
	 * @param id - work request id
	 * @return - ActivityLineDTOs
	 * @throws Exception
	 */
	public List<ActivityPhaseResourcesDTO> findByActivityLineId(int activityLineId) throws Exception {
		return activityPhaseResourcesDAO.findByActivityLineId(activityLineId);
	}


	@Required
	public void setActivityPhaseResourcesDAO(
			ActivityPhaseResourcesDAO activityPhaseResourcesDAO) {
		this.activityPhaseResourcesDAO = activityPhaseResourcesDAO;
	}
	
	
	
	

	
}
