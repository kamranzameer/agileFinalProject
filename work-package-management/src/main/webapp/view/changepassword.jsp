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
        <div class="col-md-5 column col-md-offset-1">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <div class="panel-title"><i class="fa fa-keyboard-o"></i> Change Password</div>
                </div>
                <div style="padding-top:30px; margin-left: 50px; margin-right: 50px" class="panel-body">
                    <form name="changePasswordForm" class="form-horizontal" role="form" method="post" action="changepassword.jsp">
                        <div style="margin-bottom: 25px" class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                            <input type="password" class="form-control" id="currentPwd"
                                   placeholder="Enter current password" required>
                        </div>
                        <div style="margin-bottom: 25px" class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                            <input type="password" class="form-control" id="newPwd" value=""
                                   placeholder="Enter new password" required>
                        </div>

						<div class="row clearfix">
							<div class="col-xs-12 col-sm-10 col-md-8 col-lg-8  column col-sm-offset-4 col-md-offset-4 col-lg-offset-4">
								<button type="button" id="addNewBtn" class="btn btn-success">
									<span class="fa fa-floppy-o">
									</span>
									&nbsp;&nbsp;Save
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
        <div class="col-md-4 column">
        </div>
    </div>
</div>