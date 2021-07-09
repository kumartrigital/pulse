/**
 * 
 */
package com.gss.pulseworkflow.oauth.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gss.pulseworkflow.model.PulseUser;
import com.gss.pulseworkflow.oauth.service.TokenService;
import com.gss.pulseworkflow.response.ResponseWrapper;

/**
 * @author SAURABH
 *
 */
public class PulseLogoutHandler implements LogoutHandler {
    
    private static String HEADER_NAME = "X-AUTH-TOKEN";
    @Value("${external.oauth.logout_url}")
    private String logoutUrl;
    @Autowired
    private TokenService tokenService;

    @Autowired
    private ObjectMapper mapper;

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        String token = getTokenHeader(request);
        if (token != null && token.length() > 0) {
            PulseUser user = tokenService.parseToken(token);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            ResponseWrapper<String> responseWrapper = new ResponseWrapper<>();
            responseWrapper.setStatus("Success");
            responseWrapper.setResult(buildLogoutUrl(request.getParameter("redirectURL"), user.getLogoutToken()));
            try {
                mapper.writeValue(response.getOutputStream(), responseWrapper);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
    
    
    private String buildLogoutUrl(String redirectUrl,String logoutToken) {
      return String.format(logoutUrl,redirectUrl, logoutToken);
    }

    public String getTokenHeader(HttpServletRequest request) {
        Enumeration<String> headers = request.getHeaderNames();
        String token = null;
        while (headers.hasMoreElements()) {
            String providedHeaderKey = headers.nextElement();
            if (providedHeaderKey.equalsIgnoreCase(HEADER_NAME)) {
                token = request.getHeader(providedHeaderKey);
                break;
            }
        }
        if (token == null) {
            token = request.getParameter(HEADER_NAME);
        }
        return token;
    }

}
