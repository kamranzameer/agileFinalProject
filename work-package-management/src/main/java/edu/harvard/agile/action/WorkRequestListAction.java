package edu.harvard.agile.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Required;

import edu.harvard.agile.model.WorkRequestDTO;
import edu.harvard.agile.service.WorkRequestService;

public class WorkRequestListAction extends WPMActionBase {
	private WorkRequestService workRequestService;
	private List<WorkRequestDTO> workRequests;

	@Override
	public void prepare() throws Exception {
		workRequests = workRequestService.findAllWorkRequests();
	}

	public String execute() throws Exception {
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
