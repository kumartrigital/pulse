/**
 * 
 */
package com.gss.pulseworkflow.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gss.pulseworkflow.model.AccessTokenRequest;
import com.gss.pulseworkflow.model.AccessTokenResponse;
import com.gss.pulseworkflow.oauth.SecurityUtils;
import com.gss.pulseworkflow.oauth.service.OauthService;
import com.gss.pulseworkflow.response.ResponseWrapper;

/**
 * @author SAURABH
 *
 */
@RestController
@RequestMapping("/oauth")
public class OauthController {
    @Autowired
    private OauthService oauthService;

    @GetMapping("/login")
    public void redirectToSSO(@RequestParam(name="redirectURL",required =true) String redirectUrl, HttpServletResponse response)
            throws IOException {
        response.sendRedirect(oauthService.getSSOLoginURL(redirectUrl));
    }

    @PostMapping("/accessToken")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseWrapper<AccessTokenResponse>> retriveAccessToken(@RequestBody AccessTokenRequest request)
            throws IOException {
       ResponseWrapper<AccessTokenResponse> responseWrapper = new ResponseWrapper<>();
       responseWrapper.setStatus("Success");
       responseWrapper.setResult(oauthService.getAccessToken(request));
       return ResponseEntity.ok().body(responseWrapper);
    }
    @GetMapping("/health")
    public ResponseEntity<ResponseWrapper<String>> health() throws IOException {
        SecurityContextHolder.getContext();
        ResponseWrapper<String> responseWrapper = new ResponseWrapper<>();
        responseWrapper.setStatus("Success");
        responseWrapper.setResult(SecurityUtils.getLoggedInUser().getUserId());
        return ResponseEntity.ok().body(responseWrapper); 
    }
}
