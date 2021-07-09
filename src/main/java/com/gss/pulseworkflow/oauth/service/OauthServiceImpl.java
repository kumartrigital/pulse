/**
 * 
 */
package com.gss.pulseworkflow.oauth.service;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Base64;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.gss.pulseworkflow.model.AccessTokenRequest;
import com.gss.pulseworkflow.model.AccessTokenResponse;

/**
 * @author SAURABH
 *
 */
@Service
public class OauthServiceImpl implements OauthService, InitializingBean {

    @Value("${external.oauth.access_token_url}")
    private String accessTokenUrl;

    @Value("${external.oauth.client_id}")
    private String clientId;

    @Value("${external.oauth.secret_key}")
    private String secretKey;

    @Value("${external.oauth.login_url}")
    private String loginUrl;
    @Value("${external.oauth.header_credential}")
    private String accessTokenHeader;

    @Autowired
    private RestTemplate oauthRequester;

    public OauthServiceImpl() {
    }

    @Override
    public AccessTokenResponse getAccessToken(AccessTokenRequest accessTokenRequest) {
        AccessTokenResponse accessResponse = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Basic " + getOauthAuthorization());

        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("code", accessTokenRequest.getCode());
        params.add("grant_type", "authorization_code");
        params.add("redirect_uri", accessTokenRequest.getRedirectURI());

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        ResponseEntity<AccessTokenResponse> response = oauthRequester.exchange(accessTokenUrl, HttpMethod.POST, request,
                AccessTokenResponse.class);
        if(response.getStatusCodeValue() == 200) {
            accessResponse = response.getBody();
        }else {
            throw new UsernameNotFoundException("Invalid Credential");
        }
       return accessResponse;

    }
    public AccessTokenResponse getFakeAccessToken(AccessTokenRequest accessTokenRequest) {
        throw new RuntimeException("Authentication Failed");
    }

    @Override
    public String refreshToken() {
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(String.format(loginUrl, "localhost"));
    }

    @Override
    public String getSSOLoginURL(String redirectUrl) {
        return String.format(loginUrl, redirectUrl);
    }

    private String getOauthAuthorization() {

        return Base64.getEncoder().encodeToString(accessTokenHeader.getBytes(Charset.forName("utf-8")));
    }

}
