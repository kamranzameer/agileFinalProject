package edu.harvard.agile.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Required;

import edu.harvard.agile.model.ActivityLineDTO;
import edu.harvard.agile.model.WorkPackageDTO;
import edu.harvard.agile.model.WorkRequestDTO;
import edu.harvard.agile.service.ActivityLineService;
import edu.harvard.agile.service.ActivityPhaseResourcesService;
import edu.harvard.agile.service.AssumptionsService;
import edu.harvard.agile.service.WorkPackageService;
import edu.harvard.agile.service.WorkRequestService;

/**
 * @author Incredibles This action class is to prepare work package details with
 *         related work requests
 *
 */
public class WorkRequestDetailAction extends WPMActionBase {
	private WorkPackageService workPackageService;
	private WorkRequestService workRequestService;
	private ActivityLineService activityLineService;
	private ActivityPhaseResourcesService activityPhaseResourcesService;
	private AssumptionsService assumptionsService;
	private WorkPackageDTO workPackage;
	private WorkRequestDTO workRequest;
	private Integer workRequestId = null;

	/*
	 * Finds the work package by id, and finds the work requests and activity
	 * lines, for the package.
	 */
	@Override
	public void prepare() throws Exception {
		workRequest = workRequestService.findByWorkRequestId(workRequestId);
		workPackage = workPackageService.findByPackageId(workRequest
				.getPackageId());

		workRequest.setActivityLineDTOs(activityLineService
				.findByRequestId(workRequest.getWorkRequestId()));
		for (ActivityLineDTO ald : workRequest.getActivityLineDTOs()) {
			ald.setAssumptions(assumptionsService
					.findAssumptionsByActivityLineId(ald.getActivityLineId()));
			ald.setActivityPhaseResourcesDTOs(activityPhaseResourcesService
					.findByActivityLineId(ald.getActivityLineId()));
		}

	}

	public String execute() throws Exception {
		ServletActionContext.getRequest().setAttribute("p", "wrd");
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

	@Required
	public void setWorkRequestService(WorkRequestService workRequestService) {
		this.workRequestService = workRequestService;
	}

	@Required
	public void setActivityLineService(ActivityLineService activityLineService) {
		this.activityLineService = activityLineService;
	}

	@Required
	public void setActivityPhaseResourcesService(
			ActivityPhaseResourcesService activityPhaseResourcesService) {
		this.activityPhaseResourcesService = activityPhaseResourcesService;
	}

	@Required
	public void setAssumptionsService(AssumptionsService assumptionsService) {
		this.assumptionsService = assumptionsService;
	}

	public WorkRequestDTO getWorkRequest() {
		return workRequest;
	}

	public void setWorkRequest(WorkRequestDTO workRequest) {
		this.workRequest = workRequest;
	}

	public Integer getWorkRequestId() {
		return workRequestId;
	}

	public void setWorkRequestId(Integer workRequestId) {
		this.workRequestId = workRequestId;
	}

}
