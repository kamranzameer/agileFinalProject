package edu.harvard.agile.service;

import java.util.List;

import edu.harvard.agile.dao.ActivityTypeDAO;
import edu.harvard.agile.dao.TestingProgramDAO;
import edu.harvard.agile.model.ActivityTypeDTO;
import edu.harvard.agile.model.TestingProgramDTO;

/**
 * @author Incredibles Team
 * 
 *         This service class contains methods to perform ActivityType 
 *         management transactions
 *
 */
public class ActivityTypeService {

	private ActivityTypeDAO activityTypeDAO;

	
	public void setActivityTypeDAO(ActivityTypeDAO activityTypeDAO) {
		this.activityTypeDAO = activityTypeDAO;
	}


	/**
	 * Fetch all Testing programs
	 * @return
	 * @throws Exception
	 */
	public List<ActivityTypeDTO> findAllActivityTypes() throws Exception {
		return activityTypeDAO.findAllActivityTypes();
	}
}
