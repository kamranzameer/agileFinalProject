<div class="container">
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Sign In</div>
            </div>

            <div style="padding-top:30px; " class="panel-body">

                <div style="margin-left: 100px; margin-right: 100px">
                    <form name="loginform" class="form-horizontal" role="form" action="./view/workspace.jsp">

                        <div style="margin-bottom: 25px" class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input type="text" class="form-control" name="username" value="" id="userId"
                                   placeholder="Username" required>
                        </div>

                        <div style="margin-bottom: 25px" class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                            <input type="password" class="form-control" id="password"
                                   placeholder="Password" required>
                        </div>

						


                        <div style="margin-top:10px" class="form-group">
                            <!-- Button -->

                        </div>

                        <div class="form-group">
                            <div class="col-md-12 control">
                                <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%">
                                    <div class="col-sm-12 controls">
                                        <button type="submit" class="btn btn-success" onclick="location.href='view/workspace.jsp'">
                                            <span class="glyphicon glyphicon-certificate"></span>&nbsp;&nbsp;Login
                                        </button>
                                        &nbsp;
                                        <button type="button" class="btn btn-warning" onclick="location.href='view/resetpassword.jsp'">
                                            <span class="glyphicon glyphicon-refresh"></span>&nbsp;&nbsp;Forgot Password
                                        </button>
                                        <div style="padding-top:5px; font-size:85%">
                                            Don't have an account!
                                            <a href="view/signup.jsp" <!---data-toggle="modal" data-target="#exampleModal" data-backdrop="static"--->>
                                                Sign Up Here
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

