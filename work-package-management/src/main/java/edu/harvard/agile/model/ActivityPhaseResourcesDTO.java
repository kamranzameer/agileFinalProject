package edu.harvard.agile.model;

import java.util.Date;

//TODO getAllPackage for the domain object in the import

/**
 *
 * <p>
 * Title: ActivityPhaseResourcesDTO
 * </p>
 *
 * <p>
 * Description: Domain Object describing a ActivityPhaseResourcesDTO entity
 * </p>
 *
 */
public class ActivityPhaseResourcesDTO extends ModelBase {

	private Integer activityPhaseResourceId;
	private Integer activityLineId;
	private Integer resourceTypeId;
	private Integer estimatedHours;
	private Date createDate;
	private Date modifiedDate;
	private String createBy;
	private String modifiedBy;
	private int totalHours;
	private int hourlyRate;
	private String resourceTypeName;
	private int totalCost;
	
	
					

	private ActivityLineDTO activityLineDTO;

	private ResourceTypeDTO resourceTypeDTO;

	public ActivityPhaseResourcesDTO() {
	}

	public Integer getActivityPhaseResourceId() {
		return activityPhaseResourceId;
	}

	public void setActivityPhaseResourceId(Integer activityPhaseResourceId) {
		this.activityPhaseResourceId = activityPhaseResourceId;
	}

	public Integer getActivityLineId() {
		return activityLineId;
	}

	public void setActivityLineId(Integer activityLineId) {
		this.activityLineId = activityLineId;
	}

	public Integer getResourceTypeId() {
		return resourceTypeId;
	}

	public void setResourceTypeId(Integer resourceTypeId) {
		this.resourceTypeId = resourceTypeId;
	}

	public Integer getEstimatedHours() {
		return estimatedHours;
	}

	public void setEstimatedHours(Integer estimatedHours) {
		this.estimatedHours = estimatedHours;
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

	public ResourceTypeDTO getResourceTypeDTO() {
		return resourceTypeDTO;
	}

	public void setResourceTypeDTO(ResourceTypeDTO resourceTypeDTO) {
		this.resourceTypeDTO = resourceTypeDTO;
	}

	public int getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(int totalHours) {
		this.totalHours = totalHours;
	}

	public int getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(int hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public String getResourceTypeName() {
		return resourceTypeName;
	}

	public void setResourceTypeName(String resourceTypeName) {
		this.resourceTypeName = resourceTypeName;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	@Override
	public String toString() {
		return "ActivityPhaseResourcesDTO [activityPhaseResourceId="
				+ activityPhaseResourceId + ", activityLineId="
				+ activityLineId + ", resourceTypeId=" + resourceTypeId
				+ ", estimatedHours=" + estimatedHours + ", createDate="
				+ createDate + ", modifiedDate=" + modifiedDate + ", createBy="
				+ createBy + ", modifiedBy=" + modifiedBy + ", totalHours="
				+ totalHours + ", hourlyRate=" + hourlyRate
				+ ", resourceTypeName=" + resourceTypeName + ", totalCost="
				+ totalCost + "]";
	}
	
	

}
