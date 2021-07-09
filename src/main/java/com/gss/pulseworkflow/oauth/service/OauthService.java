package com.gss.pulseworkflow.oauth.service;

import com.gss.pulseworkflow.model.AccessTokenRequest;
import com.gss.pulseworkflow.model.AccessTokenResponse;

public interface OauthService {
    AccessTokenResponse getAccessToken(AccessTokenRequest request);
    String refreshToken();
    String getSSOLoginURL(String redirectUrl);
    AccessTokenResponse getFakeAccessToken(AccessTokenRequest accessTokenRequest);
}
