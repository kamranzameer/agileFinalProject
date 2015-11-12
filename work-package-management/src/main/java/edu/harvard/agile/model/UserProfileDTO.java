package edu.harvard.agile.model;

import java.util.Date;

/**
 *
 * <p>Title: UserProfileDTO</p>
 *
 * <p>Description: Domain Object describing a UserProfileDTO entity</p>
 *
 */
public class UserProfileDTO extends ModelBase {

	private String userId;
	private String firstName;
	private String lastName;
	private String middleName;
	private Date dateOfBirth;
	private String emailId;
	private String addressLine1;
	private String addressLine2;
	private String state;
	private String zipCode;
	private Date createDate;
	private Date modifiedDate;
	private String createBy;
	private String modifiedBy;



    private UsersDTO usersDTO;


    public UserProfileDTO() {
    }

    public String getUserId() {
        	return userId;
    }
	
    public void setUserId (String userId) {
        this.userId = userId;
    }	
    public String getFirstName() {
        	return firstName;
    }
	
    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }	
    public String getLastName() {
        	return lastName;
    }
	
    public void setLastName (String lastName) {
        this.lastName = lastName;
    }	
    public String getMiddleName() {
        	return middleName;
    }
	
    public void setMiddleName (String middleName) {
        this.middleName = middleName;
    }	
    public Date getDateOfBirth() {
        	return dateOfBirth;
    }
	
    public void setDateOfBirth (Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }	
    public String getEmailId() {
        	return emailId;
    }
	
    public void setEmailId (String emailId) {
        this.emailId = emailId;
    }	
    public String getAddressLine1() {
        	return addressLine1;
    }
	
    public void setAddressLine1 (String addressLine1) {
        this.addressLine1 = addressLine1;
    }	
    public String getAddressLine2() {
        	return addressLine2;
    }
	
    public void setAddressLine2 (String addressLine2) {
        this.addressLine2 = addressLine2;
    }	
    public String getState() {
        	return state;
    }
	
    public void setState (String state) {
        this.state = state;
    }	
    public String getZipCode() {
        	return zipCode;
    }
	
    public void setZipCode (String zipCode) {
        this.zipCode = zipCode;
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


    public UsersDTO getUsersDTO () {
    	    return usersDTO;
    }
	
    public void setUsersDTO (UsersDTO usersDTO) {
    	    this.usersDTO = usersDTO;
    }
	
}
