package edu.harvard.agile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import edu.harvard.agile.dao.ActivityLineDAO;
import edu.harvard.agile.dao.ApplicationContactsDAO;
import edu.harvard.agile.dao.ApplicationDAO;
import edu.harvard.agile.model.ActivityLineDTO;
import edu.harvard.agile.model.ApplicationContactsDTO;
import edu.harvard.agile.model.ApplicationDTO;

/**
 * @author Incredibles Team
 * 
 *         This service class contains methods to perform Activity Line 
 *         management transactions
 *
 */
public class ActivityLineService {

	private ActivityLineDAO activityLineDAO;

	public List<ActivityLineDTO> findByRequestId(int workRequestId) throws Exception {
		return activityLineDAO.findByRequestId(workRequestId);
	}
	
	@Required
	public void setActivityLineDAO(ActivityLineDAO activityLineDAO) {
		this.activityLineDAO = activityLineDAO;
	}
	
	

	
}
