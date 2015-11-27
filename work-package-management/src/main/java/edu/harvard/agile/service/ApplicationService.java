package edu.harvard.agile.service;

import java.util.List;

import edu.harvard.agile.dao.ApplicationContactsDAO;
import edu.harvard.agile.dao.ApplicationDAO;
import edu.harvard.agile.model.ApplicationContactsDTO;
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
	private ApplicationContactsDAO applicationContactsDAO;

	/**
	 * @return the applicationContactsDAO
	 */
	public ApplicationContactsDAO getApplicationContactsDAO() {
		return applicationContactsDAO;
	}

	/**
	 * @param applicationContactsDAO the applicationContactsDAO to set
	 */
	public void setApplicationContactsDAO(
			ApplicationContactsDAO applicationContactsDAO) {
		this.applicationContactsDAO = applicationContactsDAO;
	}

	public void setApplicationDAO(ApplicationDAO applicationDAO) {
		this.applicationDAO = applicationDAO;
	}

	public List<ApplicationDTO> findAllApplications() throws Exception {
		return applicationDAO.findAllApplications();
	}
	
	public ApplicationContactsDTO findApplicationContactByUser(String userid) throws Exception{
		return applicationContactsDAO.findContactsByUser(userid);
	}
	
}
