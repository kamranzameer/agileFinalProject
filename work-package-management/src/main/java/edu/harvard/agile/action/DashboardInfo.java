/**
 * 
 */
package edu.harvard.agile.action;

/**
 * @author Incredibles
 * This class holds information about the dashboard.
 *
 */
public class DashboardInfo {
	private int openWorkPackagesCount = 0;
	private int approvedWorkPackagesCount = 0;
	private int totalWorkPackagesCount = 0;
	private int inprogressWorkPackagesCount = 0;
	private int completedWorkPackagesCount = 0;
	private int appTotalWorkRequestsCount = 0;
	
	/**
	 * @return the appTotalWorkRequestsCount
	 */
	public int getAppTotalWorkRequestsCount() {
		return appTotalWorkRequestsCount;
	}

	/**
	 * @param appTotalWorkRequestsCount the appTotalWorkRequestsCount to set
	 */
	public void setAppTotalWorkRequestsCount(int appTotalWorkRequestsCount) {
		this.appTotalWorkRequestsCount = appTotalWorkRequestsCount;
	}

	DashboardInfo(){
		
	}
	
	/**
	 * @return the openWorkPackagesCount
	 */
	public int getOpenWorkPackagesCount() {
		return openWorkPackagesCount;
	}
	/**
	 * @param openWorkPackagesCount the openWorkPackagesCount to set
	 */
	public void setOpenWorkPackagesCount(int openWorkPackagesCount) {
		this.openWorkPackagesCount = openWorkPackagesCount;
	}
	/**
	 * @return the approvedWorkPackagesCount
	 */
	public int getApprovedWorkPackagesCount() {
		return approvedWorkPackagesCount;
	}
	/**
	 * @param approvedWorkPackagesCount the approvedWorkPackagesCount to set
	 */
	public void setApprovedWorkPackagesCount(int approvedWorkPackagesCount) {
		this.approvedWorkPackagesCount = approvedWorkPackagesCount;
	}
	/**
	 * @return the totalWorkPackagesCount
	 */
	public int getTotalWorkPackagesCount() {
		return totalWorkPackagesCount;
	}
	/**
	 * @param totalWorkPackagesCount the totalWorkPackagesCount to set
	 */
	public void setTotalWorkPackagesCount(int totalWorkPackagesCount) {
		this.totalWorkPackagesCount = totalWorkPackagesCount;
	}
	/**
	 * @return the inprogressWorkPackagesCount
	 */
	public int getInprogressWorkPackagesCount() {
		return inprogressWorkPackagesCount;
	}
	/**
	 * @param inprogressWorkPackagesCount the inprogressWorkPackagesCount to set
	 */
	public void setInprogressWorkPackagesCount(int inprogressWorkPackagesCount) {
		this.inprogressWorkPackagesCount = inprogressWorkPackagesCount;
	}
	/**
	 * @return the completedWorkPackagesCount
	 */
	public int getCompletedWorkPackagesCount() {
		return completedWorkPackagesCount;
	}
	/**
	 * @param completedWorkPackagesCount the completedWorkPackagesCount to set
	 */
	public void setCompletedWorkPackagesCount(int completedWorkPackagesCount) {
		this.completedWorkPackagesCount = completedWorkPackagesCount;
	}
	

}
