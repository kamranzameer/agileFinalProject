package edu.harvard.agile.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/wpm")
@ResultPath(value="/")
@Result(name="success",location="view/workspace.jsp")
public class WorkPackageAction extends ActionSupport{

	
	//business logic
	public String execute() {

		return "SUCCESS";

	}

        //simple validation
	public void validate(){
		
	}
}