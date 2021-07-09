
package org.wso2.carbon.user.core.xsd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UserStoreException complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserStoreException"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://api.user.carbon.wso2.org/xsd}UserStoreException"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="errorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserStoreException", propOrder = {
    "errorCode"
})
public class UserStoreException
    extends org.wso2.carbon.user.api.xsd.UserStoreException
{

    @XmlElementRef(name = "errorCode", namespace = "http://core.user.carbon.wso2.org/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> errorCode;

    /**
     * Gets the value of the errorCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the value of the errorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setErrorCode(JAXBElement<String> value) {
        this.errorCode = value;
    }

}
