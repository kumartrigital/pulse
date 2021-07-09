/**
 * 
 */
package com.gss.pulseworkflow.oauth.service;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.cxf.binding.soap.SoapFault;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.wso2.carbon.um.ws.service.AddUser;
import org.wso2.carbon.um.ws.service.UpdateCredential;
import org.wso2.carbon.user.mgt.common.xsd.ClaimValue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * @author SAURABH
 *
 */
@Service
public class WSO2UserServiceImpl implements WSO2UserWebService, InitializingBean {

    @Value("${external.wso2.user.service.endpoint}")
    private String wsoEndPoint;
    
    @Value("${external.wso2.default_role}")
    private String defaultWSO2Role;
    private XmlMapper mapper;
    @Autowired
    private WebClient client;
    public boolean createUser(String username,String email) {
        AddUser user = new AddUser();
        user.setUserName(new JAXBElement<String>(new QName("http://service.ws.um.carbon.wso2.org","userName","ser"), String.class,username));
        user.setCredential(new JAXBElement<String>(new QName("http://service.ws.um.carbon.wso2.org","credential","ser"), String.class,"Welcome1234" /*generateRandomPassword()*/));
        user.setRequirePasswordChange(false);
        user.getRoleList().add(defaultWSO2Role);
        ClaimValue claim = new ClaimValue();
        claim.setClaimURI(new JAXBElement<String>(new QName("http://common.mgt.user.carbon.wso2.org/xsd","claimURI","ser"), String.class, "http://wso2.org/claims/emailaddress"));
        claim.setValue(new JAXBElement<String>(new QName("http://common.mgt.user.carbon.wso2.org/xsd","value","ser"), String.class, email));
        user.getClaims().add(claim);
        
        Response response = client.post(user);
        boolean success=true;
        if(response.hasEntity()) {
            try {
            	success=false;
              HashMap<?, ?> value =   mapper.readValue(response.readEntity(String.class), HashMap.class);
              String exception  = value.get("")!=null ? String.valueOf(value.get("")):null;
              System.out.println(String.format("Exception occured %s", exception));
              
            } catch (IOException e) {
               throw new RuntimeException(e);
            }
            
        } 
       
        return success;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        mapper = new XmlMapper();
    }
    
    /**
     * code to generate random password
     * @return
     */
    
   private String generateRandomPassword(){
       String upperCaseLetters = RandomStringUtils.random(2, 65, 90, true, true);
       String lowerCaseLetters = RandomStringUtils.random(2, 97, 122, true, true);
       String numbers = RandomStringUtils.randomNumeric(2);
       String specialChar = RandomStringUtils.random(2, 33, 47, false, false);
       String totalChars = RandomStringUtils.randomAlphanumeric(2);
       String combinedChars = upperCaseLetters.concat(lowerCaseLetters)
         .concat(numbers)
         .concat(specialChar)
         .concat(totalChars);
       List<Character> pwdChars = combinedChars.chars()
         .mapToObj(c -> (char) c)
         .collect(Collectors.toList());
       Collections.shuffle(pwdChars);
       String password = pwdChars.stream()
         .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
         .toString();
       return password;
   }
   @Override
   public boolean changePassword(String username,String oldPassword,String newPassword) {
      UpdateCredential updateCredential = new UpdateCredential();
      updateCredential.setUserName(new JAXBElement<String>(new QName("http://service.ws.um.carbon.wso2.org","userName","ser"), String.class, username));
      updateCredential.setNewCredential(new JAXBElement<String>(new QName("http://service.ws.um.carbon.wso2.org","newCredential","ser"), String.class, newPassword));
      updateCredential.setOldCredential(new JAXBElement<String>(new QName("http://service.ws.um.carbon.wso2.org","oldCredential","ser"), String.class, oldPassword));
      Response response = client.post(updateCredential);
      if(response.hasEntity()) {
          try {
            HashMap<?, ?> value =   mapper.readValue(response.readEntity(String.class), HashMap.class);
            String exception  = value.get("")!=null ? String.valueOf(value.get("")):null;
            System.out.println(String.format("Exception occured %s", exception));
            
          } catch (IOException e) {
             throw new RuntimeException(e);
          }
          
      } 
      return false;
   }

}
