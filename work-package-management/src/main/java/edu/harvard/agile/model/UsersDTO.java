package edu.harvard.agile.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//TODO getAllPackage for the domain object in the import

/**
 *
 * <p>
 * Title: UsersDTO
 * </p>
 *
 * <p>
 * Description: Domain Object describing a UsersDTO entity
 * </p>
 *
 */
public class UsersDTO extends ModelBase {

	private String userId;
	private String password;
	private Date createDate;
	private Date modifiedDate;
	private String createBy;
	private String modifiedBy;

	private List<ApplicationContactsDTO> applicationContactsDTOs;

	private List<UserProfileDTO> userProfileDTOs;

	private List<UserRoleDTO> userRoleDTOs;

	public UsersDTO() {
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public List<UserProfileDTO> getUserProfileDTOs() {
		if (userProfileDTOs == null) {
			userProfileDTOs = new ArrayList<UserProfileDTO>();
		}
		return userProfileDTOs;
	}

	public void setUserProfileDTOs(List<UserProfileDTO> userProfileDTOs) {
		this.userProfileDTOs = userProfileDTOs;
	}

	public void addUserProfileDTOs(UserProfileDTO userProfile) {
		getUserProfileDTOs().add(userProfile);
	}

	public List<UserRoleDTO> getUserRoleDTOs() {
		if (userRoleDTOs == null) {
			userRoleDTOs = new ArrayList<UserRoleDTO>();
		}
		return userRoleDTOs;
	}

	public void setUserRoleDTOs(List<UserRoleDTO> userRoleDTOs) {
		this.userRoleDTOs = userRoleDTOs;
	}

	public void addUserRoleDTOs(UserRoleDTO userRole) {
		getUserRoleDTOs().add(userRole);
	}

}
