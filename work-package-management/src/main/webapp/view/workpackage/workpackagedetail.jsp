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
											
											
									
											<div class="row">
											       <div class="col-md-6">
											              <strong> Status: </strong>
											       </div>
											       <div class="col-md-6">
											              <s:select class="form-control" id="status"
											                     cssStyle="min-width:150px; color:black"
											                     value="%{workPackage.status}" list="statuses"
											                     name="workPackageDTO.status">
											              </s:select>
											       </div>
											</div>


											
											<div class= "row">
												<div class="col-md-6">
														<strong>
															Total Applications:
														</strong>
												</div>
												<div class="col-md-6">
													${workPackage.totalApplications}
											</div>
											</div>
											
											
											<div class= "row">
												<div class="col-md-6">
														<strong>
															Total Cost:
														</strong>
												</div>
												<div class="col-md-6">
													$<s:property value="getText('{0,number,#,##0.00}',{workPackage.totalCost})"/>
											</div>
											</div>
											
											 <br/>
							                <div class= "row" align="center">
								                <a href="javascript:updateStatus()" class="btn btn-success">Save</a>
							                </div>
											
											<hr style="border-color: #EEEEEE;"/>
											
											
											<h4>Work Requests</h4>
											
											
											<div class="accordion" id="accordion2">
											
											
											<s:iterator var = "workRequest" value="workRequests">
												  <div class="accordion-group">
												    <div class="accordion-heading">
												      <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion2" href="#collapse${workRequest.workRequestId}">
												       (+) ${workRequest.applicationName}
												      </a>, <strong>Total Hours : </strong>${workRequest.totalHours}, <strong>Total Cost :</strong> 
												      	$<s:property value="getText('{0,number,#,##0.00}',{#workRequest.totalCost})"/>
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
																		        (+)${activityLine.activityLineDesc},
																		      </a>
																		       <strong>Total Hours:</strong> ${activityLine.totalHours}, <strong>Total Cost:</strong>
																		       $<s:property value="getText('{0,number,#,##0.00}',{#activityLine.totalCost})"/> 
																		       	
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
																			        		<td>
																			        			$<s:property value="getText('{0,number,#,##0.00}',{#activityPhaseResource.hourlyRate})"/> 
																			        		</td>
																			        		<td>${activityPhaseResource.estimatedHours} </td>
																			        		<td>
																			        			$<s:property value="getText('{0,number,#,##0.00}',{#activityPhaseResource.totalCost})"/> 
																			        		</td>
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
	<script>
       
       function updateStatus() {
              if('${workPackage.status}' != $('#status').val()) {
                     window.location='updateWorkPackageStatus.action?workPackageId=${workPackage.packageId}&status='+$('#status').val();  
              } else {
                     alert('Please update status.')
              }
              
       }
       </script>

	
