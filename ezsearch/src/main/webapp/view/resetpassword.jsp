<!DOCTYPE html>
<html>
<head lang="en">
    <link href="../css/glyphicon.css" rel="stylesheet">
    <link href="../css/theme1/bootstrap.css" rel="stylesheet">
    <link href="../css/theme1/user.css" rel="stylesheet">
	<link href="../css/font-awesome.min.css" rel="stylesheet">
	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/app.js"></script>
	<script>
		ezsearch = ezsearch();
	</script>
</head>
<body>
	<div class="container">
	    <div class="row clearfix">
	        <div class="col-md-12 column">
	            <p></p>
	        </div>
	    </div>
	    <div class="row clearfix">
	        <div class="col-md-12 column">
	            <p></p>
	        </div>
	    </div>
	    <div class="row clearfix">
	        <div class="col-md-12 column">
	            <p></p>
	        </div>
	    </div>
	    <div class="row clearfix">
	        <div class="col-md-2 column">
	        </div>
	        <div class="col-md-7 column">
	            <div class="panel panel-info">
	                <div class="panel-heading">
	                    <div class="panel-title">Forgot Password</div>
	                </div>
	                <div style="padding-top:30px;" class="panel-body">
	                    <!-- <form name="resetpwdform" class="form-horizontal" role="form" method="post" action="resetpassword.jsp"> -->
	                    <form name="resetpwdform" class="form-horizontal" role="form" method="post" action="resetpassword.jsp">
	                    
							<div class="form-group row">
						        <div class="col-md-4 text-right column">
									<label class="control-label" for="inputIcon">User Id</label>
								</div>
						        <div class="col-md-6">
									<div class="input-group input-group-md">
										<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
										<input id="userId" type="text" class="form-control input-md" placeholder="Enter user id">
									</div>
								</div>
							</div>

							<div class="form-group row">
						        <div class="col-md-4 text-right column">
									<label class="control-label" for="inputIcon">Security Question</label>
								</div>
						        <div class="col-md-6 column">
									<div class="input-group input-group-md">
									<label class="control-label" for="inputIcon">What is your favorite book?</label>
									</div>
								</div>
							</div>

							<div class="form-group row">
						        <div class="col-md-4 text-right column">
									<label class="control-label" for="inputIcon">Answer</label>
								</div>
						        <div class="col-md-6">
									<div class="input-group input-group-md">
										<span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
										<input id="securityAnswer" type="text" class="form-control input-md" placeholder="Answer">
									</div>
								</div>
							</div>

							<div class="form-group row">
						        <div class="col-md-4 text-right column">
									<label class="control-label" for="inputIcon">New Password</label>
								</div>
						        <div class="col-md-6">
									<div class="input-group input-group-md">
										<span class="input-group-addon"><i class="glyphicon glyphicon-eye-close"></i></span>
										<input id="newPassword" type="password" class="form-control input-md" placeholder="Enter new password">
									</div>
								</div>
							</div>

							<div class="form-group row">
						        <div class="col-md-4 text-right column">
									<label class="control-label" for="inputIcon">Confirm New Password</label>
								</div>
						        <div class="col-md-6">
									<div class="input-group input-group-md">
										<span class="input-group-addon"><i class="glyphicon glyphicon-eye-close"></i></span>
										<input id="confirmNewPassword" type="password" class="form-control input-md" placeholder="Confirm new password">
									</div>
								</div>
							</div>

							<div class="form-group row">
		                        <div class="col-sm-12 col-md-offset-4 controls">
									<button type="button" id="addNewBtn" class="btn btn-success" onclick="ezsearch.submitForm('resetpwdform', function(data) {location.href='../index.jsp'});"></span>&nbsp;&nbsp;Reset
		                                Password
									</button>
								</div>
							</div>
							<div class="form-group row">
						        <div class="col-md-12">

								</div>
							</div>
						</form>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
</body>
</html>
