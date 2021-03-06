
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package org.wso2.carbon.um.ws.service;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.3.8
 * 2020-12-31T20:26:42.516+05:30
 * Generated source version: 3.3.8
 *
 */

@javax.jws.WebService(
                      serviceName = "RemoteUserStoreManagerService",
                      portName = "RemoteUserStoreManagerServiceHttpsSoap12Endpoint",
                      targetNamespace = "http://service.ws.um.carbon.wso2.org",
                      wsdlLocation = "file:/C:/Users/SAURABH/AppData/Local/Temp/tempdir14407942385562470121.tmp/RemoteUserStoreManagerService_1.wsdl",
                      endpointInterface = "org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType")

public class RemoteUserStoreManagerServiceHttpsSoap12EndpointImpl implements RemoteUserStoreManagerServicePortType {

    private static final Logger LOG = Logger.getLogger(RemoteUserStoreManagerServiceHttpsSoap12EndpointImpl.class.getName());

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#getTenantId()*
     */
    public java.lang.Integer getTenantId() throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation getTenantId");
        try {
            java.lang.Integer _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#deleteRole(org.wso2.carbon.um.ws.service.DeleteRole parameters)*
     */
    public void deleteRole(DeleteRole parameters) throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation deleteRole");
        System.out.println(parameters);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#isExistingRole(java.lang.String roleName)*
     */
    public java.lang.Boolean isExistingRole(java.lang.String roleName) throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation isExistingRole");
        System.out.println(roleName);
        try {
            java.lang.Boolean _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#getProperties(org.wso2.carbon.user.core.tenant.xsd.Tenant tenant)*
     */
    public java.util.List<org.wso2.carbon.um.ws.service.ArrayOfString> getProperties(org.wso2.carbon.user.core.tenant.xsd.Tenant tenant) throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation getProperties");
        System.out.println(tenant);
        try {
            java.util.List<org.wso2.carbon.um.ws.service.ArrayOfString> _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#getUserListOfRole(java.lang.String roleName)*
     */
    public java.util.List<java.lang.String> getUserListOfRole(java.lang.String roleName) throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation getUserListOfRole");
        System.out.println(roleName);
        try {
            java.util.List<java.lang.String> _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#updateUserListOfRole(org.wso2.carbon.um.ws.service.UpdateUserListOfRole parameters)*
     */
    public void updateUserListOfRole(UpdateUserListOfRole parameters) throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation updateUserListOfRole");
        System.out.println(parameters);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#addUserClaimValue(org.wso2.carbon.um.ws.service.AddUserClaimValue parameters)*
     */
    public void addUserClaimValue(AddUserClaimValue parameters) throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation addUserClaimValue");
        System.out.println(parameters);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#updateRoleName(org.wso2.carbon.um.ws.service.UpdateRoleName parameters)*
     */
    public void updateRoleName(UpdateRoleName parameters) throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation updateRoleName");
        System.out.println(parameters);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#addRole(org.wso2.carbon.um.ws.service.AddRole parameters)*
     */
    public void addRole(AddRole parameters) throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation addRole");
        System.out.println(parameters);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#getUserId(java.lang.String username)*
     */
    public java.lang.Integer getUserId(java.lang.String username) throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation getUserId");
        System.out.println(username);
        try {
            java.lang.Integer _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#deleteUser(org.wso2.carbon.um.ws.service.DeleteUser parameters)*
     */
    public void deleteUser(DeleteUser parameters) throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation deleteUser");
        System.out.println(parameters);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#getProfileNames(java.lang.String userName)*
     */
    public java.util.List<java.lang.String> getProfileNames(java.lang.String userName) throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation getProfileNames");
        System.out.println(userName);
        try {
            java.util.List<java.lang.String> _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#getUserClaimValues(java.lang.String userName, java.lang.String profileName)*
     */
    public java.util.List<org.wso2.carbon.um.ws.service.dao.xsd.ClaimDTO> getUserClaimValues(java.lang.String userName, java.lang.String profileName) throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation getUserClaimValues");
        System.out.println(userName);
        System.out.println(profileName);
        try {
            java.util.List<org.wso2.carbon.um.ws.service.dao.xsd.ClaimDTO> _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#setUserClaimValue(org.wso2.carbon.um.ws.service.SetUserClaimValue parameters)*
     */
    public void setUserClaimValue(SetUserClaimValue parameters) throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation setUserClaimValue");
        System.out.println(parameters);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#getTenantIdofUser(java.lang.String username)*
     */
    public java.lang.Integer getTenantIdofUser(java.lang.String username) throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation getTenantIdofUser");
        System.out.println(username);
        try {
            java.lang.Integer _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#getUserClaimValue(java.lang.String userName, java.lang.String claim, java.lang.String profileName)*
     */
    public java.lang.String getUserClaimValue(java.lang.String userName, java.lang.String claim, java.lang.String profileName) throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation getUserClaimValue");
        System.out.println(userName);
        System.out.println(claim);
        System.out.println(profileName);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#listUsers(java.lang.String filter, java.lang.Integer maxItemLimit)*
     */
    public java.util.List<java.lang.String> listUsers(java.lang.String filter, java.lang.Integer maxItemLimit) throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation listUsers");
        System.out.println(filter);
        System.out.println(maxItemLimit);
        try {
            java.util.List<java.lang.String> _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#updateCredentialByAdmin(org.wso2.carbon.um.ws.service.UpdateCredentialByAdmin parameters)*
     */
    public void updateCredentialByAdmin(UpdateCredentialByAdmin parameters) throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation updateCredentialByAdmin");
        System.out.println(parameters);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#getAllProfileNames()*
     */
    public java.util.List<java.lang.String> getAllProfileNames() throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation getAllProfileNames");
        try {
            java.util.List<java.lang.String> _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#getRoleListOfUser(java.lang.String userName)*
     */
    public java.util.List<java.lang.String> getRoleListOfUser(java.lang.String userName) throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation getRoleListOfUser");
        System.out.println(userName);
        try {
            java.util.List<java.lang.String> _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#getUserList(java.lang.String claimUri, java.lang.String claimValue, java.lang.String profile)*
     */
    public java.util.List<java.lang.String> getUserList(java.lang.String claimUri, java.lang.String claimValue, java.lang.String profile) throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation getUserList");
        System.out.println(claimUri);
        System.out.println(claimValue);
        System.out.println(profile);
        try {
            java.util.List<java.lang.String> _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#addUserClaimValues(org.wso2.carbon.um.ws.service.AddUserClaimValues parameters)*
     */
    public void addUserClaimValues(AddUserClaimValues parameters) throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation addUserClaimValues");
        System.out.println(parameters);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#isExistingUser(java.lang.String userName)*
     */
    public java.lang.Boolean isExistingUser(java.lang.String userName) throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation isExistingUser");
        System.out.println(userName);
        try {
            java.lang.Boolean _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#addUser(org.wso2.carbon.um.ws.service.AddUser parameters)*
     */
    public void addUser(AddUser parameters) throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation addUser");
        System.out.println(parameters);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#updateRoleListOfUser(org.wso2.carbon.um.ws.service.UpdateRoleListOfUser parameters)*
     */
    public void updateRoleListOfUser(UpdateRoleListOfUser parameters) throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation updateRoleListOfUser");
        System.out.println(parameters);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#deleteUserClaimValues(org.wso2.carbon.um.ws.service.DeleteUserClaimValues parameters)*
     */
    public void deleteUserClaimValues(DeleteUserClaimValues parameters) throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation deleteUserClaimValues");
        System.out.println(parameters);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#getRoleNames()*
     */
    public java.util.List<java.lang.String> getRoleNames() throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation getRoleNames");
        try {
            java.util.List<java.lang.String> _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#updateCredential(org.wso2.carbon.um.ws.service.UpdateCredential parameters)*
     */
    public void updateCredential(UpdateCredential parameters) throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation updateCredential");
        System.out.println(parameters);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#authenticate(java.lang.String userName, java.lang.String credential)*
     */
    public java.lang.Boolean authenticate(java.lang.String userName, java.lang.String credential) throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation authenticate");
        System.out.println(userName);
        System.out.println(credential);
        try {
            java.lang.Boolean _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#getPasswordExpirationTime(java.lang.String username)*
     */
    public java.lang.Long getPasswordExpirationTime(java.lang.String username) throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation getPasswordExpirationTime");
        System.out.println(username);
        try {
            java.lang.Long _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#getUserClaimValuesForClaims(java.lang.String userName, java.util.List<java.lang.String> claims, java.lang.String profileName)*
     */
    public java.util.List<org.wso2.carbon.user.mgt.common.xsd.ClaimValue> getUserClaimValuesForClaims(java.lang.String userName, java.util.List<java.lang.String> claims, java.lang.String profileName) throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation getUserClaimValuesForClaims");
        System.out.println(userName);
        System.out.println(claims);
        System.out.println(profileName);
        try {
            java.util.List<org.wso2.carbon.user.mgt.common.xsd.ClaimValue> _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#setUserClaimValues(org.wso2.carbon.um.ws.service.SetUserClaimValues parameters)*
     */
    public void setUserClaimValues(SetUserClaimValues parameters) throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation setUserClaimValues");
        System.out.println(parameters);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#deleteUserClaimValue(org.wso2.carbon.um.ws.service.DeleteUserClaimValue parameters)*
     */
    public void deleteUserClaimValue(DeleteUserClaimValue parameters) throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation deleteUserClaimValue");
        System.out.println(parameters);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#isReadOnly()*
     */
    public java.lang.Boolean isReadOnly() throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation isReadOnly");
        try {
            java.lang.Boolean _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

    /* (non-Javadoc)
     * @see org.wso2.carbon.um.ws.service.RemoteUserStoreManagerServicePortType#getHybridRoles()*
     */
    public java.util.List<java.lang.String> getHybridRoles() throws RemoteUserStoreManagerServiceUserStoreException_Exception   {
        LOG.info("Executing operation getHybridRoles");
        try {
            java.util.List<java.lang.String> _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RemoteUserStoreManagerServiceUserStoreException_Exception("RemoteUserStoreManagerServiceUserStoreException...");
    }

}
