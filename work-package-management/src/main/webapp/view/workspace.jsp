
<%
    String currentPage = request.getParameter("p");
	if(currentPage == null){
		currentPage = (String) request.getAttribute("p");
	}
    if(currentPage!=null ){
	    if (currentPage.equals("cp")){
	    	currentPage = "changepassword.jsp";
	    }else if (currentPage.equals("ecit")){
	    	currentPage = "userProfile.jsp";
	    }else if (currentPage.equals("wpl")){
	    	currentPage = "workpackage/workpackagelist.jsp";
	    }else if (currentPage.equals("cnwp")){
	    	currentPage = "workpackage/createNewWorkPackage.jsp";
	    }else if (currentPage.equals("cnac")){
	    	currentPage = "workpackage/createnewactivity.jsp";
	    }else if (currentPage.equals("wrl")){
	    	currentPage = "workrequest/workRequestList.jsp";
	    }else if (currentPage.equals("wrpd")){
	    	currentPage = "workrequest/workRequestPackageDetail.jsp";
	    }else if (currentPage.equals("wps")){
	    	currentPage = "workpackage/workPackageStatistics.jsp";
	    }else if (currentPage.equals("wpd")){
	    	currentPage = "workpackage/workpackagedetail.jsp";
	    }else if (currentPage.equals("wrd")){
	    	currentPage = "workrequest/workrequestdetail.jsp";
	    }else{
	    	currentPage = "dashboard.jsp";
	    }

	}else{
	currentPage = "dashboard.jsp";
	}
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>


<!DOCTYPE html>
<html>
<head lang="en">
 
	<link href="../css/datepicker.css" rel="stylesheet">
 
    <link href="../css/glyphicon.css" rel="stylesheet">
    <link href="../css/theme1/bootstrap.css" rel="stylesheet">
    <link href="../css/theme1/user.css" rel="stylesheet">
   
	<link href="../css/font-awesome.min.css" rel="stylesheet">
	 
	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/bootstrap-datepicker.js"></script>
	<script src="../js/app.js"></script>
	<script src="../js/bootstrapValidator.min.js"></script>
	
	<style>
/* 	.datepicker td span:hover {
  background: black;
} */
.datepicker {
	background-color: #fff ;
	color: #333 ;
}
	
	
	label, .radio label, .checkbox label, .help-block {
    font-size: 14px;
    font-weight: 300;
}
	</style>
</head>
<body>
<div class="container" style="margin-left:5px; margin-right:5px">
    <div class="row" clearfix>
        <div class="col-md-12" column>
			<jsp:include page="topmenu.jsp"/>
        </div>
    </div>
    <div class="row" clearfix style="margin-top: 5%">
        <div class="col-md-3">
		    <div class="row">
		        <div class="col-md-12">
		        <p>&nbsp;</p>
		       	</div>
        	</div>

		    <div class="row">
		        <div class="col-md-12">
				<div class="bs-docs-sidebar hidden-print affix col-md-2" role="complementary" style="background-color: rgba(11, 43, 50, 0.82)">
				    <ul class="nav bs-docs-sidenav">
		                <li><a href="homepage.jsp"><i class="glyphicon glyphicon-dashboard">&nbsp;</i>Dashboard</a></li>

						<shiro:hasAnyRoles name="DM,BU">
						<li class=""> <a href="workPackageList.action" data-toggle="collapse" data-target="#workPackageMenu"><i class="fa fa-newspaper-o">&nbsp;</i>Work Packages</a>
						</li>
						</shiro:hasAnyRoles>
						
						<shiro:hasAnyRoles name="AC">
							<li class=""> <a href="workRequestList.action" data-toggle="collapse" data-target="#workRequestMenu"><i class="fa fa-newspaper-o">&nbsp;</i>Work Requests</a>
							</li>
						</shiro:hasAnyRoles>

		                <li><a href="../logout"><i class="glyphicon glyphicon-off">&nbsp;</i>Sign Out</a>&nbsp;</li>
				    </ul>
				</div>
	        	</div>
        	</div>
        </div>
        <div class="col-md-9" id="workspace">
			<jsp:include page="<%=currentPage%>"/>
        </div>
    </div>
</div>
<script>
	workPackageManagement = workPackageManagement();
</script>
</body>
</html>
