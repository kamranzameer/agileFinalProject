<div class="navbar navbar-default navbar-fixed-top">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="">Work Pacakge Management</a>
    </div>
    <div class="navbar-collapse collapse navbar-responsive-collapse">
        <ul class="nav navbar-nav">
            <li><a href="" ng-disabled="true"></a></li>
            <li><a href="" ng-disabled="true"></a></li>
        </ul>
        
        <!-- <form class="navbar-form navbar-left">
            <input type="text" class="form-control col-lg-8" placeholder="Search">
        </form> -->
        <ul class="nav navbar-nav navbar-right">
            <li><a href="" ng-click="menuService.changeMenu('config')" class="glyphicon glyphicon-cog"></a></li>
            <li class="divider-vertical"></li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li class="user-header bg-light-blue">
                        <p>
                            <shiro:user>
                            <%
                            org.apache.shiro.SecurityUtils.getSubject().getPrincipals().oneByType(java.util.Map.class);
                            %>
                            </shiro:user>
                        </p>
                        
                    </li>
                    <!-- Menu Body -->
                    <!-- Menu Footer-->
                    <li class="user-footer">
                        <div class="pull-left">
                            <a class="btn btn-default btn-flat" href="#/workspace"  ng-click="menuService.changeMenu('changepwd')">Profile</a>
                        </div>
                        <div class="pull-right">
                            <a class="btn btn-default btn-flat" href="../logout">Sign out</a>
                        </div>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</div   >
