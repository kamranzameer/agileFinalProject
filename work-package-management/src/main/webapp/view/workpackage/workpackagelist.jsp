<%@ taglib prefix="s" uri="/struts-tags" %>

<script>
$(function () {
  $('[data-toggle="tooltip"]').tooltip()
})
</script>

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
	                    <div class="panel-title"><i class="fa fa-windows">
					</i> Work Packages List</div>
	                </div>
	                
	                <br/>
	                <br/>
	                <br/>
	                
					 
	                <div style="padding-top:30px"; class="panel-body">
	                
	                	<div class="accordion" id="inneraccordion">
						  <div class="accordion-group">
						    <div class="accordion-heading">
						      <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#inneraccordion" href="#innercollapse">
						         Search Filter
						      </a> 
						    </div>
						    <div id="innercollapse" class="accordion-body collapse">
						      <div class="accordion-inner">
								<!--  ------------------------------------------------------------------------------------------->
								
								<div style="padding-top:30px"; class="panel-body">
						<form id="workPackageListForm" name="createworkpackageform" class="form-horizontal" role="form" method="post" action="workPackageList.action">
							<div class="row clearfix">
								<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8  column col-sm-offset-0 col-md-offset-1 col-lg-offset-1">
										<div class="form-group">
											<div class="col-md-6">
												<label class="control-label" for="packageName">
													Package Name
												</label>
												<input class="form-control" id="packageName" name="workPackage.packageName" value="" placeholder="Enter package name">
											</div>
											<div class="col-md-6">
												<label class="control-label" for="packageDesc">
													Package Description
												</label>
												<input class="form-control" id="packageDesc" name="workPackage.packageDesc" value="" placeholder="Enter package description" type="text" >
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-6">
												<label class="control-label" for="testingProgramCode">
													Select Testing Program
												</label>
												<select id="testingProgram" class="form-control" tooltip="Select Test Program" name="workPackage.testingProgramCode" value="" placeholder="testingProgramCode" >
												<option value="">---Select---</option>
												<s:iterator var = "testProgram" value="testPrograms">
												<option value="${testProgram.testingProgramCode}">${testProgram.testingProgramDesc}</option>
											</s:iterator>
												</select>
											</div>
											<div class="col-md-6">
												<label class="control-label" for="requestor">
													Requestor
												</label>
												
												<input class="form-control" id="packageDesc" name="workPackage.requestorName" value="" placeholder="Enter Requester Name" type="text" >
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-6">
												<label class="control-label" for="contractFromYear">
													Contract Start Year
												</label>
											
												<input class="form-control" id="contractFromYear" name="contractFromYear" value="" placeholder="Enter Contract Start Year" type="date">
											</div>		
				
						
											<div class="col-md-6">
												<label class="control-label" for="contractToYear">
													Contract End Year
												</label>
												<input class="form-control" id="contractToYear" name="contractToYear" value="" placeholder="Enter Contract End Year" type="date">
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-6">
												<label class="control-label" for="startDate">
													Start Date
												</label>
												<input class="form-control" id="startDate" name="startDate" value="" placeholder="Enter Start Date" type="date">
											</div>
											<div class="col-md-6">
												<label class="control-label" for="endDate">
													End Date
												</label>
												<input class="form-control" id="endDate" name="endDate"  value="" placeholder="Enter End Date" type="date">
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-6">
												<label class="control-label" for="status">
													Status
												</label>
												<select class="form-control" id="status" name="workPackage.status" >
													<option value="">---Select---</option>
													<s:iterator var = "statuss" value="statuses">
													<option value="${statuss}">${statuss}</option>
													</s:iterator>
												</select>
											</div>
										</div>
										
								</div>
							</div>
							
							<div class="row clearfix">
								<div class="col-xs-12 col-sm-10 col-md-8 col-lg-8  column col-sm-offset-0 col-md-offset-1 col-lg-offset-1">
								
								
								
								<button type="submit" id="addNewBtn" name="save" class="btn btn-success" >
										<span class="fa fa-floppy-o">
										</span>
										&nbsp;&nbsp;Search
								</button>
									
								</div>
							</div>
						    
						</form>
					</div>
								
								<!-- --------------------------------------------------------------------------------------------- -->
						      </div>
						    </div>
						  </div>
						 </div>
						 
						<div class="row clearfix">
							<div id="academicDiv" class="table-responsive col-xs-12 col-sm-12 col-md-11 col-lg-11">
								<table class="table table-striped table-hover" id="academicsTable">
									<thead>
										<tr>
											<td colspan="6" align="right">
												<a href="newWorkPackage.action" class="btn btn-success">New</a>
											</td>
										</tr>
										<tr>
											<th>
												Package Name
											</th>
											<th>
												Created Date
											</th>
											<th>
												# of Applications
											</th>
											<th>
												Total Estimate Received
											</th>
											<th>
												Status
											</th>
											<th>
												Actions
											</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator var = "wp" value="workPackages">
											<tr>
												<td>
													${wp.packageName}
												</td>
												<td>
													${wp.startDate}
												</td>
												<td>
													${wp.totalApplications}
												</td>
												<td>
													$<s:property value="getText('{0,number,#,##0.00}',{#wp.totalCost})"/>
												</td>
												<td>
													${wp.status}
												</td>
												<td>
													<a href="workPackageDetail.action?workPackageId=${wp.packageId}" data-toggle="tooltip" title="View"><i class="fa fa-eye">&nbsp;</i></a>
													<a href="editWorkPackage.action?workPackageId=${wp.packageId}" data-toggle="tooltip" title="Edit"><i class="fa fa-keyboard-o">&nbsp;</i></a>
													<a href="#" data-toggle="tooltip" title="Comming Soon..."><i class="fa fa-trash">&nbsp;</i></a>
												</td>
											</tr>
										</s:iterator>	
										

										
										<tr><td colspan="6"/></tr>
										<tr><td colspan="6"/></tr>
										<tr><td colspan="6"/></tr>
										
										<tr>
											<td colspan="6" align="right">
												<a href="newWorkPackage.action" class="btn btn-success">New</a>
											</td>
										</tr>


									</tbody>
								</table>
							</div>
						</div>
					    <div class="row clearfix">
					        <div class="col-md-10 column">
					            <p>&nbsp</p>
					        </div>
					    </div>
					</div>
			</div>
		</div>
	</div>

	<div id="modaldiv" hidden="true">
			<div class="modal fade" id="addNewAcademic" tabindex="-100" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<form id="saveAcademic" class="form-horizontal" role="form" method="post" action="candidateacademicstab.jsp">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
								×
							</button>
							<h4 class="modal-title">
									<i class="fa fa-graduation-cap"></i>
								Add Academic Record
							</h4>
						</div>
						<div class="modal-body col-md-offset-1">
							<div class="form-group">
								<div class="col-md-10">
									<label class="control-label" for="schoolName">
										School Attended
									</label>
									<input class="form-control input-sm" id="schoolName" placeholder="School name">
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-6">
									<label class="control-label" for="courseTitle">
										Title
									</label>
									<input class="form-control input-sm" id="courseTitle" placeholder="Course title">
								</div>
								<div class="col-md-4">
									<label class="control-label" for="degreeReceived">
										Degree/Certificate Received
									</label>
									<select class="form-control input-sm" id="degreeReceived">
										<option value="">
										</option>
										<option value="1">
											Graduate
										</option>
										<option value="2">
											Post Graduate
										</option>
										<option value="3">
											PhD
										</option>
										<option value="4">
											High School
										</option>
									</select>
								</div>
							</div>
							<div class="form-group daterange">
								<div class="col-md-5">
									<label class="control-label" for="dateAttendedStart">
										Dates Attended
									</label>
									<div class="input-group startdate date">
										<input type="text" class="form-control input-sm" placeholder="Select start date" id="dateAttendedStart">
										<span class="input-group-addon input-sm">
											<i class="glyphicon glyphicon-calendar">
											</i>
										</span>
									</div>
								</div>
								<div class="col-md-5">
									<label class="control-label" for="dateAttendedEnd">
										&nbsp;
									</label>
									<div class="input-group enddate date">
										<input type="text" class="form-control input-sm" placeholder="Select end date" id="dateAttendedEnd">
										<span class="input-group-addon input-sm">
											<i class="glyphicon glyphicon-calendar">
											</i>
										</span>
									</div>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-warning" data-dismiss="modal">
								<span class="fa fa-undo">
								</span>
								&nbsp;&nbsp;Cancel
							</button>
							<button type="button" id="addNewBtn" class="btn btn-success" >
								<span class="fa fa-floppy-o">
								</span>
								&nbsp;&nbsp;Save
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

