package edu.harvard.agile.model;

import java.util.Date;

//TODO getAllPackage for the domain object in the import

/**
 *
 * <p>
 * Title: UserRoleDTO
 * </p>
 *
 * <p>
 * Description: Domain Object describing a UserRoleDTO entity
 * </p>
 *
 */
public class UserRoleDTO extends ModelBase {

	private String userId;
	private String roleId;
	private Date createDate;
	private String createBy;

	private RoleDTO roleDTO;

	private UsersDTO usersDTO;

	public UserRoleDTO() {
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
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

	public RoleDTO getRoleDTO() {
		return roleDTO;
	}

	public void setRoleDTO(RoleDTO roleDTO) {
		this.roleDTO = roleDTO;
	}

	public UsersDTO getUsersDTO() {
		return usersDTO;
	}

	public void setUsersDTO(UsersDTO usersDTO) {
		this.usersDTO = usersDTO;
	}

}
