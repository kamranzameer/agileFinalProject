<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script src="../js/activityvalidation.js"></script>
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
								<th>Estimated Effort (Hours)</th>
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
								<th>Estimated Effort (Hours)</th>
								<th>Hourly Rate</th>
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
