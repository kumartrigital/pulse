
package org.wso2.carbon.um.ws.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="newCredential" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="oldCredential" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "newCredential",
    "oldCredential"
})
@XmlRootElement(name = "updateCredential")
public class UpdateCredential {

    @XmlElementRef(name = "userName", namespace = "http://service.ws.um.carbon.wso2.org", type = JAXBElement.class, required = false)
    protected JAXBElement<String> userName;
    @XmlElementRef(name = "newCredential", namespace = "http://service.ws.um.carbon.wso2.org", type = JAXBElement.class, required = false)
    protected JAXBElement<String> newCredential;
    @XmlElementRef(name = "oldCredential", namespace = "http://service.ws.um.carbon.wso2.org", type = JAXBElement.class, required = false)
    protected JAXBElement<String> oldCredential;

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
     * Gets the value of the newCredential property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNewCredential() {
        return newCredential;
    }

    /**
     * Sets the value of the newCredential property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNewCredential(JAXBElement<String> value) {
        this.newCredential = value;
    }

    /**
     * Gets the value of the oldCredential property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOldCredential() {
        return oldCredential;
    }

    /**
     * Sets the value of the oldCredential property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOldCredential(JAXBElement<String> value) {
        this.oldCredential = value;
    }

}
