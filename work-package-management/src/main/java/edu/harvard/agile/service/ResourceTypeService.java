package edu.harvard.agile.service;

import java.util.List;

import edu.harvard.agile.dao.ResourceTypeDAO;
import edu.harvard.agile.model.ResourceTypeDTO;

/**
 * @author Incredibles Team
 * 
 *         This service class contains methods to perform ResourceType 
 *         management transactions
 *
 */
public class ResourceTypeService {

	private ResourceTypeDAO resourceTypeDAO;

	
	public void setResourceTypeDAO(ResourceTypeDAO resourceTypeDAO) {
		this.resourceTypeDAO = resourceTypeDAO;
	}


	/**
	 * Fetch all Testing programs
	 * @return
	 * @throws Exception
	 */
	public List<ResourceTypeDTO> findAllResourceTypes() throws Exception {
		return resourceTypeDAO.findAllResourceTypes();
	}
}
