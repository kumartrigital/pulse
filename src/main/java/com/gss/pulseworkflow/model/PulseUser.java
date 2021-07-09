/**
 * 
 */
package com.gss.pulseworkflow.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author SAURABH
 *
 */
@JsonIgnoreProperties("password")
public class PulseUser extends User {

    private static final long serialVersionUID = 1L;

    private String userId;
    private String accessToken;
    private String expiresIn;
    private String refreshToken;
    private String token;
    private String logoutToken;
    private String emailId;
    private String fullName;

    public PulseUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
    

    public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}





	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getLogoutToken() {
		return logoutToken;
	}


	public void setLogoutToken(String logoutToken) {
		this.logoutToken = logoutToken;
	}


	@JsonProperty("userId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    @JsonIgnore
    @JsonProperty("accessToken")
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    @JsonIgnore
    @JsonProperty("expiresIn")
    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }
    @JsonIgnore
    @JsonProperty("refreshToken")
    public String getRefreshToken() {
        return refreshToken;
    }
    
    @JsonIgnore
    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return super.getAuthorities();
    }
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return super.isEnabled();
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return super.isAccountNonExpired();
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return super.isAccountNonLocked();
    }
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return super.isCredentialsNonExpired();
    }

    

    @JsonProperty("roles")
    public List<String> getRoles() {
        ArrayList<String> roles = new ArrayList<>();
        super.getAuthorities().stream().forEach(authority->roles.add(String.valueOf(authority)));
        return roles;
    }

    
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String accessTokenHash) {
        this.token = accessTokenHash;
    }
    
    
    

}
