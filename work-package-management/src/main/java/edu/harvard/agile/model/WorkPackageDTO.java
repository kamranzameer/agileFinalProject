package edu.harvard.agile.model;

import java.util.Date;
import java.util.List;

//TODO getAllPackage for the domain object in the import

/**
 *
 * <p>
 * Title: WorkPackageDTO
 * </p>
 *
 * <p>
 * Description: Domain Object describing a WorkPackageDTO entity
 * </p>
 *
 */
public class WorkPackageDTO extends ModelBase {

	private Integer packageId;
	private String packageName;
	private String packageDesc;
	private String testingProgramCode;
	private String requestorName;
	private Date contractFromYear;
	private Date contractToYear;
	private Date startDate;
	private Date endDate;
	private String status;
	private Date createDate;
	private Date modifiedDate;
	private String createBy;
	private String modifiedBy;
	private Integer totalCost;
	private Integer totalApplications;
	
	private List<String> impactedApplications;

	public WorkPackageDTO() {
	}

	public Integer getPackageId() {
		return packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPackageDesc() {
		return packageDesc;
	}

	public void setPackageDesc(String packageDesc) {
		this.packageDesc = packageDesc;
	}

	public String getTestingProgramCode() {
		return testingProgramCode;
	}

	public void setTestingProgramCode(String testingProgramCode) {
		this.testingProgramCode = testingProgramCode;
	}

	public String getRequestorName() {
		return requestorName;
	}

	public void setRequestorName(String requestorName) {
		this.requestorName = requestorName;
	}

	public Date getContractFromYear() {
		return contractFromYear;
	}

	public void setContractFromYear(Date contractFromYear) {
		this.contractFromYear = contractFromYear;
	}

	public Date getContractToYear() {
		return contractToYear;
	}

	public void setContractToYear(Date contractToYear) {
		this.contractToYear = contractToYear;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	public List<String> getImpactedApplications() {
		return impactedApplications;
	}

	public void setImpactedApplications(List<String> impactedApplications) {
		this.impactedApplications = impactedApplications;
	}

	public Integer getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Integer totalCost) {
		this.totalCost = totalCost;
	}

	public Integer getTotalApplications() {
		return totalApplications;
	}

	public void setTotalApplications(Integer totalApplications) {
		this.totalApplications = totalApplications;
	}
	
	


}