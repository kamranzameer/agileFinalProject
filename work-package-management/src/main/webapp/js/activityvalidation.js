$(document).ready(function() {
	
	//Validators begin

	$('#createactivityform').bootstrapValidator({
		framework : 'bootstrap',
		icon : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			'activityLineDTO.activityLineDesc' : {
				validators : {
					notEmpty : {
						message : 'Activity Description is required'
					}
				}
			},
			startDate : {
				validators : {
					notEmpty : {
						message : 'The Start Date is required.'
					}
				},onSuccess: function(e, data) {
						$('#createactivityform').bootstrapValidator('revalidateField', 'endDate');	
	            }
			},
			endDate : {
				validators : {
					notEmpty : {
						message : 'The End Date is required.'
					},
					callback: {
                        message: 'Please enter valid end date',
                        callback: function(value, validator, $field) {
                            if (value === '') {
                                return true;
                            }
                            
                            if($('#startDate').val()==''){
                            	return {
                                valid: false,
                                message: 'Please select Start Date'
                            	};
                            }
                            if(!(new Date($('#endDate').val()).getTime() >= new Date($('#startDate').val()).getTime())) {
                            	return {
                            		valid:false,
                            		message: 'End Date cannot be prior to Start Date'
                            	};
                            }
                            return true;
                        }
                    }
				}
			}
		}
		
	});

	//Validators end
	
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
	        
	      //Estimated effort
	        var cell3 = row.insertCell(2);
	        var item = document.createElement("label");
	        //item.type = "text";
	        item.name="activityPhaseResourcesDTOs["+counts+"].hourlyRate";
	        item.innerHTML = "$"+str[2];
	        item.readonly = true;
	        cell3.appendChild(item);
	
	        //display cost associated with this resource
	        var cell4 = row.insertCell(3);
	        var item = document.createElement("label");
	        //item.type = "text";
	        item.name="activityPhaseResourcesDTOs["+counts+"].totalCost";
	        item.innerHTML = "$"+cost;
	        item.readonly = true;
	        cell4.appendChild(item);
	
	        //hidden field to capture resource type id
	        var cell5 = row.insertCell(4);
	        var item = document.createElement("input");
	        item.type = "hidden";
	        item.name="activityPhaseResourcesDTOs["+counts+"].resourceTypeId";
	        item.value = str[0];
	        cell5.appendChild(item);
	
	        //to delete rows from table
	        var cell6 = row.insertCell(5);
	        var operations = document.createElement("a");
	        operations.id = counts;
	        operations.setAttribute("href","#");
	        operations.setAttribute("data-toggle", "tooltip");
	        operations.setAttribute("title","Delete");
	        var operationsChild = document.createElement("i");
	        operationsChild.classList.add("fa");
	        operationsChild.classList.add("fa-trash");
	        operations.appendChild(operationsChild);
	        cell6.appendChild(operations);
	        
	      //hidden field to capture resource estimated hours
	        var cell7 = row.insertCell(6);
	        var item = document.createElement("input");
	        item.type = "hidden";
	        item.name="activityPhaseResourcesDTOs["+counts+"].estimatedHours";
	        item.value = effort;
	        cell7.appendChild(item);
    	}
        
        // handle remove button click
        $("#"+counts).on("click",function() {
        	
        	//get table row from where button was clicked
        	var td = $(this).parent();
            var tr = td.parent();
            
            //Update the total cost value before deleting row
            var cellCost = tr.find('td').eq(3).text().substring(1);
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