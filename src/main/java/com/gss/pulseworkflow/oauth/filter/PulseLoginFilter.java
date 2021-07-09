/**
 * 
 */
package com.gss.pulseworkflow.oauth.filter;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import com.gss.pulseworkflow.oauth.service.OauthService;

/**
 * @author SAURABH
 *
 */
public class PulseLoginFilter extends GenericFilterBean implements InitializingBean {
    
    @Autowired
    private OauthService oauthService;
    private RequestMatcher matcher;
    
    public PulseLoginFilter(RequestMatcher matcher) {
       this.matcher = matcher;
    }
    
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        this.doInternalFilter(request, response, chain);
    }
    private void doInternalFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String redirectURL = request.getParameter("redirectURL");
        if(matcher.matches(request) && Objects.nonNull(redirectURL) && !redirectURL.isEmpty()) {
            response.sendRedirect(oauthService.getSSOLoginURL(redirectURL));
            return;
        }
        chain.doFilter(request, response);
    }
    
    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();
        Assert.notNull(oauthService, "Oauth Service is null");
    }
    
    
}
