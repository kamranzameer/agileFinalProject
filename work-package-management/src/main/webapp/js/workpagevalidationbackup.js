	$('#contractFromYear').datepicker({
		format : " yyyy",
		viewMode : "years",
		minViewMode : "years",
		startDate : new Date(),
		autoclose: true
	});

	$('#contractToYear').datepicker({
		format : " yyyy",
		viewMode : "years",
		minViewMode : "years",
		startDate : new Date(),
		autoclose: true
	});

	$('#startDate').datepicker({
		format : "dd-mm-yyyy",
		startDate : new Date(),
		autoclose: true
	});

	$('#endDate').datepicker({
		format : "dd-mm-yyyy",
		startDate : new Date(),
		autoclose: true
	});

	$(document).ready(function() {
		$('#createworkpackageform').bootstrapValidator({
			framework : 'bootstrap',
			icon : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				'workPackageDTO.packageName' : {
					validators : {
						notEmpty : {
							message : 'The Package Name is required'
						},
						stringLength : {
							min : 4,
							max : 40,
							message : 'The Package Name must be more than 8 and less than 40 characters long'
						},
						regexp : {
							regexp : /^[a-zA-Z0-9\s]+$/,
							message : 'The Package Name can only consist of alphabetical, number, and space'
						}
					}
				},
				'workPackageDTO.packageDesc' : {
					validators : {
						notEmpty : {
							message : 'The Package Description is required'
						},
						regexp : {
							regexp : /^[a-zA-Z0-9\s]+$/,
							message : 'The Package Name can only consist of alphabetical, number, and space.'
						}
					}
				},
				'workPackageDTO.testingProgramCode' : {
					validators : {
						notEmpty : {
							message : 'The Testing Program is required.'
						}
					}
				},
				contractFromYear : {
					validators : {
						notEmpty : {
							message : 'The Contract From Year is required.'
						}
					}
				},
				contractToYear : {
					validators : {
						notEmpty : {
							message : 'The Contract To Year is required.'
						}
					}
				},
				'workPackageDTO.status' : {
						validators : {
							notEmpty : {
								message : 'The Status is required.'
							}
					}
				},
				startDate : {
					validators : {
						notEmpty : {
							message : 'The Start Date is required.'
						}
					}
				},
				endDate : {
					validators : {
						notEmpty : {
							message : 'The End Date is required.'
						}
					}
				},
				impactedApplication : {
					validators : {
						notEmpty : {
							message : 'The  Impacted Applications is required.'
						}
					}
				}
			}
			
		});
	});