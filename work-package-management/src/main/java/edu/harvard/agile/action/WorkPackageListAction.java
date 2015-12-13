package edu.harvard.agile.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Required;

import edu.harvard.agile.model.SearchEnum;
import edu.harvard.agile.model.StatusEnum;
import edu.harvard.agile.model.WorkPackageDTO;
import edu.harvard.agile.service.WorkPackageService;

/**
 * Action class to handle list all workpackages requests
 * @author Incredibles
 *
 */
public class WorkPackageListAction extends WPMActionBase {
	private WorkPackageService workPackageService;
	private List<WorkPackageDTO> workPackages;
	private SearchEnum status;

	@Override
	public void prepare() throws Exception {
	  if(status == null){
	    status = SearchEnum.ALL;
	  }
		workPackages = workPackageService.findAllPackages(status);
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

  
  public SearchEnum getStatus() {
    return status;
  }

  
  public void setStatus(SearchEnum status) {
    this.status = status;
  }

  
	
	

}
