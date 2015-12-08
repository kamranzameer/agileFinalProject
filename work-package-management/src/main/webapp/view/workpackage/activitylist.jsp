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
					</i> Activities List</div>
	                </div>
	                <div style="padding-top:30px"; class="panel-body">
						<div class="row clearfix">
							<div id="academicDiv" class="table-responsive col-xs-12 col-sm-12 col-md-11 col-lg-11">
								<table class="table table-striped table-hover" id="academicsTable">
									<thead>
										<tr>
											<td colspan="6" align="right">
												<a href="newActivity.action" class="btn btn-success">New</a>
											</td>
										</tr>
										<tr>
											<th>
												Activity Desc
											</th>
											<th>
												Activity Type
											</th>
											<th>
												Start Date
											</th>
											<th>
												End Date
											</th>
											<th>
												Total Hours
											</th>
											<th>
												Total Estimate
											</th>
										</tr>
									</thead>
									<tbody>
										<%-- <s:iterator var = "activity" value="activitys"> --%>
											<tr>
												<td>
													Web service interface
												</td>
												<td>
													On-boarding
												</td>
												<td>
													2015-10-12
												</td>
												<td>
													2015-11-12
												</td>
												<td>
													20
												</td>
												<td>
													1000
												</td>
											</tr>
											<tr>
												<td>
													New UI to upload file 
												</td>
												<td>
													Development
												</td>
												<td>
													2015-10-12
												</td>
												<td>
													2015-11-12
												</td>
												<td>
													50
												</td>
												<td>
													2000
												</td>
											</tr>
										<%-- </s:iterator>	 --%>
										

										
										<tr><td colspan="6"/></tr>
										<tr><td colspan="6"/></tr>
										<tr><td colspan="6"/></tr>
										
										<tr>
											<td colspan="6" align="right">
												<a href="newActivity.action" class="btn btn-success">New</a>
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

</div>
