package edu.harvard.agile.service;

import java.util.List;

import edu.harvard.agile.dao.TestingProgramDAO;
import edu.harvard.agile.model.TestingProgramDTO;

/**
 * @author Incredibles Team
 * 
 *         This service class contains methods to perform TestingProgram 
 *         management transactions
 *
 */
public class TestingProgramService {

	private TestingProgramDAO testingProgramDAO;

	public void setTestingProgramDAO(TestingProgramDAO testingProgramDAO) {
		this.testingProgramDAO = testingProgramDAO;
	}
	
	/**
	 * Fetch all Testing programs
	 * @return
	 * @throws Exception
	 */
	public List<TestingProgramDTO> findAllTestingPrograms() throws Exception {
		return testingProgramDAO.findAllTestingPrograms();
	}
}
