/**
 * 
 */
package com.gss.pulseworkflow.oauth.filter;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gss.pulseworkflow.model.AccessTokenRequest;
import com.gss.pulseworkflow.model.AccessTokenResponse;
import com.gss.pulseworkflow.model.PulseUser;
import com.gss.pulseworkflow.oauth.service.OauthService;

/**
 * @author SAURABH
 *
 */
public class PulseAuthenticationManager implements AuthenticationManager {

    @Autowired
    private OauthService oauthService;
    
    @Autowired
    private ObjectMapper jsonMapper;
    
    @Autowired
    private UserDetailsService userDetailService;
    
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Authentication auth  = authentication;
        if(authentication instanceof AccessTokenRequest) {
           AccessTokenResponse response =  oauthService.getAccessToken((AccessTokenRequest) authentication);
           String username = getSSOLoggedInUserName(response);
           PulseUser details = (PulseUser)userDetailService.loadUserByUsername(username);
           details.setAccessToken(response.getAccessToken());
           details.setRefreshToken(response.getRefreshToken());
           details.setExpiresIn(response.getExpiresIn());
           details.setLogoutToken(response.getIdToken());
           
           auth = new UsernamePasswordAuthenticationToken(details, "",details.getAuthorities());
        }
        return auth;
    }
    
    private String getSSOLoggedInUserName( AccessTokenResponse response) {
        String token = response.getIdToken();
        String[] tokenParts = token.split("\\.");
        if(tokenParts.length < 3) {
          throw new UsernameNotFoundException("Invalid token from sso");   
        }
        String infoPart = tokenParts[1];
        try {
            System.out.println(infoPart);
           HashMap<String, String> userInfo= jsonMapper.readValue(Base64.getDecoder().decode(infoPart),HashMap.class);
           return userInfo.get("sub");
        } catch (IOException e) {
            throw new UsernameNotFoundException("Unable to parse sso token",e);
        }
        
    }

}
