/**
 * 
 */
package com.gss.pulseworkflow.oauth.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.web.filter.OncePerRequestFilter;

import com.gss.pulseworkflow.model.PulseUser;
import com.gss.pulseworkflow.oauth.service.TokenService;

/**
 * @author SAURABH
 *
 */
public class PulseTokenCheckerFilter extends OncePerRequestFilter {

	private static String HEADER_NAME = "X-AUTH-TOKEN";

	@Autowired
	private TokenService tokenService;
	@Autowired
	private AccessDeniedHandler accessDeniedHandler;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String token = getTokenHeader(request);
			if (token != null) {
				try {
					PulseUser user = tokenService.parseToken(token);
					if (user != null && !isUserAuthenticated(user)) {
						if (user.getAuthorities() != null && !user.getAuthorities().isEmpty())
							SecurityContextHolder.getContext().setAuthentication(
									new UsernamePasswordAuthenticationToken(user, "", user.getAuthorities()));
					} else if (user != null) {
						accessDeniedHandler.handle(request, response,
								new AccessDeniedException("You have not enough permission to handle "));
						return;
					}
				} catch (Exception e) {
					accessDeniedHandler.handle(request, response,
							new AccessDeniedException("You have not enough permission to handle ", e));
					return;
				}
			}
		} catch (Exception e) {

		}
		filterChain.doFilter(request, response);

	}

	private boolean isUserAuthenticated(PulseUser user) {
		boolean isAnnomus = user.getUserId() == null;
		isAnnomus = isAnnomus || user.getAuthorities() == null || user.getAuthorities().isEmpty();
		return isAnnomus;
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
			//token = request.getParameter(HEADER_NAME);
			
		}
		return token;
	}

}
