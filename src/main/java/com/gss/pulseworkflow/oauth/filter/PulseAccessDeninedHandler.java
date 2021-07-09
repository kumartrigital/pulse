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
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gss.pulseworkflow.response.ResponseWrapper;

/**
 * @author SAURABH
 *
 */
public class PulseAccessDeninedHandler implements AccessDeniedHandler {

    @Autowired
    private ObjectMapper jsonMapper;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
            AccessDeniedException accessDeniedException) throws IOException, ServletException {
       accessDeniedException.printStackTrace();
       ResponseWrapper<String> wrapper = new ResponseWrapper<String>();
       response.setContentType(MediaType.APPLICATION_JSON_VALUE);
       wrapper.setErrorCode("ACCESS_DENIED");
       wrapper.setErrorMessage("Insufficient previlage to perform this operation. Please contact administrator to upgrade your access level");
       jsonMapper.writeValue(response.getOutputStream(), wrapper);

    }

}
