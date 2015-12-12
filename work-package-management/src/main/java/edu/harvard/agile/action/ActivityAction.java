package edu.harvard.agile.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Required;

import edu.harvard.agile.dao.ActivityPhaseResourcesDAO;
import edu.harvard.agile.model.ActivityPhaseResourcesDTO;
import edu.harvard.agile.model.ActivityTypeDTO;
import edu.harvard.agile.model.ResourceTypeDTO;
import edu.harvard.agile.service.ActivityLineService;
import edu.harvard.agile.service.ActivityPhaseResourcesService;
import edu.harvard.agile.service.ActivityTypeService;
import edu.harvard.agile.service.ResourceTypeService;

/**
 * Action class to handle list all workpackages requests
 * @author Incredibles
 *
 */
public class ActivityAction extends WPMActionBase {
	private ActivityTypeService activityTypeService;
	private ActivityLineService activityLineService;
	private ResourceTypeService resourceTypeService;
	private List<ActivityTypeDTO> activityTypes;
	private List<ResourceTypeDTO> resourceTypes;
	private List<ActivityPhaseResourcesDTO> activityPhaseResourcesDTOs;// = new ArrayList<ActivityPhaseResourcesDTO>();; 

	@Override
	public void prepare() throws Exception {
		
		if(activityTypes == null)
		{
			System.out.println("load activity types first time");
			activityTypes = activityTypeService.findAllActivityTypes();
		}
		
		if(resourceTypes == null)
		{
			System.out.println("load resource types first time");
			resourceTypes = resourceTypeService.findAllResourceTypes();
		}
		
		//addRow();//For first row
		/*ActivityPhaseResourcesService aps = new ActivityPhaseResourcesService();
		aps.setActivityPhaseResourcesDAO(new ActivityPhaseResourcesDAO());
		activityPhaseResourcesDTOs = aps.findByActivityLineId(10);*/
		
		System.out.println("in prepare");
		
	}
	
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
	
	public String addRow()
	{
		activityPhaseResourcesDTOs.add(new ActivityPhaseResourcesDTO());
		System.out.println("in add row : "+activityPhaseResourcesDTOs.size());
		return SUCCESS;
	}
	
}
