<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- This is the result page. You can use Struts tags here, 
the generated HTML will be appended to the target div. -->

<table id="resourcesTable" class="table table-striped table-hover">
	<thead class="panel-heading">
		<tr>
			<td colspan="4" align="right">
				<!-- <a id="addrow" href="javascript:addRow('resourcesTable');" class="btn btn-success">+</a> -->
				<button type="submit" id="addRowBtn" name="save"
					class="btn btn-success">+</button>
			</td>
		</tr>
		<tr>
			<th>Resource Type</th>
			<th>Estimated Effort</th>
			<th>Cost</th>

			<th />
		</tr>
	</thead>
	<tbody>
		<s:set var="counter" value="0"/>
		<s:iterator var="activityPhaseResourcesDTO"
			value="activityPhaseResourcesDTOs">
			<tr>
				<td><select class="form-control" tooltip="Select Resource Type"
					name="activityPhaseResourcesDTO.resourceTypeId"
					value="activityPhaseResourcesDTO.resourceTypeId" required onchange="javascript:resourcetypechanged(${counter})">
						<s:iterator var="resourceType" value="resourceTypes">
							<option value="${resourceType.resourceTypeId}">${resourceType.resourceTypeName}</option>
						</s:iterator>
				</select> <input type="hidden" name="activityPhaseResourcesDTO.hourlyRate" value="${resourceType.hourlyRate}" />
				</td>
				<td><input class="form-control" type="text" id="hours"+"${counter}"
					name="activityPhaseResourcesDTO.totalHours" onchange="javascript:hourschanged(this)" /></td>
				<td><input class="form-control" type="text" readonly="true"
					name="activityPhaseResourcesDTO.totalCost" /></td>
				<td><a href=\"#\"><span class=\ "glyphiconglyphicon-remove\"></span></a>
				</td>
			</tr>
			<s:set var="counter" value="%{#counter+1}"/>
		</s:iterator>
	</tbody>

</table>