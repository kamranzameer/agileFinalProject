package edu.harvard.agile.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//TODO getAllPackage for the domain object in the import

/**
 *
 * <p>
 * Title: ResourceTypeDTO
 * </p>
 *
 * <p>
 * Description: Domain Object describing a ResourceTypeDTO entity
 * </p>
 *
 */
public class ResourceTypeDTO extends ModelBase {

	private Integer resourceTypeId;
	private String resourceTypeName;
	private Integer hourlyRate;
	private Date createDate;
	private Date modifiedDate;
	private String createBy;
	private String modifiedBy;

	private List<ActivityPhaseResourcesDTO> activityPhaseResourcesDTOs;

	public ResourceTypeDTO() {
	}

	public Integer getResourceTypeId() {
		return resourceTypeId;
	}

	public void setResourceTypeId(Integer resourceTypeId) {
		this.resourceTypeId = resourceTypeId;
	}

	public String getResourceTypeName() {
		return resourceTypeName;
	}

	public void setResourceTypeName(String resourceTypeName) {
		this.resourceTypeName = resourceTypeName;
	}

	public Integer getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(Integer hourlyRate) {
		this.hourlyRate = hourlyRate;
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

}
