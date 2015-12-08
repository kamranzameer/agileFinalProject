package edu.harvard.agile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.harvard.agile.model.ResourceTypeDTO;
import edu.harvard.agile.util.DBUtil;

/**
 * @author Incredibles Team This DAO class contains methods to perform actions
 *         on the database against RESOURCE_TYPE table
 *
 */
public class ResourceTypeDAO {

	/**
	 * Find all Resource Types 
	 * 
	 * @param id
	 * @return - List<ResourceTypeDTO>
	 * @throws Exception
	 */
	public List<ResourceTypeDTO> findAllResourceTypes()
			throws Exception {

		/*
		 * Get connection from DBUtil, executes select query and initializes the
		 * object with values returned from the database and returns the
		 * Resource Line DTO.
		 */

		Connection con = null;
		PreparedStatement stmt = null;
		List<ResourceTypeDTO> resourceTypes = new ArrayList<ResourceTypeDTO>();
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();

			String query = "SELECT RESOURCE_TYPE_ID, RESOURCE_TYPE_NAME,HOURLY_RATE FROM RESOURCE_TYPE";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			ResourceTypeDTO resource = null;
			while (rs.next()) {
				resource = new ResourceTypeDTO();
				resource.setResourceTypeId(rs.getInt("RESOURCE_TYPE_ID"));
				resource.setResourceTypeName(rs.getString("RESOURCE_TYPE_NAME"));
				resource.setHourlyRate(rs.getInt("HOURLY_RATE"));
				resourceTypes.add(resource);
			}
		} finally {
			DBUtil.closeRS(rs);
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(con);

		}

		return resourceTypes;
	}

}
