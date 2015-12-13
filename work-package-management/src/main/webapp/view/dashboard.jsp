<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<div class="row clearfix">
    <div class="col-md-12 column">
        <ul class="breadcrumb" style="margin-bottom: 5px;">
            <% String userID = session.getAttribute("userID").toString(); %>
            <li>Dashboard : Welcome <%=userID%></li>
        </ul>
    </div>
</div>
<div class="row clearfix">
    <div class="col-md-12 column">
        &nbsp;
    </div>
</div>

<shiro:hasAnyRoles name="DM,BU">
<div class="row" style="margin-top: 30px">
    <div class="col-xs-3">
        <!-- small box -->
        <div class="small-box-usr bg-green">
            <div class="inner">
                <h3>
                     ${dashboardInfo.inprogressWorkPackagesCount}<!-- <sup style="font-size: 20px">GB</sup> -->
                </h3>
                <p>
                    In Progress<br>
                    Work Packages
                </p>
            </div>
            <div class="icon">
                <i class="ion ion-load-a"></i>
            </div>
            <a href="workPackageList.action?workPackage.status=INPROGRESS" ng-click="menuService.changeMenu('config')" class="small-box-usr-footer">
                More info <i class="fa fa-arrow-circle-right"></i>
            </a>
        </div>
    </div><!-- ./col -->
    
    <div class="col-xs-3">
        <!-- small box -->
        <div class="small-box-usr bg-blue">
            <div class="inner">
                <h3>
                     ${dashboardInfo.openWorkPackagesCount}<!-- <sup style="font-size: 20px">GB</sup> -->
                </h3>
                <p>
                    Open<br>
                    Work Packages
                </p>
            </div>
            <div class="icon">
                <i class="ion ion-unlocked"></i>
            </div>
            <a href="workPackageList.action?workPackage.status=OPEN" ng-click="menuService.changeMenu('config')" class="small-box-usr-footer">
                More info <i class="fa fa-arrow-circle-right"></i>
            </a>
        </div>
    </div><!-- ./col -->
    
    <div class="col-xs-3">
        <!-- small box -->
        <div class="small-box-usr bg-red">
            <div class="inner">
                <h3>
                   ${dashboardInfo.approvedWorkPackagesCount} 
                </h3>
                <p>
                    Approved<br>Work Packages
                </p>
            </div>
            <div class="icon">
                <i class="ion ion-checkmark-circled"></i>
            </div>
            <a href="workPackageList.action?workPackage.status=APPROVED" ng-click="menuService.changeMenu('config')" class="small-box-usr-footer">
                More info <i class="fa fa-arrow-circle-right"></i>
            </a>
        </div>
    </div><!-- ./col -->
    
    <div class="col-xs-3">
        <!-- small box -->
        <div class="small-box-usr bg-yellow">
            <div class="inner">
                <h3>
                    ${dashboardInfo.completedWorkPackagesCount}
                </h3>
                <p>
                    Completed<br>Work Packages
                </p>
            </div>
            <div class="icon">
                <i class="ion ion-load-d"></i>
            </div>
            <a href="workPackageList.action?workPackage.status=COMPLETED" ng-click="menuService.changeMenu('config')" class="small-box-usr-footer">
                More info <i class="fa fa-arrow-circle-right"></i>
            </a>
        </div>
    </div><!-- ./col -->
    <div class="col-xs-3">
        <!-- small box -->
        <div class="small-box-usr bg-aqua">
            <div class="inner">
   												
                <h3>
                   ${dashboardInfo.totalWorkPackagesCount}
                </h3>
                <p>
                    Total <br>
                    Work Packages
                </p>
            </div>
            <div class="icon">
                <i class="ion ion-clipboard"></i>
            </div>
            <a href="workPackageList.action?workPackage.status=" class="small-box-usr-footer" ng-click="menuService.changeMenu('config')">
                More info <i class="fa fa-arrow-circle-right"></i>
            </a>
        </div>
    </div><!-- ./col -->
    
    
    
</div><!-- /.row -->
</shiro:hasAnyRoles>
<shiro:hasAnyRoles name="AC">
<div class="row" style="margin-top: 30px">
    <div class="col-xs-3">
        <!-- small box -->
        <div class="small-box-usr bg-aqua">
            <div class="inner">
                <h3>
                	
                     ${dashboardInfo.appTotalWorkRequestsCount} 
                </h3>
                <p>
                    Total <br>
                    Work Requests
                </p>
            </div>
            <div class="icon">
                <i class="ion ion-clipboard"></i>
            </div>
            <a href="workRequestList.action" class="small-box-usr-footer" ng-click="menuService.changeMenu('config')">
                More info <i class="fa fa-arrow-circle-right"></i>
            </a>
        </div>
    </div><!-- ./col -->
</div>
</shiro:hasAnyRoles>
