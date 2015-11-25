package edu.harvard.agile.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Required;

import edu.harvard.agile.service.WorkPackageService;

public class DashboardAction extends WPMActionBase {
	private WorkPackageService workPackageService;

	private int openWorkPackagesCount = 0;
	private int approvedWorkPackagesCount = 0;
	private int totalWorkPackagesCount = 0;
	private int inprogressWorkPackagesCount = 0;
	private int completedWorkPackagesCount = 0;

	@Override
	public void prepare() throws Exception {
		openWorkPackagesCount = workPackageService.findCountByStatus("Open");
		approvedWorkPackagesCount = workPackageService
				.findCountByStatus("Approved");
		totalWorkPackagesCount = workPackageService.findAllPackages().size();
		inprogressWorkPackagesCount = workPackageService
				.findCountByStatus("Inprogress");
		completedWorkPackagesCount = workPackageService
				.findCountByStatus("Completed");
		System.out.println("Open count is " + openWorkPackagesCount);
	}

	@Override
	public String execute() throws Exception {
		ServletActionContext.getRequest().setAttribute("p", "db");
		System.out.println("****************USHA***********in the dashboard action class -->" + SUCCESS);
		return SUCCESS;
	}

	@Required
	public void setWorkPackageService(WorkPackageService workPackageService) {
		this.workPackageService = workPackageService;
	}

	public int getOpenWorkPackagesCount() {
		return openWorkPackagesCount;
	}

	public void setOpenWorkPackagesCount(int openWorkPackagesCount) {
		this.openWorkPackagesCount = openWorkPackagesCount;
	}

	public int getApprovedWorkPackagesCount() {
		return approvedWorkPackagesCount;
	}

	public void setApprovedWorkPackagesCount(int approvedWorkPackagesCount) {
		this.approvedWorkPackagesCount = approvedWorkPackagesCount;
	}

	public int getTotalWorkPackagesCount() {
		return totalWorkPackagesCount;
	}

	public void setTotalWorkPackagesCount(int totalWorkPackagesCount) {
		this.totalWorkPackagesCount = totalWorkPackagesCount;
	}

	public int getInprogressWorkPackagesCount() {
		return inprogressWorkPackagesCount;
	}

	public void setInprogressWorkPackagesCount(int inprogressWorkPackagesCount) {
		this.inprogressWorkPackagesCount = inprogressWorkPackagesCount;
	}

	public int getCompletedWorkPackagesCount() {
		return completedWorkPackagesCount;
	}

	public void setCompletedWorkPackagesCount(int completedWorkPackagesCount) {
		this.completedWorkPackagesCount = completedWorkPackagesCount;
	}

}
