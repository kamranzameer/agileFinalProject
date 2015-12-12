<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script>

var itemCount = 0;
$(document).ready(function() {
	
	$("#resourcesform").submit(function(e)
	{
		var postData = $(this).serializeArray();
		var formURL = $(this).attr("action");
		$.ajax(
		{
			url : formURL,
			type: "POST",
			data : postData,
			success:function(data, textStatus, jqXHR) 
			{
				$("#resourcetable").html(data);

			},
			error: function(jqXHR, textStatus, errorThrown) 
			{
				alert('error');
			}
		});
	    e.preventDefault();	//STOP default action
	    e.unbind();
	});
	
	var objs=[];
    var temp_objs=[];
     
    $( "#addRowBtn" ).click(function() {   
        var html = "";
        var str = $("#resourceTypeId").val().split(":");
        var effort = $("#effort").val();
        var cost = eval(effort * str[2]);
        
        var obj={
            "ROW_ID" : itemCount,
            "RESOURCE_TYPE_ID" : str[0],
            "RESOURCE_TYPE_NAME" : str[1],
            "HOURLY_RATE" : str[2],
            "EFFORT" : effort,
            "COST" : "$"+cost
        }   
     
        // add object
        objs.push(obj);
                     
        itemCount++;
        // dynamically create rows in the table
        html = "<tr id='tr"+ itemCount + "'><td>"+ obj['RESOURCE_TYPE_NAME'] + "</td> <td>" +  obj['EFFORT'] + " </td><td>" +  obj['COST'] + " </td><td><input type='button'  id='" + itemCount + "' value='X' class='btn btn-link'></td> </tr>";            
         
        //add to the table
        $("#resourcesTable").append(html)
         
        // The remove button click
        $("#"+itemCount).click(function() {
            var buttonId = $(this).attr("id");
            //write the logic for removing from the array
            $("#tr"+ buttonId).remove();            
        });
         
    });
			
});

function resourcetypechanged(row)
{
	//var row = row + 2;
	var table = document.getElementById("resourcesTable");
    for (var r = 1, n = table.rows.length; r < n; r++) {
        for (var c = 0, m = table.rows[r].cells.length; c < m; c++) {
            cell = table.rows[r].cells[c].innerHTML;
        }
    }
	//var table = document.getElementById("resourcesTable");
	//alert(row);
	//alert(rate);
	/*var row - table.rows[row];
	alert(row);
	/*alert(row.cells[0].value);*/
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
					<div class="panel-title">
						<i class="fa fa-pencil"> </i> New Activity
					</div>
				</div>
				<div style="padding-top: 30px" ; class="panel-body">
					<form id="createactivityform" name="createactivityform"
						class="form-horizontal" role="form" method="post" action="">
						<div class="row clearfix">
							<div
								class="col-xs-12 col-sm-12 col-md-8 col-lg-8  column col-sm-offset-0 col-md-offset-1 col-lg-offset-1">
								<div class="form-group">
									<div class="col-md-12">
										<label class="control-label" for="activityDesc">
											Activity Description </label> <input class="form-control"
											id="activityDesc" name="activityDTO.activityDesc"
											placeholder="Enter activity Description" required>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-12">
										<label class="control-label" for="activityTypeCode">
											Select Activity Type </label> <select class="form-control"
											tooltip="Select Activity Type"
											name="activityDTO.activityTypeCode" value="activityTypeCode"
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
					</form>
					<hr style="border-color: #EEEEEE;" />

					<br />

					<form id="resourcesform" name="resourcesform"
						class="form-horizontal" role="form" method="post"
						action="addRow.action">

							<table id="addresources"
								class="table table-striped table-hover">
									<tr> 
										<th>Resource Type</th>
										<th>Estimated Effort</th>
										<th />
									 </tr>
									 <tr>
									 	<td>
									 		<select class="form-control" tooltip="Select Resource Type" id="resourceTypeId"
												name="resourceTypeId" value="resourceTypeId">
												<s:iterator var="resourceType" value="resourceTypes">
													<option value="${resourceType.resourceTypeId}:${resourceType.resourceTypeName}:${resourceType.hourlyRate}">${resourceType.resourceTypeName}</option>
												</s:iterator>
											</select>
									 	</td>
									 	<td>
									 		<input class="form-control" type="text" id="effort" name="effort"/>
										</td>
										<td>
											<button type="button" id="addRowBtn" name="addRowBtn"
												class="btn btn-success">Add</button>
										</td>
									 </tr>
								<tbody>
								</tbody>
							</table>
							
							<hr style="border-color: #EEEEEE;" />
							
							<table id="resourcesTable"
								class="table table-striped table-hover">
								
									<tr> 
										<th>Resource Type</th>
										<th>Estimated Effort</th>
										<th>Cost</th>

										<th />
									 </tr>
								<tbody>
								</tbody>
							</table>

						<BR />
						<table class="table table-striped table-hover">
							<tr>
								<td colspan="3" align="right"><b>Total Cost :</b></td>
								<td align="center"><b>$7178</b></td>
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
					</form>
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
					<!-- </form> -->
				</div>
			</div>
		</div>
	</div>
</div>
