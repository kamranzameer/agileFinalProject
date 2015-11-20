package edu.harvard.agile.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.harvard.agile.model.WorkPackageDTO;
import edu.harvard.agile.util.DBUtil;

/**
 * @author Incredibles Team
 * 
 *         This service class contains methods to perform Work Package management transactions
 *
 */
public class WorkPackageService {

	
	/**
	 * This method creates
	 * 1. A new work package in the system
	 * 2. Creates new Work Request for each impacted application
	 * 
	 * @param workPackage
	 * @return
	 * @throws Exception
	 */
	public WorkPackageDTO createPackage(WorkPackageDTO workPackage) throws Exception {
		
		return null;
		
	}
}
