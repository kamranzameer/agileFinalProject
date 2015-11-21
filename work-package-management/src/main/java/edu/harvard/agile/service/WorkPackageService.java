package edu.harvard.agile.service;

import java.util.List;

import edu.harvard.agile.dao.WorkPackageDAO;
import edu.harvard.agile.model.WorkPackageDTO;

/**
 * @author Incredibles Team
 * 
 *         This service class contains methods to perform Work Package
 *         management transactions
 *
 */
public class WorkPackageService {

	private WorkPackageDAO workPackageDAO;

	/**
	 * This method creates 1. A new work package in the system 2. Creates new
	 * Work Request for each impacted application
	 * 
	 * @param workPackage
	 * @return
	 * @throws Exception
	 */
	public WorkPackageDTO createPackage(WorkPackageDTO workPackage)
			throws Exception {

		return workPackageDAO.createPackage(workPackage);

	}

	public void setWorkPackageDAO(WorkPackageDAO workPackageDAO) {
		this.workPackageDAO = workPackageDAO;
	}

	public List<WorkPackageDTO> findAllPackages() throws Exception {
		return workPackageDAO.findAllPackages();
	}
}
