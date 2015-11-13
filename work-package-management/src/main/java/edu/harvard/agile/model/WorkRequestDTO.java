package edu.harvard.agile.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * <p>Title: WorkRequestDTO</p>
 *
 * <p>Description: Domain Object describing a WorkRequestDTO entity</p>
 *
 */
public class WorkRequestDTO extends ModelBase {

	private Integer workRequestId;
	private String applicationId;
	private Integer packageId;
	private String status;
	private Date startDate;
	private Date endDate;
	private Date createDate;
	private Date modifiedDate;
	private String createBy;
	private String modifiedBy;




	private List<AssumptionsDTO> assumptionsDTOs;

    public WorkRequestDTO() {
    }

    public Integer getWorkRequestId() {
        	return workRequestId;
    }
	
    public void setWorkRequestId (Integer workRequestId) {
        this.workRequestId = workRequestId;
    }	
    public String getApplicationId() {
        	return applicationId;
    }
	
    public void setApplicationId (String applicationId) {
        this.applicationId = applicationId;
    }	
    public Integer getPackageId() {
        	return packageId;
    }
	
    public void setPackageId (Integer packageId) {
        this.packageId = packageId;
    }	
    public String getStatus() {
        	return status;
    }
	
    public void setStatus (String status) {
        this.status = status;
    }	
    public Date getStartDate() {
        	return startDate;
    }
	
    public void setStartDate (Date startDate) {
        this.startDate = startDate;
    }	
    public Date getEndDate() {
        	return endDate;
    }
	
    public void setEndDate (Date endDate) {
        this.endDate = endDate;
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


    
    public List<AssumptionsDTO> getAssumptionsDTOs() {
        if (assumptionsDTOs == null){
            assumptionsDTOs = new ArrayList<AssumptionsDTO>();
        }
        return assumptionsDTOs;
    }

    public void setAssumptionsDTOs (List<AssumptionsDTO> assumptionsDTOs) {
        this.assumptionsDTOs = assumptionsDTOs;
    }
    
    public void addAssumptionsDTOs (AssumptionsDTO assumptions) {
        getAssumptionsDTOs().add(assumptions);
    }	

}
