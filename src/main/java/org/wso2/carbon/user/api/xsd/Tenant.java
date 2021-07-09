
package org.wso2.carbon.user.api.xsd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Tenant complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Tenant"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="active" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="adminFirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adminFullName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adminLastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adminName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adminPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adminUserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="claimsMap" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="createdDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="domain" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="provisioningMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="realmConfig" type="{http://api.user.carbon.wso2.org/xsd}RealmConfiguration" minOccurs="0"/&gt;
 *         &lt;element name="tenantUniqueID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tenant", propOrder = {
    "active",
    "adminFirstName",
    "adminFullName",
    "adminLastName",
    "adminName",
    "adminPassword",
    "adminUserId",
    "claimsMap",
    "createdDate",
    "domain",
    "email",
    "id",
    "provisioningMethod",
    "realmConfig",
    "tenantUniqueID"
})
@XmlSeeAlso({
    org.wso2.carbon.user.core.tenant.xsd.Tenant.class
})
public class Tenant {

    protected Boolean active;
    @XmlElementRef(name = "adminFirstName", namespace = "http://api.user.carbon.wso2.org/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> adminFirstName;
    @XmlElementRef(name = "adminFullName", namespace = "http://api.user.carbon.wso2.org/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> adminFullName;
    @XmlElementRef(name = "adminLastName", namespace = "http://api.user.carbon.wso2.org/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> adminLastName;
    @XmlElementRef(name = "adminName", namespace = "http://api.user.carbon.wso2.org/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> adminName;
    @XmlElementRef(name = "adminPassword", namespace = "http://api.user.carbon.wso2.org/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> adminPassword;
    @XmlElementRef(name = "adminUserId", namespace = "http://api.user.carbon.wso2.org/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> adminUserId;
    @XmlElement(nillable = true)
    protected List<String> claimsMap;
    @XmlElementRef(name = "createdDate", namespace = "http://api.user.carbon.wso2.org/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> createdDate;
    @XmlElementRef(name = "domain", namespace = "http://api.user.carbon.wso2.org/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> domain;
    @XmlElementRef(name = "email", namespace = "http://api.user.carbon.wso2.org/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> email;
    protected Integer id;
    @XmlElementRef(name = "provisioningMethod", namespace = "http://api.user.carbon.wso2.org/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> provisioningMethod;
    @XmlElementRef(name = "realmConfig", namespace = "http://api.user.carbon.wso2.org/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<RealmConfiguration> realmConfig;
    @XmlElementRef(name = "tenantUniqueID", namespace = "http://api.user.carbon.wso2.org/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> tenantUniqueID;

    /**
     * Gets the value of the active property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setActive(Boolean value) {
        this.active = value;
    }

    /**
     * Gets the value of the adminFirstName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAdminFirstName() {
        return adminFirstName;
    }

    /**
     * Sets the value of the adminFirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAdminFirstName(JAXBElement<String> value) {
        this.adminFirstName = value;
    }

    /**
     * Gets the value of the adminFullName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAdminFullName() {
        return adminFullName;
    }

    /**
     * Sets the value of the adminFullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAdminFullName(JAXBElement<String> value) {
        this.adminFullName = value;
    }

    /**
     * Gets the value of the adminLastName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAdminLastName() {
        return adminLastName;
    }

    /**
     * Sets the value of the adminLastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAdminLastName(JAXBElement<String> value) {
        this.adminLastName = value;
    }

    /**
     * Gets the value of the adminName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAdminName() {
        return adminName;
    }

    /**
     * Sets the value of the adminName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAdminName(JAXBElement<String> value) {
        this.adminName = value;
    }

    /**
     * Gets the value of the adminPassword property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAdminPassword() {
        return adminPassword;
    }

    /**
     * Sets the value of the adminPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAdminPassword(JAXBElement<String> value) {
        this.adminPassword = value;
    }

    /**
     * Gets the value of the adminUserId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAdminUserId() {
        return adminUserId;
    }

    /**
     * Sets the value of the adminUserId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAdminUserId(JAXBElement<String> value) {
        this.adminUserId = value;
    }

    /**
     * Gets the value of the claimsMap property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the claimsMap property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClaimsMap().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getClaimsMap() {
        if (claimsMap == null) {
            claimsMap = new ArrayList<String>();
        }
        return this.claimsMap;
    }

    /**
     * Gets the value of the createdDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getCreatedDate() {
        return createdDate;
    }

    /**
     * Sets the value of the createdDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setCreatedDate(JAXBElement<XMLGregorianCalendar> value) {
        this.createdDate = value;
    }

    /**
     * Gets the value of the domain property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDomain() {
        return domain;
    }

    /**
     * Sets the value of the domain property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDomain(JAXBElement<String> value) {
        this.domain = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEmail(JAXBElement<String> value) {
        this.email = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the provisioningMethod property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProvisioningMethod() {
        return provisioningMethod;
    }

    /**
     * Sets the value of the provisioningMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProvisioningMethod(JAXBElement<String> value) {
        this.provisioningMethod = value;
    }

    /**
     * Gets the value of the realmConfig property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link RealmConfiguration }{@code >}
     *     
     */
    public JAXBElement<RealmConfiguration> getRealmConfig() {
        return realmConfig;
    }

    /**
     * Sets the value of the realmConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link RealmConfiguration }{@code >}
     *     
     */
    public void setRealmConfig(JAXBElement<RealmConfiguration> value) {
        this.realmConfig = value;
    }

    /**
     * Gets the value of the tenantUniqueID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTenantUniqueID() {
        return tenantUniqueID;
    }

    /**
     * Sets the value of the tenantUniqueID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTenantUniqueID(JAXBElement<String> value) {
        this.tenantUniqueID = value;
    }

}
