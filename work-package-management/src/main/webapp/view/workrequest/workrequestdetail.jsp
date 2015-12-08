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
						<form id="workPackageDetail" class="form-horizontal" role="form" method="post" action="workRequestList.action">
							<div class="row clearfix">
								<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8  column col-sm-offset-0 col-md-offset-1 col-lg-offset-1">
										<div class="form-group">
										
											<div class= "row">
												<div class="col-md-6">
														<strong>
															Work Request Name:
														</strong>
												</div>
												
												<div class="col-md-6">
														${workRequest.applicationName}
												</div>
											</div>
											
											
											<div class= "row">
												<div class="col-md-6">
														<strong>
															Total Hours:
														</strong>
												</div>
												
												<div class="col-md-6">
														${workRequest.totalHours}
												</div>
											</div>
											
											<div class= "row">
												<div class="col-md-6">
														<strong>
															Total Cost :
														</strong>
												</div>
												
												<div class="col-md-6">
														${workRequest.totalCost}
												</div>
											</div>
											
											<div class= "row">
												<div class="col-md-6">
														<strong>
															Request Status:
														</strong>
												</div>
												<div class="col-md-6">
														${workRequest.status}
												</div>
											</div>
											
											<hr style="border-color: #EEEEEE;"/>
											
											

											<div class= "row">
												<div class="col-md-6">
														<strong>
															Package Name:
														</strong>
												</div>
												
												<div class="col-md-6">
														${workPackage.packageName}
												</div>
											</div>	
											
											<div class= "row">
												<div class="col-md-6">
														<strong>
															Package Description:
														</strong>
												</div>
												<div class="col-md-6">
														${workPackage.packageDesc}
												</div>
											</div>
											
											<div class= "row">
												<div class="col-md-6">
														<strong>
															Testing Program:
														</strong>
												</div>
												<div class="col-md-6">
														${workPackage.testingProgramCode}
												</div>
											</div>
											
											<div class= "row">
												<div class="col-md-6">
														<strong>
															Requester Name:
														</strong>
												</div>
												<div class="col-md-6">
														${workPackage.requestorName}
												</div>
											</div>
											
											
											<div class= "row">
												<div class="col-md-6">
														<strong>
															Contract Start Date:
														</strong>
												</div>
												<div class="col-md-6">
														${workPackage.contractFromYear}
												</div>
											</div>
											
											<div class= "row">
												<div class="col-md-6">
														<strong>
															Contract End Date:
														</strong>
												</div>
												<div class="col-md-6">
														${workPackage.contractToYear}
												</div>
											</div>
											
											<div class= "row">
												<div class="col-md-6">
														<strong>
															Start Date:
														</strong>
												</div>
												<div class="col-md-6">
														${workPackage.startDate}
												</div>
											</div>
											
											<div class= "row">
												<div class="col-md-6">
														<strong>
															End Date:
														</strong>
												</div>
												<div class="col-md-6">
														${workPackage.endDate}
												</div>
											</div>
											
											
											<div class= "row">
												<div class="col-md-6">
														<strong>
															Package Status:
														</strong>
												</div>
												<div class="col-md-6">
														${workPackage.status}
												</div>
											</div>
											
											
											
											<hr style="border-color: #EEEEEE;"/>
											
											
											
											
											<h4>Details</h4>
											
											
												      		<!-- ----------------------------start inner------------------------ -->
															      		<div class="accordion" id="inneraccordion${workRequest.workRequestId}">
															      		<s:iterator var = "activityLine" value="workRequest.activityLineDTOs">
																		  <div class="accordion-group">
																		    <div class="accordion-heading">
																		      <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#inneraccordion${activityLine.activityLineId}" href="#innercollapse${activityLine.activityLineId}">
																		        (+)${activityLine.activityLineDesc},
																		      </a>
																		       <strong>Total Hours:</strong> ${activityLine.totalHours}, <strong>Total Cost:</strong> ${activityLine.totalCost}
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
									
									<a href="newActivity.action" class="btn btn-success">New</a>
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
