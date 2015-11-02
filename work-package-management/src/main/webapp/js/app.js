var workPackageManagement  = function() {
	var waitProgress = $('<div class="modal fade" id="waitProgress" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"><div class="modal-dialog modal-sm"><div class="modal-content"><div class="modal-header "><h5 class="modal-title" id="myModalLabel"><i class="fa fa-cog fa-spin"></i> Processing</h5></div><div class="modal-body center-block"><div class="progress" id="parent"><div id="prgbar" class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100"></div></div></div></div></div></div>');

	$( document ).ajaxComplete(function() {
		var parent = $('.daterange');
		if (parent.length > 0) {
			var startDate = parent.find('.startdate');
			var endDate = parent.find('.enddate');
			startDate.datepicker({todayBtn: "linked",  autoclose: true, todayHighlight: true});
			startDate.datepicker()
				.on('changeDate', function(e){
					endDate.datepicker('setStartDate', e.date);
			});
			endDate.datepicker({todayBtn: "linked",  autoclose: true, todayHighlight: true});
		}
		
		if ($('.datepicker').length > 0)
			$('.datepicker').datepicker({todayBtn: "linked",  autoclose: true, todayHighlight: true});
	});
	
	waitProgress.on('shown.bs.modal', function () { 
		var progress = setInterval(function() { 
			var $bar = $('#prgbar'); 
			if ($bar.width()>=250) { 
				clearInterval(progress); 
				$('#parent').addClass('progress-striped active'); 
			} else { 
				$bar.width($bar.width()+40); 
			} 
		}, 300); 
	});
		

	this.showProcessingDialog = function() {
		waitProgress.modal({show: true, backdrop: 'static'});
	};

	this.hideProcessingDialog = function() {
		var $bar = $('#prgbar'); 
		$bar.width(0);
		waitProgress.modal('hide');
	};
	
	this.submitForm = function(formid, callback, beforesubmit) {
		var formobj = $("#" + formid);
		var workPackageManagement = this;
		var responseData;
		if (beforesubmit) 
			beforesubmit();

		waitProgress.on('hidden.bs.modal', function (e) {
	  		if (callback)
	  			callback(responseData);
		});
		
	    this.showProcessingDialog();
	  	//event.preventDefault();
	  	var datastring = formobj.serialize();
	    url = formobj.attr( "action" );
	  	var posting = $.post( url, datastring );
	  	posting.done(function( data ) {
	  		responseData = data;
	  		var delay = setInterval(function() {
	  			clearInterval(delay);
		  		workPackageManagement.hideProcessingDialog();
	  		}, 5000)
	  	});
	    return false;
	}

	return this;
}


