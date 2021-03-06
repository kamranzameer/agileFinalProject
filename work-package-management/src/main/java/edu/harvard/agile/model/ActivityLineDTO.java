package edu.harvard.agile.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//TODO getAllPackage for the domain object in the import

/**
 *
 * <p>
 * Title: ActivityLineDTO
 * </p>
 *
 * <p>
 * Description: Domain Object describing a ActivityLineDTO entity
 * </p>
 *
 */
public class ActivityLineDTO extends ModelBase {

	private Integer activityLineId;
	private String activityLineDesc;
	private Integer workRequestId;
	private String activityTypeCode;
	private String activityTypeDesc;
	private Date startDate;
	private Date endDate;
	private Date createDate;
	private Date modifiedDate;
	private String createBy;
	private String modifiedBy;
	private int totalHours;
	private int totalCost;
	private List<ActivityPhaseResourcesDTO> activityPhaseResourcesDTOs;
	private List<String> assumptions;
	private List<AssumptionsDTO> assumptionDTOs;
	
	public List<AssumptionsDTO> getAssumptionDTOs() {
		return assumptionDTOs;
	}

	public void setAssumptionDTOs(List<AssumptionsDTO> assumptionDTOs) {
		this.assumptionDTOs = assumptionDTOs;
	}

	public List<String> getAssumptions() {
		return assumptions;
	}

	public void setAssumptions(List<String> assumptions) {
		this.assumptions = assumptions;
	}

	public Integer getActivityLineId() {
		return activityLineId;
	}

	public void setActivityLineId(Integer activityLineId) {
		this.activityLineId = activityLineId;
	}

	public String getActivityLineDesc() {
		return activityLineDesc;
	}

	public void setActivityLineDesc(String activityLineDesc) {
		this.activityLineDesc = activityLineDesc;
	}

	public Integer getWorkRequestId() {
		return workRequestId;
	}

	public void setWorkRequestId(Integer workRequestId) {
		this.workRequestId = workRequestId;
	}

	public String getActivityTypeCode() {
		return activityTypeCode;
	}

	public void setActivityTypeCode(String activityTypeCode) {
		this.activityTypeCode = activityTypeCode;
	}
	
	public String getActivityTypeDesc() {
		return activityTypeDesc;
	}

	public void setActivityTypeDesc(String activityTypeDesc) {
		this.activityTypeDesc = activityTypeDesc;
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

	public List<ActivityPhaseResourcesDTO> getActivityPhaseResourcesDTOs() {
		if (activityPhaseResourcesDTOs == null) {
			activityPhaseResourcesDTOs = new ArrayList<ActivityPhaseResourcesDTO>();
		}
		return activityPhaseResourcesDTOs;
	}

	public void setActivityPhaseResourcesDTOs(
			List<ActivityPhaseResourcesDTO> activityPhaseResourcesDTOs) {
		this.activityPhaseResourcesDTOs = activityPhaseResourcesDTOs;
	}

	public void addActivityPhaseResourcesDTOs(
			ActivityPhaseResourcesDTO activityPhaseResources) {
		getActivityPhaseResourcesDTOs().add(activityPhaseResources);
	}

	public int getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(int totalHours) {
		this.totalHours = totalHours;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	public String getAssumptionsHtml() {
		String s = "";
		for (String assumption : assumptions) {
			s = s + assumption + "<br/>";
		}
		return s;
	}

}
