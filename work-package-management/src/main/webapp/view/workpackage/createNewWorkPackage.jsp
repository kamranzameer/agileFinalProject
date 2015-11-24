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
					</i> New Work Package</div>
	                </div>
	                <div style="padding-top:30px"; class="panel-body">
						<form id="createworkpackageform" class="form-horizontal" role="form" method="post" action="saveWorkPackage.action">
							<div class="row clearfix">
								<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8  column col-sm-offset-0 col-md-offset-1 col-lg-offset-1">
										<div class="form-group">
											<div class="col-md-6">
												<label class="control-label" for="packageName">
													Package Name
												</label>
												<input class="form-control" id="packageName" name="packageName" placeholder="Enter package name" required>
											</div>
											<div class="col-md-6">
												<label class="control-label" for="packageDesc">
													Package Description
												</label>
												<input class="form-control" id="packageDesc" name="packageDesc" placeholder="Enter package description" type="text" required>
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-6">
												<label class="control-label" for="testingProgramCode">
													Select Testing Program
												</label>
												<select class="form-control" tooltip="Select Test Program" name="testingProgramCode" value="testingProgramCode" required>
												<s:iterator var = "testProgram" value="testPrograms">
												<option value="${testProgram.testingProgramCode}">${testProgram.testingProgramDesc}</option>
											</s:iterator>
												</select>
											</div>
											<div class="col-md-6">
												<label class="control-label" for="requestor">
													Requestor
												</label>
												<label class="form-control" id="requestorName" name="requestorName">
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
												<input class="form-control" id="contractFromYear" name="contractFromYear" placeholder="Enter Contract Start Year" type="date" required>
											</div>
											<div class="col-md-6">
												<label class="control-label" for="contractToYear">
													Contract End Year
												</label>
												<input class="form-control" id="contractToYear" name="contractToYear" placeholder="Enter Contract End Year" type="date" required>
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-6">
												<label class="control-label" for="startDate">
													Start Date
												</label>
												<input class="form-control" id="startDate" name="startDate" placeholder="Enter Start Date" type="date" required>
											</div>
											<div class="col-md-6">
												<label class="control-label" for="endDate">
													End Date
												</label>
												<input class="form-control" id="endDate" name="endDate" placeholder="Enter End Date" type="date" required>
											</div>
										</div>
										
										<div class="form-group">
											<div class="col-md-6">
												<label class="control-label" for="status">
													Status
												</label>
												<select class="form-control" id="status" name="status" required>
													<option value="open">open</option>
												</select>
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-12">
												<label class="control-label" for="impactedApplications">
													Choose Impacted Applications
												</label>
												<br/>
										<select tooltip="Choose Impacted Applications" multiple="true" class="form-control"
											id="impactedApplications" name="impactedApplications" required>
											<s:iterator var = "application" value="applications">
												<option value="${application.applicationId}">${application.applicationName}</option>
											</s:iterator>
										</select>
									</div>
										</div>
								</div>
							</div>
							
							<div class="row clearfix">
								<div class="col-xs-12 col-sm-10 col-md-8 col-lg-8  column col-sm-offset-0 col-md-offset-1 col-lg-offset-1">
									<button type="submit" id="addNewBtn" name="save" class="btn btn-success">
										<span class="fa fa-floppy-o">
										</span>
										&nbsp;&nbsp;Save
									</button>
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
