package edu.harvard.agile.action;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Required;

import edu.harvard.agile.model.WorkRequestDTO;
import edu.harvard.agile.service.WorkRequestService;

/**
 * Action class to handle list all work requests
 * @author Incredibles
 *
 */
public class WorkRequestListAction extends WPMActionBase {
	private WorkRequestService workRequestService;
	private List<WorkRequestDTO> workRequests;

	@Override
	public void prepare() throws Exception {
		
		//Load all Work Requests for the logged in user
		workRequests = workRequestService.findAllWorkRequestsByUser(SecurityUtils.getSubject().getPrincipal().toString());
	}

	public String execute() throws Exception {
		
		//Display workrequests list page
		ServletActionContext.getRequest().setAttribute("p", "wrl");
		return SUCCESS;
	}

	@Required
	public void setWorkRequestService(WorkRequestService workRequestService) {
		this.workRequestService = workRequestService;
	}

	public List<WorkRequestDTO> getWorkRequests() {
		return workRequests;
	}

	public void setWorkRequests(List<WorkRequestDTO> workRequests) {
		this.workRequests = workRequests;
	}

}
