
package org.wso2.carbon.um.ws.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.wso2.carbon.user.core.tenant.xsd.Tenant;
import org.wso2.carbon.user.core.xsd.UserStoreException;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.wso2.carbon.um.ws.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RemoteUserStoreManagerServiceUserStoreExceptionUserStoreException_QNAME = new QName("http://service.ws.um.carbon.wso2.org", "UserStoreException");
    private final static QName _GetPropertiesTenant_QNAME = new QName("http://service.ws.um.carbon.wso2.org", "tenant");
    private final static QName _AuthenticateUserName_QNAME = new QName("http://service.ws.um.carbon.wso2.org", "userName");
    private final static QName _AuthenticateCredential_QNAME = new QName("http://service.ws.um.carbon.wso2.org", "credential");
    private final static QName _AddRoleRoleName_QNAME = new QName("http://service.ws.um.carbon.wso2.org", "roleName");
    private final static QName _UpdateRoleNameNewRoleName_QNAME = new QName("http://service.ws.um.carbon.wso2.org", "newRoleName");
    private final static QName _GetUserListClaimUri_QNAME = new QName("http://service.ws.um.carbon.wso2.org", "claimUri");
    private final static QName _GetUserListClaimValue_QNAME = new QName("http://service.ws.um.carbon.wso2.org", "claimValue");
    private final static QName _GetUserListProfile_QNAME = new QName("http://service.ws.um.carbon.wso2.org", "profile");
    private final static QName _AddUserClaimValuesProfileName_QNAME = new QName("http://service.ws.um.carbon.wso2.org", "profileName");
    private final static QName _GetTenantIdofUserUsername_QNAME = new QName("http://service.ws.um.carbon.wso2.org", "username");
    private final static QName _AddUserClaimValueClaimURI_QNAME = new QName("http://service.ws.um.carbon.wso2.org", "claimURI");
    private final static QName _ListUsersFilter_QNAME = new QName("http://service.ws.um.carbon.wso2.org", "filter");
    private final static QName _UpdateCredentialNewCredential_QNAME = new QName("http://service.ws.um.carbon.wso2.org", "newCredential");
    private final static QName _UpdateCredentialOldCredential_QNAME = new QName("http://service.ws.um.carbon.wso2.org", "oldCredential");
    private final static QName _GetUserClaimValueClaim_QNAME = new QName("http://service.ws.um.carbon.wso2.org", "claim");
    private final static QName _GetUserClaimValueResponseReturn_QNAME = new QName("http://service.ws.um.carbon.wso2.org", "return");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.wso2.carbon.um.ws.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RemoteUserStoreManagerServiceUserStoreException }
     * 
     */
    public RemoteUserStoreManagerServiceUserStoreException createRemoteUserStoreManagerServiceUserStoreException() {
        return new RemoteUserStoreManagerServiceUserStoreException();
    }

    /**
     * Create an instance of {@link GetProperties }
     * 
     */
    public GetProperties createGetProperties() {
        return new GetProperties();
    }

    /**
     * Create an instance of {@link GetPropertiesResponse }
     * 
     */
    public GetPropertiesResponse createGetPropertiesResponse() {
        return new GetPropertiesResponse();
    }

    /**
     * Create an instance of {@link ArrayOfString }
     * 
     */
    public ArrayOfString createArrayOfString() {
        return new ArrayOfString();
    }

    /**
     * Create an instance of {@link IsReadOnly }
     * 
     */
    public IsReadOnly createIsReadOnly() {
        return new IsReadOnly();
    }

    /**
     * Create an instance of {@link IsReadOnlyResponse }
     * 
     */
    public IsReadOnlyResponse createIsReadOnlyResponse() {
        return new IsReadOnlyResponse();
    }

    /**
     * Create an instance of {@link Authenticate }
     * 
     */
    public Authenticate createAuthenticate() {
        return new Authenticate();
    }

    /**
     * Create an instance of {@link AuthenticateResponse }
     * 
     */
    public AuthenticateResponse createAuthenticateResponse() {
        return new AuthenticateResponse();
    }

    /**
     * Create an instance of {@link GetTenantId }
     * 
     */
    public GetTenantId createGetTenantId() {
        return new GetTenantId();
    }

    /**
     * Create an instance of {@link GetTenantIdResponse }
     * 
     */
    public GetTenantIdResponse createGetTenantIdResponse() {
        return new GetTenantIdResponse();
    }

    /**
     * Create an instance of {@link GetRoleListOfUser }
     * 
     */
    public GetRoleListOfUser createGetRoleListOfUser() {
        return new GetRoleListOfUser();
    }

    /**
     * Create an instance of {@link GetRoleListOfUserResponse }
     * 
     */
    public GetRoleListOfUserResponse createGetRoleListOfUserResponse() {
        return new GetRoleListOfUserResponse();
    }

    /**
     * Create an instance of {@link AddRole }
     * 
     */
    public AddRole createAddRole() {
        return new AddRole();
    }

    /**
     * Create an instance of {@link DeleteRole }
     * 
     */
    public DeleteRole createDeleteRole() {
        return new DeleteRole();
    }

    /**
     * Create an instance of {@link UpdateRoleName }
     * 
     */
    public UpdateRoleName createUpdateRoleName() {
        return new UpdateRoleName();
    }

    /**
     * Create an instance of {@link GetUserList }
     * 
     */
    public GetUserList createGetUserList() {
        return new GetUserList();
    }

    /**
     * Create an instance of {@link GetUserListResponse }
     * 
     */
    public GetUserListResponse createGetUserListResponse() {
        return new GetUserListResponse();
    }

    /**
     * Create an instance of {@link AddUserClaimValues }
     * 
     */
    public AddUserClaimValues createAddUserClaimValues() {
        return new AddUserClaimValues();
    }

    /**
     * Create an instance of {@link GetTenantIdofUser }
     * 
     */
    public GetTenantIdofUser createGetTenantIdofUser() {
        return new GetTenantIdofUser();
    }

    /**
     * Create an instance of {@link GetTenantIdofUserResponse }
     * 
     */
    public GetTenantIdofUserResponse createGetTenantIdofUserResponse() {
        return new GetTenantIdofUserResponse();
    }

    /**
     * Create an instance of {@link AddUserClaimValue }
     * 
     */
    public AddUserClaimValue createAddUserClaimValue() {
        return new AddUserClaimValue();
    }

    /**
     * Create an instance of {@link GetUserClaimValuesForClaims }
     * 
     */
    public GetUserClaimValuesForClaims createGetUserClaimValuesForClaims() {
        return new GetUserClaimValuesForClaims();
    }

    /**
     * Create an instance of {@link GetUserClaimValuesForClaimsResponse }
     * 
     */
    public GetUserClaimValuesForClaimsResponse createGetUserClaimValuesForClaimsResponse() {
        return new GetUserClaimValuesForClaimsResponse();
    }

    /**
     * Create an instance of {@link IsExistingUser }
     * 
     */
    public IsExistingUser createIsExistingUser() {
        return new IsExistingUser();
    }

    /**
     * Create an instance of {@link IsExistingUserResponse }
     * 
     */
    public IsExistingUserResponse createIsExistingUserResponse() {
        return new IsExistingUserResponse();
    }

    /**
     * Create an instance of {@link IsExistingRole }
     * 
     */
    public IsExistingRole createIsExistingRole() {
        return new IsExistingRole();
    }

    /**
     * Create an instance of {@link IsExistingRoleResponse }
     * 
     */
    public IsExistingRoleResponse createIsExistingRoleResponse() {
        return new IsExistingRoleResponse();
    }

    /**
     * Create an instance of {@link GetRoleNames }
     * 
     */
    public GetRoleNames createGetRoleNames() {
        return new GetRoleNames();
    }

    /**
     * Create an instance of {@link GetRoleNamesResponse }
     * 
     */
    public GetRoleNamesResponse createGetRoleNamesResponse() {
        return new GetRoleNamesResponse();
    }

    /**
     * Create an instance of {@link GetProfileNames }
     * 
     */
    public GetProfileNames createGetProfileNames() {
        return new GetProfileNames();
    }

    /**
     * Create an instance of {@link GetProfileNamesResponse }
     * 
     */
    public GetProfileNamesResponse createGetProfileNamesResponse() {
        return new GetProfileNamesResponse();
    }

    /**
     * Create an instance of {@link GetHybridRoles }
     * 
     */
    public GetHybridRoles createGetHybridRoles() {
        return new GetHybridRoles();
    }

    /**
     * Create an instance of {@link GetHybridRolesResponse }
     * 
     */
    public GetHybridRolesResponse createGetHybridRolesResponse() {
        return new GetHybridRolesResponse();
    }

    /**
     * Create an instance of {@link ListUsers }
     * 
     */
    public ListUsers createListUsers() {
        return new ListUsers();
    }

    /**
     * Create an instance of {@link ListUsersResponse }
     * 
     */
    public ListUsersResponse createListUsersResponse() {
        return new ListUsersResponse();
    }

    /**
     * Create an instance of {@link DeleteUser }
     * 
     */
    public DeleteUser createDeleteUser() {
        return new DeleteUser();
    }

    /**
     * Create an instance of {@link UpdateCredential }
     * 
     */
    public UpdateCredential createUpdateCredential() {
        return new UpdateCredential();
    }

    /**
     * Create an instance of {@link GetUserId }
     * 
     */
    public GetUserId createGetUserId() {
        return new GetUserId();
    }

    /**
     * Create an instance of {@link GetUserIdResponse }
     * 
     */
    public GetUserIdResponse createGetUserIdResponse() {
        return new GetUserIdResponse();
    }

    /**
     * Create an instance of {@link SetUserClaimValues }
     * 
     */
    public SetUserClaimValues createSetUserClaimValues() {
        return new SetUserClaimValues();
    }

    /**
     * Create an instance of {@link GetPasswordExpirationTime }
     * 
     */
    public GetPasswordExpirationTime createGetPasswordExpirationTime() {
        return new GetPasswordExpirationTime();
    }

    /**
     * Create an instance of {@link GetPasswordExpirationTimeResponse }
     * 
     */
    public GetPasswordExpirationTimeResponse createGetPasswordExpirationTimeResponse() {
        return new GetPasswordExpirationTimeResponse();
    }

    /**
     * Create an instance of {@link GetAllProfileNames }
     * 
     */
    public GetAllProfileNames createGetAllProfileNames() {
        return new GetAllProfileNames();
    }

    /**
     * Create an instance of {@link GetAllProfileNamesResponse }
     * 
     */
    public GetAllProfileNamesResponse createGetAllProfileNamesResponse() {
        return new GetAllProfileNamesResponse();
    }

    /**
     * Create an instance of {@link DeleteUserClaimValues }
     * 
     */
    public DeleteUserClaimValues createDeleteUserClaimValues() {
        return new DeleteUserClaimValues();
    }

    /**
     * Create an instance of {@link SetUserClaimValue }
     * 
     */
    public SetUserClaimValue createSetUserClaimValue() {
        return new SetUserClaimValue();
    }

    /**
     * Create an instance of {@link GetUserListOfRole }
     * 
     */
    public GetUserListOfRole createGetUserListOfRole() {
        return new GetUserListOfRole();
    }

    /**
     * Create an instance of {@link GetUserListOfRoleResponse }
     * 
     */
    public GetUserListOfRoleResponse createGetUserListOfRoleResponse() {
        return new GetUserListOfRoleResponse();
    }

    /**
     * Create an instance of {@link GetUserClaimValues }
     * 
     */
    public GetUserClaimValues createGetUserClaimValues() {
        return new GetUserClaimValues();
    }

    /**
     * Create an instance of {@link GetUserClaimValuesResponse }
     * 
     */
    public GetUserClaimValuesResponse createGetUserClaimValuesResponse() {
        return new GetUserClaimValuesResponse();
    }

    /**
     * Create an instance of {@link UpdateUserListOfRole }
     * 
     */
    public UpdateUserListOfRole createUpdateUserListOfRole() {
        return new UpdateUserListOfRole();
    }

    /**
     * Create an instance of {@link DeleteUserClaimValue }
     * 
     */
    public DeleteUserClaimValue createDeleteUserClaimValue() {
        return new DeleteUserClaimValue();
    }

    /**
     * Create an instance of {@link UpdateCredentialByAdmin }
     * 
     */
    public UpdateCredentialByAdmin createUpdateCredentialByAdmin() {
        return new UpdateCredentialByAdmin();
    }

    /**
     * Create an instance of {@link UpdateRoleListOfUser }
     * 
     */
    public UpdateRoleListOfUser createUpdateRoleListOfUser() {
        return new UpdateRoleListOfUser();
    }

    /**
     * Create an instance of {@link AddUser }
     * 
     */
    public AddUser createAddUser() {
        return new AddUser();
    }

    /**
     * Create an instance of {@link GetUserClaimValue }
     * 
     */
    public GetUserClaimValue createGetUserClaimValue() {
        return new GetUserClaimValue();
    }

    /**
     * Create an instance of {@link GetUserClaimValueResponse }
     * 
     */
    public GetUserClaimValueResponse createGetUserClaimValueResponse() {
        return new GetUserClaimValueResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserStoreException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UserStoreException }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "UserStoreException", scope = RemoteUserStoreManagerServiceUserStoreException.class)
    public JAXBElement<UserStoreException> createRemoteUserStoreManagerServiceUserStoreExceptionUserStoreException(UserStoreException value) {
        return new JAXBElement<UserStoreException>(_RemoteUserStoreManagerServiceUserStoreExceptionUserStoreException_QNAME, UserStoreException.class, RemoteUserStoreManagerServiceUserStoreException.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Tenant }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Tenant }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "tenant", scope = GetProperties.class)
    public JAXBElement<Tenant> createGetPropertiesTenant(Tenant value) {
        return new JAXBElement<Tenant>(_GetPropertiesTenant_QNAME, Tenant.class, GetProperties.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "userName", scope = Authenticate.class)
    public JAXBElement<String> createAuthenticateUserName(String value) {
        return new JAXBElement<String>(_AuthenticateUserName_QNAME, String.class, Authenticate.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "credential", scope = Authenticate.class)
    public JAXBElement<String> createAuthenticateCredential(String value) {
        return new JAXBElement<String>(_AuthenticateCredential_QNAME, String.class, Authenticate.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "userName", scope = GetRoleListOfUser.class)
    public JAXBElement<String> createGetRoleListOfUserUserName(String value) {
        return new JAXBElement<String>(_AuthenticateUserName_QNAME, String.class, GetRoleListOfUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "roleName", scope = AddRole.class)
    public JAXBElement<String> createAddRoleRoleName(String value) {
        return new JAXBElement<String>(_AddRoleRoleName_QNAME, String.class, AddRole.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "roleName", scope = DeleteRole.class)
    public JAXBElement<String> createDeleteRoleRoleName(String value) {
        return new JAXBElement<String>(_AddRoleRoleName_QNAME, String.class, DeleteRole.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "roleName", scope = UpdateRoleName.class)
    public JAXBElement<String> createUpdateRoleNameRoleName(String value) {
        return new JAXBElement<String>(_AddRoleRoleName_QNAME, String.class, UpdateRoleName.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "newRoleName", scope = UpdateRoleName.class)
    public JAXBElement<String> createUpdateRoleNameNewRoleName(String value) {
        return new JAXBElement<String>(_UpdateRoleNameNewRoleName_QNAME, String.class, UpdateRoleName.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "claimUri", scope = GetUserList.class)
    public JAXBElement<String> createGetUserListClaimUri(String value) {
        return new JAXBElement<String>(_GetUserListClaimUri_QNAME, String.class, GetUserList.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "claimValue", scope = GetUserList.class)
    public JAXBElement<String> createGetUserListClaimValue(String value) {
        return new JAXBElement<String>(_GetUserListClaimValue_QNAME, String.class, GetUserList.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "profile", scope = GetUserList.class)
    public JAXBElement<String> createGetUserListProfile(String value) {
        return new JAXBElement<String>(_GetUserListProfile_QNAME, String.class, GetUserList.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "userName", scope = AddUserClaimValues.class)
    public JAXBElement<String> createAddUserClaimValuesUserName(String value) {
        return new JAXBElement<String>(_AuthenticateUserName_QNAME, String.class, AddUserClaimValues.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "profileName", scope = AddUserClaimValues.class)
    public JAXBElement<String> createAddUserClaimValuesProfileName(String value) {
        return new JAXBElement<String>(_AddUserClaimValuesProfileName_QNAME, String.class, AddUserClaimValues.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "username", scope = GetTenantIdofUser.class)
    public JAXBElement<String> createGetTenantIdofUserUsername(String value) {
        return new JAXBElement<String>(_GetTenantIdofUserUsername_QNAME, String.class, GetTenantIdofUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "userName", scope = AddUserClaimValue.class)
    public JAXBElement<String> createAddUserClaimValueUserName(String value) {
        return new JAXBElement<String>(_AuthenticateUserName_QNAME, String.class, AddUserClaimValue.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "claimURI", scope = AddUserClaimValue.class)
    public JAXBElement<String> createAddUserClaimValueClaimURI(String value) {
        return new JAXBElement<String>(_AddUserClaimValueClaimURI_QNAME, String.class, AddUserClaimValue.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "claimValue", scope = AddUserClaimValue.class)
    public JAXBElement<String> createAddUserClaimValueClaimValue(String value) {
        return new JAXBElement<String>(_GetUserListClaimValue_QNAME, String.class, AddUserClaimValue.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "profileName", scope = AddUserClaimValue.class)
    public JAXBElement<String> createAddUserClaimValueProfileName(String value) {
        return new JAXBElement<String>(_AddUserClaimValuesProfileName_QNAME, String.class, AddUserClaimValue.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "userName", scope = GetUserClaimValuesForClaims.class)
    public JAXBElement<String> createGetUserClaimValuesForClaimsUserName(String value) {
        return new JAXBElement<String>(_AuthenticateUserName_QNAME, String.class, GetUserClaimValuesForClaims.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "profileName", scope = GetUserClaimValuesForClaims.class)
    public JAXBElement<String> createGetUserClaimValuesForClaimsProfileName(String value) {
        return new JAXBElement<String>(_AddUserClaimValuesProfileName_QNAME, String.class, GetUserClaimValuesForClaims.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "userName", scope = IsExistingUser.class)
    public JAXBElement<String> createIsExistingUserUserName(String value) {
        return new JAXBElement<String>(_AuthenticateUserName_QNAME, String.class, IsExistingUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "roleName", scope = IsExistingRole.class)
    public JAXBElement<String> createIsExistingRoleRoleName(String value) {
        return new JAXBElement<String>(_AddRoleRoleName_QNAME, String.class, IsExistingRole.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "userName", scope = GetProfileNames.class)
    public JAXBElement<String> createGetProfileNamesUserName(String value) {
        return new JAXBElement<String>(_AuthenticateUserName_QNAME, String.class, GetProfileNames.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "filter", scope = ListUsers.class)
    public JAXBElement<String> createListUsersFilter(String value) {
        return new JAXBElement<String>(_ListUsersFilter_QNAME, String.class, ListUsers.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "userName", scope = DeleteUser.class)
    public JAXBElement<String> createDeleteUserUserName(String value) {
        return new JAXBElement<String>(_AuthenticateUserName_QNAME, String.class, DeleteUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "userName", scope = UpdateCredential.class)
    public JAXBElement<String> createUpdateCredentialUserName(String value) {
        return new JAXBElement<String>(_AuthenticateUserName_QNAME, String.class, UpdateCredential.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "newCredential", scope = UpdateCredential.class)
    public JAXBElement<String> createUpdateCredentialNewCredential(String value) {
        return new JAXBElement<String>(_UpdateCredentialNewCredential_QNAME, String.class, UpdateCredential.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "oldCredential", scope = UpdateCredential.class)
    public JAXBElement<String> createUpdateCredentialOldCredential(String value) {
        return new JAXBElement<String>(_UpdateCredentialOldCredential_QNAME, String.class, UpdateCredential.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "username", scope = GetUserId.class)
    public JAXBElement<String> createGetUserIdUsername(String value) {
        return new JAXBElement<String>(_GetTenantIdofUserUsername_QNAME, String.class, GetUserId.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "userName", scope = SetUserClaimValues.class)
    public JAXBElement<String> createSetUserClaimValuesUserName(String value) {
        return new JAXBElement<String>(_AuthenticateUserName_QNAME, String.class, SetUserClaimValues.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "profileName", scope = SetUserClaimValues.class)
    public JAXBElement<String> createSetUserClaimValuesProfileName(String value) {
        return new JAXBElement<String>(_AddUserClaimValuesProfileName_QNAME, String.class, SetUserClaimValues.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "username", scope = GetPasswordExpirationTime.class)
    public JAXBElement<String> createGetPasswordExpirationTimeUsername(String value) {
        return new JAXBElement<String>(_GetTenantIdofUserUsername_QNAME, String.class, GetPasswordExpirationTime.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "userName", scope = DeleteUserClaimValues.class)
    public JAXBElement<String> createDeleteUserClaimValuesUserName(String value) {
        return new JAXBElement<String>(_AuthenticateUserName_QNAME, String.class, DeleteUserClaimValues.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "profileName", scope = DeleteUserClaimValues.class)
    public JAXBElement<String> createDeleteUserClaimValuesProfileName(String value) {
        return new JAXBElement<String>(_AddUserClaimValuesProfileName_QNAME, String.class, DeleteUserClaimValues.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "userName", scope = SetUserClaimValue.class)
    public JAXBElement<String> createSetUserClaimValueUserName(String value) {
        return new JAXBElement<String>(_AuthenticateUserName_QNAME, String.class, SetUserClaimValue.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "claimURI", scope = SetUserClaimValue.class)
    public JAXBElement<String> createSetUserClaimValueClaimURI(String value) {
        return new JAXBElement<String>(_AddUserClaimValueClaimURI_QNAME, String.class, SetUserClaimValue.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "claimValue", scope = SetUserClaimValue.class)
    public JAXBElement<String> createSetUserClaimValueClaimValue(String value) {
        return new JAXBElement<String>(_GetUserListClaimValue_QNAME, String.class, SetUserClaimValue.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "profileName", scope = SetUserClaimValue.class)
    public JAXBElement<String> createSetUserClaimValueProfileName(String value) {
        return new JAXBElement<String>(_AddUserClaimValuesProfileName_QNAME, String.class, SetUserClaimValue.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "roleName", scope = GetUserListOfRole.class)
    public JAXBElement<String> createGetUserListOfRoleRoleName(String value) {
        return new JAXBElement<String>(_AddRoleRoleName_QNAME, String.class, GetUserListOfRole.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "userName", scope = GetUserClaimValues.class)
    public JAXBElement<String> createGetUserClaimValuesUserName(String value) {
        return new JAXBElement<String>(_AuthenticateUserName_QNAME, String.class, GetUserClaimValues.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "profileName", scope = GetUserClaimValues.class)
    public JAXBElement<String> createGetUserClaimValuesProfileName(String value) {
        return new JAXBElement<String>(_AddUserClaimValuesProfileName_QNAME, String.class, GetUserClaimValues.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "roleName", scope = UpdateUserListOfRole.class)
    public JAXBElement<String> createUpdateUserListOfRoleRoleName(String value) {
        return new JAXBElement<String>(_AddRoleRoleName_QNAME, String.class, UpdateUserListOfRole.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "userName", scope = DeleteUserClaimValue.class)
    public JAXBElement<String> createDeleteUserClaimValueUserName(String value) {
        return new JAXBElement<String>(_AuthenticateUserName_QNAME, String.class, DeleteUserClaimValue.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "claimURI", scope = DeleteUserClaimValue.class)
    public JAXBElement<String> createDeleteUserClaimValueClaimURI(String value) {
        return new JAXBElement<String>(_AddUserClaimValueClaimURI_QNAME, String.class, DeleteUserClaimValue.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "profileName", scope = DeleteUserClaimValue.class)
    public JAXBElement<String> createDeleteUserClaimValueProfileName(String value) {
        return new JAXBElement<String>(_AddUserClaimValuesProfileName_QNAME, String.class, DeleteUserClaimValue.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "userName", scope = UpdateCredentialByAdmin.class)
    public JAXBElement<String> createUpdateCredentialByAdminUserName(String value) {
        return new JAXBElement<String>(_AuthenticateUserName_QNAME, String.class, UpdateCredentialByAdmin.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "newCredential", scope = UpdateCredentialByAdmin.class)
    public JAXBElement<String> createUpdateCredentialByAdminNewCredential(String value) {
        return new JAXBElement<String>(_UpdateCredentialNewCredential_QNAME, String.class, UpdateCredentialByAdmin.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "userName", scope = UpdateRoleListOfUser.class)
    public JAXBElement<String> createUpdateRoleListOfUserUserName(String value) {
        return new JAXBElement<String>(_AuthenticateUserName_QNAME, String.class, UpdateRoleListOfUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "userName", scope = AddUser.class)
    public JAXBElement<String> createAddUserUserName(String value) {
        return new JAXBElement<String>(_AuthenticateUserName_QNAME, String.class, AddUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "credential", scope = AddUser.class)
    public JAXBElement<String> createAddUserCredential(String value) {
        return new JAXBElement<String>(_AuthenticateCredential_QNAME, String.class, AddUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "profileName", scope = AddUser.class)
    public JAXBElement<String> createAddUserProfileName(String value) {
        return new JAXBElement<String>(_AddUserClaimValuesProfileName_QNAME, String.class, AddUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "userName", scope = GetUserClaimValue.class)
    public JAXBElement<String> createGetUserClaimValueUserName(String value) {
        return new JAXBElement<String>(_AuthenticateUserName_QNAME, String.class, GetUserClaimValue.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "claim", scope = GetUserClaimValue.class)
    public JAXBElement<String> createGetUserClaimValueClaim(String value) {
        return new JAXBElement<String>(_GetUserClaimValueClaim_QNAME, String.class, GetUserClaimValue.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "profileName", scope = GetUserClaimValue.class)
    public JAXBElement<String> createGetUserClaimValueProfileName(String value) {
        return new JAXBElement<String>(_AddUserClaimValuesProfileName_QNAME, String.class, GetUserClaimValue.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.ws.um.carbon.wso2.org", name = "return", scope = GetUserClaimValueResponse.class)
    public JAXBElement<String> createGetUserClaimValueResponseReturn(String value) {
        return new JAXBElement<String>(_GetUserClaimValueResponseReturn_QNAME, String.class, GetUserClaimValueResponse.class, value);
    }

}
