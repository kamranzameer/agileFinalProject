package edu.harvard.agile.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Required;

import edu.harvard.agile.model.ApplicationDTO;
import edu.harvard.agile.model.TestingProgramDTO;
import edu.harvard.agile.model.WorkPackageDTO;
import edu.harvard.agile.service.ApplicationService;
import edu.harvard.agile.service.TestingProgramService;
import edu.harvard.agile.service.WorkPackageService;
import edu.harvard.agile.util.WorkPackageUtil;

/**
 * Action class to process all Work package related requests
 * @author incredibles
 *
 */
public class WorkPackageAction extends WPMActionBase {
	private WorkPackageService workPackageService;
	private ApplicationService applicationService;
	private TestingProgramService testingProgramService;
	private WorkPackageDTO workPackageDTO;
	private List<ApplicationDTO> applications;
	private List<TestingProgramDTO> testPrograms;
	private List<String> impactedApplications;
	private String contractFromYear;
	private String contractToYear;
	private String startDate;
	private String endDate;
	private Integer workPackageId = null; 
	private WorkPackageDTO workPackage = null;
	private List<String> statuses = new ArrayList<String>();
	

	@Override
	public void prepare() throws Exception {
		applications = applicationService.findAllApplications();
		testPrograms = testingProgramService.findAllTestingPrograms();
		
		statuses.add("open");
		statuses.add("close");
		statuses.add("pend");
	}
	
	public String execute(){
		ServletActionContext.getRequest().setAttribute("p", "cnwp");
		return SUCCESS;
	}
	
	/**
	 * Called to create new work package
	 * @return
	 */
	public String save()
	{
		try {
			processNewPackage();
		} catch (Exception e) {
			e.printStackTrace();
			//return ERROR;
		}		
		return SUCCESS;
	}
	
	/**
	 * Called to edit work package
	 * @return
	 * @throws Exception 
	 */
	public String edit() throws Exception {
		workPackage = workPackageService.findByPackageId(workPackageId);
		ServletActionContext.getRequest().setAttribute("p", "cnwp");
		return SUCCESS;
	}
	
	
	public String update() throws Exception {
		workPackage = workPackageService.findByPackageId(workPackageId);
		workPackage.setStatus(workPackageDTO.getStatus());
		ServletActionContext.getRequest().setAttribute("p", "cnwp");
		workPackageService.updatePackageStatus(workPackage);
		return SUCCESS;
	}

	/**
	 * Build WorkPackage DTO and create work package
	 * @throws Exception
	 */
	private void processNewPackage() throws Exception 
	{
		workPackageDTO.setContractFromYear(WorkPackageUtil.convertDate(contractFromYear, "yyyy-MM-dd"));
		workPackageDTO.setContractToYear(WorkPackageUtil.convertDate(contractToYear, "yyyy-MM-dd"));
		workPackageDTO.setStartDate(WorkPackageUtil.convertDate(startDate, "yyyy-MM-dd"));
		workPackageDTO.setEndDate(WorkPackageUtil.convertDate(endDate, "yyyy-MM-dd"));
		workPackageDTO.setImpactedApplications(impactedApplications);
		String userID = SecurityUtils.getSubject().getPrincipal().toString(); //logged in user
		workPackageDTO.setRequestorName(userID);
		workPackageDTO.setCreateBy(userID);
		workPackageDTO.setModifiedBy(userID);
		workPackageService.createPackage(workPackageDTO);
	}
	
	@Required
	public void setWorkPackageService(WorkPackageService workPackageService) {
		this.workPackageService = workPackageService;
	}

	@Required
	public void setApplicationService(ApplicationService applicationService) {
		this.applicationService = applicationService;
	}
	
	@Required
	public void setTestingProgramService(TestingProgramService testingProgramService) {
		this.testingProgramService = testingProgramService;
	}

	public WorkPackageDTO getWorkPackageDTO() {
		return workPackageDTO;
	}

	public void setWorkPackageDTO(WorkPackageDTO workPackageDTO) {
		this.workPackageDTO = workPackageDTO;
	}

	public List<ApplicationDTO> getApplications() {
		return applications;
	}

	public void setApplications(List<ApplicationDTO> applications) {
		this.applications = applications;
	}
	
	public List<TestingProgramDTO> getTestPrograms() {
		return testPrograms;
	}

	public void setTestPrograms(List<TestingProgramDTO> testPrograms) {
		this.testPrograms = testPrograms;
	}
	
	public String getContractFromYear() {
		return contractFromYear;
	}

	public void setContractFromYear(String contractFromYear) {
		this.contractFromYear = contractFromYear;
	}

	public String getContractToYear() {
		return contractToYear;
	}

	public void setContractToYear(String contractToYear) {
		this.contractToYear = contractToYear;
	}
	
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public List<String> getImpactedApplications() {
		return impactedApplications;
	}

	public void setImpactedApplications(List<String> impactedApplications) {
		this.impactedApplications = impactedApplications;
	}
	
	public Integer getWorkPackageId() {
		return workPackageId;
	}

	public void setWorkPackageId(Integer workPackageId) {
		this.workPackageId = workPackageId;
	}
	
	public WorkPackageDTO getWorkPackage() {
		return workPackage;
	}

	public void setWorkPackage(WorkPackageDTO workPackage) {
		this.workPackage = workPackage;
	}

	public List<String> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<String> statuses) {
		this.statuses = statuses;
	}

}