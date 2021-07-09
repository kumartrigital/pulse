package com.gss.pulseworkflow.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gss.pulseworkflow.model.AccessTokenRequest;
import com.gss.pulseworkflow.model.AccessTokenRequestTest;
import com.gss.pulseworkflow.response.Response;

@RestController
@RequestMapping("/authentication")
public class OauthControllerTest {
	@RequestMapping("/token")
	public Response getAccessToken(@RequestBody AccessTokenRequestTest accesTokenRequest) {
		try {
		String userName="FfYZqPU2h1tQns4K5_RYNTZ0rq4a";
		String password="ruPrWOw5BW26IaJu1bwUjbFN4Cka";
		String uri="https://pulseoftheworkforce.com/oauth2/token";
		StringBuilder obj=new StringBuilder();
		obj.append(userName);
		obj.append(":");
		obj.append(password);
	
			String authorizationHeaderValue=Base64Utils.encodeToString(obj.toString().getBytes("UTF-8"));
			
			try {
				sendPost(accesTokenRequest);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

		return null;
	}
	
	private void sendPost(AccessTokenRequestTest accesTokenRequest) throws Exception {
		String userName="FfYZqPU2h1tQns4K5_RYNTZ0rq4a";
		String password="ruPrWOw5BW26IaJu1bwUjbFN4Cka";
		String uri="https://pulseoftheworkforce.com/oauth2/token";
		StringBuilder obj=new StringBuilder();
		obj.append(userName);
		obj.append(":");
		obj.append(password);
	
			String authorizationHeaderValue=Base64Utils.encodeToString(obj.toString().getBytes("UTF-8"));

	    //String url = "https://aptransport.in/CFSTONLINE/Reports/VehicleRegistrationSearch.aspx";
	    URL urlObj = new URL(uri);
	    HttpsURLConnection con = (HttpsURLConnection) urlObj.openConnection();

	    //add reuqest header
	    con.setRequestMethod("POST");
	    con.setRequestProperty("Authorization", "Basic "+authorizationHeaderValue);
	    String urlParameters = "ctl00$OnlineContent$ddlInput=R&ctl00$OnlineContent$txtInput=AP31BF2942";
	    StringBuilder param=new StringBuilder();
	    param.append("grant_type=authorization_code");
	    param.append("&code=");
	    param.append(accesTokenRequest.getCode());
	    param.append("&redirect_uri=");
	    param.append(accesTokenRequest.getRedirectUri());


	    // Send post request
	    con.setDoOutput(true);
	    OutputStream wr = con.getOutputStream();
	    wr.write(param.toString().getBytes());
	    wr.flush();
	    wr.close();

	    int responseCode = con.getResponseCode();
	    //System.out.println("\nSending 'POST' request to URL : " + urlObj);
	    //System.out.println("Post parameters : " + urlParameters);
	    System.out.println("Response Code : " + responseCode);

	    BufferedReader in = new BufferedReader(
	            new InputStreamReader(con.getInputStream()));
	    String inputLine;
	    StringBuffer response = new StringBuffer();

	    while ((inputLine = in.readLine()) != null) {
	        response.append(inputLine);
	    }
	    in.close();

	    //print result
	    System.out.println(response.toString());

	}

}
