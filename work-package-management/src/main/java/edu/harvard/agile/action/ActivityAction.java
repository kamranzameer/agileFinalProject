package edu.harvard.agile.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Required;

import edu.harvard.agile.model.ActivityLineDTO;
import edu.harvard.agile.model.ActivityPhaseResourcesDTO;
import edu.harvard.agile.model.ActivityTypeDTO;
import edu.harvard.agile.model.AssumptionsDTO;
import edu.harvard.agile.model.ResourceTypeDTO;
import edu.harvard.agile.service.ActivityLineService;
import edu.harvard.agile.service.ActivityTypeService;
import edu.harvard.agile.service.ResourceTypeService;
import edu.harvard.agile.util.WorkPackageUtil;

/**
 * Action class to handle list all ActivityLine item requests
 * @author Incredibles
 *
 */
public class ActivityAction extends WPMActionBase {
	private ActivityTypeService activityTypeService;
	private ActivityLineService activityLineService;
	private ResourceTypeService resourceTypeService;
	private ActivityLineDTO activityLineDTO;
	private Integer workRequestId = null;
	private String startDate;
	private String endDate;
	
	private List<ActivityTypeDTO> activityTypes;
	private List<ResourceTypeDTO> resourceTypes;
	private List<ActivityPhaseResourcesDTO> activityPhaseResourcesDTOs;// = new ArrayList<ActivityPhaseResourcesDTO>();; 
	private String assumptions;//New line separated list of assumptions

	@Override
	public void prepare() throws Exception {
		
		//Load activity types
		activityTypes = activityTypeService.findAllActivityTypes();
		//Load resource types
		resourceTypes = resourceTypeService.findAllResourceTypes();
	}
	
	//new activity called from workrequest detail
	public String newActivity()
	{
		activityPhaseResourcesDTOs = new ArrayList<ActivityPhaseResourcesDTO>();
		ServletActionContext.getRequest().setAttribute("p", "cnac");
		return SUCCESS;
	}

	public String execute() throws Exception {
		ServletActionContext.getRequest().setAttribute("p", "cnac");
		return SUCCESS;
	}
	
	@Required
	public void setActivityTypeService(ActivityTypeService activityTypeService) {
		this.activityTypeService = activityTypeService;
	}
	
	@Required
	public void setResourceTypeService(ResourceTypeService resourceTypeService) {
		this.resourceTypeService = resourceTypeService;
	}

	@Required
	public void setActivityLineService(ActivityLineService activityLineService) {
		this.activityLineService = activityLineService;
	}
	
	public List<ActivityTypeDTO> getActivityTypes() {
		return activityTypes;
	}

	public void setActivityTypes(List<ActivityTypeDTO> activityTypes) {
		this.activityTypes = activityTypes;
	}
	
	public List<ResourceTypeDTO> getResourceTypes() {
		return resourceTypes;
	}

	public void setResourceTypes(List<ResourceTypeDTO> resourceTypes) {
		this.resourceTypes = resourceTypes;
	}
	public List<ActivityPhaseResourcesDTO> getActivityPhaseResourcesDTOs() {
		return activityPhaseResourcesDTOs;
	}

	public void setActivityPhaseResourcesDTOs(
			List<ActivityPhaseResourcesDTO> activityPhaseResourcesDTOs) {
		this.activityPhaseResourcesDTOs = activityPhaseResourcesDTOs;
	}
	
	public String getAssumptions() {
		return assumptions;
	}

	public void setAssumptions(String assumptions) {
		this.assumptions = assumptions;
	}
	public ActivityLineDTO getActivityLineDTO() {
		return activityLineDTO;
	}

	public void setActivityLineDTO(ActivityLineDTO activityLineDTO) {
		this.activityLineDTO = activityLineDTO;
	}
	
	public Integer getWorkRequestId() {
		return workRequestId;
	}

	public void setWorkRequestId(Integer workRequestId) {
		this.workRequestId = workRequestId;
	}
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	
	public String saveActivity() throws Exception 
	{
		String userID = SecurityUtils.getSubject().getPrincipal().toString(); //logged in user
		setActivityPhaseResourcesDTOs(getActivityPhaseResourcesDTOs());
		
		//populate activity line details
		activityLineDTO.setWorkRequestId(workRequestId);
		activityLineDTO.setCreateBy(userID);
		activityLineDTO.setModifiedBy(userID);
		activityLineDTO.setStartDate(WorkPackageUtil.convertDate(startDate, "yyyy-MM-dd"));
		activityLineDTO.setEndDate(WorkPackageUtil.convertDate(endDate, "yyyy-MM-dd"));
		
		//Remove any NULL DTOs because of result of delete from UI
		List<ActivityPhaseResourcesDTO> activeActivityPhaseResourcesDTOs = new ArrayList<ActivityPhaseResourcesDTO>();
		for (ActivityPhaseResourcesDTO activityPhaseResourcesDTO : activityPhaseResourcesDTOs) 
		{
			if(activityPhaseResourcesDTO != null)
				activeActivityPhaseResourcesDTOs.add(activityPhaseResourcesDTO);
		}
		
		//populate logged in user details to ActivityPhaseResourcesDTO
		for (ActivityPhaseResourcesDTO activityPhaseResourcesDTO : activeActivityPhaseResourcesDTOs) 
		{
			activityPhaseResourcesDTO.setCreateBy(userID);
			activityPhaseResourcesDTO.setModifiedBy(userID);
		}
		activityLineDTO.setActivityPhaseResourcesDTOs(activeActivityPhaseResourcesDTOs);
		
		//If assumptions are entered populate them to ActivityLineDTO
		if(assumptions != null && assumptions.length() > 0)
		{
			String[] assumptionsArr = assumptions.split("\n");
			
			List<AssumptionsDTO> assumptionsDTOs = new ArrayList<AssumptionsDTO>();
			
			for (String assumption : assumptionsArr) 
			{
				AssumptionsDTO assumptionDTO = new AssumptionsDTO();
				assumptionDTO.setAssumptionsDesc(assumption);
				assumptionDTO.setCreateBy(userID);
				assumptionDTO.setModifiedBy(userID);
				assumptionDTO.setWorkRequestId(workRequestId);
				assumptionsDTOs.add(assumptionDTO);
			}
			
			activityLineDTO.setAssumptionDTOs(assumptionsDTOs);
		}
		
		activityLineService.createActivityLine(activityLineDTO);
		return SUCCESS;
	}
	
	
	
}
