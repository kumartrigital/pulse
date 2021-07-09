/**
 * 
 */
package com.gss.pulseworkflow.oauth.service;

import javax.ws.rs.ext.Provider;

import org.wso2.carbon.um.ws.service.AddUser;

/**
 * @author SAURABH
 *
 */
@Provider
public interface WSO2UserWebService  {

     boolean createUser(String username,String email);
     boolean changePassword(String username,String oldPassword,String newPassword);

}
