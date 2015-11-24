package edu.harvard.agile.service;

import java.util.List;

import edu.harvard.agile.dao.ApplicationDAO;
import edu.harvard.agile.model.ApplicationDTO;

/**
 * @author Incredibles Team
 * 
 *         This service class contains methods to perform Application 
 *         management transactions
 *
 */
public class ApplicationService {

	private ApplicationDAO applicationDAO;

	public void setApplicationDAO(ApplicationDAO applicationDAO) {
		this.applicationDAO = applicationDAO;
	}

	public List<ApplicationDTO> findAllApplications() throws Exception {
		return applicationDAO.findAllApplications();
	}
}
