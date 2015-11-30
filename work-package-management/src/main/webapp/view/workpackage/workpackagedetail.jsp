<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-10 column">
            <p>&nbsp</p>
        </div>
    </div>
	<div class="row clearfix">
		<div class="col-sm-9 column col-sm-offset-1">
	            <div class="panel panel-info">
	                <div class="panel-heading">
	                    <div class="panel-title"><i class="fa fa-pencil">
					</i> Work Package Detail</div>
	                </div>
	                <div style="padding-top:30px"; class="panel-body">
						<form id="workPackageDetail" class="form-horizontal" role="form" method="post" action="workPackageList.action">
							<div class="row clearfix">
								<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8  column col-sm-offset-0 col-md-offset-1 col-lg-offset-1">
										<div class="form-group">
											<div class="col-md-12">
													<strong>
														Package Name:
													</strong>${workPackage.packageName}
											</div>
											
											<div class="col-md-12">
													<strong>
														Package Description:
													</strong>${workPackage.packageDesc}
											</div>
											<div class="col-md-12">
													<strong>
														Testing Program:
													</strong>${workPackage.testingProgramCode}
											</div>
											<div class="col-md-12">
													<strong>
														Requester Name:
													</strong>${workPackage.requestorName}
											</div>
											
											
											<div class="col-md-12">
													<strong>
														Contract Start Date:
													</strong>${workPackage.contractFromYear}
											</div>
											
											<div class="col-md-12">
													<strong>
														Contract End Date:
													</strong>${workPackage.contractToYear}
											</div>
											
											<div class="col-md-12">
													<strong>
														Start Date:
													</strong>${workPackage.startDate}
											</div>
											
											<div class="col-md-12">
													<strong>
														End Date:
													</strong>${workPackage.endDate}
											</div>
											
											
											<div class="col-md-12">
													<strong>
														Status:
													</strong>${workPackage.status}
											</div>
											
											<div class="col-md-12">
													<strong>
														Total Applications:
													</strong>${workPackage.totalApplications}
											</div>
											
											
											<div class="col-md-12">
													<strong>
														Total Cost:
													</strong>${workPackage.totalCost}
											</div>
											
											
											<div class="col-md-12">
													&nbsp;
											</div>
											
											<div class="col-md-12">
													&nbsp;
											</div>
											
											
											<h4>Work Requests</h4>
											
											
											<div class="accordion" id="accordion2">
											
											
											<s:iterator var = "workRequest" value="workRequests">
												  <div class="accordion-group">
												    <div class="accordion-heading">
												      <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion2" href="#collapse${workRequest.workRequestId}">
												       (+) ${workRequest.applicationName}, Total Hours : ${workRequest.totalHours}, Total Cost : ${workRequest.totalCost}
												      </a>
												    </div>
												    <div id="collapse${workRequest.workRequestId}" class="accordion-body collapse">
												      <div class="accordion-inner">
												      		<!-- ----------------------------start inner------------------------ -->
												      		<s:iterator var = "activityLine" value="#workRequest.activityLineDTOs">
												      			<div class="row clearfix">
														      		<div class="col-sm-12 column col-sm-offset-1">
															      		<div class="accordion" id="inneraccordion${activityLine.activityLineId}">
																		  <div class="accordion-group">
																		    <div class="accordion-heading">
																		      <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#inneraccordion${activityLine.activityLineId}" href="#innercollapse${activityLine.activityLineId}">
																		        ${activityLine.activityLineDesc}: Total Hours = ${activityLine.totalHours}, Total Cost: ${activityLine.totalCost}
																		      </a>
																		    </div>
																		    <div id="innercollapse${activityLine.activityLineId}" class="accordion-body collapse">
																		      <div class="accordion-inner">
																		        <table class="table">
																		        	<tr>
																		        		<th>Resource Type </th>
																		        		<th>Hourly Rates </th>
																		        		<th>Estimated Hours </th>
																		        		<th>Total Cost </th>
																		        	</tr>
																		        	<s:iterator var = "activityPhaseResource" value="#activityLine.activityPhaseResourcesDTOs">
													      					        	<tr>
																			        		<td>${activityPhaseResource.resourceTypeName} </td>
																			        		<td>${activityPhaseResource.hourlyRate} </td>
																			        		<td>${activityPhaseResource.estimatedHours} </td>
																			        		<td>${activityPhaseResource.totalCost} </td>
																			        	</tr>
																			        </s:iterator>	
																				</table>
																		      </div>
																		    </div>
																		  </div>
																		 </div> 
																	</div>	 
																</div>
															</s:iterator>	
																
																
															
												        	<!-- ---------------------end inner---------------------------- -->
	
												      </div>
												    </div>
												  </div>
											 </s:iterator>	  
											</div>	
											
											<!-- <div class="panel panel-info">
												<div class="panel-heading">
								                    <div class="panel-title"><i class="fa fa-pencil">
													</i> Work Package Detail</div>
								                </div>
								            </div> -->    
										</div>
										
								</div>
							</div>
							
							<div class="row clearfix">
								<div class="col-xs-12 col-sm-10 col-md-8 col-lg-8  column col-sm-offset-0 col-md-offset-1 col-lg-offset-1">
									<button type="submit" id="addNewBtn" name="save" class="btn btn-success">
										<span class="fa fa-arrow-left">
										</span>
										&nbsp;&nbsp;Back
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
