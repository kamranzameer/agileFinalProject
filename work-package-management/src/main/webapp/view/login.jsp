<div class="container">
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Sign in</div>
            </div>

            <div style="padding-top:30px; " class="panel-body">

                <div style="margin-left: 100px; margin-right: 100px">
                    <!-- <form name="loginform" class="form-horizontal" role="form" action="./view/workspace.jsp"> -->
                    <% 
        String errorMessage = (String) request.getAttribute("shiroLoginFailure");
        if (errorMessage != null) { %>
        	<div style="padding-top:5px; font-size:90%">
        		<font color="red">Invalid Login</font>
        	</div>
            <% } %>
    
                    <form name="loginform" action="" method="POST" accept-charset="UTF-8" role="form">

                        <div style="margin-bottom: 25px" class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input type="text" class="form-control" name="username" value="" id="userId"
                                   placeholder="Username" required>
                        </div>
                        <div style="margin-bottom: 25px" class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                            <input type="password" class="form-control" id="password"  name="password"
                                   placeholder="Password" required>
                        </div>
                        <div style="margin-top:10px" class="form-group">
                            <!-- Button -->
                        </div>
                        <div class="form-group">
                            <div class="col-md-12 control">
                                <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" align="center">
                                        <button type="submit" class="btn btn-success">
                                            <span class="glyphicon glyphicon-certificate"></span>Login
                                        </button>
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

