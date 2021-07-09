
package org.wso2.carbon.um.ws.service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.wso2.carbon.user.mgt.common.xsd.ClaimValue;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="credential" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="roleList" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="claims" type="{http://common.mgt.user.carbon.wso2.org/xsd}ClaimValue" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="profileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="requirePasswordChange" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "userName",
    "credential",
    "roleList",
    "claims",
    "profileName",
    "requirePasswordChange"
})
@XmlRootElement(name = "addUser")
public class AddUser {

    @XmlElementRef(name = "userName", namespace = "http://service.ws.um.carbon.wso2.org", type = JAXBElement.class, required = false)
    protected JAXBElement<String> userName;
    @XmlElementRef(name = "credential", namespace = "http://service.ws.um.carbon.wso2.org", type = JAXBElement.class, required = false)
    protected JAXBElement<String> credential;
    @XmlElement(nillable = true)
    protected List<String> roleList;
    @XmlElement(nillable = true)
    protected List<ClaimValue> claims;
    @XmlElementRef(name = "profileName", namespace = "http://service.ws.um.carbon.wso2.org", type = JAXBElement.class, required = false)
    protected JAXBElement<String> profileName;
    protected Boolean requirePasswordChange;

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUserName(JAXBElement<String> value) {
        this.userName = value;
    }

    /**
     * Gets the value of the credential property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCredential() {
        return credential;
    }

    /**
     * Sets the value of the credential property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCredential(JAXBElement<String> value) {
        this.credential = value;
    }

    /**
     * Gets the value of the roleList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roleList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoleList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getRoleList() {
        if (roleList == null) {
            roleList = new ArrayList<String>();
        }
        return this.roleList;
    }

    /**
     * Gets the value of the claims property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the claims property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClaims().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClaimValue }
     * 
     * 
     */
    public List<ClaimValue> getClaims() {
        if (claims == null) {
            claims = new ArrayList<ClaimValue>();
        }
        return this.claims;
    }

    /**
     * Gets the value of the profileName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProfileName() {
        return profileName;
    }

    /**
     * Sets the value of the profileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProfileName(JAXBElement<String> value) {
        this.profileName = value;
    }

    /**
     * Gets the value of the requirePasswordChange property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRequirePasswordChange() {
        return requirePasswordChange;
    }

    /**
     * Sets the value of the requirePasswordChange property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRequirePasswordChange(Boolean value) {
        this.requirePasswordChange = value;
    }

}
