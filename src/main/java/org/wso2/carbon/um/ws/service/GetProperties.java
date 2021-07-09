
package org.wso2.carbon.um.ws.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.wso2.carbon.user.core.tenant.xsd.Tenant;


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
 *         &lt;element name="tenant" type="{http://tenant.core.user.carbon.wso2.org/xsd}Tenant" minOccurs="0"/&gt;
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
    "tenant"
})
@XmlRootElement(name = "getProperties")
public class GetProperties {

    @XmlElementRef(name = "tenant", namespace = "http://service.ws.um.carbon.wso2.org", type = JAXBElement.class, required = false)
    protected JAXBElement<Tenant> tenant;

    /**
     * Gets the value of the tenant property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Tenant }{@code >}
     *     
     */
    public JAXBElement<Tenant> getTenant() {
        return tenant;
    }

    /**
     * Sets the value of the tenant property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Tenant }{@code >}
     *     
     */
    public void setTenant(JAXBElement<Tenant> value) {
        this.tenant = value;
    }

}
