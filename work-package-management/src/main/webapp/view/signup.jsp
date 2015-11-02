<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8">
    <title>Work Pacakge Management</title>
    <link href="../css/glyphicon.css" rel="stylesheet">
    <link href="../css/theme1/bootstrap.css" rel="stylesheet">
    <link href="../css/theme1/user.css" rel="stylesheet">
	<link href="../css/font-awesome.min.css" rel="stylesheet">
	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/app.js"></script>
	<script>
		workPackageManagement = workPackageManagement();
	</script>
</head>
<body>
<div class="container">
    <div id="signupbox" style="margin-top:50px" class="mainbox col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Sign Up</div>
            </div>
            <div style="margin-left: 35px; margin-right: 35px" class="panel-body" >
                <form id="signupform" class="form-horizontal" role="form">
					<div class="form-group row">
				        <div class="col-md-3 text-right column">
							<label class="control-label" for="inputIcon">User Id</label>
						</div>
				        <div class="col-md-8">
							<div class="input-group input-group-md">
								<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
								<input id="userId" type="text" class="form-control input-md" placeholder="Enter desired user id">
							</div>
						</div>
					</div>

					<div class="form-group row">
				        <div class="col-md-3 text-right column">
							<label class="control-label" for="inputIcon">Password</label>
						</div>
				        <div class="col-md-8 column">
							<div class="input-group input-group-md">
								<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
								<input id="password" type="password" class="form-control input-md" placeholder="Enter password">
							</div>
						</div>
					</div>

					<div class="form-group row">
				        <div class="col-md-3 text-right column">
							<label class="control-label" for="inputIcon">Confirm Password</label>
						</div>
				        <div class="col-md-8 column">
							<div class="input-group input-group-md">
								<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
	                            <input type="password" class="form-control" id="confirmPassword" placeholder="Confirm password">
							</div>
						</div>
					</div>

					<div class="form-group row">
				        <div class="col-md-3 text-right column">
							<label class="control-label" for="inputIcon">Security Question</label>
						</div>
				        <div class="col-md-8 column">
							<div class="input-group input-group-md">
								<span class="input-group-addon"><i class="fa fa-question">&nbsp;&nbsp;</i></span>
	                            <select class="form-control" id="securityQuestion">
									<option value="1">What is your first car?</option>
									<option value="2">What is you mother's maider name'?</option>
									<option value="3">Where were you born?</option>
									<option value="4">What is father's middle name'?</option>
								</select>
							</div>
						</div>
					</div>

					<div class="form-group row">
				        <div class="col-md-3 text-right column">
							<label class="control-label" for="inputIcon">Answer</label>
						</div>
				        <div class="col-md-8">
							<div class="input-group input-group-md">
								<span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
								<input id="securityAnswer" type="text" class="form-control input-md" placeholder="Answer security question">
							</div>
						</div>
					</div>


                    <div class="form-group">
                        <div class="col-md-12 control">
                            <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%">
                                <div class="col-sm-12 col-sm-offset-4 controls">
                                    <button id="signupBtn" type="button" class="btn btn-success" onclick="workPackageManagement.submitForm('signupform', function(data) {location.href='../index.jsp'});"><span class="glyphicon glyphicon-ok-sign"></span>&nbsp;&nbsp;Sign Up</button>
                                    &nbsp;
                                    <button id="cancelBtn" type="button" class="btn btn-danger" onclick="window.location = '../index.jsp';" ><span class="glyphicon glyphicon-remove-sign"></span>&nbsp;&nbsp;Cancel</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
