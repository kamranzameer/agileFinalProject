package edu.harvard.agile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import edu.harvard.agile.dao.AssumptionsDAO;

/**
 * 
 * @author Team Incredibles
 *
 */
public class AssumptionsService {

	AssumptionsDAO assumptionsDAO;
	
	/**
	 * Fetch all assumptions for an Activity Line item
	 * @param activityLineId
	 * @return
	 * @throws Exception
	 */
	public List<String> findAssumptionsByActivityLineId(int activityLineId)
			throws Exception {
		return assumptionsDAO.findAssumptionsByActivityLineId(activityLineId);
	}
	
		@Required
	public void setAssumptionsDAO(AssumptionsDAO assumptionsDAO) {
		this.assumptionsDAO = assumptionsDAO;
	}

}
