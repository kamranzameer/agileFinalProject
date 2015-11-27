package edu.harvard.agile.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import edu.harvard.agile.model.WorkRequestDTO;
import edu.harvard.agile.service.ApplicationService;
import edu.harvard.agile.service.WorkPackageService;
import edu.harvard.agile.service.WorkRequestService;

/**
 * @author Incredibles
 * This class is invoked after successful login of user
 *
 */
public class DashboardAction extends WPMActionBase {
	private WorkPackageService workPackageService;
	private DashboardInfo dashboardInfo;
	private ApplicationService applicationService;
	private WorkRequestService workRequestService;

	/**
	 * @return the workRequestService
	 */
	public WorkRequestService getWorkRequestService() {
		return workRequestService;
	}

	/**
	 * @param workRequestService the workRequestService to set
	 */
	public void setWorkRequestService(WorkRequestService workRequestService) {
		this.workRequestService = workRequestService;
	}

	/**
	 * @return the applicationService
	 */
	public ApplicationService getApplicationService() {
		return applicationService;
	}

	/**
	 * @param applicationService the applicationService to set
	 */
	public void setApplicationService(ApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	/**
	 * @return the DashboardInfo
	 */
	public DashboardInfo getDashboardInfo() {
		return dashboardInfo;
	}

	/**
	 * @param DashboardInfo the DashboardInfo to set
	 */
	@Required
	public void setDashboardInfo(DashboardInfo dashboardInfo) {
		this.dashboardInfo = dashboardInfo;
	}

	@Override
	public void prepare() throws Exception {
		int workRequestsCountByUser = 0;
		dashboardInfo = new DashboardInfo();
		dashboardInfo.setApprovedWorkPackagesCount(workPackageService.findCountByStatus("Approved"));
		dashboardInfo.setOpenWorkPackagesCount(workPackageService.findCountByStatus("Open"));
		dashboardInfo.setInprogressWorkPackagesCount(workPackageService.findCountByStatus("Inprogress"));
		dashboardInfo.setCompletedWorkPackagesCount(workPackageService.findCountByStatus("Completed"));
		dashboardInfo.setTotalWorkPackagesCount(workPackageService.findAllPackages().size());
		List<WorkRequestDTO> workRequests = workRequestService.findAllWorkRequestsByUser("userapp1");
		
		if(!workRequests.isEmpty()){
			workRequestsCountByUser = workRequests.size();
		}
		dashboardInfo.setAppTotalWorkRequestsCount(workRequestsCountByUser);
		
	}

	public String execute() throws Exception {
		return SUCCESS;
	}

	@Required
	public void setWorkPackageService(WorkPackageService workPackageService) {
		this.workPackageService = workPackageService;
	}

	}
