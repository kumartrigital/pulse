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
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gss.pulseworkflow.response.ResponseWrapper;

/**
 * @author SAURABH
 *
 */
public class PulseAuthenticationEntryPoint implements AuthenticationEntryPoint {
    
    @Autowired
    private ObjectMapper mapper;
    
    
    
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        ResponseWrapper<String> responseWrapper = new ResponseWrapper<>();
        responseWrapper.setStatus("NOT_LOGGED_IN");
        responseWrapper.setErrorMessage("You are trying to access secure data. please login");
        mapper.writeValue(response.getOutputStream(), responseWrapper);
    }

   
}
