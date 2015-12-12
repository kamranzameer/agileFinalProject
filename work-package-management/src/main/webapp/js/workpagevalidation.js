

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
				},onSuccess: function(e, data) {
						$('#createworkpackageform').bootstrapValidator('revalidateField', 'contractToYear');	
	            }
			},
			contractToYear : {
				validators : {
					notEmpty : {
						message : 'The Contract End Year is required.'
					},
					callback: {
                        message: 'Please enter valid Contract To Year',
                        callback: function(value, validator, $field) {
                            if (value === '') {
                                return true;
                            }
                            if($('#contractFromYear').val()==''){
                            	return {
                                	valid: false,
                                	message: 'Please select Contract Start Year'
                            	};
                            }
                            if(!(new Date($('#contractToYear').val()).getTime() >= new Date($('#contractFromYear').val()).getTime())) {
                            	return {
                            		valid:false,
                            		message: 'Contract End Year cannot be prior to start year'
                            	};
                            }
                            return true;
                        }
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
				},onSuccess: function(e, data) {
						$('#createworkpackageform').bootstrapValidator('revalidateField', 'endDate');	
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
			},
			impactedApplications : {
				validators : {
					notEmpty : {
						message : 'The  Impacted Applications is required.'
					}
				}
			}
		}
		
	});
});
