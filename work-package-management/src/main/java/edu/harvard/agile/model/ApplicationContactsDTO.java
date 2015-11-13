package edu.harvard.agile.model;

import java.util.Date;

/**
 *
 * <p>Title: ApplicationContactsDTO</p>
 *
 * <p>Description: Domain Object describing a ApplicationContactsDTO entity</p>
 *
 */
public class ApplicationContactsDTO extends ModelBase {

	private String applicationId;
	private String userId;
	private String isActive;
	private Date createDate;
	private Date modifiedDate;
	private String createBy;
	private String modifiedBy;



    private ApplicationDTO applicationDTO;


    private UsersDTO usersDTO;


    public ApplicationContactsDTO() {
    }

    public String getApplicationId() {
        	return applicationId;
    }
	
    public void setApplicationId (String applicationId) {
        this.applicationId = applicationId;
    }	
    public String getUserId() {
        	return userId;
    }
	
    public void setUserId (String userId) {
        this.userId = userId;
    }	
    public String getIsActive() {
        	return isActive;
    }
	
    public void setIsActive (String isActive) {
        this.isActive = isActive;
    }	
    public Date getCreateDate() {
        	return createDate;
    }
	
    public void setCreateDate (Date createDate) {
        this.createDate = createDate;
    }	
    public Date getModifiedDate() {
        	return modifiedDate;
    }
	
    public void setModifiedDate (Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }	
    public String getCreateBy() {
        	return createBy;
    }
	
    public void setCreateBy (String createBy) {
        this.createBy = createBy;
    }	
    public String getModifiedBy() {
        	return modifiedBy;
    }
	
    public void setModifiedBy (String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }	


    public ApplicationDTO getApplicationDTO () {
    	    return applicationDTO;
    }
	
    public void setApplicationDTO (ApplicationDTO applicationDTO) {
    	    this.applicationDTO = applicationDTO;
    }
	

    public UsersDTO getUsersDTO () {
    	    return usersDTO;
    }
	
    public void setUsersDTO (UsersDTO usersDTO) {
    	    this.usersDTO = usersDTO;
    }
	
}
