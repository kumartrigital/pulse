
package org.wso2.carbon.user.mgt.common.xsd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.wso2.carbon.user.mgt.common.xsd package. 
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

    private final static QName _ClaimValueClaimURI_QNAME = new QName("http://common.mgt.user.carbon.wso2.org/xsd", "claimURI");
    private final static QName _ClaimValueValue_QNAME = new QName("http://common.mgt.user.carbon.wso2.org/xsd", "value");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.wso2.carbon.user.mgt.common.xsd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ClaimValue }
     * 
     */
    public ClaimValue createClaimValue() {
        return new ClaimValue();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://common.mgt.user.carbon.wso2.org/xsd", name = "claimURI", scope = ClaimValue.class)
    public JAXBElement<String> createClaimValueClaimURI(String value) {
        return new JAXBElement<String>(_ClaimValueClaimURI_QNAME, String.class, ClaimValue.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://common.mgt.user.carbon.wso2.org/xsd", name = "value", scope = ClaimValue.class)
    public JAXBElement<String> createClaimValueValue(String value) {
        return new JAXBElement<String>(_ClaimValueValue_QNAME, String.class, ClaimValue.class, value);
    }

}
