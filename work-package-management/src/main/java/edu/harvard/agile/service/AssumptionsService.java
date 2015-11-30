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
	public List<String> findAssumptionsVyActivityLineId(int activityLineId)
			throws Exception {
		return assumptionsDAO.findAssumptionsVyActivityLineId(activityLineId);
	}
	
		@Required
	public void setAssumptionsDAO(AssumptionsDAO assumptionsDAO) {
		this.assumptionsDAO = assumptionsDAO;
	}

}
