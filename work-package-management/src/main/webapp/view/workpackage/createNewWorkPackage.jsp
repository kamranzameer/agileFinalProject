<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-10 column">
            <p>&nbsp</p>
        </div>
    </div>
	<div class="row clearfix">
		<div class="col-md-8 column col-md-offset-1">
	            <div class="panel panel-info">
	                <div class="panel-heading">
	                    <div class="panel-title"><i class="fa fa-pencil">
					</i> <span id="pageTitle"> New Work Package </span> </div>
	                </div>
	                <div style="padding-top:30px"; class="panel-body">
						<form id="createworkpackageform" name="createworkpackageform" class="form-horizontal" role="form" method="post" action="saveWorkPackage.action">
							<div class="row clearfix">
								<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8  column col-sm-offset-0 col-md-offset-1 col-lg-offset-1">
										<div class="form-group">
											<div class="col-md-6">
												<label class="control-label" for="packageName">
													Package Name
												</label>
												<input class="form-control" id="packageName" name="workPackageDTO.packageName" value="${workPackage.packageName}" placeholder="Enter package name">
											</div>
											<div class="col-md-6">
												<label class="control-label" for="packageDesc">
													Package Description
												</label>
												<input class="form-control" id="packageDesc" name="workPackageDTO.packageDesc" value="${workPackage.packageDesc}" placeholder="Enter package description" type="text" >
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-6">
												<label class="control-label" for="testingProgramCode">
													Select Testing Program
												</label>
												<select class="form-control" tooltip="Select Test Program" name="workPackageDTO.testingProgramCode" value="${workPackage.testingProgramCode}" placeholder="testingProgramCode" >
												<s:iterator var = "testProgram" value="testPrograms">
												<option value="${testProgram.testingProgramCode}">${testProgram.testingProgramDesc}</option>
											</s:iterator>
												</select>
											</div>
											<div class="col-md-6">
												<label class="control-label" for="requestor">
													Requestor
												</label>
												<label class="form-control" id="requestorName" name="workPackageDTO.requestorName">
													<shiro:principal/>
												</label>
												<!-- <input class="form-control" id="requestorName" name="requestorName" placeholder="Enter name of Requestor" type="text">-->
												<!--<shiro:principal/>-->
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-6">
												<label class="control-label" for="contractFromYear">
													Contract Start Year
												</label>
											
												<input class="form-control" id="contractFromYear" name="contractFromYear" value="${workPackage.contractFromYear}" placeholder="Enter Contract Start Year" type="date">
											</div>		
				
						
											<div class="col-md-6">
												<label class="control-label" for="contractToYear">
													Contract End Year
												</label>
												<input class="form-control" id="contractToYear" name="contractToYear" value="${workPackage.contractToYear}" placeholder="Enter Contract End Year" type="date">
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-6">
												<label class="control-label" for="startDate">
													Start Date
												</label>
												<input class="form-control" id="startDate" name="startDate" value="${workPackage.startDate}" placeholder="Enter Start Date" type="date">
											</div>
											<div class="col-md-6">
												<label class="control-label" for="endDate">
													End Date
												</label>
												<input class="form-control" id="endDate" name="endDate"  value="${workPackage.endDate}" placeholder="Enter End Date" type="date">
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-6">
												<label class="control-label" for="status">
													Status
												</label>
												<select class="form-control" id="status" value="%{workPackage.status}" name="workPackageDTO.status" >
													<s:iterator var = "status" value="statuses">
													<option value="${status}">${status}</option>
													</s:iterator>
												</select>
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-12">
												<label class="control-label" for="impactedApplications">
													Choose Impacted Applications
												</label>
												<br/>
												<s:select tooltip="Choose Impacted Applications" multiple="true"  list="applications" listKey="applicationId" listValue="applicationName" value="%{workPackage.impactedApplications}" cssClass="form-control"
													id="impactedApplications" name="impactedApplications" style="color:black;" >
												</s:select>
											</div>
										</div>
								</div>
							</div>
							
							<div class="row clearfix">
								<div class="col-xs-12 col-sm-10 col-md-8 col-lg-8  column col-sm-offset-0 col-md-offset-1 col-lg-offset-1">
								
								
								<s:if test="workPackage.packageId !=''">
									<button type="submit" id="updateBtn" name="update" class="btn btn-success">
										<span class="fa fa-floppy-o">
										</span>
										&nbsp;&nbsp;Update
									</button>
								</s:if>
								<s:else>
								<button type="submit" id="addNewBtn" name="save" class="btn btn-success" >
										<span class="fa fa-floppy-o">
										</span>
										&nbsp;&nbsp;Save
									</button>
								</s:else>
									
									
								</div>
							</div>
						    <div class="row clearfix">
						        <div class="col-md-10 column">
						            <p>&nbsp</p>
						        </div>
						    </div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
		
	
<script>



var contractFromYear = new Date();
var contractToYear = new Date();
var startDate = new Date();
var endDate = new Date();

if ('${workPackage.packageId}' != '') {
	contractFromYear = '${workPackage.contractFromYear}';
	contractToYear = '${workPackage.contractToYear}';
	startDate = '${workPackage.startDate}';
	endDate = '${workPackage.endDate}';
	
	$('#status').val('${workPackage.impactedApplications}');
	
	$('#createworkpackageform').attr('action', 'updateWorkPackage.action?workPackageId=${workPackage.packageId}');
	$('#pageTitle').html('Update Work Package');
}
</script>

<script src="../js/workpagevalidation.js"></script>