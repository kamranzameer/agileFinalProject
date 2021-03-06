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
					 		</i> Work Request List
					 	</div>
	                </div>
	                
	                
	                <div style="padding-top:30px"; class="panel-body">
	                	<s:if test="workRequests.size >0"> <span> <strong>Application Name :</strong> <s:text name="%{workRequests[0].applicationName}"/>  </span>  </s:if>
	                	<hr style="border-color: #EEEEEE;"/>
	                	
						<div class="row clearfix">
							<div id="academicDiv" class="table-responsive col-xs-12 col-sm-12 col-md-11 col-lg-11">
								<table class="table table-striped table-hover" id="academicsTable">
									<thead>
										<tr>
										<th>
												Package Name
											</th>
											<th>
												Created Date
											</th>
											<th>
												Total Hours
											</th>
											<th>
												Total Cost
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
										<s:iterator var = "workRequest" value="workRequests">
										<tr>
											<td>
												${workRequest.workPackageName}
											</td>
											<td>
												${workRequest.startDate}
											</td>
											<td>
												${workRequest.totalHours}
											</td>
											<td>
												$<s:property value="getText('{0,number,#,##0.00}',{#workRequest.totalCost})"/>
											</td>
											<td>
												${workRequest.status}
											</td>
											<td>
												<a href="workRequestDetail.action?workRequestId=${workRequest.workRequestId}" data-toggle="tooltip" title="View"><i class="fa fa-eye">&nbsp;</i></a>
												<a href="#" data-toggle="tooltip" title="Comming Soon..."><i class="fa fa-keyboard-o">&nbsp;</i></a>
												<a href="#" data-toggle="tooltip" title="Comming Soon..."><i class="fa fa-trash">&nbsp;</i></a>
											</td>
										</tr>
										</s:iterator>

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

</div>
