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
					</i> Work Request Estimation</div>
	                </div>
	                <div style="padding-top:30px"; class="panel-body">
						<form id="employerContactInforForm" class="form-horizontal" role="form" method="post" action="employercontactinfotab.jsp">
							<div class="row clearfix">
								<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8  column col-sm-offset-0 col-md-offset-1 col-lg-offset-1">
										<div class="form-group">
											<div class="col-md-6">
												<label class="control-label" for="contactFirstName">
													Full Name
												</label>
												<input class="form-control" id="contactFirstName" placeholder="Enter full name" >
											</div>
											<div class="col-md-6">
												<label class="control-label" for="email">
													Email
												</label>
												<input class="form-control" id="email" placeholder="Enter email address" type="email">
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-12">
												<label class="control-label" for="addressLine1">
													Address Line 1
												</label>
												<input class="form-control" id="addressLine1" placeholder="Enter address line 1">
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-12">
												<label class="control-label" for="addressLine2">
													Address Line 2
												</label>
												<input class="form-control" id="addressLine2" placeholder="Enter address line 2">
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-6">
												<label class="control-label" for="city">
													City
												</label>
												<input class="form-control" id="city" placeholder="Enter city">
											</div>
											<div class="col-md-3">
												<label class="control-label" for="state">
													State
												</label>
												<select class="form-control" id="state">
													<option>
														AZ
													</option>
													<option>
														VA
													</option>
													<option>
														NY
													</option>
													<option>
														OH
													</option>
												</select>
											</div>
											<div class="col-md-3">
												<label class="control-label" for="zipCode">
													Zip Code
												</label>
												<input class="form-control" id="zipCode" placeholder="Enter zip">
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-5">
												<label class="control-label" for="phoneNumber">
													Phone Number
												</label>
												<input class="form-control" id="phoneNumber" placeholder="Enter Phone Number">
											</div>
											<div class="col-md-5">
												<label class="control-label" for="faxNumber">
													Fax Number
												</label>
												<input class="form-control" id="faxNumber" placeholder="Enter Fax Number">
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-10">
												<label class="control-label" for="website">
													Website
												</label>
												<input class="form-control" id="website" placeholder="Enter business website URL">
											</div>
										</div>
								</div>
							</div>
							<div class="row clearfix">
								<div class="col-xs-12 col-sm-10 col-md-8 col-lg-8  column col-sm-offset-0 col-md-offset-1 col-lg-offset-1">
									<button type="button" id="addNewBtn" class="btn btn-success" onclick="workPackageManagement.submitForm('employerContactInforForm');">
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
