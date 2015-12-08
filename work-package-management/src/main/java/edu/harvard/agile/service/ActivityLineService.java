package edu.harvard.agile.service;

import java.sql.Connection;
import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import edu.harvard.agile.dao.ActivityLineDAO;
import edu.harvard.agile.dao.ActivityPhaseResourcesDAO;
import edu.harvard.agile.dao.AssumptionsDAO;
import edu.harvard.agile.model.ActivityLineDTO;
import edu.harvard.agile.model.ActivityPhaseResourcesDTO;
import edu.harvard.agile.model.AssumptionsDTO;
import edu.harvard.agile.util.DBUtil;

/**
 * @author Incredibles Team
 * 
 *         This service class contains methods to perform Activity Line 
 *         management transactions
 *
 */
public class ActivityLineService {

	private ActivityLineDAO activityLineDAO;
	private ActivityPhaseResourcesDAO activityPhaseResourceDAO;
	private AssumptionsDAO assumptionsDAO;

	public List<ActivityLineDTO> findByRequestId(int workRequestId) throws Exception {
		return activityLineDAO.findByRequestId(workRequestId);
	}
	
	@Required
	public void setActivityLineDAO(ActivityLineDAO activityLineDAO) {
		this.activityLineDAO = activityLineDAO;
	}
	
	@Required
	public void setActivityPhaseResourceDAO(
			ActivityPhaseResourcesDAO activityPhaseResourceDAO) {
		this.activityPhaseResourceDAO = activityPhaseResourceDAO;
	}

	@Required
	public void setAssumptionsDAO(AssumptionsDAO assumptionsDAO) {
		this.assumptionsDAO = assumptionsDAO;
	}
	
	public ActivityLineDTO createActivityLine(ActivityLineDTO activityLineDTO) throws Exception
	{
		Connection con = null;
				
		try
		{
			con = DBUtil.getConnection();
			activityLineDTO = activityLineDAO.createActivityLine(activityLineDTO, con);
			
			//set Activity line id to all Activity Phase resource dtos
			for (ActivityPhaseResourcesDTO activityPhaseResourceDTO : activityLineDTO.getActivityPhaseResourcesDTOs()) {
				activityPhaseResourceDTO.setActivityLineId(activityLineDTO.getActivityLineId());
			}
			activityPhaseResourceDAO.createActivityPhaseResources(activityLineDTO.getActivityPhaseResourcesDTOs(), con);
			
			//set Activity Line id to all Assumption dtos
			for (AssumptionsDTO assumptionsDTO : activityLineDTO.getAssumptionDTOs()) {
				assumptionsDTO.setActivityLineId(activityLineDTO.getActivityLineId());
			}
			assumptionsDAO.createAssumptions(activityLineDTO.getAssumptionDTOs(), con);
			
			con.commit();
			
			return activityLineDTO;
		}
		catch(Exception ex)
		{
			DBUtil.rollBack(con);
			throw ex;
		}
		finally
		{
			DBUtil.closeConnection(con);
		}
	}
	

	
}
