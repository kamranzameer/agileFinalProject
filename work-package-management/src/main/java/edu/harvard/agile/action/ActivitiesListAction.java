package edu.harvard.agile.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Required;

import edu.harvard.agile.model.WorkPackageDTO;
import edu.harvard.agile.service.ActivityLineService;
import edu.harvard.agile.service.WorkPackageService;

/**
 * Action class to handle list all workpackages requests
 * @author Incredibles
 *
 */
public class ActivitiesListAction extends WPMActionBase {
	//private ActivityLineService activityLineService;
	//private List<WorkPackageDTO> workPackages;

	@Override
	public void prepare() throws Exception {
		//workPackages = workPackageService.findAllPackages();
	}

	public String execute() throws Exception {
		ServletActionContext.getRequest().setAttribute("p", "acl");
		return SUCCESS;
	}

	/*@Required
	public void setWorkPackageService(WorkPackageService workPackageService) {
		this.workPackageService = workPackageService;
	}

	public List<WorkPackageDTO> getWorkPackages() {
		return workPackages;
	}

	public void setWorkPackages(List<WorkPackageDTO> workPackages) {
		this.workPackages = workPackages;
	}*/

}
