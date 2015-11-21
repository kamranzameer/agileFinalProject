package edu.harvard.agile.actions;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Required;

import edu.harvard.agile.model.WorkPackageDTO;
import edu.harvard.agile.service.WorkPackageService;

public class WorkPackageListAction extends WPMActionBase {
	private WorkPackageService workPackageService;
	private List<WorkPackageDTO> workPackages;

	@Override
	public void prepare() throws Exception {
		workPackages = workPackageService.findAllPackages();
		System.out.println(workPackages.size());
	}

	public String execute() throws Exception {
		ServletActionContext.getRequest().setAttribute("p", "wpl");
		return SUCCESS;
	}

	@Required
	public void setWorkPackageService(WorkPackageService workPackageService) {
		this.workPackageService = workPackageService;
	}

	public List<WorkPackageDTO> getWorkPackages() {
		return workPackages;
	}

	public void setWorkPackages(List<WorkPackageDTO> workPackages) {
		this.workPackages = workPackages;
	}

}
