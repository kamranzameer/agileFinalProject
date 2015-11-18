package edu.harvard.agile.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//TODO getAllPackage for the domain object in the import

/**
 *
 * <p>
 * Title: ApplicationDTO
 * </p>
 *
 * <p>
 * Description: Domain Object describing a ApplicationDTO entity
 * </p>
 *
 */
public class ApplicationDTO extends ModelBase {

	private String applicationId;
	private String applicationName;
	private String applicationDesc;
	private String isActive;
	private Date createDate;
	private Date modifiedDate;
	private String createBy;
	private String modifiedBy;

	private List<ApplicationContactsDTO> applicationContactsDTOs;

	public ApplicationDTO() {
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getApplicationDesc() {
		return applicationDesc;
	}

	public void setApplicationDesc(String applicationDesc) {
		this.applicationDesc = applicationDesc;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
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

	public List<ApplicationContactsDTO> getApplicationContactsDTOs() {
		if (applicationContactsDTOs == null) {
			applicationContactsDTOs = new ArrayList<ApplicationContactsDTO>();
		}
		return applicationContactsDTOs;
	}

	public void setApplicationContactsDTOs(
			List<ApplicationContactsDTO> applicationContactsDTOs) {
		this.applicationContactsDTOs = applicationContactsDTOs;
	}

	public void addApplicationContactsDTOs(
			ApplicationContactsDTO applicationContacts) {
		getApplicationContactsDTOs().add(applicationContacts);
	}

}
