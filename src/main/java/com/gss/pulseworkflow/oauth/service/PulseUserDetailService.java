/**
 * 
 */
package com.gss.pulseworkflow.oauth.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gss.pulseworkflow.constants.RoleConstant;
import com.gss.pulseworkflow.dao.EmployeeRepository;
import com.gss.pulseworkflow.model.PulseUser;
import com.gss.pulseworkflow.model.Usercheck;
import com.gss.pulseworkflow.service.UserRoleService;

/**
 * @author SAURABH
 *
 */
public class PulseUserDetailService implements UserDetailsService {
    private static final String FAKE_PASSWORD = "FAKE_PASSWORD";

    
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
	private UserRoleService userRoleService;
    

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (username == null || username.trim().length() < 1) {
			throw new UsernameNotFoundException("Invalid credentials");
		}
		List<Usercheck> loggedInUserAccessRoles = employeeRepository.getUserAccessRoleByEmail(username);
		if (loggedInUserAccessRoles.size() < 1 || loggedInUserAccessRoles == null) {
			throw new UsernameNotFoundException("User don't have any roles to access application");
		}
		//TODO comment in next release
		String name =loggedInUserAccessRoles.get(0).getLoggedInUserFirstName()+" "+loggedInUserAccessRoles.get(0).getLoggedInUserLastName();
		PulseUser pulseUser = null;
		if(isSuperAdmin(loggedInUserAccessRoles)) {
			pulseUser = new PulseUser(name, FAKE_PASSWORD, buildGrantedAuthorityForSuperAdmin());
		}else {
			pulseUser = new PulseUser(name, FAKE_PASSWORD, buildGrantedAuthority(loggedInUserAccessRoles));
		}
		
		pulseUser.setFullName(loggedInUserAccessRoles.get(0).getLoggedInUserFirstName()+" "+loggedInUserAccessRoles.get(0).getLoggedInUserLastName());
		pulseUser.setEmailId(username);
		pulseUser.setUserId(loggedInUserAccessRoles.get(0).getLoggedInUserId());
		return pulseUser;
	}

	private Collection<? extends GrantedAuthority> buildGrantedAuthority(List<Usercheck> loggedInUserAccessRoles) {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		
		loggedInUserAccessRoles.forEach(role->grantedAuthorities.add(new SimpleGrantedAuthority(role.getUserRole())));
		return grantedAuthorities;
		
	}
	
	private boolean  isSuperAdmin(List<Usercheck> loggedInUserAccessRoles) {
	  boolean isAdmin = false;
		for(Usercheck role : loggedInUserAccessRoles) {
		  if("SUPER_ADMIN".equalsIgnoreCase(role.getUserRole())) {
			  isAdmin = true;
			  break;
		  }
	  }
		return isAdmin;
	}
	//TODO remove hard code and read from the database
	private List<GrantedAuthority> buildGrantedAuthorityForSuperAdmin() {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		grantedAuthorities.add(new SimpleGrantedAuthority(RoleConstant.ROLE_MANAGE_ASSESSMENT));
		grantedAuthorities.add(new SimpleGrantedAuthority(RoleConstant.ROLE_MANAGE_CAPABILITY));
		grantedAuthorities.add(new SimpleGrantedAuthority(RoleConstant.ROLE_MANAGE_CONTENT));
		grantedAuthorities.add(new SimpleGrantedAuthority(RoleConstant.ROLE_MANAGE_EMPLOYEE));
		grantedAuthorities.add(new SimpleGrantedAuthority(RoleConstant.ROLE_MANAGE_GOALS));
		grantedAuthorities.add(new SimpleGrantedAuthority(RoleConstant.ROLE_MANAGE_POSITION));
		grantedAuthorities.add(new SimpleGrantedAuthority(RoleConstant.ROLE_MANAGE_PROJECT));
		grantedAuthorities.add(new SimpleGrantedAuthority(RoleConstant.ROLE_MANAGE_TRAINING));
		grantedAuthorities.add(new SimpleGrantedAuthority(RoleConstant.ROLE_MY_ASSESSMENT));
		grantedAuthorities.add(new SimpleGrantedAuthority(RoleConstant.ROLE_MY_GOALS));
		grantedAuthorities.add(new SimpleGrantedAuthority(RoleConstant.ROLE_MY_PROJECT));
		grantedAuthorities.add(new SimpleGrantedAuthority(RoleConstant.ROLE_MY_SKILLS));
		grantedAuthorities.add(new SimpleGrantedAuthority(RoleConstant.ROLE_MY_TRAININGS));
		grantedAuthorities.add(new SimpleGrantedAuthority(RoleConstant.ROLE_REVIEW_ASSESSMENT));
		
		return grantedAuthorities;
	}
}
