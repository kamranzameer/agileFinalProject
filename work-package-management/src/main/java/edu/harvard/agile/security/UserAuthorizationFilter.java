package edu.harvard.agile.security;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;


/**
 * Authorization class used by Shiro to check for User permissions before allowing logged in user access to page
 * @author Incredibles
 *
 */
public class UserAuthorizationFilter extends RolesAuthorizationFilter {

    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response,
                                   Object mappedValue) throws IOException {

    	boolean allowAccess = false;
    	
        final Subject subject = getSubject(request, response);
        final String[] rolesArray = (String[]) mappedValue;

        if (rolesArray == null || rolesArray.length == 0) {
            //no roles specified, allow access.
        	allowAccess = true;
        }

        for (String roleName : rolesArray) {
            if (subject.hasRole(roleName)) {
            	allowAccess = true;
            }
        }

        return allowAccess;
    }
}
