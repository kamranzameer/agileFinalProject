package edu.harvard.agile.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Required;

import edu.harvard.agile.model.WorkPackageDTO;
import edu.harvard.agile.model.WorkRequestDTO;
import edu.harvard.agile.service.WorkPackageService;
import edu.harvard.agile.service.WorkRequestService;

public class WorkPackageDetailAction extends WPMActionBase {
	private WorkPackageService workPackageService;
	private WorkRequestService workRequestService; 
	private WorkPackageDTO workPackage;
	private List<WorkRequestDTO> workRequests;
	private Integer workPackageId = null; 

	@Override
	public void prepare() throws Exception {
		System.out.println("got work package id " + workPackageId);
		System.out.println("got work package id " + workPackageId);
		workPackage = workPackageService.findById(workPackageId);
		workRequests = workRequestService.findRequestsByPackageId(workPackageId);
		
	}

	public String execute() throws Exception {
		System.out.println("execute got work package id " + workPackageId);
		ServletActionContext.getRequest().setAttribute("p", "wpd");
		return SUCCESS;
	}

	@Required
	public void setWorkPackageService(WorkPackageService workPackageService) {
		this.workPackageService = workPackageService;
	}


	public WorkPackageDTO getWorkPackage() {
		return workPackage;
	}

	public void setWorkPackage(WorkPackageDTO workPackage) {
		this.workPackage = workPackage;
	}

	public Integer getWorkPackageId() {
		return workPackageId;
	}

	public void setWorkPackageId(Integer workPackageId) {
		System.out.println("setting work package id to --> " + workPackageId);
		this.workPackageId = workPackageId;
	}
	
	

	public List<WorkRequestDTO> getWorkRequests() {
		return workRequests;
	}

	public void setWorkRequests(List<WorkRequestDTO> workRequests) {
		this.workRequests = workRequests;
	}

	@Required
	public void setWorkRequestService(WorkRequestService workRequestService) {
		this.workRequestService = workRequestService;
	}
	
	
	
	

}
