/**
 * 
 */
package com.gss.pulseworkflow.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author SAURABH
 *
 */
public class AccessTokenResponse implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private String accessToken;
    private String idToken;
    private String scope;
    private String tokenType;
    private String expiresIn;
    private String refreshToken;

    
    @JsonProperty("accessToken")
    public String getAccessToken() {
        return accessToken;
    }

    @JsonProperty("access_token")
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @JsonIgnore
    public String getIdToken() {
        return idToken;
    }

    @JsonProperty("id_token")
    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    @JsonIgnore
    public String getTokenType() {
        return tokenType;
    }
    @JsonProperty("token_type")
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    @JsonProperty("expiresIn")
    public String getExpiresIn() {
        return expiresIn;
    }
    @JsonProperty("expires_in")
    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }
    @JsonProperty("refreshToken")
    public String getRefreshToken() {
        return refreshToken;
    }
    
    @JsonProperty("refresh_token")
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @JsonIgnore
    public String getScope() {
        return scope;
    }
    @JsonProperty("scope")
    public void setScope(String scope) {
        this.scope = scope;
    }
    
    

}
