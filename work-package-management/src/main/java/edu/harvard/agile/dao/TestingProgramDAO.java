package edu.harvard.agile.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.harvard.agile.model.TestingProgramDTO;
import edu.harvard.agile.util.DBUtil;

/**
 * @author Incredibles Team
 * 
 *         This DAO class contains methods to perform actions on the database
 *         against Testing Program table
 *
 */
public class TestingProgramDAO {

	/**
	 * This method returns all the testing programs from the table
	 * 
	 * @return a list testingProgram DTOs
	 * @throws Exception
	 */
	public List<TestingProgramDTO> findAllTestingPrograms() throws Exception {
		 /* Get connection from DBUtil, executes select query. Iterates through
		 * result set, initialize new testingProgramDTO object with the values
		 * returned from the database, add to the list and return the list of
		 * objects.
		 */

		Connection con = null;
		PreparedStatement stmt = null;
		List<TestingProgramDTO> testingProgramDTOs = null;
		try {

			con = DBUtil.getConnection();
			String query = "SELECT TESTING_PROGRAM_CODE, TESTING_PROGRAM_DESC FROM  TESTING_PROGRAM";
			stmt = con.prepareStatement(query);

			ResultSet rs = stmt.executeQuery();

			testingProgramDTOs = new ArrayList<TestingProgramDTO>();
			TestingProgramDTO testingProgram = null;

			while (rs.next()) {
				testingProgram = new TestingProgramDTO();
				testingProgram.setTestingProgramCode(rs.getString("TESTING_PROGRAM_CODE"));
				testingProgram.setTestingProgramDesc(rs.getString("TESTING_PROGRAM_DESC"));
				
				testingProgramDTOs.add(testingProgram);
			}
		} finally {
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(con);

		}

		return testingProgramDTOs;
	}

}
