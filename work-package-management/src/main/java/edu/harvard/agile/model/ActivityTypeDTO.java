package edu.harvard.agile.model;

import java.util.Date;

//TODO getAllPackage for the domain object in the import

/**
 *
 * <p>
 * Title: ActivityTypeDTO
 * </p>
 *
 * <p>
 * Description: Domain Object describing a ActivityTypeDTO entity
 * </p>
 *
 */
public class ActivityTypeDTO extends ModelBase {

	private String activityTypeCode;
	private String activityTypeDesc;
	private Date createDate;
	private String createBy;

	public ActivityTypeDTO() {
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

}
