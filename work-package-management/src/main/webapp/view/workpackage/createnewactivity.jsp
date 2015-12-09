<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script>
function myFunction() {
    var table = document.getElementById("resourcesTable");
    var row = table.insertRow(-1);
    var cell1 = row.insertCell(-1);
    var cell2 = row.insertCell(-1);
    var cell3 = row.insertCell(-1);
    var cell4 = row.insertCell(-1);
    
    cell1.innerHTML = "<select name=\'ResourceType\'><option>Developer</option><option>Business Analyst</option></select>";
    cell2.innerHTML = "<input type=\"text\"/>";
    cell3.innerHTML = "$1234";
    cell4.innerHTML = "<a href=\"#\"><span class=\"glyphicon glyphicon-remove\"></span></a>";
    
}
function showModal() { 
    document.getElementById("myDialog").showModal(); 
} 
function addRow(tableID) 
{
        var table = document.getElementById(tableID);

        var rowCount = table.rows.length;
        var row = table.insertRow(rowCount);
        var counts = rowCount - 1;
		
        var cell1 = row.insertCell(0);
        var resourceType = document.createElement("select");
        resourceType.class = "form-control";
        resourceType.tooltip="Select Resource Type";
        resourceType.name="activityPhaseResourcesDTO["+counts+"].resourceTypeId";
        resourceType.value="activityPhaseResourcesDTO["+counts+"].resourceTypeId";
        
        /* var resourceTypeIterator = document.createElement("s:iterator");
        resourceTypeIterator.var =  "resourceType";
        resourceTypeIterator.value="resourceTypes"; */
        
        var selectOptions = document.createElement("option");
        selectOptions.value = "${resourceType.resourceTypeId}";
        
        resourceType.appendChild(selectOptions);
        
        var hourlyRate = document.createElement("input");
        hourlyRate.type = "hidden";
        hourlyRate.name = "activityPhaseResourcesDTO["+counts+"].hourlyRate"
        
        cell1.appendChild(resourceType);
        cell1.appendChild(hourlyRate);
        
        var cell2 = row.insertCell(1);
        var totalHours = document.createElement("input");
        totalHours.class="form-control";
        totalHours.type="text";
        totalHours.name="activityPhaseResourcesDTO["+counts+"].totalHours"
        cell2.appendChild(totalHours);
        
        var cell3 = row.insertCell(2);
        var totalCost = document.createElement("input");
        totalCost.class="form-control";
        totalCost.type="text";
        totalCost.name="activityPhaseResourcesDTO["+counts+"].totalCost"
        cell2.appendChild(totalCost);
        
        var cell4 = row.insertCell(3);
        cell2.appendChild("<a href=\"#\"><span class=\"glyphicon glyphicon-remove\"></span></a>");
        
}


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
	                    <div class="panel-title"><i class="fa fa-pencil">
					</i> New Activity</div>
	                </div>
	                <div style="padding-top:30px"; class="panel-body">
						<form id="createactivityform" name="createactivityform" class="form-horizontal" role="form" method="post" action="">
							<div class="row clearfix">
								<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8  column col-sm-offset-0 col-md-offset-1 col-lg-offset-1">
										<div class="form-group">
											<div class="col-md-12">
												<label class="control-label" for="activityDesc">
													Activity Description
												</label>
												<input class="form-control" id="activityDesc" name="activityDTO.activityDesc" placeholder="Enter activity Description" required>
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-12">
												<label class="control-label" for="activityTypeCode">
													Select Activity Type
												</label>
												<select class="form-control" tooltip="Select Activity Type" name="activityDTO.activityTypeCode" value="activityTypeCode" required>
												<s:iterator var = "activityType" value="activityTypes">
													<option value="${activityType.activityTypeCode}">${activityType.activityTypeDesc}</option>
												</s:iterator>
												</select>
												
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
								</div>
							</div>
							
							<hr style="border-color: #EEEEEE;"/>
							
							<br/>
							
							<table id="resourcesTable" class="table table-striped table-hover">
									<thead class="panel-heading">
										<tr>
											<td colspan="4" align="right">
												<a href="javascript:addRow('resourcesTable');" class="btn btn-success">+</a>
											</td>
										</tr>
										<tr>
											<th>
												Resource Type
											</th>
											<th>
												Estimated Effort
											</th>
											<th>
												Cost
											</th>
											
											<th/>
										</tr>
									</thead>
									<tbody>
										<s:iterator var = "activityPhaseResourcesDTO" value="activityPhaseResourcesDTOs">
										<tr>
										<td>
											<select class="form-control" tooltip="Select Resource Type" name="activityPhaseResourcesDTO.resourceTypeId" value="activityPhaseResourcesDTO.resourceTypeId" required>
												<s:iterator var = "resourceType" value="resourceTypes">
													<option value="${resourceType.resourceTypeId}">${resourceType.resourceTypeName}</option>
												</s:iterator>
											</select>
											<input type="hidden" name="activityPhaseResourcesDTO.hourlyRate"/>
										</td>
										<td>
											<input class="form-control" type="text" name="activityPhaseResourcesDTO.totalHours"/>
										</td>
										<td>
											<input class="form-control" type="text" readonly="true" name="activityPhaseResourcesDTO.totalCost"/>
										</td>
										<td>
											<a href=\"#\"><span class=\"glyphicon glyphicon-remove\"></span></a>
										</td>
										</tr>
										</s:iterator>
									</tbody>
									
								</table>
							
							<BR/>
							
							<table class="table table-striped table-hover">
								<tr>
									<td colspan="3" align="right">
										<b>Total Cost :</b> 
									</td>
									<td align="center">
										<b>$7178</b>
									</td>
								</tr>
							</table>
							
							<hr style="border-color: #EEEEEE;"/>
							
							<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8  column col-sm-offset-0 col-md-offset-1 col-lg-offset-1">
								<div class="form-group">
									<div class="col-md-12">
										<label class="control-label" for="activityDesc">
											Assumptions
										</label>
										<textarea name="assumptions" class="form-control" rows="5"></textarea>
									</div>
								</div>
							</div>
							
							<!-- <div class="table-responsive col-xs-12 col-sm-12 col-md-11 col-lg-11">
							
									<table id="assumptionsTable" class="table table-striped table-hover">
											<thead class="panel-heading">
												<tr>
													<td colspan="4" align="right">
														<a href="javascript:addAssumption();" class="btn btn-success">+</a>
													</td>
												</tr>
												<tr>
													<th colspan="4">
														Assumptions
													</th>
												</tr>
											</thead>
											<tbody>
											</tbody>
									</table>
							</div> -->
							
							
							
							<div class="row clearfix">
								<div class="col-xs-12 col-sm-10 col-md-3 col-lg-8  column col-sm-offset-0  col-lg-offset-2" align="center">
									<br/>
									<button type="submit" id="addNewBtn" name="save" class="btn btn-success">
										<span class="fa fa-floppy-o">
										</span>
										&nbsp;&nbsp;Save
									</button>
								</div>
							</div>
						    <div class="row clearfix">
						        <div class="col-md-10 column">
						            <p>&nbsp;</p>
						        </div>
						    </div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
