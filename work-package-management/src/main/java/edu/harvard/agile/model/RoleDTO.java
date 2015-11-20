package edu.harvard.agile.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//TODO getAllPackage for the domain object in the import

/**
 *
 * <p>
 * Title: RoleDTO
 * </p>
 *
 * <p>
 * Description: Domain Object describing a RoleDTO entity
 * </p>
 *
 */
public class RoleDTO extends ModelBase {

	private String roleId;
	private String roleName;
	private String isActive;
	private Date createDate;
	private Date modifiedDate;
	private String createBy;
	private String modifiedBy;

	private List<UserRoleDTO> userRoleDTOs;

	public RoleDTO() {
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
