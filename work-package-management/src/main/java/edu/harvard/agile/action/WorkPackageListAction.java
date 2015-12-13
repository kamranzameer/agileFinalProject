package edu.harvard.agile.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Required;

import edu.harvard.agile.model.TestingProgramDTO;
import edu.harvard.agile.model.WorkPackageDTO;
import edu.harvard.agile.service.TestingProgramService;
import edu.harvard.agile.service.WorkPackageService;
import edu.harvard.agile.util.WorkPackageUtil;

/**
 * Action class to handle list all workpackages requests
 * 
 * @author Incredibles
 *
 */
public class WorkPackageListAction extends WPMActionBase {

  private WorkPackageService workPackageService;
  private TestingProgramService testingProgramService;
  private List<WorkPackageDTO> workPackages;
  private List<TestingProgramDTO> testPrograms;
  private WorkPackageDTO workPackage;
  private List<String> statuses = new ArrayList<String>();

  private String contractFromYear;
  private String contractToYear;
  private String startDate;
  private String endDate;

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

  @Override
  public void prepare() throws Exception {

    if (workPackage == null) {
      workPackage = new WorkPackageDTO();
    }

    if (contractFromYear != null && contractFromYear.length() > 0) {
      workPackage.setContractFromYear(WorkPackageUtil.convertDate(contractFromYear, "yyyy-MM-dd"));
    }

    if (contractToYear != null && contractToYear.length() > 0) {
      workPackage.setContractToYear(WorkPackageUtil.convertDate(contractToYear, "yyyy-MM-dd"));
    }

    if (startDate != null && startDate.length() > 0) {
      workPackage.setStartDate(WorkPackageUtil.convertDate(startDate, "yyyy-MM-dd"));
    }

    if (endDate != null && endDate.length() > 0) {
      workPackage.setEndDate(WorkPackageUtil.convertDate(endDate, "yyyy-MM-dd"));
    }

    testPrograms = testingProgramService.findAllTestingPrograms();
    workPackages = workPackageService.findAllPackages(workPackage);
    statuses = WorkPackageUtil.getValidStatus();
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

  public List<TestingProgramDTO> getTestPrograms() {
    return testPrograms;
  }

  public void setTestPrograms(List<TestingProgramDTO> testPrograms) {
    this.testPrograms = testPrograms;
  }

  @Required
  public void setTestingProgramService(TestingProgramService testingProgramService) {
    this.testingProgramService = testingProgramService;
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
