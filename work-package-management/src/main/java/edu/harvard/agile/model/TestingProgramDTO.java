package edu.harvard.agile.model;

import java.util.Date;

//TODO getAllPackage for the domain object in the import

/**
 *
 * <p>
 * Title: TestingProgramDTO
 * </p>
 *
 * <p>
 * Description: Domain Object describing a TestingProgramDTO entity
 * </p>
 *
 */
public class TestingProgramDTO extends ModelBase {

	private String testingProgramCode;
	private String testingProgramDesc;
	private Date createDate;
	private String createBy;

	public TestingProgramDTO() {
	}

	public String getTestingProgramCode() {
		return testingProgramCode;
	}

	public void setTestingProgramCode(String testingProgramCode) {
		this.testingProgramCode = testingProgramCode;
	}

	public String getTestingProgramDesc() {
		return testingProgramDesc;
	}

	public void setTestingProgramDesc(String testingProgramDesc) {
		this.testingProgramDesc = testingProgramDesc;
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

	@Override
	public String toString() {
		return testingProgramDesc;
	}

}
