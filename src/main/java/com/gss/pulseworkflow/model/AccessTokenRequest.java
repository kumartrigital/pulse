/**
 * 
 */
package com.gss.pulseworkflow.model;

import java.io.Serializable;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * @author SAURABH
 *
 */
public class AccessTokenRequest extends UsernamePasswordAuthenticationToken implements Serializable{

   
    private static final long serialVersionUID = 1L;
    private String code;
    private String redirectURI;
    
    public AccessTokenRequest(Object principal, Object credentials) {
        super(principal, credentials);
        // TODO Auto-generated constructor stub
    }
    public AccessTokenRequest() {
      super(null,null);
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getRedirectURI() {
        return redirectURI;
    }
    public void setRedirectURI(String redirectURI) {
        this.redirectURI = redirectURI;
    }
    
    
    
}
