/**
 * 
 */
package com.gss.pulseworkflow.oauth.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gss.pulseworkflow.model.AccessTokenRequest;
import com.gss.pulseworkflow.model.PulseUser;
import com.gss.pulseworkflow.oauth.service.TokenService;
import com.gss.pulseworkflow.response.ResponseWrapper;

/**
 * @author SAURABH
 *
 */
public class PulseAccessTokenFilter extends AbstractAuthenticationProcessingFilter {
    
    @Autowired
    private TokenService tokenService;
    
    @Autowired
    private ObjectMapper jsonMapper;
   

    public PulseAccessTokenFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
        super(requiresAuthenticationRequestMatcher);
        setAuthenticationFailureHandler(this::onAuthenticationFailure);
        setAuthenticationSuccessHandler(this::onAuthenticationSuccess);
    }

    
    
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
        AccessTokenRequest tokenRequest = jsonMapper.readValue(request.getInputStream(), AccessTokenRequest.class);
        return getAuthenticationManager().authenticate(tokenRequest);
       
    }
    
    private  void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException {
        Object details = authentication.getPrincipal();
        if(details == null || !PulseUser.class.isAssignableFrom(details.getClass())) {
            onAuthenticationFailure(request, response, new UsernameNotFoundException("Invalid Credentials"));
            return;
        }
        PulseUser loggedInUser = (PulseUser)details;
        String authToken = tokenService.createToken(loggedInUser);
        try {
            loggedInUser.setToken(tokenService.buildTokenHash(authToken));
           
        } catch (RuntimeException e) {
            onAuthenticationFailure(request, response, new UsernameNotFoundException("Invalid Credentials",e));
        }
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        ResponseWrapper<PulseUser> wrapper = new ResponseWrapper<>();
        wrapper.setStatus("Success");
        wrapper.setResult(loggedInUser);
        jsonMapper.writeValue(response.getOutputStream(), wrapper);
        
    }
    private  void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException {
        exception.printStackTrace();
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        ResponseWrapper<String> wrapper = new ResponseWrapper<>();
        wrapper.setStatus("Error");
        wrapper.setErrorCode("AUTHENTICATION_FAILED");
        wrapper.setErrorMessage("Oops! Invalid Credentials. Please check your credentials");
        jsonMapper.writeValue(response.getOutputStream(), wrapper);
    }

    
}
