package edu.harvard.agile.service;

import java.util.List;

import edu.harvard.agile.dao.WorkRequestDAO;
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

		public void setWorkRequestDAO(WorkRequestDAO workRequestDAO) {
		this.workRequestDAO = workRequestDAO;
	}

	public List<WorkRequestDTO> findAllWorkRequests() throws Exception {
		return workRequestDAO.findAllWorkRequests();
	}
}
