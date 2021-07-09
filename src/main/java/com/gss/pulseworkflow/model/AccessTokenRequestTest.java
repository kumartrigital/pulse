package com.gss.pulseworkflow.model;

import java.io.Serializable;

public class AccessTokenRequestTest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String grantType;
	private String code;
	private String redirectUri;
	
	@Override
	public String toString() {
		return "AccessTokenRequest [grantType=" + grantType + ", code=" + code + ", redirectUri=" + redirectUri + "]";
	}
	public String getGrantType() {
		return grantType;
	}
	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getRedirectUri() {
		return redirectUri;
	}
	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}
	
	

}
