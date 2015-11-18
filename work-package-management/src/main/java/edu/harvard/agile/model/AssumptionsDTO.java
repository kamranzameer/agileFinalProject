package edu.harvard.agile.model;

import java.util.Date;

//TODO getAllPackage for the domain object in the import

/**
 *
 * <p>
 * Title: AssumptionsDTO
 * </p>
 *
 * <p>
 * Description: Domain Object describing a AssumptionsDTO entity
 * </p>
 *
 */
public class AssumptionsDTO extends ModelBase {

	private Integer assumptionsId;
	private String assumptionsDesc;
	private Integer workRequestId;
	private Integer activityLineId;
	private Date createDate;
	private Date modifiedDate;
	private String createBy;
	private String modifiedBy;

	private ActivityLineDTO activityLineDTO;

	private WorkRequestDTO workRequestDTO;

	public AssumptionsDTO() {
	}

	public Integer getAssumptionsId() {
		return assumptionsId;
	}

	public void setAssumptionsId(Integer assumptionsId) {
		this.assumptionsId = assumptionsId;
	}

	public String getAssumptionsDesc() {
		return assumptionsDesc;
	}

	public void setAssumptionsDesc(String assumptionsDesc) {
		this.assumptionsDesc = assumptionsDesc;
	}

	public Integer getWorkRequestId() {
		return workRequestId;
	}

	public void setWorkRequestId(Integer workRequestId) {
		this.workRequestId = workRequestId;
	}

	public Integer getActivityLineId() {
		return activityLineId;
	}

	public void setActivityLineId(Integer activityLineId) {
		this.activityLineId = activityLineId;
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

	public ActivityLineDTO getActivityLineDTO() {
		return activityLineDTO;
	}

	public void setActivityLineDTO(ActivityLineDTO activityLineDTO) {
		this.activityLineDTO = activityLineDTO;
	}

	public WorkRequestDTO getWorkRequestDTO() {
		return workRequestDTO;
	}

	public void setWorkRequestDTO(WorkRequestDTO workRequestDTO) {
		this.workRequestDTO = workRequestDTO;
	}

}
