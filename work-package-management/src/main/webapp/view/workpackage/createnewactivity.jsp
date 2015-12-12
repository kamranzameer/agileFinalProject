<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script>


$(document).ready(function() {
	
	//Handle add row button click
    $( "#addRowBtn" ).click(function() {   
    	//remove any previously displayed required field alerts 
    	$('#effort').next(".red").remove();
    	
    	//capture resource type details
        var str = $("#resourceTypeId").val().split(":");
    	
    	//capture resource effort
        var effort = $("#effort").val();
        if(effort.length == 0){
            $('#effort').after('<div class="red" style="color:red">Effort is Required</div>');
        }
        else
        {
        	//get currently displayed total cost value and update with new effort
	        var cost = eval(effort * str[2]);
	        var currentTotalCost = $("#totalcostitem").html();
	        if(currentTotalCost.length > 0)
	        {
	        	currentTotalCost = currentTotalCost.substring(1);
	        	currentTotalCost = parseInt(currentTotalCost,10)
	        }
	        
	        var totalCost = eval(cost + currentTotalCost);
	        $("#totalcostitem").html("$"+totalCost);
	        
	        //contruct new row for the table
	        var table = document.getElementById('resourcesTable');
	        var rowCount = table.rows.length;
	
	        var row = table.insertRow(rowCount);
	        row.id = "row"+rowCount;
	        var counts=rowCount-1;
			
	        //resource type name
	        var cell1 = row.insertCell(0);
	        var item = document.createElement("label");
	        item.name="activityPhaseResourcesDTOs["+counts+"].resourceTypeName";
	        item.innerHTML = str[1];
	        item.readonly = true;
	        cell1.appendChild(item);
	        
	     	 //Estimated effort
	        var cell2 = row.insertCell(1);
	        var item = document.createElement("label");
	        //item.type = "text";
	        item.name="activityPhaseResourcesDTOs["+counts+"].estimatedHours";
	        item.innerHTML = effort;
	        item.readonly = true;
	        cell2.appendChild(item);
	
	        //display cost associated with this resource
	        var cell3 = row.insertCell(2);
	        var item = document.createElement("label");
	        //item.type = "text";
	        item.name="activityPhaseResourcesDTOs["+counts+"].totalCost";
	        item.innerHTML = "$"+cost;
	        item.readonly = true;
	        cell3.appendChild(item);
	
	        //hidden field to capture resource type id
	        var cell4 = row.insertCell(3);
	        var item = document.createElement("input");
	        item.type = "hidden";
	        item.name="activityPhaseResourcesDTOs["+counts+"].resourceTypeId";
	        item.value = str[0];
	        cell4.appendChild(item);
	
	        //to delete rows from table
	        var cell5 = row.insertCell(4);
	        var operations = document.createElement("a");
	        operations.id = counts;
	        operations.setAttribute("href","#");
	        operations.setAttribute("data-toggle", "tooltip");
	        operations.setAttribute("title","Delete");
	        var operationsChild = document.createElement("i");
	        operationsChild.classList.add("fa");
	        operationsChild.classList.add("fa-trash");
	        operations.appendChild(operationsChild);
	        cell5.appendChild(operations);
	        
	      //hidden field to capture resource estimated hours
	        var cell6 = row.insertCell(5);
	        var item = document.createElement("input");
	        item.type = "hidden";
	        item.name="activityPhaseResourcesDTOs["+counts+"].estimatedHours";
	        item.value = effort;
	        cell4.appendChild(item);
    	}
        
        // handle remove button click
        $("#"+counts).on("click",function() {
        	
        	//get table row from where button was clicked
        	var td = $(this).parent();
            var tr = td.parent();
            
            //Update the total cost value before deleting row
            var cellCost = tr.find('td').eq(2).text().substring(1);
            cellCost = parseInt(cellCost,10);
            
            var currentTotalCost = $("#totalcostitem").html();
	        if(currentTotalCost.length > 0)
	        {
	        	currentTotalCost = currentTotalCost.substring(1);
	        	currentTotalCost = parseInt(currentTotalCost,10)
	        }
	        
	        var totalCost = eval(currentTotalCost - cellCost);

	        //change the background color to red before removing
            tr.css("background-color","#FF3700");

	        //delete the row
            tr.fadeOut(400, function(){
                tr.remove();
            });
            $("#totalcostitem").html("$"+totalCost);
        });
         
    });
			
});

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
					<div class="panel-title">
						<i class="fa fa-pencil"> </i> New Activity
					</div>
				</div>
				<div style="padding-top: 30px" ; class="panel-body">
					<form id="createactivityform" name="createactivityform"
						class="form-horizontal" role="form" method="post"
						action="saveActivity.action">
						<div class="row clearfix">
							<div
								class="col-xs-12 col-sm-12 col-md-8 col-lg-8  column col-sm-offset-0 col-md-offset-1 col-lg-offset-1">
								<div class="form-group">
									<div class="col-md-12">
										<label class="control-label" for="activityDesc">
											Activity Description </label> <input class="form-control"
											id="activityDesc" name="activityLineDTO.activityLineDesc"
											placeholder="Enter activity Description" required>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-12">
										<label class="control-label" for="activityTypeCode">
											Select Activity Type </label> <select class="form-control"
											tooltip="Select Activity Type"
											name="activityLineDTO.activityTypeCode" value="activityTypeCode"
											required>
											<s:iterator var="activityType" value="activityTypes">
												<option value="${activityType.activityTypeCode}">${activityType.activityTypeDesc}</option>
											</s:iterator>
										</select>

									</div>
								</div>
								<div class="form-group">
									<div class="col-md-6">
										<label class="control-label" for="startDate"> Start
											Date </label> <input class="form-control" id="startDate"
											name="startDate" placeholder="Enter Start Date" type="date"
											required>
									</div>
									<div class="col-md-6">
										<label class="control-label" for="endDate"> End Date </label>
										<input class="form-control" id="endDate" name="endDate"
											placeholder="Enter End Date" type="date" required>
									</div>
								</div>
							</div>
						</div>
						<hr style="border-color: #EEEEEE;" />

						<br />

						<table id="addresources" class="table table-striped table-hover">
							<tr>
								<th>Resource Type</th>
								<th>Estimated Effort</th>
								<th />
							</tr>
							<tr>
								<td><select class="form-control"
									tooltip="Select Resource Type" id="resourceTypeId"
									name="resourceTypeId" value="resourceTypeId">
										<s:iterator var="resourceType" value="resourceTypes">
											<option
												value="${resourceType.resourceTypeId}:${resourceType.resourceTypeName}:${resourceType.hourlyRate}">${resourceType.resourceTypeName}</option>
										</s:iterator>
								</select></td>
								<td><input class="form-control" type="number" id="effort"
									name="effort" /></td>
								<td>
									<button type="button" id="addRowBtn" name="addRowBtn"
										class="btn btn-success">Add</button>
								</td>
							</tr>
							<tbody>
							</tbody>
						</table>

						<hr style="border-color: #EEEEEE;" />

						<table id="resourcesTable" class="table table-striped table-hover">

							<tr>
								<th>Resource Type</th>
								<th>Estimated Effort</th>
								<th>Cost</th>
								<th />
							</tr>
							<tbody>
								<s:iterator value="activityPhaseResourcesDTOs"
									status="activityPhaseResourcesDTO">
									<tr>
									</tr>
								</s:iterator>
							</tbody>
						</table>

						<BR />
						<table id = "totalcosttable" class="table table-striped table-hover">
							<tr>
								<td colspan="3" align="right">Total Cost :</td>
								<td id = "totalcostitem" align="center" class="strong">$0</td>
							</tr>
						</table>


						<hr style="border-color: #EEEEEE;" />

						<div
							class="col-xs-12 col-sm-12 col-md-8 col-lg-8  column col-sm-offset-0 col-md-offset-1 col-lg-offset-1">
							<div class="form-group">
								<div class="col-md-12">
									<label class="control-label" for="activityDesc">
										Assumptions </label>
									<textarea name="assumptions" class="form-control" rows="5"></textarea>
								</div>
							</div>
						</div>

						<div class="row clearfix">
							<div
								class="col-xs-12 col-sm-10 col-md-3 col-lg-8  column col-sm-offset-0  col-lg-offset-2"
								align="center">
								<br />
								<button type="submit" id="addNewBtn" name="save"
									class="btn btn-success">
									<span class="fa fa-floppy-o"> </span> &nbsp;&nbsp;Save
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
