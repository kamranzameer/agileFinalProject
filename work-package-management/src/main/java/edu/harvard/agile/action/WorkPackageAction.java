package edu.harvard.agile.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Required;

import edu.harvard.agile.model.ApplicationDTO;
import edu.harvard.agile.model.TestingProgramDTO;
import edu.harvard.agile.model.WorkPackageDTO;
import edu.harvard.agile.service.ApplicationService;
import edu.harvard.agile.service.TestingProgramService;
import edu.harvard.agile.service.WorkPackageService;

public class WorkPackageAction extends WPMActionBase {
	private WorkPackageService workPackageService;
	private ApplicationService applicationService;
	private TestingProgramService testingProgramService;
	private WorkPackageDTO workPackageDTO;
	private List<ApplicationDTO> applications;
	private List<String> impactedApplications;
	private List<TestingProgramDTO> testPrograms;
	//private TestingProgramDTO selectedTestProgram;
	private boolean save;

	@Override
	public void prepare() throws Exception {
		applications = applicationService.findAllApplications();
		testPrograms = testingProgramService.findAllTestingPrograms();
		
	}
	
	public void setSave(boolean isSave)
	{
		this.save = isSave;
	}

	public String execute(){
		ServletActionContext.getRequest().setAttribute("p", "cnwp");
		return SUCCESS;
	}
	
	public String save()
	{
		System.out.println("Save");
		try {
			
			
			processNewPackage();
		} catch (Exception e) {
			e.printStackTrace();
			//return ERROR;
		}		
		return SUCCESS;
	}

	private void processNewPackage() throws Exception 
	{
		//workPackageDTO.setImpactedApplications(impactedApplications);
		//workPackageDTO.setTestingProgramCode(testingProgramCode);
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
	
	public List<String> getImpactedApplications() {
		return impactedApplications;
	}

	public void setImpactedApplications(List<String> impactedApplications) {
		this.impactedApplications = impactedApplications;
	}

	public List<TestingProgramDTO> getTestPrograms() {
		return testPrograms;
	}

	public void setTestPrograms(List<TestingProgramDTO> testPrograms) {
		this.testPrograms = testPrograms;
	}

}
