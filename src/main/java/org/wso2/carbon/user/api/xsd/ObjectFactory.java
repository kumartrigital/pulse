
package org.wso2.carbon.user.api.xsd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.wso2.carbon.user.api.xsd package. 
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

    private final static QName _TenantAdminFirstName_QNAME = new QName("http://api.user.carbon.wso2.org/xsd", "adminFirstName");
    private final static QName _TenantAdminFullName_QNAME = new QName("http://api.user.carbon.wso2.org/xsd", "adminFullName");
    private final static QName _TenantAdminLastName_QNAME = new QName("http://api.user.carbon.wso2.org/xsd", "adminLastName");
    private final static QName _TenantAdminName_QNAME = new QName("http://api.user.carbon.wso2.org/xsd", "adminName");
    private final static QName _TenantAdminPassword_QNAME = new QName("http://api.user.carbon.wso2.org/xsd", "adminPassword");
    private final static QName _TenantAdminUserId_QNAME = new QName("http://api.user.carbon.wso2.org/xsd", "adminUserId");
    private final static QName _TenantCreatedDate_QNAME = new QName("http://api.user.carbon.wso2.org/xsd", "createdDate");
    private final static QName _TenantDomain_QNAME = new QName("http://api.user.carbon.wso2.org/xsd", "domain");
    private final static QName _TenantEmail_QNAME = new QName("http://api.user.carbon.wso2.org/xsd", "email");
    private final static QName _TenantProvisioningMethod_QNAME = new QName("http://api.user.carbon.wso2.org/xsd", "provisioningMethod");
    private final static QName _TenantRealmConfig_QNAME = new QName("http://api.user.carbon.wso2.org/xsd", "realmConfig");
    private final static QName _TenantTenantUniqueID_QNAME = new QName("http://api.user.carbon.wso2.org/xsd", "tenantUniqueID");
    private final static QName _RealmConfigurationAddAdmin_QNAME = new QName("http://api.user.carbon.wso2.org/xsd", "addAdmin");
    private final static QName _RealmConfigurationAdminRoleName_QNAME = new QName("http://api.user.carbon.wso2.org/xsd", "adminRoleName");
    private final static QName _RealmConfigurationAdminUserName_QNAME = new QName("http://api.user.carbon.wso2.org/xsd", "adminUserName");
    private final static QName _RealmConfigurationAuthorizationManagerClass_QNAME = new QName("http://api.user.carbon.wso2.org/xsd", "authorizationManagerClass");
    private final static QName _RealmConfigurationDescription_QNAME = new QName("http://api.user.carbon.wso2.org/xsd", "description");
    private final static QName _RealmConfigurationEveryOneRoleName_QNAME = new QName("http://api.user.carbon.wso2.org/xsd", "everyOneRoleName");
    private final static QName _RealmConfigurationIsOverrideUsernameClaimFromInternalUsername_QNAME = new QName("http://api.user.carbon.wso2.org/xsd", "isOverrideUsernameClaimFromInternalUsername");
    private final static QName _RealmConfigurationPersistedTimestamp_QNAME = new QName("http://api.user.carbon.wso2.org/xsd", "persistedTimestamp");
    private final static QName _RealmConfigurationRealmClassName_QNAME = new QName("http://api.user.carbon.wso2.org/xsd", "realmClassName");
    private final static QName _RealmConfigurationSecondaryRealmConfig_QNAME = new QName("http://api.user.carbon.wso2.org/xsd", "secondaryRealmConfig");
    private final static QName _RealmConfigurationUserStoreClass_QNAME = new QName("http://api.user.carbon.wso2.org/xsd", "userStoreClass");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.wso2.carbon.user.api.xsd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UserStoreException }
     * 
     */
    public UserStoreException createUserStoreException() {
        return new UserStoreException();
    }

    /**
     * Create an instance of {@link Tenant }
     * 
     */
    public Tenant createTenant() {
        return new Tenant();
    }

    /**
     * Create an instance of {@link RealmConfiguration }
     * 
     */
    public RealmConfiguration createRealmConfiguration() {
        return new RealmConfiguration();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.user.carbon.wso2.org/xsd", name = "adminFirstName", scope = Tenant.class)
    public JAXBElement<String> createTenantAdminFirstName(String value) {
        return new JAXBElement<String>(_TenantAdminFirstName_QNAME, String.class, Tenant.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.user.carbon.wso2.org/xsd", name = "adminFullName", scope = Tenant.class)
    public JAXBElement<String> createTenantAdminFullName(String value) {
        return new JAXBElement<String>(_TenantAdminFullName_QNAME, String.class, Tenant.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.user.carbon.wso2.org/xsd", name = "adminLastName", scope = Tenant.class)
    public JAXBElement<String> createTenantAdminLastName(String value) {
        return new JAXBElement<String>(_TenantAdminLastName_QNAME, String.class, Tenant.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.user.carbon.wso2.org/xsd", name = "adminName", scope = Tenant.class)
    public JAXBElement<String> createTenantAdminName(String value) {
        return new JAXBElement<String>(_TenantAdminName_QNAME, String.class, Tenant.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.user.carbon.wso2.org/xsd", name = "adminPassword", scope = Tenant.class)
    public JAXBElement<String> createTenantAdminPassword(String value) {
        return new JAXBElement<String>(_TenantAdminPassword_QNAME, String.class, Tenant.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.user.carbon.wso2.org/xsd", name = "adminUserId", scope = Tenant.class)
    public JAXBElement<String> createTenantAdminUserId(String value) {
        return new JAXBElement<String>(_TenantAdminUserId_QNAME, String.class, Tenant.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.user.carbon.wso2.org/xsd", name = "createdDate", scope = Tenant.class)
    public JAXBElement<XMLGregorianCalendar> createTenantCreatedDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_TenantCreatedDate_QNAME, XMLGregorianCalendar.class, Tenant.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.user.carbon.wso2.org/xsd", name = "domain", scope = Tenant.class)
    public JAXBElement<String> createTenantDomain(String value) {
        return new JAXBElement<String>(_TenantDomain_QNAME, String.class, Tenant.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.user.carbon.wso2.org/xsd", name = "email", scope = Tenant.class)
    public JAXBElement<String> createTenantEmail(String value) {
        return new JAXBElement<String>(_TenantEmail_QNAME, String.class, Tenant.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.user.carbon.wso2.org/xsd", name = "provisioningMethod", scope = Tenant.class)
    public JAXBElement<String> createTenantProvisioningMethod(String value) {
        return new JAXBElement<String>(_TenantProvisioningMethod_QNAME, String.class, Tenant.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RealmConfiguration }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RealmConfiguration }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.user.carbon.wso2.org/xsd", name = "realmConfig", scope = Tenant.class)
    public JAXBElement<RealmConfiguration> createTenantRealmConfig(RealmConfiguration value) {
        return new JAXBElement<RealmConfiguration>(_TenantRealmConfig_QNAME, RealmConfiguration.class, Tenant.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.user.carbon.wso2.org/xsd", name = "tenantUniqueID", scope = Tenant.class)
    public JAXBElement<String> createTenantTenantUniqueID(String value) {
        return new JAXBElement<String>(_TenantTenantUniqueID_QNAME, String.class, Tenant.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.user.carbon.wso2.org/xsd", name = "addAdmin", scope = RealmConfiguration.class)
    public JAXBElement<String> createRealmConfigurationAddAdmin(String value) {
        return new JAXBElement<String>(_RealmConfigurationAddAdmin_QNAME, String.class, RealmConfiguration.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.user.carbon.wso2.org/xsd", name = "adminPassword", scope = RealmConfiguration.class)
    public JAXBElement<String> createRealmConfigurationAdminPassword(String value) {
        return new JAXBElement<String>(_TenantAdminPassword_QNAME, String.class, RealmConfiguration.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.user.carbon.wso2.org/xsd", name = "adminRoleName", scope = RealmConfiguration.class)
    public JAXBElement<String> createRealmConfigurationAdminRoleName(String value) {
        return new JAXBElement<String>(_RealmConfigurationAdminRoleName_QNAME, String.class, RealmConfiguration.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.user.carbon.wso2.org/xsd", name = "adminUserName", scope = RealmConfiguration.class)
    public JAXBElement<String> createRealmConfigurationAdminUserName(String value) {
        return new JAXBElement<String>(_RealmConfigurationAdminUserName_QNAME, String.class, RealmConfiguration.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.user.carbon.wso2.org/xsd", name = "authorizationManagerClass", scope = RealmConfiguration.class)
    public JAXBElement<String> createRealmConfigurationAuthorizationManagerClass(String value) {
        return new JAXBElement<String>(_RealmConfigurationAuthorizationManagerClass_QNAME, String.class, RealmConfiguration.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.user.carbon.wso2.org/xsd", name = "description", scope = RealmConfiguration.class)
    public JAXBElement<String> createRealmConfigurationDescription(String value) {
        return new JAXBElement<String>(_RealmConfigurationDescription_QNAME, String.class, RealmConfiguration.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.user.carbon.wso2.org/xsd", name = "everyOneRoleName", scope = RealmConfiguration.class)
    public JAXBElement<String> createRealmConfigurationEveryOneRoleName(String value) {
        return new JAXBElement<String>(_RealmConfigurationEveryOneRoleName_QNAME, String.class, RealmConfiguration.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.user.carbon.wso2.org/xsd", name = "isOverrideUsernameClaimFromInternalUsername", scope = RealmConfiguration.class)
    public JAXBElement<String> createRealmConfigurationIsOverrideUsernameClaimFromInternalUsername(String value) {
        return new JAXBElement<String>(_RealmConfigurationIsOverrideUsernameClaimFromInternalUsername_QNAME, String.class, RealmConfiguration.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.user.carbon.wso2.org/xsd", name = "persistedTimestamp", scope = RealmConfiguration.class)
    public JAXBElement<XMLGregorianCalendar> createRealmConfigurationPersistedTimestamp(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_RealmConfigurationPersistedTimestamp_QNAME, XMLGregorianCalendar.class, RealmConfiguration.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.user.carbon.wso2.org/xsd", name = "realmClassName", scope = RealmConfiguration.class)
    public JAXBElement<String> createRealmConfigurationRealmClassName(String value) {
        return new JAXBElement<String>(_RealmConfigurationRealmClassName_QNAME, String.class, RealmConfiguration.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RealmConfiguration }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RealmConfiguration }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.user.carbon.wso2.org/xsd", name = "secondaryRealmConfig", scope = RealmConfiguration.class)
    public JAXBElement<RealmConfiguration> createRealmConfigurationSecondaryRealmConfig(RealmConfiguration value) {
        return new JAXBElement<RealmConfiguration>(_RealmConfigurationSecondaryRealmConfig_QNAME, RealmConfiguration.class, RealmConfiguration.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.user.carbon.wso2.org/xsd", name = "userStoreClass", scope = RealmConfiguration.class)
    public JAXBElement<String> createRealmConfigurationUserStoreClass(String value) {
        return new JAXBElement<String>(_RealmConfigurationUserStoreClass_QNAME, String.class, RealmConfiguration.class, value);
    }

}
