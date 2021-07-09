/**
 * 
 */
package com.gss.pulseworkflow.oauth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.Assert;

import com.gss.pulseworkflow.model.PulseUser;

/**
 * @author SAURABH
 *
 */
public class SecurityUtils {
    
    private SecurityUtils() {}
    
    public static PulseUser getLoggedInUser() {
        PulseUser user = null;
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication auth  = context.getAuthentication();
        Assert.notNull(auth,"User is not logged in");
        Assert.notNull(auth.getPrincipal(), "User is not logged in");
        if(auth.getPrincipal().getClass().isAssignableFrom(PulseUser.class)) {
            user=  (PulseUser) auth.getPrincipal();
        }
        Assert.notNull(user, "User is not logged in");
        return user;
    }

}
