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
	                    <div class="panel-title"><i class="fa fa-windows">
					</i> Work Packages List</div>
	                </div>
	                <div style="padding-top:30px"; class="panel-body">
						<div class="row clearfix">
							<div id="academicDiv" class="table-responsive col-xs-12 col-sm-12 col-md-11 col-lg-11">
								<table class="table table-striped table-bordered table-hover" id="academicsTable">
									<thead>
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
												% Estiamte Received
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
										<s:iterator var = "workPackage" value="workPackages">
											<tr>
												<td>
													${workPackage.packageName}
												</td>
												<td>
													${workPackage.createDate}
												</td>
												<td>
													3
												</td>
												<td>
													2
												</td>
												<td>
													${workPackage.status}
												</td>
												<td>
													<a href="#" data-toggle="tooltip" title="View"><i class="fa fa-eye">&nbsp;</i></a>
													<a href="#" data-toggle="tooltip" title="Edit"><i class="fa fa-keyboard-o">&nbsp;</i></a>
													<a href="#" data-toggle="tooltip" title="Delete"><i class="fa fa-trash">&nbsp;</i></a>
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
							<button type="button" id="addNewBtn" class="btn btn-success" onclick="workPackageManagement.submitForm('saveAcademic', function(data) { var content = $( data ).find( '#academicsTable' ); $( '#academicDiv' ).empty().append( content );}, function() {$('#addNewAcademic').modal('hide');});">
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
