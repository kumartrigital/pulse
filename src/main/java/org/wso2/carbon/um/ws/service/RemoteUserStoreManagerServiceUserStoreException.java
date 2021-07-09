
package org.wso2.carbon.um.ws.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.wso2.carbon.user.core.xsd.UserStoreException;


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
 *         &lt;element name="UserStoreException" type="{http://core.user.carbon.wso2.org/xsd}UserStoreException" minOccurs="0"/&gt;
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
    "userStoreException"
})
@XmlRootElement(name = "RemoteUserStoreManagerServiceUserStoreException")
public class RemoteUserStoreManagerServiceUserStoreException {

    @XmlElementRef(name = "UserStoreException", namespace = "http://service.ws.um.carbon.wso2.org", type = JAXBElement.class, required = false)
    protected JAXBElement<UserStoreException> userStoreException;

    /**
     * Gets the value of the userStoreException property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link UserStoreException }{@code >}
     *     
     */
    public JAXBElement<UserStoreException> getUserStoreException() {
        return userStoreException;
    }

    /**
     * Sets the value of the userStoreException property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link UserStoreException }{@code >}
     *     
     */
    public void setUserStoreException(JAXBElement<UserStoreException> value) {
        this.userStoreException = value;
    }

}
