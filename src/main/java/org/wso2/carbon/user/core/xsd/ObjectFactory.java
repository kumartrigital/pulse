
package org.wso2.carbon.user.core.xsd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.wso2.carbon.user.core.xsd package. 
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

    private final static QName _UserStoreExceptionErrorCode_QNAME = new QName("http://core.user.carbon.wso2.org/xsd", "errorCode");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.wso2.carbon.user.core.xsd
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
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://core.user.carbon.wso2.org/xsd", name = "errorCode", scope = UserStoreException.class)
    public JAXBElement<String> createUserStoreExceptionErrorCode(String value) {
        return new JAXBElement<String>(_UserStoreExceptionErrorCode_QNAME, String.class, UserStoreException.class, value);
    }

}
